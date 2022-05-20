plugins {
    id("com.android.application")
    kotlin("android")
}

val composeVersion = "1.1.1"

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.6.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.activity:activity-compose:1.4.0")

    //添加Jetpack Compose依赖
    implementation("androidx.compose.ui:ui:${composeVersion}")
    implementation("androidx.compose.ui:ui-tooling:${composeVersion}")
    implementation("androidx.compose.foundation:foundation:${composeVersion}")
    implementation("androidx.compose.material:material:${composeVersion}")

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.1")
}


android {
    compileSdk = 32
    defaultConfig {
        applicationId = "org.myddd.kmm"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    namespace = "org.myddd.kmm"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}

