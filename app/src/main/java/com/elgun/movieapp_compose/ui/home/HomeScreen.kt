package com.elgun.movieapp_compose.ui.home

import android.icu.text.StringSearch
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elgun.movieapp_compose.data.model.Movie
import com.elgun.movieapp_compose.data.model.fakeMovieList

@Composable
fun HomeScreen(
    movieList: List<Movie>,
    onMovieClick: (Movie) -> Unit,
    onSearchClick: () -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        contentPadding = PaddingValues(
            top = 16.dp,
            start = 16.dp,
            end = 16.dp
        )
    ) {
        item {
            Text(
                text = "🔍 Go to Search" ,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSearchClick()}
                    .padding(12.dp)
            )

        }
        items(movieList) { movie ->

            MovieItem(
                movie = movie ,
                onClick ={ onMovieClick(movie) }
            )

        }


    }

}

@Composable
fun MovieItem(
    movie: Movie,
    onClick  : () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically ,
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
            ) {
                Text(text = "🎬 Poster")
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(text = movie.title)
                Text(text = "⭐ ${movie.rating}")
            }

        }
    }

}
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen(
        movieList = fakeMovieList,
        onMovieClick = {},
        onSearchClick = {} ,
        )
}