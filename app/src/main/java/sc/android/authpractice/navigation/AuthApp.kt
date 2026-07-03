package sc.android.authpractice.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import sc.android.authpractice.auth.presentation.authstate.AuthState
import sc.android.authpractice.auth.presentation.viewmodel.AuthViewModel
import sc.android.authpractice.auth.ui.HomeScreen
import sc.android.authpractice.auth.ui.LoadingScreen
import sc.android.authpractice.auth.ui.AuthenticationScreen

/**
 * Root composable for the authentication flow.
 *
 * Observes the authentication state from the ViewModel
 * and displays the appropriate screen.
 */
@Composable
fun AuthApp(
    viewModel: AuthViewModel,
    modifier: Modifier
) {

    // Observe the current authentication state.
    val authState by viewModel.authState.collectAsState()

    // Display the appropriate screen based on
    // the current authentication state.
    when (authState) {

        AuthState.Unauthenticated -> AuthenticationScreen(viewModel)

        AuthState.CheckingSession -> LoadingScreen("Checking Session")

        AuthState.Authenticating -> LoadingScreen("Authenticating User")

        AuthState.Authenticated -> HomeScreen(viewModel)

    }
}