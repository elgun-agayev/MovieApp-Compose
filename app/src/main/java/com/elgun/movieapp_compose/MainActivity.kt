package com.elgun.movieapp_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elgun.movieapp_compose.data.model.fakeMovieList
import com.elgun.movieapp_compose.ui.detail.DetailScreen
import com.elgun.movieapp_compose.ui.home.HomeScreen
import com.elgun.movieapp_compose.ui.search.SearchScreen
import com.elgun.movieapp_compose.ui.theme.MovieApp_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieApp_composeTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        HomeScreen(
                            movieList = fakeMovieList,
                            onMovieClick = { movie ->
                                navController.navigate("detail/${movie.id}")
                            } ,
                            onSearchClick = {
                                navController.navigate("search")
                            }
                        )
                    }

                    composable("detail/{movieId}") { backStackEntry ->
                        val movieId = backStackEntry
                            .arguments
                            ?.getString("movieId")
                            ?.toIntOrNull()

                        val selectedMovie = fakeMovieList.find { it.id == movieId }

                        DetailScreen(
                            movieTitle = selectedMovie?.title ,
                            movieRating = selectedMovie?.rating ,
                            movieDescription = selectedMovie?.description ,
                        )
                    }
                    composable ("search"){
                                SearchScreen(
                                    movieList = fakeMovieList,
                                    onMovieClick = {movie ->
                                        navController.navigate("detail/${movie.id}")
                                    }
                        )
                    }
                }
            }
        }
    }
}