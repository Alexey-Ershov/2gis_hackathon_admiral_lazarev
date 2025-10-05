package com.larkes.neurobuildermultiplatform.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.gestures.awaitFirstDown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.larkes.neurobuildermultiplatform.navigation.BuilderDetailScreen
import com.larkes.neurobuildermultiplatform.presentation.landing.LandingUIEvent
import com.larkes.neurobuildermultiplatform.presentation.landing.LandingViewModel
import com.larkes.neurobuildermultiplatform.ui.components.BuilderComponent
import com.larkes.neurobuildermultiplatform.ui.components.CustomTextField
import com.larkes.neurobuildermultiplatform.ui.components.MapComponent
import com.larkes.neurobuildermultiplatform.ui.theme.StringResource.TEXT_FILED_SEARCH_HINT
import com.larkes.neurobuildermultiplatform.ui.theme.Theme
import com.larkes.neurobuildermultiplatform.ui.theme.getRailWayFont
import kotlinx.coroutines.coroutineScope
import neurobuildermultiplatform.composeapp.generated.resources.Res
import neurobuildermultiplatform.composeapp.generated.resources.arrow_right
import neurobuildermultiplatform.composeapp.generated.resources.hamburger
import neurobuildermultiplatform.composeapp.generated.resources.heart_icon
import neurobuildermultiplatform.composeapp.generated.resources.search
import org.jetbrains.compose.resources.painterResource

import kotlin.math.abs

class VisibilityTracker {
    var isVisible: Boolean by mutableStateOf(false)
        private set

    fun onPositionChanged(layoutCoordinates: LayoutCoordinates?) {
        layoutCoordinates?.let { coordinates ->
            val visibleRect = coordinates.boundsInWindow()
            val windowBounds = Rect(0f, 0f,
                coordinates.size.width.toFloat(),
                coordinates.size.height.toFloat()
            )
            isVisible = visibleRect.intersect(windowBounds).width > 0
        }
    }
}

@Composable
fun rememberVisibilityTracker(): VisibilityTracker {
    return remember { VisibilityTracker() }
}

