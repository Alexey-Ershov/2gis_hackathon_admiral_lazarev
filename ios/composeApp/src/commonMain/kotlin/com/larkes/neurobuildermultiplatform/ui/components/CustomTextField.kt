package com.larkes.neurobuildermultiplatform.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.larkes.neurobuildermultiplatform.ui.theme.Theme
import com.larkes.neurobuildermultiplatform.ui.theme.getRailWayFont

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    textFieldModifier: Modifier = Modifier
        .fillMaxWidth()
        .defaultMinSize(minHeight = 36.dp),
    singleLine: Boolean = false,
    contentCenter: Boolean = false
) {
    Box(
        modifier = modifier.clip(RoundedCornerShape(100.dp)).background(Theme.colors.title).border(1.dp, Theme.colors.formStrokeColor,
            RoundedCornerShape(100.dp)),
        contentAlignment = if (contentCenter) Alignment.Center else Alignment.TopStart

    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                color = Theme.colors.secondTextColor,
                fontSize = 12.sp,
               fontFamily = getRailWayFont(),
                fontWeight = FontWeight.Medium
            ),
            modifier = textFieldModifier.align(Alignment.Center),
            cursorBrush = SolidColor(Theme.colors.secondTextColor),
            singleLine = singleLine
        )

        if (value.isEmpty()) {
            Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                Text(
                    text = hint,
                    style = TextStyle(
                        color = Theme.colors.secondTextColor,
                        fontSize = 14.sp,
                        fontFamily = getRailWayFont(),
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
        }

    }
}