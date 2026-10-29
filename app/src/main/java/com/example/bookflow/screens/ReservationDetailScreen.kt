
package com.example.bookflow.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookflow.model.Reservation
import com.example.bookflow.sections.ReservationInfoSection

@Composable
fun ReservationDetailScreen(
    reservation: Reservation,
    onRenew: () -> Unit,
    onCancel: () -> Unit,
    onBack: () -> Unit
) {
    Page("Detalle de la reserva") {
        ReservationInfoSection(reservation = reservation)

        Button(
            onClick = onRenew,
            modifier = Modifier.fillMaxWidth(),
            enabled = reservation.status == "Activa"
        ) {
            Text("Renovar reserva")
        }

        OutlinedButton(
            onClick = onCancel,
            modifier = Modifier.fillMaxWidth(),
            enabled = reservation.status == "Activa"
        ) {
            Text("Cancelar reserva")
        }

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}
