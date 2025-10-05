package com.larkes.neurobuildermultiplatform.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.larkes.neurobuildermultiplatform.presentation.builder_detail.BuilderDetailViewModel
import com.larkes.neurobuildermultiplatform.presentation.landing.LandingViewModel
import com.larkes.neurobuildermultiplatform.presentation.test.TestViewModel
import com.larkes.neurobuildermultiplatform.ui.screen.BuilderDetailScreen
import com.larkes.neurobuildermultiplatform.ui.screen.LandingScreen
import com.larkes.neurobuildermultiplatform.ui.screen.TestScreen
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun Navigation(navHostController: NavHostController) {

    NavHost(navHostController, LandingScreen){

        composable<LandingScreen> {
            val viewModel: TestViewModel = koinViewModel()
            TestScreen(viewModel)
        }
        composable<LandingScreen> {
            val viewModel: LandingViewModel = koinViewModel()
            LandingScreen(viewModel,navHostController)
        }
        composable<BuilderDetailScreen>() { entry ->
            val id: BuilderDetailScreen = entry.toRoute<BuilderDetailScreen>()
            println(id.id)
            val viewModel: BuilderDetailViewModel = koinViewModel()
            BuilderDetailScreen(navHostController,viewModel, id.id)
        }

    }

}