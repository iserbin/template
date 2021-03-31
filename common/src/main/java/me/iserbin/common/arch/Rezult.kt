package me.iserbin.common.arch

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * This class is copy-pasted from [kotlin.Result], because
 * of [issues](https://youtrack.jetbrains.com/issue/KT-27586) related to its usage.
 * Removed all `inline` modifiers from the class.
 *
 * A discriminated union that encapsulates a successful outcome with a value of type [T]
 * or a failure with an arbitrary [Throwable] exception.
 */
@SinceKotlin("1.3")
class Rezult<out T> @PublishedApi internal constructor(
    @PublishedApi
    internal val value: Any?
) : java.io.Serializable {
    // discovery

    /**
     * Returns `true` if this instance represents a successful outcome.
     * In this case [isFailure] returns `false`.
     */
    val isSuccess: Boolean get() = value !is Failure

    /**
     * Returns `true` if this instance represents a failed outcome.
     * In this case [isSuccess] returns `false`.
     */
    val isFailure: Boolean get() = value is Failure

    // value & exception retrieval

    /**
     * Returns the encapsulated value if this instance represents [success][Rezult.isSuccess] or `null`
     * if it is [failure][Rezult.isFailure].
     *
     * This function is a shorthand for `getOrElse { null }` (see `getOrElse`) or
     * `fold(onSuccess = { it }, onFailure = { null })` (see [fold]).
     */
    fun getOrNull(): T? =
        when {
            isFailure -> null
            else -> value as T
        }

    /**
     * Returns the encapsulated [Throwable] exception if this instance represents [failure][isFailure] or `null`
     * if it is [success][isSuccess].
     *
     * This function is a shorthand for `fold(onSuccess = { null }, onFailure = { it })` (see [fold]).
     */
    fun exceptionOrNull(): Throwable? =
        when (value) {
            is Failure -> value.exception
            else -> null
        }

    /**
     * Returns a string `Success(v)` if this instance represents [success][Rezult.isSuccess]
     * where `v` is a string representation of the value or a string `Failure(x)` if
     * it is [failure][isFailure] where `x` is a string representation of the exception.
     */
    override fun toString(): String =
        when (value) {
            is Failure -> value.toString() // "Failure($exception)"
            else -> "Success($value)"
        }

    // companion with constructors

    /**
     * Companion object for [Rezult] class that contains its constructor functions
     * [success] and [failure].
     */
    companion object {
        /**
         * Returns an instance that encapsulates the given [value] as successful value.
         */
        fun <T> success(value: T): Rezult<T> =
            Rezult(value)

        /**
         * Returns an instance that encapsulates the given [Throwable] [exception] as failure.
         */
        fun <T> failure(exception: Throwable): Rezult<T> =
            Rezult(createFailure(exception))
    }

    internal class Failure(
        @JvmField
        val exception: Throwable
    ) : java.io.Serializable {
        override fun equals(other: Any?): Boolean = other is Failure && exception == other.exception
        override fun hashCode(): Int = exception.hashCode()
        override fun toString(): String = "Failure($exception)"
    }
}

/**
 * Creates an instance of internal marker [Rezult.Failure] class to
 * make sure that this class is not exposed in ABI.
 */
@PublishedApi
@SinceKotlin("1.3")
internal fun createFailure(exception: Throwable): Any =
    Rezult.Failure(exception)

/**
 * Throws exception if the Rezult is failure. This internal function minimizes
 * inlined bytecode for `getOrThrow` and makes sure that in the future we can
 * add some exception-augmenting logic here (if needed).
 */
@PublishedApi
@SinceKotlin("1.3")
internal fun Rezult<*>.throwOnFailure() {
    if (value is Rezult.Failure) throw value.exception
}

/**
 * Calls the specified function [block] and returns its encapsulated Rezult if invocation was successful,
 * catching any [Throwable] exception that was thrown from the [block] function execution and encapsulating it as a failure.
 */
@SinceKotlin("1.3")
fun <R> runCatching(block: () -> R): Rezult<R> {
    return try {
        Rezult.success(block())
    } catch (e: Throwable) {
        Rezult.failure(e)
    }
}

/**
 * Calls the specified function [block] with `this` value as its receiver and returns its encapsulated Rezult if invocation was successful,
 * catching any [Throwable] exception that was thrown from the [block] function execution and encapsulating it as a failure.
 */
@SinceKotlin("1.3")
fun <T, R> T.runCatching(block: T.() -> R): Rezult<R> {
    return try {
        Rezult.success(block())
    } catch (e: Throwable) {
        Rezult.failure(e)
    }
}

// -- extensions ---

/**
 * Returns the encapsulated value if this instance represents [success][Rezult.isSuccess] or throws the encapsulated [Throwable] exception
 * if it is [failure][Rezult.isFailure].
 *
 * This function is a shorthand for `getOrElse { throw it }` (see `getOrElse`).
 */
@SinceKotlin("1.3")
fun <T> Rezult<T>.getOrThrow(): T {
    throwOnFailure()
    return value as T
}

/**
 * Returns the encapsulated value if this instance represents [success][Rezult.isSuccess] or the
 * Rezult of [onFailure] function for the encapsulated [Throwable] exception if it is [failure][Rezult.isFailure].
 *
 * Note, that this function rethrows any [Throwable] exception thrown by [onFailure] function.
 *
 * This function is a shorthand for `fold(onSuccess = { it }, onFailure = onFailure)` (see [fold]).
 */
@ExperimentalContracts
@SinceKotlin("1.3")
fun <R, T : R> Rezult<T>.getOrElse(onFailure: (exception: Throwable) -> R): R {
    contract {
        callsInPlace(onFailure, InvocationKind.AT_MOST_ONCE)
    }
    return when (val exception = exceptionOrNull()) {
        null -> value as T
        else -> onFailure(exception)
    }
}

/**
 * Returns the encapsulated value if this instance represents [success][Rezult.isSuccess] or the
 * [defaultValue] if it is [failure][Rezult.isFailure].
 *
 * This function is a shorthand for `getOrElse { defaultValue }` (see `getOrElse`).
 */
@SinceKotlin("1.3")
fun <R, T : R> Rezult<T>.getOrDefault(defaultValue: R): R {
    if (isFailure) return defaultValue
    return value as T
}

/**
 * Returns the Rezult of [onSuccess] for the encapsulated value if this instance represents [success][Rezult.isSuccess]
 * or the Rezult of [onFailure] function for the encapsulated [Throwable] exception if it is [failure][Rezult.isFailure].
 *
 * Note, that this function rethrows any [Throwable] exception thrown by [onSuccess] or by [onFailure] function.
 */
@ExperimentalContracts
@SinceKotlin("1.3")
fun <R, T> Rezult<T>.fold(
    onSuccess: (value: T) -> R,
    onFailure: (exception: Throwable) -> R
): R {
    contract {
        callsInPlace(onSuccess, InvocationKind.AT_MOST_ONCE)
        callsInPlace(onFailure, InvocationKind.AT_MOST_ONCE)
    }
    return when (val exception = exceptionOrNull()) {
        null -> onSuccess(value as T)
        else -> onFailure(exception)
    }
}

// transformation

/**
 * Returns the encapsulated Rezult of the given [transform] function applied to the encapsulated value
 * if this instance represents [success][Rezult.isSuccess] or the
 * original encapsulated [Throwable] exception if it is [failure][Rezult.isFailure].
 *
 * Note, that this function rethrows any [Throwable] exception thrown by [transform] function.
 * See [mapCatching] for an alternative that encapsulates exceptions.
 */
@ExperimentalContracts
@SinceKotlin("1.3")
fun <R, T> Rezult<T>.map(transform: (value: T) -> R): Rezult<R> {
    contract {
        callsInPlace(transform, InvocationKind.AT_MOST_ONCE)
    }
    return when {
        isSuccess -> Rezult.success(transform(value as T))
        else -> Rezult(value)
    }
}

/**
 * Returns the encapsulated Rezult of the given [transform] function applied to the encapsulated value
 * if this instance represents [success][Rezult.isSuccess] or the
 * original encapsulated [Throwable] exception if it is [failure][Rezult.isFailure].
 *
 * This function catches any [Throwable] exception thrown by [transform] function and encapsulates it as a failure.
 * See [map] for an alternative that rethrows exceptions from `transform` function.
 */
@SinceKotlin("1.3")
fun <R, T> Rezult<T>.mapCatching(transform: (value: T) -> R): Rezult<R> {
    return when {
        isSuccess -> runCatching { transform(value as T) }
        else -> Rezult(value)
    }
}

/**
 * Returns the encapsulated Rezult of the given [transform] function applied to the encapsulated [Throwable] exception
 * if this instance represents [failure][Rezult.isFailure] or the
 * original encapsulated value if it is [success][Rezult.isSuccess].
 *
 * Note, that this function rethrows any [Throwable] exception thrown by [transform] function.
 * See [recoverCatching] for an alternative that encapsulates exceptions.
 */
@ExperimentalContracts
@SinceKotlin("1.3")
fun <R, T : R> Rezult<T>.recover(transform: (exception: Throwable) -> R): Rezult<R> {
    contract {
        callsInPlace(transform, InvocationKind.AT_MOST_ONCE)
    }
    return when (val exception = exceptionOrNull()) {
        null -> this
        else -> Rezult.success(transform(exception))
    }
}

/**
 * Returns the encapsulated Rezult of the given [transform] function applied to the encapsulated [Throwable] exception
 * if this instance represents [failure][Rezult.isFailure] or the
 * original encapsulated value if it is [success][Rezult.isSuccess].
 *
 * This function catches any [Throwable] exception thrown by [transform] function and encapsulates it as a failure.
 * See [recover] for an alternative that rethrows exceptions.
 */
@SinceKotlin("1.3")
fun <R, T : R> Rezult<T>.recoverCatching(transform: (exception: Throwable) -> R): Rezult<R> {
    // val value = value // workaround for inline classes BE bug
    return when (val exception = exceptionOrNull()) {
        null -> this
        else -> runCatching { transform(exception) }
    }
}

// "peek" onto value/exception and pipe

/**
 * Performs the given [action] on the encapsulated [Throwable] exception if this instance represents [failure][Rezult.isFailure].
 * Returns the original `Rezult` unchanged.
 */
@ExperimentalContracts
@SinceKotlin("1.3")
fun <T> Rezult<T>.onFailure(action: (exception: Throwable) -> Unit): Rezult<T> {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    exceptionOrNull()?.let { action(it) }
    return this
}

/**
 * Performs the given [action] on the encapsulated value if this instance represents [success][Rezult.isSuccess].
 * Returns the original `Rezult` unchanged.
 */
@ExperimentalContracts
@SinceKotlin("1.3")
fun <T> Rezult<T>.onSuccess(action: (value: T) -> Unit): Rezult<T> {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    if (isSuccess) action(value as T)
    return this
}
