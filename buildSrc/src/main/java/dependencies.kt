package me.iserbin.template.buildsrc

object Versions {
    const val compileSdk = 30
    const val minSdk = 16
    const val targetSdk = 30
    const val versionApp = 1
    const val versionAppName = "1.0"
    const val ktlint = "0.40.0"
    const val androidGradlePlugin = "4.2.0-beta06"
    const val spotlessGradlePlugin = "5.9.0"
    const val gradleVersionsPlugin = "0.36.0"
    const val kotlin = "1.4.31"
    const val coroutines = "1.4.3"
    const val hilt = "2.33-beta"
    const val test = "1.2.0"
    const val testExtJunit = "1.1.2"
    const val testEspressoCore = "3.3.0"
    const val androidxCore = "1.3.1"
    const val androidxAppcompat = "1.2.0"
    const val androidxConstraint = "2.0.4"
    const val uiMaterial = "1.3.0"
    const val timber = "4.7.1"
    const val activity = "1.2.0-rc01"
    const val fragment = "1.3.0-rc01"
    const val navigation = "2.3.4"
    const val annotation = "1.1.0"
}

object Libs {
    const val junit = "junit:junit:4.13.2"
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val spotlessGradlePlugin =
        "com.diffplug.spotless:spotless-plugin-gradle:${Versions.spotlessGradlePlugin}"
    const val gradleVersionsPlugin =
        "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleVersionsPlugin}"

    object Kotlin {
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val kotlinGradlePlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object Di {
        const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object AndroidX {
        object Test {
            const val core = "androidx.test:core:${Versions.test}"
            const val runner = "androidx.test:runner:${Versions.test}"
            const val rules = "androidx.test:rules:${Versions.test}"
            const val extJunit = "androidx.test.ext:junit:${Versions.testExtJunit}"
            const val espressoCore =
                "androidx.test.espresso:espresso-core:${Versions.testEspressoCore}"
        }

        const val core = "androidx.core:core:${Versions.androidxCore}"
        const val annotationLib = "androidx.annotation:annotation:${Versions.annotation}"
        const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
        const val navigationRuntime =
            "androidx.navigation:navigation-runtime:${Versions.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val navigationSafeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.androidxAppcompat}"
        const val constraint =
            "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraint}"
    }

    object Ui {
        const val material = "com.google.android.material:material:${Versions.uiMaterial}"
    }

    object Debug {
        const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    }
}