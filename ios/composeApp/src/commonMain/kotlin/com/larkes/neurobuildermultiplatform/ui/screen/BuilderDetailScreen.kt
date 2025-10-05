package com.larkes.neurobuildermultiplatform.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.larkes.neurobuildermultiplatform.presentation.builder_detail.BuilderDetailViewModel
import com.larkes.neurobuildermultiplatform.ui.theme.Theme
import com.larkes.neurobuildermultiplatform.ui.theme.getMontserratFont
import com.larkes.neurobuildermultiplatform.ui.theme.getRailWayFont
import neurobuildermultiplatform.composeapp.generated.resources.Res
import neurobuildermultiplatform.composeapp.generated.resources.arrow_left
import neurobuildermultiplatform.composeapp.generated.resources.arrow_right
import org.jetbrains.compose.resources.painterResource

@Composable
fun BuilderDetailScreen(
    navController: NavController,
    viewModel: BuilderDetailViewModel,
    id: String
){

    LaunchedEffect(id){
        viewModel.fetchBuliderInfo(id)
    }

    val builderInfo by viewModel._builderInfo.collectAsState()


    if(builderInfo != null){
        LazyColumn {
            item {
                Box(modifier = Modifier.fillMaxWidth().height(390.dp)){
                    AsyncImage(
                        "https://enjoyenglish-blog.com/wp-content/uploads/2017/07/%D0%A1%D0%BB%D0%BE%D0%B2%D0%B0-%D0%B8-%D0%B2%D1%8B%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D1%81%D0%BE-%D1%81%D0%BB%D0%BE%D0%B2%D0%BE%D0%BC-%C2%AB%D0%B4%D0%BE%D0%BC%C2%BB.jpg",
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 25.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(Theme.colors.title)
                                .padding(vertical = 11.dp, horizontal = 12.dp)
                                .clickable{
                                    navController.popBackStack()
                                }
                        ){
                            Image(
                                painter = painterResource(Res.drawable.arrow_left),
                                contentDescription = "",
                                modifier = Modifier
                                    .height(14.dp)
                                    .width(8.dp),
                                contentScale = ContentScale.FillBounds
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(Theme.colors.title)
                                .padding(vertical = 8.dp, horizontal = 14.dp)
                        ){
                            Text(
                                text = "Индекс надёжности ${builderInfo!!.trustIndex}/100",
                                color = Color(0xff308414),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 21.dp, bottom = 32.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Theme.colors.title)
                                .padding(vertical = 8.dp, horizontal = 14.dp)

                        ){
                            Text(
                                text = builderInfo!!.title,
                                color = Color.Black,
                                fontSize = 40.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = getRailWayFont()
                            )
                        }
                    }
                }
            }
            item {
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp)
                ){
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "с ${builderInfo!!.fromYear}, ${2025 - builderInfo!!.fromYear} лет",
                        fontFamily = getMontserratFont(),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 32.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Люди ценят/хвалят",
                        fontFamily = getRailWayFont(),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2), // 2 колонки в общей сетке
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 0.dp, max = 900.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        itemsIndexed(
                            builderInfo!!.complimentPeople,
                            span = { _, item ->
                                GridItemSpan(if (item.length > 18) 2 else 1)
                            }
                        ) { index, item -> // 👈 также здесь

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0xffEAEAEA))
                                    .padding(vertical = 4.dp, horizontal = 10.dp),
                                contentAlignment = Alignment.Center

                            ){
                                Text(
                                    text = item,
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = getRailWayFont()
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Люди отмечают",
                        fontFamily = getRailWayFont(),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2), // 2 колонки в общей сетке
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 0.dp, max = 900.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        itemsIndexed(
                            builderInfo!!.peopleNote,
                            span = { _, item ->
                                GridItemSpan(if (item.length > 18) 2 else 1)
                            }
                        ) { index, item -> // 👈 также здесь

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0xffEAEAEA))
                                    .padding(vertical = 4.dp, horizontal = 10.dp),
                                contentAlignment = Alignment.Center

                            ){
                                Text(
                                    text = item,
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = getRailWayFont()
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = builderInfo!!.description,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        fontFamily = getRailWayFont(),
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(60.dp))
                }
            }
        }
    }else{
        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(40.dp),
                color = Theme.colors.landingLinearFirst
            )
        }
    }

}