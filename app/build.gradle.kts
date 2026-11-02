plugins {
    id("com.android.application")
}

android {
    namespace = "dev.tvos.launcher"
    compileSdk = 36

    defaultConfig {
        applicationId = "dev.tvos.launcher"
        minSdk = 28
        targetSdk = 28          // match the TV; avoids newer background/perm restrictions
        versionCode = 1
        versionName = "0.1"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
            signingConfig = signingConfigs.getByName("debug") // sideload only
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
