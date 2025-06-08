/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/navigation/AppNavGraph.kt
* Descrição:
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 24/05/2025
*/
package br.edu.senai.cac.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import br.edu.senai.cac.R
import br.edu.senai.cac.ui.AdminScreen
import br.edu.senai.cac.ui.HomeScreen
import br.edu.senai.cac.ui.KeyDetailScreen
import br.edu.senai.cac.ui.KeyRegistrationScreen
import br.edu.senai.cac.ui.RoomDetailScreen
import br.edu.senai.cac.ui.RoomRegistrationScreen
import br.edu.senai.cac.ui.SettingsScreen
import br.edu.senai.cac.ui.TeacherDetailScreen
import br.edu.senai.cac.ui.TeacherRegistrationScreen
import br.edu.senai.cac.ui.viewmodel.KeyDetailViewModel
import br.edu.senai.cac.ui.viewmodel.RoomDetailViewModel
import br.edu.senai.cac.ui.viewmodel.TeacherDetailViewModel

@Composable
fun AppNavGraph(
    modifier: Modifier,
    navController: NavHostController,
    updateTitle: (String) -> Unit,
    keyDetailViewModel: KeyDetailViewModel,
    roomDetailViewModel: RoomDetailViewModel,
    teacherDetailViewModel: TeacherDetailViewModel
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val title = when (currentRoute) {
        Screen.Home.route -> stringResource(id = R.string.title_home)
        Screen.Admin.route -> stringResource(id = R.string.title_admin)
        Screen.Settings.route -> stringResource(id = R.string.title_settings)
        Screen.KeyRegistration.route -> stringResource(id = R.string.title_key_registration)
        Screen.KeyDetail.route -> stringResource(id = R.string.title_key_details)
        Screen.TeacherRegistration.route -> stringResource(id = R.string.title_teacher_registration)
        Screen.TeacherDetail.route -> stringResource(id = R.string.title_teacher_details)
        Screen.RoomRegistration.route -> stringResource(id = R.string.title_room_registration)
        Screen.RoomDetail.route -> stringResource(id = R.string.title_room_details)
        else -> ""
    }

    LaunchedEffect(currentRoute) {
        if (currentRoute != null)
            updateTitle(title)
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        route = "root_graph",
        modifier = modifier
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                modifier = Modifier,
                onLoginAction = { navController.navigate(route = Screen.Admin.route) },
                onForgotPasswordAction = {}
            )
        }

        composable(route = Screen.Admin.route) {
            AdminScreen(
                modifier = Modifier,
                onKeyRegistrationAction = { navController.navigate(route = Screen.KeyRegistration.route) },
                onTeacherRegistrationAction = { navController.navigate(route = Screen.TeacherRegistration.route) },
                onRoomRegistrationAction = { navController.navigate(route = Screen.RoomRegistration.route) },
                onKeyDetailsAction = { navController.navigate(route = Screen.KeyDetail.route) },
                onTeacherDetailsAction = { navController.navigate(route = Screen.TeacherDetail.route) },
                onRoomDetailsAction = { navController.navigate(route = Screen.RoomDetail.route) },
                onSettingsScreenAction = { navController.navigate(route = Screen.Settings.route) }
            )
        }

        composable(route = Screen.Settings.route) {
            SettingsScreen(modifier = Modifier)
        }

        composable(route = Screen.KeyRegistration.route) {
            KeyRegistrationScreen(
                modifier = Modifier,
                onNavigateBack = { navController.navigateUp() },
                onSaveKey = { key ->
                    keyDetailViewModel.addKey(key)
                    navController.navigateUp()
                }
            )
        }

        composable(route = Screen.KeyDetail.route) {
            KeyDetailScreen(
                modifier = Modifier,
                updateTitle = updateTitle,
                onNavigateBack = {
                    navController.navigateUp()
                },
                keyDetailViewModel = keyDetailViewModel
            )
        }

        composable(route = Screen.TeacherRegistration.route) {
            TeacherRegistrationScreen(
                modifier = Modifier,
                onNavigateBack = { navController.navigateUp() },
                onSaveTeacher = { teacher ->
                    teacherDetailViewModel.addTeacher(teacher)
                    navController.navigateUp()
                }
            )
        }

        composable(route = Screen.TeacherDetail.route) {
            TeacherDetailScreen(
                modifier = Modifier,
                updateTitle = updateTitle,
                onNavigateBack = {
                    navController.navigateUp()
                },
                teacherDetailViewModel = teacherDetailViewModel,
            )
        }

        composable(route = Screen.RoomRegistration.route) {
            RoomRegistrationScreen(
                modifier = Modifier,
                onNavigateBack = { navController.navigateUp() },
                onSaveRoom = { room ->
                    roomDetailViewModel.addRoom(room)
                    navController.navigateUp()
                }
            )
        }

        composable(route = Screen.RoomDetail.route) {
            RoomDetailScreen(
                modifier = Modifier,
                updateTitle = updateTitle,
                onNavigateBack = {
                    navController.navigateUp()
                },
                roomDetailViewModel = roomDetailViewModel
            )
        }
    }
}