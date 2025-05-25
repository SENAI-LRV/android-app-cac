/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/navigation/AppNavGraph.kt
* Descrição:
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 24/05/2025
*/
package br.edu.senai.cac.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.senai.cac.ui.AdminScreen
import br.edu.senai.cac.ui.HomeScreen
import br.edu.senai.cac.ui.KeyDetailScreen
import br.edu.senai.cac.ui.KeyRegistrationScreen
import br.edu.senai.cac.ui.RoomDetailScreen
import br.edu.senai.cac.ui.RoomRegistrationScreen
import br.edu.senai.cac.ui.SettingsScreen
import br.edu.senai.cac.ui.TeacherDetailScreen
import br.edu.senai.cac.ui.TeacherRegistrationScreen

@Composable
fun AppNavGraph(modifier: Modifier) {
    var navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        route = "root_graph"
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(modifier = Modifier)
        }

        composable(route = Screen.Admin.route) {
            AdminScreen(modifier = Modifier)
        }

        composable(route = Screen.Settings.route) {
            SettingsScreen(modifier = Modifier)
        }

        composable(route = Screen.KeyRegistration.route) {
            KeyRegistrationScreen(modifier = Modifier)
        }

        composable(route = Screen.KeyDetail.route) {
            KeyDetailScreen(modifier = Modifier)
        }

        composable(route = Screen.TeacherRegistration.route) {
            TeacherRegistrationScreen(modifier = Modifier)
        }

        composable(route = Screen.TeacherDetail.route) {
            TeacherDetailScreen(modifier = Modifier)
        }

        composable(route = Screen.RoomRegistration.route) {
            RoomRegistrationScreen(modifier = Modifier)
        }

        composable(route = Screen.RoomDetail.route) {
            RoomDetailScreen(modifier = Modifier)
        }
    }
}