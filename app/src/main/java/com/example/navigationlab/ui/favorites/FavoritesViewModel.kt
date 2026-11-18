package com.example.navigationlab.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.navigationlab.data.preferences.UserPreferencesRepository
import com.example.navigationlab.data.repository.FavoriteRepository
import com.example.navigationlab.ui.favorites.FavoritesUiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val preferencesRepository: UserPreferencesRepository,
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {
    val uiState: StateFlow<FavoritesUiState> = combine(
        favoriteRepository.observeFavorites(),
        preferencesRepository.sortAscending
    ) { favorites, sortAscending ->
        val sortedList = if (sortAscending) {
            favorites.sortedBy { it.firstName }
        } else {
            favorites.sortedByDescending { it.firstName }
        }
        FavoritesUiState(
            favorites = sortedList,
            sortAscending = sortAscending
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = FavoritesUiState()
    )

    fun toggleSortOrder(){
        viewModelScope.launch{
            val currentSort = uiState.value.sortAscending
            preferencesRepository.saveSortAscending(!currentSort)
        }
    }

    companion object {
        fun factory(
            favoriteRepository: FavoriteRepository,
            preferencesRepository: UserPreferencesRepository
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return FavoritesViewModel(preferencesRepository, favoriteRepository) as T
            }
        }
    }
}