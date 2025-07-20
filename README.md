# InDriver Clone - Kotlin Android App

## 📱 Descripción
Aplicación Android desarrollada en Kotlin usando Jetpack Compose y Hilt para inyección de dependencias.

## 🛠️ Tecnologías Utilizadas

- **Kotlin**: 1.9.22
- **Android Gradle Plugin**: 8.2.2
- **Jetpack Compose**: 2024.02.00
- **Hilt**: 2.51.1
- **KSP**: 1.9.22-1.0.16
- **Navigation Compose**: 2.7.7

## 🔧 Configuración de Hilt

### ⚠️ IMPORTANTE: Configuración para Futuros Proyectos

Hilt ha migrado de KAPT a KSP. Aquí está la configuración correcta:

#### 1. **Versiones Compatibles (2024)**

```toml
# gradle/libs.versions.toml
[versions]
agp = "8.2.2"
kotlin = "1.9.22"
hilt = "2.51.1"
ksp = "1.9.22-1.0.16"
composeBom = "2024.02.00"
kotlinCompilerExtensionVersion = "1.5.8"

[libraries]
hilt-android = { module = "com.google.dagger:hilt-android", version.ref = "hilt" }
hilt-compiler = { module = "com.google.dagger:hilt-android-compiler", version.ref = "hilt" }
androidx-hilt-navigation-compose = { module = "androidx.hilt:hilt-navigation-compose", version = "1.2.0" }

[plugins]
dagger-hilt-android = { id = "com.google.dagger.hilt.android", version.ref = "hilt" }
kotlin-ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }
```

#### 2. **build.gradle.kts (Proyecto Raíz)**

```kotlin
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.dagger.hilt.android) apply false
    alias(libs.plugins.kotlin.ksp) apply false
}
```

#### 3. **app/build.gradle.kts (Módulo App)**

```kotlin
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.dagger.hilt.android)
}

android {
    // ... otras configuraciones
    
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
}

dependencies {
    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
}
```

### 🔄 Migración de KAPT a KSP

**ANTES (KAPT - Deprecado):**
```kotlin
plugins {
    id("kotlin-kapt")
}

dependencies {
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
}
```

**AHORA (KSP - Recomendado):**
```kotlin
plugins {
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.dagger.hilt.android)
}

dependencies {
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}
```

## 🚀 Configuración de la Aplicación

### 1. **Application Class**

```kotlin
@HiltAndroidApp
class InDriverApplication : Application() {
    // Configuración de la aplicación
}
```

### 2. **AndroidManifest.xml**

```xml
<application
    android:name=".InDriverApplication"
    ...>
    <!-- Configuración de la aplicación -->
</application>
```

### 3. **MainActivity**

```kotlin
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    // Tu código aquí
}
```

## 📋 Checklist para Nuevos Proyectos

- [ ] Verificar versiones compatibles en `gradle/libs.versions.toml`
- [ ] Configurar plugins correctos en `build.gradle.kts`
- [ ] Usar KSP en lugar de KAPT
- [ ] Agregar `@HiltAndroidApp` en Application class
- [ ] Agregar `@AndroidEntryPoint` en Activities
- [ ] Configurar `kotlinCompilerExtensionVersion` para Compose
- [ ] Verificar que todas las referencias usen `dagger.hilt.android`

## 🔍 Solución de Problemas Comunes

### Error: "Unresolved reference: hilt"
**Solución:** Cambiar `libs.plugins.hilt` por `libs.plugins.dagger.hilt.android`

### Error: "Kotlin version compatibility"
**Solución:** Usar versiones compatibles:
- Kotlin: 1.9.22
- Compose BOM: 2024.02.00
- Compose Compiler: 1.5.8

### Error: "google-services.json is missing"
**Solución:** Remover el plugin `google-gms-google-services` si no usas Firebase

### Error: "KSP not found"
**Solución:** Usar `libs.plugins.kotlin.ksp` en lugar de `libs.plugins.ksp`

## 📦 Dependencias Principales

```kotlin
dependencies {
    // Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    
    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    
    // Navigation
    implementation(libs.androidx.navigation.compose)
    
    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
}
```

## 🎯 Comandos Útiles

```bash
# Limpiar y compilar
./gradlew clean build

# Compilar solo debug
./gradlew assembleDebug

# Ver dependencias
./gradlew dependencies

# Verificar configuración
./gradlew projects
```

## 📚 Recursos Adicionales

- [Documentación oficial de Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [Migración de KAPT a KSP](https://kotlinlang.org/docs/ksp-overview.html)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation)

---

**Nota:** Este proyecto usa las versiones más recientes y estables de todas las dependencias. Para futuros proyectos, siempre verifica la compatibilidad entre Kotlin, AGP, Compose y Hilt. 