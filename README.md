# KtDiscord

[![Kotlin](https://img.shields.io/badge/kotlin-1.9.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![License](https://img.shields.io/github/license/TempestProject/KtDiscord)](https://www.gnu.org/licenses/agpl-3.0.en.html)

KtDiscord is a Kotlin Multiplatform library for working with Discord Interactions.

## Features

* All Discord Interactions objects are exposed as classes
* All Interactions endpoints are supported by KtDiscord and their usage is exposed as (suspendable) functions
* Helper functions are provided for creating Global/Guild Application Commands, as are classes that expose the
  Application Command objects

## Installation

KtDiscord is available from Maven Central.

Add the following to your `build.gradle.kts` file to install KtDiscord:

```kotlin
dependencies {
    implementation("cloud.drakon:ktdiscord:7.0.0-SNAPSHOT")
}
```
