# NavigationLab V2 🚀

NavigationLab V2 adalah aplikasi Android berbasis **Jetpack Compose** yang dirancang sebagai lab pembelajaran modular untuk eksplorasi Navigasi Android, Arsitektur Bersih (Repository Pattern), integrasi REST API dengan Retrofit, serta pemrograman asinkron menggunakan **Kotlin Coroutines & Flow**.

---

## 🛠️ Tech Stack & Dependencies

- **UI Framework**: Jetpack Compose, Material 3
- **Navigation**: Jetpack Navigation Compose
- **Network / API**: Retrofit, Gson Converter
- **Asynchronous & State Management**: Kotlin Coroutines, Kotlin Flow (`StateFlow`), Lifecycle ViewModel Compose (`lifecycle-viewmodel-ktx`, `lifecycle-runtime-compose`)

---

## 📦 Recent Updates & Changelog

### ⚡ Module 8: Kotlin Coroutines & Flow (Latest Update)
- Implementasi **Kotlin Coroutines** untuk manajemen proses asinkron dan background operations.
- Penggunaan **Kotlin Flow** dan `StateFlow` di dalam `HomeViewModel` dan `DetailViewModel` untuk reactive state management.
- Integrasi `collectAsStateWithLifecycle()` di Compose UI (`HomeScreen`) untuk efisiensi lifecycle-aware state collection.

### 🌐 Module 7: REST API Retrofit Implementation
- Integrasi **Retrofit** dan Gson untuk komunikasi jaringan dengan API eksternal.
- Pembuatan DTO (`UserDto`, `UserResponse`) beserta mapper.
- Konfigurasi `RetrofitClient` singleton dan `StudentApiService` endpoint.

### 🎨 UI Enhancements & State Handling
- Perbaikan layout UI dan penanganan status *Loading* serta *Error* secara responsif di berbagai layar.

---

## 📂 Project Structure & Directory Tree

```text
com.example.navigationlab
├── data/                       ---> LAYER DATA (Pengelolaan Data)
│   ├── model/                  ---> Domain Model (Student.kt, Response.kt)
│   ├── remote/                 ---> Network / API Source
│   │   ├── dto/                ---> Data Transfer Object (UserDto.kt, UserResponse.kt + Mapper)
│   │   ├── RetrofitClient.kt   ---> Builder Singleton Retrofit
│   │   ├── StudentApiService.kt ---> Interface Endpoint Retrofit
│   │   └── StudentRemoteDataSource.kt ---> Implementasi API Call
│   ├── source/                 ---> Local Data Source (Tempat data lokal/database jika ada)
│   └── repository/             ---> Abstraksi Data (StudentRepository.kt & DefaultStudentRepository.kt)
│
├── ui/                         ---> LAYER PRESENTATION / UI (Tampilan & ViewModel)
│   ├── home/                   ---> Fitur Home
│   │   ├── HomeUiState.kt      ---> State khusus HomeScreen
│   │   └── HomeViewModel.kt    ---> ViewModel pengelola logika & state Home (Flow/Coroutines)
│   ├── detail/                 ---> Fitur Detail
│   │   ├── DetailUiState.kt    ---> State khusus DetailScreen
│   │   └── DetailViewModel.kt  └── ViewModel pengelola logika & state Detail
│   ├── screen/                 ---> UI Components (Jetpack Compose)
│   │   ├── HomeScreen.kt
│   │   ├── DetailScreen.kt
│   │   ├── ProfileScreen.kt
│   │   └── AboutScreen.kt
│   └── theme/                  ---> Styling, Warna, & Tipografi Material Theme
│
├── navigation/                 ---> LAYER NAVIGASI
│   └── NavigationLabApp.kt     ---> NavHost & Manual Dependency Injection
│
├── MainActivity.kt             ---> Entry Point Aplikasi
└── routes.kt                   ---> Definisi Rute Navigasi
```

---

## 🚀 Getting Started

1. Buka proyek ini di **Android Studio**.
2. Lakukan Gradle Sync untuk memastikan dependensi terbaru ter-load.
3. Jalankan aplikasi pada emulator atau perangkat Android fisik.
