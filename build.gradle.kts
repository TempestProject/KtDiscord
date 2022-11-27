plugins {
    kotlin("multiplatform") version "1.7.21"
    kotlin("plugin.serialization") version "1.7.21"
    id("maven-publish")
    id("org.jetbrains.dokka") version "1.7.20"
}

group = "cloud.drakon"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

val ktor_version: String by project

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    //    js(BOTH) {
    //        nodejs()
    //        useCommonJs()
    //    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

                implementation("io.ktor:ktor-client-core:2.1.3")
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

                implementation("io.ktor:ktor-client-java:2.1.3")
            }
        }
        val jvmTest by getting

        //        val jsMain by getting {
        //            dependencies {
        //                implementation(npm("tweetnacl", "1.0.3", generateExternals = true))
        //
        //                implementation("io.ktor:ktor-client-js:2.1.3")
        //            }
        //        }
        //        val jsTest by getting
    }

    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/TempestProject/Tempest")
                credentials {
                    username = System.getenv("GITHUB_ACTOR")
                    password = System.getenv("GITHUB_TOKEN")
                }
            }
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
