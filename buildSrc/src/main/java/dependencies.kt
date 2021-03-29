package me.iserbin.template.buildsrc

object Versions {
    const val ktlint = "0.40.0"
    const val compileSdk = 30
    const val minSdk = 16
    const val targetSdk = 30
    const val versionApp = 1
    const val versionAppName = "1.0"
}

object Libs {
    private const val androidGradlePluginVersion = "4.2.0-beta06"
    const val androidGradlePlugin = "com.android.tools.build:gradle:$androidGradlePluginVersion"
    private const val spotless_plugin_gradle = "5.9.0"
    const val spotless = "com.diffplug.spotless:spotless-plugin-gradle:$spotless_plugin_gradle"

    const val junit = "junit:junit:4.13.2"
    private const val gradle_versions_plugin = "0.36.0"
    const val gradleVersionsPlugin =
        "com.github.ben-manes:gradle-versions-plugin:$gradle_versions_plugin"

    object Kotlin {
        private const val version = "1.4.31"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object AndroidX {
        object Test {
            private const val version = "1.2.0"
            const val core = "androidx.test:core:$version"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"
            const val extJunit = "androidx.test.ext:junit:1.1.2"
            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
        }

        const val core = "androidx.core:core:1.3.1"
        const val coreKtx = "androidx.core:core-ktx:1.5.0-beta01"
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.4"
    }

    object Ui {
        const val material = "com.google.android.material:material:1.3.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
    }
}