
package com.example.bookflow.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookflow.data.BookRepository
import com.example.bookflow.model.Book
import com.example.bookflow.sections.BookCard

@Composable
fun BookListScreen(
    onBack: () -> Unit,
    onBookSelected: (Book) -> Unit
) {
    Page("Catálogo de libros") {
        Text("Selecciona un libro para ver sus detalles.")

        BookRepository.books.forEach { book ->
            BookCard(
                book = book,
                onViewDetails = {
                    onBookSelected(book)
                }
            )
        }

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}
