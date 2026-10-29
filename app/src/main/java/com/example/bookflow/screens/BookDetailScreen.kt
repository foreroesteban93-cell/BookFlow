
package com.example.bookflow.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookflow.model.Book
import com.example.bookflow.sections.BookInfoSection

@Composable
fun BookDetailScreen(
    book: Book,
    onReserve: () -> Unit,
    onBack: () -> Unit
) {
    Page("Detalle del libro") {
        BookInfoSection(book = book)

        Button(
            onClick = onReserve,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reservar libro")
        }

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver al catálogo")
        }
    }
}
