/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/build.gradle.kts
* Descrição: Configuração do Gradle para o módulo de aplicativo Android.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 24/05/2025
*/
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.hilt.gradle.plugin)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "br.edu.senai.cac"
    compileSdk = 36

    /* Habilita a geração da classe dinâmica BuildConfig */
    buildFeatures.buildConfig = true

    defaultConfig {
        applicationId = "br.edu.senai.cac"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        /* Otimização para compilações de lançamento */
        release {
            buildConfigField("String", "BUILD_TYPE", "\"Release\"")
            resValue("string", "BUILD_TYPE", "Release")

            isMinifyEnabled = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }

        /* Adição de sufixo nas compilações de depuração */
        debug {
            buildConfigField("String", "BUILD_TYPE", "\"Debug\"")
            resValue("string", "BUILD_TYPE", "Debug")

            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    /* Implementações para compilação de teste */
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(platform(libs.androidx.compose.bom))

    /* Processador de anotações */
    kapt(libs.hilt.compiler)
    kapt(libs.androidx.room.compiler)

    /* Implementações para compilação de depuração */
    debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation(libs.androidx.ui.tooling)

    /* Implementações para compilação de lançamento */
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.room)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.hilt)
    implementation(libs.hilt.navigation.compose)
    implementation(platform(libs.androidx.compose.bom))

    /* Implementações para compilação de teste */
    testImplementation(libs.junit)
}
