
package com.example.bookflow.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookflow.data.BookRepository
import com.example.bookflow.model.Book

@Composable
fun BookListScreen(
    onBack: () -> Unit,
    onBookSelected: (Book) -> Unit
) {
    Page("Catálogo de libros") {
        BookRepository.books.forEach { book ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = book.title,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text("Autor: ${book.author}")
                    Text("Categoría: ${book.category}")

                    PrimaryButton("Ver detalles") {
                        onBookSelected(book)
                    }
                }
            }
        }

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}
