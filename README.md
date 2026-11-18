# NavigationLab V2 🚀

NavigationLab V2 adalah aplikasi Android berbasis **Jetpack Compose** yang dirancang sebagai lab pembelajaran modular untuk eksplorasi Navigasi Android, Arsitektur Bersih (Repository Pattern), integrasi REST API dengan Retrofit, pemrograman asinkron **Kotlin Coroutines & Flow**, serta penyimpanan data lokal menggunakan **Preferences DataStore & Room Database**.

---

## 🛠️ Tech Stack & Dependencies

- **UI Framework**: Jetpack Compose, Material 3
- **Navigation**: Jetpack Navigation Compose
- **Network / API**: Retrofit, Gson Converter
- **Local Persistence**: 
  - **Room Database** (SQLite Abstraction Layer) + **KSP** (Kotlin Symbol Processing)
  - **Jetpack Preferences DataStore** (Key-Value Storage)
- **Asynchronous & State Management**: Kotlin Coroutines, Kotlin Flow (`StateFlow`), Lifecycle ViewModel Compose (`lifecycle-viewmodel-ktx`, `lifecycle-runtime-compose`)

---

## 📦 Recent Updates & Changelog

### 🗄️ Module 9: DataStore & Room Database (Latest Update)
- **Preferences DataStore (`UserPreferencesRepository`)**: Menyimpan dan memulihkan kata kunci pencarian terakhir (`last_search_query`) secara persisten pada `HomeViewModel`.
- **Room Database (`AppDatabase`, `FavoriteStudentDao`, `FavoriteStudentEntity`)**: Implementasi penyimpanan database SQLite lokal untuk fitur favorit.
- **`FavoriteRepository`**: Abstraksi akses data favorit (tambah, hapus, dan observasi status favorit secara *reactive* menggunakan Flow).
- **Layar & Fitur Favorit (`FavoriteScreen`, `FavoritesViewModel`)**: Halaman khusus untuk menampilkan daftar mahasiswa favorit yang tersimpan secara lokal.
- **Navigasi & Route**: Penambahan rute `FAVORITES` ("favorites") di `routes.kt` dan `NavigationLabApp.kt`.

### ⚡ Module 8: Kotlin Coroutines & Flow
- Implementasi **Kotlin Coroutines** untuk manajemen proses asinkron dan background operations.
- Penggunaan **Kotlin Flow** dan `StateFlow` di dalam `HomeViewModel` dan `DetailViewModel` untuk reactive state management.
- Integrasi `collectAsStateWithLifecycle()` di Compose UI (`HomeScreen`) untuk efisiensi lifecycle-aware state collection.

### 🌐 Module 7: REST API Retrofit Implementation
- Integrasi **Retrofit** dan Gson untuk komunikasi jaringan dengan API eksternal.
- Pembuatan DTO (`UserDto`, `UserResponse`) beserta mapper.
- Konfigurasi `RetrofitClient` singleton dan `StudentApiService` endpoint.

---

## 📂 Project Structure & Directory Tree

```text
com.example.navigationlab
├── data/                       ---> LAYER DATA (Pengelolaan Data)
│   ├── local/                  ---> Local Database (Room)
│   │   ├── AppDatabase.kt      ---> RoomDatabase Singleton / Provider
│   │   ├── FavoriteStudentDao.kt ---> Data Access Object (DAO) Room
│   │   └── FavoriteStudentEntity.kt ---> Entity Tabel Database (favorite_students)
│   ├── model/                  ---> Domain Model (Student.kt, Response.kt)
│   ├── preferences/            ---> Key-Value Local Storage (DataStore)
│   │   └── UserPreferencesRepository.kt ---> Pengelola Preferences DataStore
│   ├── remote/                 ---> Network / API Source
│   │   ├── dto/                ---> Data Transfer Object (UserDto.kt, UserResponse.kt + Mapper)
│   │   ├── RetrofitClient.kt   ---> Builder Singleton Retrofit
│   │   ├── StudentApiService.kt ---> Interface Endpoint Retrofit
│   │   └── StudentRemoteDataSource.kt ---> Implementasi API Call
│   ├── source/                 ---> Local Data Source
│   └── repository/             ---> Abstraksi Data (StudentRepository, FavoriteRepository)
│
├── ui/                         ---> LAYER PRESENTATION / UI (Tampilan & ViewModel)
│   ├── home/                   ---> Fitur Home
│   │   ├── HomeUiState.kt      ---> State khusus HomeScreen
│   │   └── HomeViewModel.kt    ---> ViewModel Home (Search, Coroutines, Flow, Preferences)
│   ├── detail/                 ---> Fitur Detail
│   │   ├── DetailUiState.kt    ---> State khusus DetailScreen (Status Favorite)
│   │   └── DetailViewModel.kt  ---> ViewModel Detail (Toggle Favorite)
│   ├── favorites/              ---> Fitur Favorites
│   │   ├── FavoritesUiState.kt ---> State khusus FavoriteScreen
│   │   └── FavoritesViewModel.kt ---> ViewModel pengelola daftar favorit dari Room
│   ├── screen/                 ---> UI Components (Jetpack Compose)
│   │   ├── HomeScreen.kt
│   │   ├── DetailScreen.kt
│   │   ├── FavoriteScreen.kt
│   │   ├── ProfileScreen.kt
│   │   └── AboutScreen.kt
│   └── theme/                  ---> Styling, Warna, & Tipografi Material Theme
│
├── navigation/                 ---> LAYER NAVIGASI
│   └── NavigationLabApp.kt     ---> NavHost & Dependency Injection (Repositories & Database)
│
├── MainActivity.kt             ---> Entry Point Aplikasi
└── routes.kt                   ---> Definisi Rute Navigasi
```

---

## 🚀 Getting Started

1. Buka proyek ini di **Android Studio**.
2. Lakukan Gradle Sync untuk memastikan dependensi terbaru ter-load.
3. Jalankan aplikasi pada emulator atau perangkat Android fisik.
