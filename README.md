# KtDiscord

[![Kotlin](https://img.shields.io/badge/kotlin-1.8.20-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![License](https://img.shields.io/github/license/TempestProject/KtDiscord)](https://www.gnu.org/licenses/agpl-3.0.en.html)

KtDiscord is a Kotlin Multiplatform library for working with Discord Interactions.

## Features

* All Discord Interactions objects are exposed as classes
* All Interactions endpoints are supported by KtDiscord and their usage is exposed as functions
* Helper functions are provided for creating Global/Guild Application Commands, as are classes that expose the
  Application Command objects

## Installation

KtDiscord is available from Maven Central.

Add the following to your `build.gradle.kts` file to install KtDiscord:

```kotlin
dependencies {
    implementation("cloud.drakon:ktdiscord:6.0.0")
}
```

## Stability

KtDiscord will follow Semantic Versioning 2.0.0, meaning:

* A MAJOR version denotes incompatible API changes
* A MINOR version denotes adding functionality in a backwards compatible manner
* A PATCH version denotes backwards compatible bug fixes
