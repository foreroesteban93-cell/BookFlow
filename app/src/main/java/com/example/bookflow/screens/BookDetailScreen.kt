
package com.example.bookflow.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookflow.model.Book

@Composable
fun BookDetailScreen(
    book: Book,
    onBack: () -> Unit,
    onReserve: () -> Unit
) {
    Page("Detalle del libro") {
        Text(
            text = book.title,
            style = MaterialTheme.typography.headlineSmall
        )

        Text("Autor: ${book.author}")
        Text("Categoría: ${book.category}")
        Text(book.description)

        PrimaryButton(
            text = "Reservar libro",
            onClick = onReserve
        )

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver al catálogo")
        }
    }
}
