
package com.example.bookflow.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.bookflow.composables.Page
import com.example.bookflow.composables.PrimaryButton
import com.example.bookflow.model.Reservation

@Composable
fun RenewReservationScreen(
    reservation: Reservation,
    onBack: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var newDate by remember(reservation.id) {
        mutableStateOf(reservation.reservationDate)
    }

    var showError by remember {
        mutableStateOf(false)
    }

    Page("Renovar reserva") {
        Text("Libro: ${reservation.bookTitle}")
        Text("Fecha actual: ${reservation.reservationDate}")

        OutlinedTextField(
            value = newDate,
            onValueChange = {
                newDate = it
                showError = false
            },
            label = { Text("Nueva fecha (DD/MM/AAAA)") },
            placeholder = { Text("Ej. 20/12/2026") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        if (showError) {
            Text(
                text = "Escribe la fecha con el formato DD/MM/AAAA.",
                color = MaterialTheme.colorScheme.error
            )
        }

        PrimaryButton("Confirmar renovación") {
            val validFormat =
                Regex("""\d{2}/\d{2}/\d{4}""").matches(newDate)

            if (validFormat) {
                onConfirm(newDate)
            } else {
                showError = true
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
