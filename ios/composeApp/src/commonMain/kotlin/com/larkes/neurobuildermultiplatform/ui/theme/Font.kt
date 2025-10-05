package com.larkes.neurobuildermultiplatform.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import neurobuildermultiplatform.composeapp.generated.resources.Res
import neurobuildermultiplatform.composeapp.generated.resources.montserratmedium
import neurobuildermultiplatform.composeapp.generated.resources.ralewaybold
import neurobuildermultiplatform.composeapp.generated.resources.ralewaymedium
import neurobuildermultiplatform.composeapp.generated.resources.ralewayregular
import org.jetbrains.compose.resources.Font

@Composable
fun getRailWayFont() = FontFamily(
    Font(
        Res.font.ralewayregular,
        FontWeight.Normal
    ),
    Font(
        Res.font.ralewaybold,
        FontWeight.Bold
    ),
    Font(
        Res.font.ralewaymedium,
        FontWeight.Medium
    )
)

@Composable
fun getMontserratFont() = FontFamily(
    Font(
        Res.font.montserratmedium,
        FontWeight.Medium
    )
)