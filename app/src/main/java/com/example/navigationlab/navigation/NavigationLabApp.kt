package com.example.navigationlab.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationlab.Routes
import com.example.navigationlab.data.remote.RetrofitClient
import com.example.navigationlab.data.remote.StudentRemoteDataSource
import com.example.navigationlab.data.repository.DefaultStudentRepository
import com.example.navigationlab.ui.detail.DetailViewModel
import com.example.navigationlab.ui.home.HomeViewModel
import com.example.navigationlab.ui.screen.AboutScreen
import com.example.navigationlab.ui.screen.DetailScreen
import com.example.navigationlab.ui.screen.HomeScreen
import com.example.navigationlab.ui.screen.ProfileScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun NavigationLabApp() {
    val navController = rememberNavController()
    val remoteDataSource = remember {
        StudentRemoteDataSource(RetrofitClient.apiService)
    }
    val repository = remember {
        DefaultStudentRepository(remoteDataSource)
    }

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            val homeVM: HomeViewModel = viewModel(
                factory = HomeViewModel.factory(repository)
            )
            val uiState by homeVM.uiState.collectAsStateWithLifecycle()
            val searchQuery by homeVM.searchQuery.collectAsStateWithLifecycle()
            HomeScreen(
                uiState = uiState,
                searchQuery = searchQuery,
                onSearchQueryChange = homeVM::onSearchQueryChange,
                onStudentClick = { id -> navController.navigate(Routes.detail(id)) },
                onOpenDetail = { id ->
                    navController.navigate(Routes.detail(id))
                },
                onOpenProfile = {
                    navController.navigate(Routes.PROFILE)
                },
                onOpenAbout = {
                    navController.navigate(Routes.ABOUT)
                },
                onRetry = homeVM::retry,
                onRefresh = homeVM::retry
            )
        }

        composable(
            route = Routes.DETAIL,
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("studentId") ?: return@composable

            val detailVM: DetailViewModel = viewModel(
                factory = DetailViewModel.factory(repository)
            )
            val uiState by detailVM.uiState.collectAsStateWithLifecycle()

            LaunchedEffect(id) {
                detailVM.loadStudent(id)
            }

            DetailScreen(
                uiState = uiState,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.PROFILE) {
            ProfileScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.ABOUT) {
            AboutScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}
