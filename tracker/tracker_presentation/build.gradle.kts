apply {
    from("$rootDir/compose-module.gradle")
}

plugins {
    id("com.google.devtools.ksp") version "1.8.21-1.0.11"
    id("com.android.library")
}

android {
    namespace = "com.plcoding.tracker_presentation"
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "tracker")
    arg("compose-destinations.useComposableVisibility", "true")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))
    "implementation"(project(Modules.trackerDomain))

    "implementation"(Coil.coilCompose)
    "ksp"(Compose.composeDestinationsKsp)
}