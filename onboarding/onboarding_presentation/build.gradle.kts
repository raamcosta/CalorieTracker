apply {
    from("$rootDir/compose-module.gradle")
}

plugins {
    id("com.google.devtools.ksp") version "1.8.21-1.0.11"
    id("com.android.library")
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "onboarding")
    arg("compose-destinations.useComposableVisibility", "true")
}

android {
    namespace = "com.plcoding.onboarding_presentation"
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))
    "implementation"(project(Modules.onboardingDomain))

    "ksp"(Compose.composeDestinationsKsp)
}