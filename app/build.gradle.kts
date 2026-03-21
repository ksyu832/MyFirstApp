plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "ru.hramova.myfirstapp"
    compileSdk = 36

    buildFeatures {
        viewBinding = true
    }
    defaultConfig {
        applicationId = "ru.hramova.myfirstapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11

    }
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
        }

    }

    dependencies {
        //noinspection UseTomlInstead
        implementation("androidx.recyclerview:recyclerview:1.4.0")
        // Lifecycle и ViewModel
        //noinspection UseTomlInstead
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.10.0")
        // LiveData
        //noinspection UseTomlInstead
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.10.0")
        // Для viewModels delegation
        //noinspection UseTomlInstead
        implementation("androidx.activity:activity-ktx:1.13.0")

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
    }
}