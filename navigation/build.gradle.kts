plugins {
    id(PluginIds.library)
    id(PluginIds.kotlinAndroid)
    id(PluginIds.kotlinKapt)
}

android {
    compileSdk = Versions.AndroidSystem.compileSdk
    buildToolsVersion = Versions.AndroidSystem.buildToolsVersions
    defaultConfig {
        minSdk = Versions.AndroidSystem.minSdk
        targetSdk = Versions.AndroidSystem.targetSdk
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    lint {
        isWarningsAsErrors = true
        isAbortOnError = false
    }
    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.composeVersion
    }
}

dependencies {
    implementation(Dependencies.Compose.navigation)

    implementation(Dependencies.Hilt.android)
    implementation(Dependencies.Hilt.navigation)
    implementation(Dependencies.Hilt.viewModel)
    kapt (Dependencies.Hilt.compiler)
    kapt (Dependencies.Hilt.viewModelCompiler)
}
