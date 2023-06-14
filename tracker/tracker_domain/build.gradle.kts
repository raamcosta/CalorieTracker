apply {
    from("$rootDir/base-module.gradle")
}

plugins {
    id("com.android.library")
}

android {
    namespace = "com.plcoding.tracker_domain"
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(Coroutines.coroutines)
}