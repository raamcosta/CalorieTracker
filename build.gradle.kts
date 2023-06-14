plugins {
    id("com.github.ben-manes.versions") version "0.47.0"
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.hiltAndroidGradlePlugin)
        classpath(Build.kotlinGradlePlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

/**
 * Run ./gradlew dependencyUpdates to check for new updates
 * in dependencies used.
 * More info at: https://github.com/ben-manes/gradle-versions-plugin
 */
tasks.withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
    rejectVersionIf {
//        false
        // Don't allow non-stable versions, unless we are already using one for this dependency
        isNonStable(candidate.version) && !isNonStable(currentVersion)
    }
}

/**
 * Decides if [version] is stable or not.
 */
fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return !isStable
}