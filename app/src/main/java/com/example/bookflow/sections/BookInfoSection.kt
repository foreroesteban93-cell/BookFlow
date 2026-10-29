
package com.example.bookflow.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookflow.model.Book

@Composable
fun BookInfoSection(book: Book) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = book.title,
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "Autor: ${book.author}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Categoría: ${book.category}",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Descripción",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = book.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