fun Modifier.trackVisibility(tracker: VisibilityTracker): Modifier = this.then(
    Modifier.onGloballyPositioned { coordinates ->
        tracker.onPositionChanged(coordinates)
    }
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingScreen(landingViewModel: LandingViewModel, navController: NavController) {

    var visibilityTracker = rememberVisibilityTracker()
    val uiState by landingViewModel.uiState.collectAsState()
    val isOutMapSwiped by remember { mutableStateOf(false) }
    var isMapInteracting by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()


    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                // Свайп вверх
                if (available.y < -20f) {

                }
                // Свайп вниз
                else if (available.y > 20f) {
                }
                // Возвращаем Offset.Zero, чтобы не блокировать скролл
                return Offset.Zero
            }
        }
    }


    LaunchedEffect(visibilityTracker.isVisible) {
        if(visibilityTracker.isVisible){
            isMapInteracting = true
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState, enabled = isMapInteracting.not())

    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(
                bottomStart = CornerSize(50.dp),
                bottomEnd = CornerSize(50.dp),
                topStart = CornerSize(0.dp),
                topEnd = CornerSize(0.dp)
            ))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Theme.colors.landingLinearFirst,
                        Theme.colors.landingLinearSecond
                    ),
                    start = androidx.compose.ui.geometry.Offset.Infinite.copy(
                        x = Float.POSITIVE_INFINITY,
                        y = 0f
                    ),
                    end = androidx.compose.ui.geometry.Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
            .padding(top = 35.dp)
            .padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = Theme.strings.APP_NAME,
                    fontSize = 22.sp,
                    fontFamily = getRailWayFont(),
                    fontWeight = FontWeight.Bold,
                    color = Theme.colors.title
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painterResource(Res.drawable.heart_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .width(28.dp)
                            .height(30.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(Res.drawable.hamburger),
                        contentDescription = "",
                        modifier = Modifier
                            .height(14.dp)
                            .width(18.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

            Spacer(modifier = Modifier.height(36.dp))
            Text(
                text = Theme.strings.LANDING_TITLE,
                fontSize = 28.sp,
                fontFamily = getRailWayFont(),
                fontWeight = FontWeight.Bold,
                color = Theme.colors.title
            )
            Spacer(modifier = Modifier.height(6.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(
                        topStart = CornerSize(10.dp),
                        topEnd = CornerSize(10.dp),
                        bottomStart = CornerSize(10.dp),
                        bottomEnd = CornerSize(10.dp)
                    ))
                    .background(Theme.colors.title)
            ) {
                Text(
                    text = Theme.strings.LANDING_ADD_TITLE,
                    fontSize = 26.sp,
                    fontFamily = getRailWayFont(),
                    fontWeight = FontWeight.Bold,
                    color = Theme.colors.secondTitle,
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = Theme.strings.LANDING_SUB_TITLE,
                fontSize = 16.sp,
                fontFamily = getRailWayFont(),
                fontWeight = FontWeight.Normal,
                color = Theme.colors.title
            )
            Spacer(modifier = Modifier.height(25.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                CustomTextField(
                    hint = TEXT_FILED_SEARCH_HINT,
                    value = uiState.searchText,
                    textFieldModifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                        .padding(start = 20.dp),
                    onValueChange = {
                        landingViewModel.onEvent(LandingUIEvent.SearchTextEntered(it))
                    },
                    modifier = Modifier.height(44.dp)
                )

                Row(modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.search),
                        contentDescription = "",
                        modifier = Modifier
                            .size(18.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
            Spacer(modifier = Modifier.height(35.dp))
        }

        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .pointerInput(Unit) {
                    coroutineScope {
                        while (true) {
                            val down = awaitPointerEventScope { awaitFirstDown() }
                            var dragOffsetY = 0f

                            awaitPointerEventScope {
                                while (true) {
                                    val event = awaitPointerEvent()
                                    val change = event.changes.firstOrNull() ?: break

                                    isMapInteracting = false
                                }
                            }
                        }
                    }
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = Theme.strings.POPULAR_TITLE,
                    color = Theme.colors.secondTitle,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = Theme.strings.ALL_TEXT,
                        color = Theme.colors.secondTextColor,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(Res.drawable.arrow_right),
                        contentDescription = "",
                        modifier = Modifier
                            .size(13.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            if(uiState.isPopularBuildersLoading){
                Row(
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(30.dp),
                        color = Theme.colors.landingLinearFirst
                    )
                }
            }
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.height(210.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.width(8.dp))
                }
                itemsIndexed(uiState.popularBuilders) { index, item ->
                    BuilderComponent(item)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = Theme.strings.CHOOSED_BUILDINGS,
                    color = Theme.colors.secondTitle,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = Theme.strings.ALL_TEXT,
                        color = Theme.colors.secondTextColor,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(Res.drawable.arrow_right),
                        contentDescription = "",
                        modifier = Modifier
                            .size(13.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            if(uiState.isPopularBuildersLoading){
                Row(
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(30.dp),
                        color = Theme.colors.landingLinearFirst
                    )
                }
            }
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.height(230.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.width(8.dp))
                }
                itemsIndexed(uiState.companiesChoosed) { index, item ->
                    BuilderComponent(item)
                }
            }
            Column(modifier = Modifier
                .padding(horizontal = 20.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = Theme.strings.BUILDING_ON_MAP,
                    color = Theme.colors.secondTitle,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
        Box(
            Modifier
                .height(400.dp)
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            MapComponent(){
                navController.navigate(BuilderDetailScreen(it))
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .trackVisibility(visibilityTracker)
        ) {

        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}



//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(scrollState, enabled = !isMapInteracting),
//
//    ) {
//
//        Box(modifier = Modifier
//            .height(800.dp)
//            .pointerInteropFilter { event ->
//                when (event.action) {
//                    android.view.MotionEvent.ACTION_DOWN,
//                    android.view.MotionEvent.ACTION_MOVE -> isMapInteracting = false // свайп по элементам -> Column скроллится
//                }
//                false // передаем событие дальше в Column
//            }
//        ) {
//
//        }
//
//    }

