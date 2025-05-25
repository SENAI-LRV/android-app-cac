/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/theme/Type.kt
* Descrição: Definição de tipografia do aplicativo.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 24/05/2025
*/
package br.edu.senai.cac.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.edu.senai.cac.R

val firaSansFamily = FontFamily(
    Font(R.font.fira_sans, FontWeight.Normal),
    Font(R.font.fira_sans_bold, FontWeight.Bold),
    Font(R.font.fira_sans_light, FontWeight.Light)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    labelSmall = TextStyle(
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)