
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
import com.example.bookflow.model.Reservation

@Composable
fun MyReservationsScreen(
    onBack: () -> Unit,
    onReservationSelected: (Reservation) -> Unit
) {
    Page("Mis reservas") {
        val reservations = BookRepository.reservations.toList()

        if (reservations.isEmpty()) {
            Text("Aún no tienes reservas. ¡Explora el catálogo!")
        } else {
            reservations.forEach { reservation ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = reservation.bookTitle,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text("Código: ${reservation.id}")
                        Text("Fecha: ${reservation.reservationDate}")
                        Text("Estado: ${reservation.status}")

                        PrimaryButton("Ver reserva") {
                            onReservationSelected(reservation)
                        }
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
