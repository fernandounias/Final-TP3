plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
//    id("com.google.dagger.hilt.android")
    id("com.google.dagger.hilt.android") version libs.versions.hiltAndroidGradlePlugin.get()
    id("com.google.gms.google-services")
//    id("kotlin-kapt")
//    id("com.google.devtools.ksp")
    id("com.google.devtools.ksp") version libs.versions.comGoogleDevtoolsKspGradlePlugin.get()
//    id("com.google.devtools.ksp") version "1.9.10"
//    id("com.google.devtools.ksp") version libs.versions.ksp.get()
}

android {
    namespace = "com.example.parcial"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.parcial"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//        sourceCompatibility = JavaVersion.VERSION_17
//        targetCompatibility = JavaVersion.VERSION_17
//        sourceCompatibility = JavaVersion.VERSION_11
//        targetCompatibility = JavaVersion.VERSION_11
        sourceCompatibility = JavaVersion.VERSION_21  // Use JDK 21
        targetCompatibility = JavaVersion.VERSION_21  // Use JDK 21
    }
    kotlinOptions {
//        jvmTarget = "1.8"
        jvmTarget = "21"  // Set Kotlin to target JDK 21
//        jvmTarget = "17"
//        jvmTarget = "11"
//        freeCompilerArgs += "--add-exports=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kotlin {
        jvmToolchain(17)
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
//        languageVersion = JavaLanguageVersion.of(17)
//        languageVersion = JavaLanguageVersion.of(11)
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))

    //Google Fonts
    implementation(libs.androidx.ui.text.google.fonts)

    //Navigation
    implementation(libs.androidx.navigation.compose)

    //ViewModel
    implementation(libs.androidx.lifecycle.common)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //Firebase
    implementation(libs.firebase.database)
    implementation(libs.xfirebase.firestore)
    implementation(platform(libs.firebase.bom))

    //HILT
    implementation(libs.hilt.android)
//    implementation(libs.hilt.compiler)
//    kapt(libs.hilt.compiler)
//    ksp(libs.hilt.ksp)
    implementation(libs.hilt.navigation.compose)
//    implementation(libs.hilt.lifecycle.viewmodel)
//    kapt(libs.hilt.lifecycle.compiler)
//    ksp(libs.hilt.lifecycle.compiler)

    //KSP NOT WORKING...
//    ksp(libs.hilt.compiler)
//    ksp(libs.hilt.lifecycle.viewmodel)

    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.animation.android)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.com.google.devtools.ksp.gradle.plugin)
//    implementation(libs.hilt.android.gradle.plugin)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}