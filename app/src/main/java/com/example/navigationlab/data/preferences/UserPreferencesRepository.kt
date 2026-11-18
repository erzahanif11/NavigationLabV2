package com.example.navigationlab.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal val Context.userPreferencesDataStore by preferencesDataStore(
    name = "user_preferences"
)

class UserPreferencesRepository(
    private val context: Context
) {
    private val lastSearchQueryKey = stringPreferencesKey("last_search_query")
    private val sortAscendingKey = booleanPreferencesKey("sort_ascending")
    val lastSearchQuery: Flow<String> =
        context.userPreferencesDataStore.data.map { preferences ->
            preferences[lastSearchQueryKey] ?: ""
        }

    val sortAscending: Flow<Boolean> =
        context.userPreferencesDataStore.data.map { preferences ->
            preferences[sortAscendingKey] ?: true
        }

    suspend fun saveLastSearchQuery(value: String) {
        context.userPreferencesDataStore.edit { preferences ->
            preferences[lastSearchQueryKey] = value
        }
    }
    suspend fun saveSortAscending(ascending: Boolean) {
        context.userPreferencesDataStore.edit { preferences ->
            preferences[sortAscendingKey] = ascending
        }
    }
}
