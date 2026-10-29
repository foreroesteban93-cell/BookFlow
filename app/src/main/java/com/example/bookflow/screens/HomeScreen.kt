
package com.example.bookflow.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onBooks: () -> Unit,
    onReservations: () -> Unit
) {
    Page("BookFlow 📚") {
        Text("Tu biblioteca, siempre contigo.")
        Text("Encuentra libros y administra tus reservas.")

        Spacer(Modifier.height(12.dp))

        PrimaryButton(
            text = "Ver libros",
            onClick = onBooks
        )

        OutlinedButton(
            onClick = onReservations,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Mis reservas")
        }
    }
}
