/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/navigation/Screen.kt
* Descrição: Classe de armazenamento de rotas.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 24/05/2025
*/
package br.edu.senai.cac.ui.navigation

/**
 * Classe de armazenamento de rotas.
 * @param route Rota da tela.
 * @param title Título da tela.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
sealed class Screen(
    val route: String,
    val title: String
) {
    object Home: Screen(
        route = "route_home",
        title = "Tela inicial"
    )

    object Admin: Screen(
        route = "route_admin",
        title = "Administração"
    )

    object KeyRegistration: Screen(
        route = "route_key_registration",
        title = "Cadastro de chave"
    )

    object KeyDetail: Screen(
        route = "route_key_detail",
        title = "Detalhes da chave"
    )

    object TeacherRegistration: Screen(
        route = "route_teacher_registration",
        title = "Cadastro de professor"
    )

    object TeacherDetail: Screen(
        route = "route_teacher_detail",
        title = "Detalhes do professor"
    )

    object RoomRegistration: Screen(
        route = "route_room_registration",
        title = "Cadastro de sala"
    )

    object RoomDetail: Screen(
        route = "route_room_detail",
        title = "Detalhes da sala"
    )

    object Settings: Screen(
        route = "route_settings",
        title = "Configurações"
    )
}
