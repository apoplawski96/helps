plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    // This breaks compose causing an error
    // java.lang.NoSuchMethodError: No static method setContent$default(Landroidx/activity/ComponentActivity;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function0;ILjava/lang/Object;)V in class Landroidx/activity/compose/ComponentActivityKt; or its super classes (declaration of 'androidx.activity.compose.ComponentActivityKt' appears in /data/app/com.footballco.mobile.android.goal-2/base.apk)
    // Because of this the precompiled plugin cannot be used and the config has to be copy pasted into every module
    // implementation("com.android.tools.build:gradle:7.0.0")
}
