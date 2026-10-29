
package com.example.bookflow.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookflow.data.BookRepository
import com.example.bookflow.screens.BookDetailScreen
import com.example.bookflow.screens.BookListScreen
import com.example.bookflow.screens.HomeScreen
import com.example.bookflow.screens.MyReservationsScreen
import com.example.bookflow.screens.ReservationDetailScreen
import com.example.bookflow.screens.ReservationSuccessScreen
import com.example.bookflow.screens.RenewReservationScreen
import com.example.bookflow.screens.RenewalSuccessScreen
import com.example.bookflow.screens.PrimaryButton
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

@Composable
fun BookFlowApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                onBooks = {
                    navController.navigate(Routes.BOOKS)
                },
                onReservations = {
                    navController.navigate(Routes.MY_RESERVATIONS)
                }
            )
        }

        composable(Routes.BOOKS) {
            BookListScreen(
                onBack = {
                    navController.popBackStack()
                },
                onBookSelected = { book ->
                    navController.navigate(
                        Routes.bookDetail(book.id)
                    )
                }
            )
        }

        composable(
            route = Routes.BOOK_DETAIL,
            arguments = listOf(
                navArgument("bookId") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val id = entry.arguments?.getString("bookId")
            val book = id?.let { BookRepository.getBook(it) }

            if (book != null) {
                BookDetailScreen(
                    book = book,
                    onBack = {
                        navController.popBackStack()
                    },
                    onReserve = {
                        val reservation =
                            BookRepository.reserveBook(book)

                        navController.navigate(
                            Routes.reservationSuccess(reservation.id)
                        )
                    }
                )
            } else {
                ErrorScreen("Libro no encontrado") {
                    navController.popBackStack()
                }
            }
        }

        composable(
            route = Routes.RESERVATION_SUCCESS,
            arguments = listOf(
                navArgument("reservationId") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val id = entry.arguments?.getString("reservationId")
            val reservation =
                id?.let { BookRepository.getReservation(it) }

            if (reservation != null) {
                ReservationSuccessScreen(
                    reservation = reservation,
                    onHome = {
                        navController.navigate(Routes.HOME) {
                            popUpTo(Routes.HOME) {
                                inclusive = false
                            }
                            launchSingleTop = true
                        }
                    },
                    onReservations = {
                        navController.navigate(Routes.MY_RESERVATIONS) {
                            popUpTo(Routes.HOME)
                        }
                    }
                )
            } else {
                ErrorScreen("Reserva no encontrada") {
                    navController.popBackStack()
                }
            }
        }

        composable(Routes.MY_RESERVATIONS) {
            MyReservationsScreen(
                onBack = {
                    navController.popBackStack()
                },
                onReservationSelected = { reservation ->
                    navController.navigate(
                        Routes.reservationDetail(reservation.id)
                    )
                }
            )
        }

        composable(
            route = Routes.RESERVATION_DETAIL,
            arguments = listOf(
                navArgument("reservationId") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val id = entry.arguments?.getString("reservationId")
            val reservation =
                id?.let { BookRepository.getReservation(it) }

            if (reservation != null) {
                ReservationDetailScreen(
                    reservation = reservation,
                    onBack = {
                        navController.popBackStack()
                    },
                    onRenew = {
                        navController.navigate(
                            Routes.renewReservation(reservation.id)
                        )
                    },
                    onCancel = {
                        BookRepository.cancelReservation(reservation.id)
                        navController.popBackStack()
                    }
                )
            } else {
                ErrorScreen("Reserva no encontrada") {
                    navController.popBackStack()
                }
            }
        }

        composable(
            route = Routes.RENEW_RESERVATION,
            arguments = listOf(
                navArgument("reservationId") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val id = entry.arguments?.getString("reservationId")
            val reservation =
                id?.let { BookRepository.getReservation(it) }

            if (reservation != null) {
                RenewReservationScreen(
                    reservation = reservation,
                    onBack = {
                        navController.popBackStack()
                    },
                    onConfirm = { newDate ->
                        val renewed =
                            BookRepository.renewReservation(
                                reservation.id,
                                newDate
                            )

                        if (renewed) {
                            navController.navigate(
                                Routes.renewalSuccess(reservation.id)
                            )
                        }
                    }
                )
            } else {
                ErrorScreen("Reserva no encontrada") {
                    navController.popBackStack()
                }
            }
        }

        composable(
            route = Routes.RENEWAL_SUCCESS,
            arguments = listOf(
                navArgument("reservationId") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val id = entry.arguments?.getString("reservationId")
            val reservation =
                id?.let { BookRepository.getReservation(it) }

            if (reservation != null) {
                RenewalSuccessScreen(
                    reservation = reservation,
                    onReservations = {
                        navController.navigate(Routes.MY_RESERVATIONS) {
                            popUpTo(Routes.HOME)
                        }
                    }
                )
            } else {
                ErrorScreen("Reserva no encontrada") {
                    navController.popBackStack()
                }
            }
        }
    }
}

@Composable
private fun ErrorScreen(
    message: String,
    onBack: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(
                androidx.compose.foundation.layout.PaddingValues(20.dp)
            )
        ) {
            Text(message)
            PrimaryButton("Volver", onBack)
        }
    }
}
