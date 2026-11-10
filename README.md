```
com.example.navigationlab
├── data/                       ---> LAYER DATA (Pengelolaan Data)
│   ├── model/                  ---> Domain Model (Student.kt)
│   ├── remote/                 ---> Network / API Source
│   │   ├── dto/                ---> Data Transfer Object (UserDto.kt, UserResponse.kt + Mapper)
│   │   ├── RetrofitClient.kt   ---> Builder Singleton Retrofit
│   │   ├── StudentApiService.kt ---> Interface Endpoint Retrofit
│   │   └── StudentRemoteDataSource.kt ---> Implementasi API Call (Enqueue Callback)
│   ├── source/                 ---> Local Data Source (Tempat data lokal/database jika ada)
│   └── repository/             ---> Abstraksi Data (StudentRepository.kt & DefaultStudentRepository.kt)
│
├── ui/                         ---> LAYER PRESENTATION / UI (Tampilan & ViewModel)
│   ├── home/                   ---> Fitur Home
│   │   ├── HomeUiState.kt      ---> State khusus HomeScreen
│   │   └── HomeViewModel.kt    ---> ViewModel pengelola logika & state Home
│   ├── detail/                 ---> Fitur Detail
│   │   ├── DetailUiState.kt    ---> State khusus DetailScreen
│   │   └── DetailViewModel.kt  ---> ViewModel pengelola logika & state Detail
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
