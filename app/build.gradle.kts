plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "com.present.pokemon"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.present.pokemon"
        minSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Dagger-Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")


    val lifecycle_version = "2.8.0"

    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Coil for image downloading from the internet
    implementation(libs.coil.compose)

    // Retrofit
    implementation(libs.retrofit)
    // OkHttp Client
    implementation(libs.okhttp)
    // Json Converter
    implementation(libs.converter.gson)

    // Room dependency
    val room_version = "2.6.1"

    /*implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)

    // To use Kotlin annotation processing tool (kapt)
    kapt(libs.androidx.room.compiler)*/
    implementation (libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    // Navigation in jetpack compose
    val nav_version = "2.7.7"

    implementation(libs.androidx.navigation.compose)

    // Extended jetpack compose icons
    implementation (libs.androidx.material.icons.extended)

    //Splash screen
    implementation("androidx.core:core-splashscreen:1.0.0")

    // Datastore
    implementation( "androidx.datastore:datastore-preferences:1.0.0")

    // Camerax implementation
    val cameraxVersion = "1.3.1"
    implementation ("androidx.camera:camera-core:${cameraxVersion}")
    implementation ("androidx.camera:camera-camera2:${cameraxVersion}")
    implementation ("androidx.camera:camera-view:${cameraxVersion}")
    implementation ("androidx.camera:camera-lifecycle:$cameraxVersion")



    implementation(platform("androidx.compose:compose-bom:2024.05.00"))

    // Coil library
    implementation("io.coil-kt:coil-compose:2.6.0")


    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // paging library
    implementation("androidx.paging:paging-runtime:3.3.1")


}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}