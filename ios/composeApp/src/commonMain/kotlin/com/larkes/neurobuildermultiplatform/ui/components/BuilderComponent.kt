package com.larkes.neurobuildermultiplatform.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

import com.larkes.neurobuildermultiplatform.ui.models.BuilderUiModel
import com.larkes.neurobuildermultiplatform.ui.theme.Theme
import com.larkes.neurobuildermultiplatform.ui.theme.getMontserratFont
import com.larkes.neurobuildermultiplatform.ui.theme.getRailWayFont
import neurobuildermultiplatform.composeapp.generated.resources.Res
import neurobuildermultiplatform.composeapp.generated.resources.heart_icon
import neurobuildermultiplatform.composeapp.generated.resources.star
import org.jetbrains.compose.resources.painterResource

//import com.larkes.neurobuildermultiplatform.ui.theme.getMontserratFont
//import com.larkes.neurobuildermultiplatform.ui.theme.getRailWayFont

@Composable
fun BuilderComponent(builderUiModel: BuilderUiModel){

    Column(modifier = Modifier.width(150.dp).fillMaxHeight()) {
        Box{
            AsyncImage(
                builderUiModel.imageSrc,
                contentDescription = "",
                modifier = Modifier.fillMaxWidth().height(150.dp).clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
                onError = { error ->
                    println("Failed_dv: ${builderUiModel.imageSrc} ${error.result.throwable.message?.toString()}")
                }
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 11.dp, top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Theme.colors.title)
                        .padding(horizontal = 4.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(Res.drawable.star),
                        contentDescription = "",
                        modifier = Modifier
                            .size(16.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = builderUiModel.rating.toString(),
                        color = Theme.colors.secondTitle,
                        fontSize = 11.sp,
                        fontFamily = getMontserratFont(),
                        fontWeight = FontWeight.Medium
                    )

                }

                Icon(
                    painter = painterResource(Res.drawable.heart_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .height(20.dp).height(24.dp),
                    tint = Theme.colors.title
                )

            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = builderUiModel.title,
            fontFamily = getRailWayFont(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Theme.colors.secondTitle
        )
        builderUiModel.recommendedFrom?.let {
            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color(0xffFFF4E4))
                    .padding(vertical = 3.dp, horizontal = 10.dp)
            ){
                Text(
                    text = it,
                    fontFamily = getRailWayFont(),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = Theme.colors.secondPrimary
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = builderUiModel.subtitle,
            fontFamily = getRailWayFont(),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Theme.colors.secondTitle
        )
    }

}