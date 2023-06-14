plugins {
    id("com.android.library")
}

apply {
    from("$rootDir/compose-module.gradle")
}

android {
    namespace = "com.plcoding.core_ui"
}

dependencies {

}