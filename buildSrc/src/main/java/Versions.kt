const val composeCompilerVersion = "1.4.7"

private const val composeVersion = "1.5.0-beta02"
private const val composeDestinationsVersion = "1.9.42-beta"
private const val androidBuildToolsVersion = "8.0.2"
private const val kotlinVersion = "1.8.21"
private const val activityComposeVersion = "1.7.2"

private const val materialVersion = "1.9.0"
private const val junitVersion = "4.13.2"
private const val junitAndroidExtVersion = "1.1.5"
private const val coroutinesTestVersion = "1.7.1"
private const val truthVersion = "1.1.4"
private const val mockkVersion = "1.13.5"
private const val turbineVersion = "0.7.0"
private const val mockWebServerVersion = "4.9.3"
private const val testRunnerVersion = "1.5.2"
private const val roomVersion = "2.5.1"
private const val retrofitVersion = "2.9.0"
private const val okHttpVersion = "5.0.0-alpha.2"
private const val moshiVersion = "1.13.0"
private const val hiltAndroidGradlePluginVersion = "2.46.1"
private const val hiltNavigationComposeVersion = "1.1.0-alpha01"
private const val lifecycleVersion = "2.6.1"
private const val coilVersion = "2.4.0"
private const val coreKtxVersion = "1.7.0"
private const val appCompatVersion = "1.6.1"
private const val daggerHiltVersion = "2.46.1"
private const val coroutinesVersion = "1.7.1"

object Testing {
    const val junit4 = "junit:junit:$junitVersion"
    const val junitAndroidExt = "androidx.test.ext:junit:$junitAndroidExtVersion"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTestVersion"
    const val truth = "com.google.truth:truth:$truthVersion"
    const val mockk = "io.mockk:mockk:$mockkVersion"
    const val mockkAndroid = "io.mockk:mockk-android:$mockkVersion"
    const val turbine = "app.cash.turbine:turbine:$turbineVersion"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$mockWebServerVersion"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:$composeVersion"
    const val hiltTesting = "com.google.dagger:hilt-android-testing:${daggerHiltVersion}"
    const val testRunner = "androidx.test:runner:$testRunnerVersion"
}

object Room {
    const val roomRuntime = "androidx.room:room-runtime:$roomVersion"
    const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    const val roomKtx = "androidx.room:room-ktx:$roomVersion"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
}

object Moshi {
    const val moshiCodegen = "kapt 'com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion'"
}

object Google {
    const val material = "com.google.android.material:material:$materialVersion"
}

object DaggerHilt {
    const val hiltAndroid = "com.google.dagger:hilt-android:$daggerHiltVersion"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$daggerHiltVersion"
}

object Build {
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}"
    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltAndroidGradlePluginVersion"
}

object Coroutines {
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
}

object Compose {
    const val material = "androidx.compose.material:material:$composeVersion"
    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val runtime = "androidx.compose.runtime:runtime:$composeVersion"
    const val compiler = "androidx.compose.compiler:compiler:$composeCompilerVersion"
    const val composeDestinations = "io.github.raamcosta.compose-destinations:core:$composeDestinationsVersion"
    const val composeDestinationsKsp = "io.github.raamcosta.compose-destinations:ksp:$composeDestinationsVersion"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
}

object Coil {
    const val coilCompose = "io.coil-kt:coil-compose:$coilVersion"
}

object AndroidX {
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
}