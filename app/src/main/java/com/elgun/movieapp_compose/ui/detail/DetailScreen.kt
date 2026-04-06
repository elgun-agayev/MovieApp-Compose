package com.elgun.movieapp_compose.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(
    movieTitle: String? ,
    movieRating: Double? ,
    movieDescription: String?

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "🎬 Poster")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = movieTitle ?:"No title" ,
            fontSize = 22.sp ,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "⭐ ${movieRating ?: 0.0}")

        Spacer(modifier = Modifier.height(12.dp))
        Text(text = movieDescription ?: "No description")


    }



}
@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    DetailScreen(
        movieTitle = "Inception",
        movieRating = 8.8,
        movieDescription = "Sample description"
    )
}