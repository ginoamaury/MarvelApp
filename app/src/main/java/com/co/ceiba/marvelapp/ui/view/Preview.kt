package com.co.ceiba.marvelapp.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.co.ceiba.marvelapp.R


@ExperimentalFoundationApi
@Composable
fun MovieListPreview() {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(128.dp),
        modifier = Modifier.testTag(stringResource(id = R.string.list_column_tag)),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.no_padding)),
    ) {
        items(10) {
            MovieCardPreview()
        }
    }
}

@Composable
fun MovieCardPreview(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding))
            .testTag(stringResource(id = R.string.card_preview_tag)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner)),
        elevation = dimensionResource(id = R.dimen.card_elevation),
    ) {
        Box(modifier = Modifier.height(dimensionResource(id = R.dimen.card_size))) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            ) {
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.padding_double)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}