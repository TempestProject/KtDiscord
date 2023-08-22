import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    val kotlinVersion = "1.9.0"

    kotlin("multiplatform") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("maven-publish")
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
    signing

    //    id("dev.petuska.npm.publish") version "3.2.1"

    id("org.jetbrains.dokka") version "1.8.20"
}

group = "cloud.drakon"
version = "7.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val jvmToolchain = 11

kotlin {
    jvm {
        jvmToolchain(jvmToolchain)

        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        nodejs()

        //        binaries.library()
    }

    sourceSets {
        val ktorVersion = "2.3.2"

        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

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
                implementation("net.java.dev.jna:jna:5.13.0")

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

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))

            username.set(System.getenv("SONATYPE_USERNAME"))
            password.set(System.getenv("SONATYPE_PASSWORD"))
        }
    }
}

val dokkaHtml by tasks.getting(DokkaTask::class)
val htmlJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
    dependsOn(tasks.dokkaHtml)
    archiveClassifier.set("html-docs")
    from(tasks.dokkaHtml.flatMap { it.outputDirectory })
}

//val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
//    dependsOn(tasks.dokkaJavadoc)
//    archiveClassifier.set("javadoc")
//    from(tasks.dokkaJavadoc.flatMap { it.outputDirectory })
//}
val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
    dependsOn(tasks.dokkaHtml)
    archiveClassifier.set("html-docs")
    from(tasks.dokkaHtml.flatMap { it.outputDirectory })
}

publishing {
    publications.withType<MavenPublication> {
        artifact(javadocJar.get())

        pom {
            name.set("KtDiscord")
            description.set("Kotlin Multiplatform library for the Discord Interactions API")
            url.set("https://github.com/TempestProject/KtDiscord")

            licenses {
                license {
                    name.set("AGPL-3.0")
                    url.set("https://opensource.org/licenses/AGPL-3.0")
                }
            }
            developers {
                developer {
                    id.set("drakon64")
                    name.set("Adam Chance")
                    email.set("adam.chance10@live.co.uk")
                }
            }
            scm {
                url.set("https://github.com/TempestProject/KtDiscord")
            }
        }
    }

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

signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications)
}

/*npmPublish {
    organization.set("tempestproject")
    packages {
        named("js") {
            packageJson {
                "bugs" by "https://github.com/TempestProject/KtDiscord/issues"
                "homepage" by "https://github.com/TempestProject/KtDiscord"
                "keywords" by arrayOf("discord-interactions", "discord")
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
}*/

tasks.dokkaJekyll.configure {
    outputDirectory.set(buildDir.resolve("dokka"))

    dokkaSourceSets {
        configureEach {
            jdkVersion.set(jvmToolchain)
        }
    }
}
