plugins {
    kotlin("multiplatform") version "1.8.0"
    kotlin("plugin.serialization") version "1.8.0"
    id("maven-publish")
    id("dev.petuska.npm.publish") version "3.2.0"
    id("org.jetbrains.dokka") version "1.7.20"
}

group = "cloud.drakon"
version = "5.0.2"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        nodejs()
        useCommonJs()
        binaries.library()
    }

    sourceSets {
        val ktorVersion = "2.2.2"

        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("com.goterl:lazysodium-java:5.1.4")
                implementation("net.java.dev.jna:jna:5.12.1")

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

    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/TempestProject/KtDiscord")
                credentials {
                    username = System.getenv("GITHUB_ACTOR")
                    password = System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}

npmPublish {
    organization.set("tempestproject")
    packages {
        named("js") {
            packageJson {
                "bugs" by "https://github.com/TempestProject/KtDiscord/issues"
                "homepage" by "https://github.com/TempestProject/KtDiscord"
                "license" by "AGPL - 3.0 - only"
                "main" by "ktdiscord.js"
                "name" by "@tempestproject/ktdiscord"
                "repository" by "github:TempestProject/KtDiscord"
            }
            packageJsonTemplateFile.set(projectDir.resolve("build/js/packages/ktdiscord/package.json"))
        }
    }
    readme.set(rootDir.resolve("README.md"))
    registries {
        github {
            authToken.set(System.getenv("GITHUB_TOKEN"))
        }
        npmjs {
            authToken.set(System.getenv("NPM_ACCESS_TOKEN"))
        }
    }
}

tasks.dokkaJekyll.configure {
    outputDirectory.set(buildDir.resolve("dokka"))

    dokkaSourceSets {
        configureEach {
            jdkVersion.set(11)
        }
    }
}
