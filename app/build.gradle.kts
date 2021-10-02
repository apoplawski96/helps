plugins {
    id(PluginIds.application)
    id(PluginIds.kotlinAndroid)
    id(PluginIds.kotlinKapt)
    id(PluginIds.hilt)
    id(PluginIds.googleServices)
}

android {
    compileSdk = Versions.AndroidSystem.compileSdk
    buildToolsVersion = Versions.AndroidSystem.buildToolsVersions

    defaultConfig {
        applicationId = "com.helps"
        minSdk = Versions.AndroidSystem.minSdk
        targetSdk = Versions.AndroidSystem.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.composeVersion
        kotlinCompilerVersion = "1.4.32"
    }
}

dependencies {
    implementation (project(":navigation"))
    implementation(Dependencies.androidCoreKtx)
    implementation(Dependencies.androidAppCompat)
    implementation(Dependencies.material)

    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiTooling)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.materialIcons)
    implementation(Dependencies.Compose.materialIconsExtended)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.liveData)
    implementation(Dependencies.Compose.rxJava)
    implementation(Dependencies.Compose.navigation)
    implementation(Dependencies.Compose.viewModel2)
    implementation(Dependencies.Compose.viewModel)
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.2")

    implementation(Dependencies.Compose.Accompanist.systemUiController)
    implementation(Dependencies.Compose.Accompanist.navigationAnimation)
    implementation(Dependencies.Compose.Accompanist.insets)
    implementation(Dependencies.Compose.Accompanist.insetsUi)


    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Coroutines.android)

    implementation (platform(Dependencies.Firebase.bom))
    implementation(Dependencies.Firebase.analytics)
    implementation(Dependencies.Firebase.auth)

    implementation(Dependencies.Hilt.android)
    implementation(Dependencies.Hilt.navigation)
    implementation(Dependencies.Hilt.viewModel)
    kapt (Dependencies.Hilt.compiler)
    kapt (Dependencies.Hilt.viewModelCompiler)

    implementation(Dependencies.ViewModel.viewModelKtx)
    implementation(Dependencies.ViewModel.extensions)
    implementation(Dependencies.ViewModel.runtime)


    testImplementation(Dependencies.UnitTest.junit4)
    androidTestImplementation(Dependencies.AndroidTest.junit)
    androidTestImplementation(Dependencies.AndroidTest.espresso)
}

//kapt {
//    correctErrorTypes = true
//}

