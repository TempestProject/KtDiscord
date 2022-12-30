# KtDiscord

[![Kotlin Stable](https://kotl.in/badges/stable.svg)](https://kotlinlang.org/docs/components-stability.html)
[![Kotlin](https://img.shields.io/badge/kotlin-1.8.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![License](https://img.shields.io/github/license/TempestProject/KtDiscord)](https://www.gnu.org/licenses/agpl-3.0.en.html)
[![Qodana](https://github.com/TempestProject/KtDiscord/actions/workflows/code_quality.yml/badge.svg)](https://github.com/TempestProject/KtDiscord/actions/workflows/code_quality.yml)

KtDiscord is a Kotlin/JVM library for working with Discord Interactions.

## Features

* All Interactions endpoints are supported by KtDiscord and their usage is exposed as suspendable functions
* All Discord Interactions objects are exposed as classes

## Stability

KtDiscord will follow Semantic Versioning 2.0.0, meaning:

* A MAJOR version denotes incompatible API changes
* A MINOR version denotes adding functionality in a backwards compatible manner
* A PATCH version denotes backwards compatible bug fixes

It's also worth noting that rate limiting is currently unimplemented and must be handled by the application at this
time.
