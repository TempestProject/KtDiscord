import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile

plugins {
    val kotlinVersion = "1.9.10"

    kotlin("multiplatform") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("org.jetbrains.dokka") version "1.9.0"
}

group = "cloud.drakon"
version = "7.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        jvmToolchain(17)
        withJava()
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }

    js {
        nodejs()

        binaries.library()
        generateTypeScriptDefinitions()

        // https://youtrack.jetbrains.com/issue/KTOR-6158
        useEsModules()
    }

    sourceSets {
        val ktorVersion = "2.3.4"

        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-java:$ktorVersion")
            }
        }
        val jvmTest by getting

        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:$ktorVersion")
            }
        }
        val jsTest by getting
    }
}

tasks.withType<KotlinJsCompile>().configureEach {
    kotlinOptions {
        useEsClasses = true
    }
}
