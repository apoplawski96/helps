object Versions {

    object AndroidSystem {

        const val minSdk = 21
        const val targetSdk = 30
        const val compileSdk = 31
        const val buildToolsVersions = "30.0.3"
    }

    object Compose {

        const val composeVersion = "1.0.2"
        const val accompanist = "0.18.0"
    }
}

object PluginIds {

    const val application = "com.android.application"
    const val library = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val hilt = "dagger.hilt.android.plugin"
    const val googleServices = "com.google.gms.google-services"
}

object Dependencies {

    const val androidCoreKtx = "androidx.core:core-ktx:1.6.0"
    const val androidAppCompat = "androidx.appcompat:appcompat:1.3.1"
    const val material = "com.google.android.material:material:1.4.0"

    object Compose {

        const val ui = "androidx.compose.ui:ui:${Versions.Compose.composeVersion}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.Compose.composeVersion}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.Compose.composeVersion}"
        const val material = "androidx.compose.material:material:${Versions.Compose.composeVersion}"
        const val materialIcons = "androidx.compose.material:material-icons-core:${Versions.Compose.composeVersion}"
        const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.Compose.composeVersion}"
        const val activity = "androidx.activity:activity-compose:1.3.1"
        const val navigation = "androidx.navigation:navigation-compose:2.4.0-alpha09"
        const val liveData = "androidx.compose.runtime:runtime-livedata:${Versions.Compose.composeVersion}"
        const val rxJava = "androidx.compose.runtime:runtime-rxjava2:${Versions.Compose.composeVersion}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
        const val viewModel2 = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0-beta01"
        const val junit = "androidx.compose.ui:ui-test-junit4:1.0.2"

        object Accompanist {

            const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.Compose.accompanist}"
            const val navigationAnimation = "com.google.accompanist:accompanist-navigation-animation:${Versions.Compose.accompanist}"
            const val insets = "com.google.accompanist:accompanist-insets:${Versions.Compose.accompanist}"
            const val insetsUi = "com.google.accompanist:accompanist-insets-ui:${Versions.Compose.accompanist}"
        }
    }

    object ViewModel {

        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
        const val extensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    }

    object Coroutines {

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2-native-mt"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2-native-mt"
    }

    object Firebase {

        const val bom = "com.google.firebase:firebase-bom:28.4.0"
        const val analytics = "com.google.firebase:firebase-analytics"
        const val auth = "com.google.firebase:firebase-auth-ktx"
        const val firestore = "com.google.firebase:firebase-firestore-ktx"
    }

    object Hilt {

        const val android = "com.google.dagger:hilt-android:2.38.1"
        const val compiler = "com.google.dagger:hilt-compiler:2.38.1"
        const val navigation = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"
        const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
        const val viewModelCompiler = "androidx.hilt:hilt-compiler:1.0.0"
    }

    object UnitTest {

        const val junit4 = "junit:junit:4.+"
    }

    object AndroidTest {

        const val junit = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }
}