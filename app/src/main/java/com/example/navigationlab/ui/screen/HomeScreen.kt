package com.example.navigationlab.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navigationlab.ui.home.HomeUiState

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onOpenDetail: (Int) -> Unit,
    onOpenProfile: () -> Unit,
    onOpenAbout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = spacedBy(12.dp)
    ) {
        Text("Home", style = MaterialTheme.typography.headlineMedium)
        LazyColumn {
            items(uiState.students ?: emptyList()) { student ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onOpenDetail(student.id)
                        }
                        .padding(16.dp)
                ) {
                    Text("ID: ${student.id}")
                    Text("Nama: ${student.name}")
                }
            }
        }
        OutlinedButton(onClick = onOpenProfile) {
            Text("Buka Profile")
        }
        OutlinedButton(onClick = onOpenAbout) {
            Text("About")
        }
    }
}
