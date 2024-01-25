plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.australiacityapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.australiacityapp"
        minSdk = 21
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.androidx.compose)
    // Gson
    implementation(libs.google.gson)
    // Lifecycle
    implementation(libs.bundles.androidx.lifecycle)
    // Coroutines
    implementation(libs.bundles.kotlinx.coroutines)
    // Dagger Hilt
    implementation(libs.google.hilt)
    kapt(libs.google.hilt.compiler)
    // Test
    testImplementation(libs.junit)
    testImplementation(libs.androidx.junit)
    // Architecture Test
    testImplementation(libs.test.arch.core)
    // Coroutines Test
    testImplementation(libs.test.coroutines)
    // Truth Test
    testImplementation(libs.test.google.truth)
    // Android Test
    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(platform(libs.androidx.test.compose.bom))
    androidTestImplementation(libs.bundles.androidx.test.compose)
    androidTestImplementation(libs.androidx.espresso.core)
    // Android Architecture Test
    androidTestImplementation(libs.androidx.test.arch.core)
    // Android Coroutines Test
    androidTestImplementation(libs.androidx.test.coroutines)
    // Android Truth Test
    androidTestImplementation(libs.androidx.test.google.truth)
    // Debug
    debugImplementation(libs.bundles.androidx.debug.test.compose)
}