
package com.example.bookflow.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookflow.composables.Page
import com.example.bookflow.data.BookRepository
import com.example.bookflow.model.Reservation
import com.example.bookflow.sections.ReservationCard

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
                ReservationCard(
                    reservation = reservation,
                    onViewDetails = {
                        onReservationSelected(reservation)
                    }
                )
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
