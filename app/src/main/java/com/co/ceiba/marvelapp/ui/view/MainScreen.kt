package com.co.ceiba.marvelapp.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.co.ceiba.domain.models.Character
import com.co.ceiba.marvelapp.R
import com.co.ceiba.marvelapp.ui.theme.MarvelTypography
import com.co.ceiba.marvelapp.ui.widget.HomeAppBar
import com.co.ceiba.marvelapp.viewmodel.CharactersViewModel
import com.google.accompanist.coil.rememberCoilPainter

@ExperimentalFoundationApi
@Composable
fun MainScreen(
    navigateToDescriptionScreen: (movieId: Int) -> Unit,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    Surface(Modifier.fillMaxSize()) {
        HomeContent(
            loading = uiState.loading,
            characters = uiState.successes,
            error = uiState.error,
            navigateToDescriptionScreen = navigateToDescriptionScreen,
            searchCharacterByName = {viewModel.getMoviesByName(it)}
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun HomeContent(
    characters: List<Character>,
    navigateToDescriptionScreen: (movieId: Int) -> Unit,
    searchCharacterByName: (name:String) -> Unit,
    loading: Boolean,
    error: Boolean
) {
    val textState = remember{ mutableStateOf(TextFieldValue()) }
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 1f,
                        endY = 0f
                    )
                )
                .testTag(stringResource(id = R.string.home_content_tag))
        ) {
            val appBarColor = MaterialTheme.colors.surface.copy(alpha = 0.87f)
            Spacer(
                Modifier
                    .background(appBarColor)
                    .fillMaxWidth()
            )
            HomeAppBar(
                backgroundColor = appBarColor,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = textState.value,
                onValueChange = {
                    textState.value = it
                    searchCharacterByName.invoke(textState.value.text)
                },
                label = { Text("Type your favorite hero to search it...") },
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.fillMaxWidth()
            )
            if (loading) {
                MovieListPreview()
            } else {
                if (error) {
                    NoDataScreen()
                } else {
                    MovieList(
                        characters = characters,
                        navigateToDescriptionScreen = navigateToDescriptionScreen
                    )
                }
            }
        }
    }
}


@Composable
fun MovieCard(
    character: Character,
    navigateToDescriptionScreen: (movieId: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding))
            .clickable {
                navigateToDescriptionScreen.invoke(character.id)
            },
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner)),
        elevation = dimensionResource(id = R.dimen.card_elevation),
    ) {
        Box(modifier = Modifier.height(dimensionResource(id = R.dimen.card_size))) {
            Image(
                painter = rememberCoilPainter(
                    request =  "${character.thumbnail.path.replace("http","https")}/portrait_xlarge.${character.thumbnail.extension}",
                    previewPlaceholder = R.drawable.ic_launcher_background
                ),
                contentDescription = character.description,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
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
                contentAlignment = Alignment.BottomStart
            ) {
                Text(character.name, style = TextStyle(color = Color.White, fontSize = MarvelTypography.subtitle1.fontSize))
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MovieList(
    characters: List<Character>,
    navigateToDescriptionScreen: (movieId: Int) -> Unit
) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.no_padding)),
        modifier = Modifier.testTag(stringResource(id = R.string.movie_list_tag))
    ) {
        items(characters.size) { item ->
            MovieCard(character = characters[item], navigateToDescriptionScreen)
        }
    }
}

