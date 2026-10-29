
package com.example.bookflow.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookflow.model.Reservation

@Composable
fun ReservationDetailScreen(
    reservation: Reservation,
    onBack: () -> Unit,
    onRenew: () -> Unit,
    onCancel: () -> Unit
) {
    Page("Detalle de reserva") {
        Text("Libro: ${reservation.bookTitle}")
        Text("Autor: ${reservation.author}")
        Text("Código: ${reservation.id}")
        Text("Fecha: ${reservation.reservationDate}")
        Text("Estado: ${reservation.status}")

        if (reservation.status == "Activa") {
            PrimaryButton("Renovar reserva", onRenew)

            OutlinedButton(
                onClick = onCancel,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancelar reserva")
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
