package com.faithdeveloper.slackidentityhngxinternshiptask1

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.faithdeveloper.slackidentityhngxinternshiptask1.ui.theme.MainScreen

@Composable
fun AppNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = MAIN_SCREEN){
        composable(MAIN_SCREEN){
            MainScreen(onGithubClick = {
                navController.navigate(GITHUB_SCREEN)
            })
        }

        composable(GITHUB_SCREEN){
            GithubScreen()
        }
    }
}

const val MAIN_SCREEN = "main_screen"
const val GITHUB_SCREEN = "gituhb_screen"