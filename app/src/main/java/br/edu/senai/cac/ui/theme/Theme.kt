/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/theme/Theme.kt
* Descrição: Definição do tema do aplicativo.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 24/05/2025
*/
package br.edu.senai.cac.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/* Esquema de cores em modo escuro */
private val DarkColorScheme = darkColorScheme(
    primary = ProDarkPrimary,
    secondary = ProDarkSecondary,
    tertiary = ProDarkTertiary,
    background = ProDarkBackground,
    surface = ProDarkSurface,
    onPrimary = ProDarkOnPrimary,
    onSecondary = ProDarkOnSecondary,
    onTertiary = ProDarkOnTertiary,
    onBackground = ProDarkOnBackground,
    onSurface = ProDarkOnSurface
)

/* Esquema de cores em modo claro */
private val LightColorScheme = lightColorScheme(
    primary = ProLightPrimary,
    secondary = ProLightSecondary,
    tertiary = ProLightTertiary,
    background = ProLightBackground,
    surface = ProLightSurface,
    onPrimary = ProLightOnPrimary,
    onSecondary = ProLightOnSecondary,
    onTertiary = ProLightOnTertiary,
    onBackground = ProLightOnBackground,
    onSurface = ProLightOnSurface,
)

/**
 * Definição do tema da aplicação.
 * @param darkTheme Indica se o tema deve ser escuro ou claro.
 * @param dynamicColor Indica se o tema deve usar cores dinâmicas.
 * @param content Conteúdo a ser exibido dentro do tema.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Composable
fun CACTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
