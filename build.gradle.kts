plugins {
    kotlin("multiplatform") version "2.0.10"
    id("dev.petuska.npm.publish") version "3.4.3"
}

group = "org.hisp.dhis.alldevs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
    jvm {
        withJava()
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }
    js {
        nodejs()
        useEsModules()
        generateTypeScriptDefinitions()
        binaries.library()
    }
    val hostOs = System.getProperty("os.name")
    val isArm64 = System.getProperty("os.arch") == "aarch64"
    val isMingwX64 = hostOs.startsWith("Windows")
    when {
        hostOs == "Mac OS X" && isArm64 -> macosArm64("native") { binaries { sharedLib() } }
        hostOs == "Mac OS X" && !isArm64 -> macosX64("native") { binaries { sharedLib() } }
        hostOs == "Linux" && isArm64 -> linuxArm64("native") { binaries { sharedLib() } }
        hostOs == "Linux" && !isArm64 -> linuxX64("native") { binaries { sharedLib() } }
        isMingwX64 -> mingwX64("native") { binaries { sharedLib() } }
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.js.ExperimentalJsExport")
            }
        }
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}
