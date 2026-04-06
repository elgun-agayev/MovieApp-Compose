package com.elgun.movieapp_compose.ui.search

import android.R.attr.top
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elgun.movieapp_compose.data.model.Movie
import com.elgun.movieapp_compose.data.model.fakeMovieList
import com.elgun.movieapp_compose.ui.home.MovieItem

@Composable
fun SearchScreen(
    movieList: List<Movie>,
    onMovieClick: (Movie) -> Unit
){

    var searchText by remember { mutableStateOf("") }
    val filteredMovies = movieList.filter {
        it.title.contains(searchText, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Search movie") } ,
            singleLine = true ,
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (filteredMovies.isEmpty()){
            Text(
                text = "No movies found" ,
                modifier = Modifier.padding(top = 8.dp)
            )

        }else{
            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(filteredMovies){ movie ->
                    MovieItem(
                        movie = movie ,
                        onClick = {
                            onMovieClick(movie)
                        }
                    )
                }
            }
        }

    }



}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(
        movieList = fakeMovieList ,
        onMovieClick = { }
    )
}