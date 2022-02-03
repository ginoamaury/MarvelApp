package com.co.ceiba.marvelapp.ui.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.co.ceiba.domain.models.Character
import com.co.ceiba.marvelapp.R
import com.co.ceiba.marvelapp.ui.character.CharacterAboutSection
import com.co.ceiba.marvelapp.ui.character.CharacterTitleSection
import com.co.ceiba.marvelapp.ui.character.CharacterVoteSection
import com.co.ceiba.marvelapp.viewmodel.CharacterViewModel
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun DescriptionScreen(
    popBackStack: () -> Unit,
    idCharacter: Int?,
    characterViewModel: CharacterViewModel = hiltViewModel()
) {
    characterViewModel.getMovie(idCharacter ?: 0)
    val uiState by characterViewModel.uiState.collectAsState()
    Surface(Modifier.fillMaxSize()) {
        MovieDetailScreen(
            loading = uiState.loading,
            character = uiState.success,
            error = uiState.error,
            popBackStack = popBackStack
        )
    }
}

@Composable
fun MovieDetailScreen(
    character: Character?,
    loading: Boolean,
    error: Boolean,
    popBackStack: () -> Unit,
    topPadding: Dp = dimensionResource(id = R.dimen.detail_screen_padding),
    movieImageSize: Dp = dimensionResource(id = R.dimen.image_size),
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = dimensionResource(id = R.dimen.padding_double))
            .testTag(stringResource(id = R.string.movie_detail_tag))
    ) {
        MovieDetailTopSection(
            popBackStack = popBackStack,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .align(Alignment.TopCenter)
        )
        MovieDetailStateWrapper(
            character = character,
            loading = loading,
            error = error,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = topPadding + movieImageSize / 2f,
                    start = dimensionResource(id = R.dimen.padding_double),
                    end = dimensionResource(id = R.dimen.padding_double),
                    bottom = dimensionResource(id = R.dimen.padding_double)
                )
                .shadow(dimensionResource(id = R.dimen.padding_double), RoundedCornerShape(dimensionResource(id = R.dimen.card_corner)))
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.card_corner)))
                .background(MaterialTheme.colors.surface)
                .padding(dimensionResource(id = R.dimen.padding_double))
                .align(Alignment.BottomCenter),
            loadingModifier = Modifier
                .size(dimensionResource(id = R.dimen.loading_size))
                .align(Alignment.Center)
                .padding(
                    top = topPadding + movieImageSize / 2f,
                    start = dimensionResource(id = R.dimen.padding_double),
                    end = dimensionResource(id = R.dimen.padding_double),
                    bottom = dimensionResource(id = R.dimen.padding_double)
                )
        )
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (character != null) {
                Image(
                    painter = rememberCoilPainter(
                        request =  "${character.thumbnail.path.replace("http","https")}/portrait_xlarge.${character.thumbnail.extension}",
                        previewPlaceholder = R.drawable.ic_launcher_background,
                    ),
                    contentDescription = character.description,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(movieImageSize)
                        .offset(y = topPadding),
                )
            }
        }
    }
}

@Composable
fun MovieDetailTopSection(
    popBackStack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = modifier
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Black,
                        Color.Transparent
                    )
                )
            )
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.arrow_back_size))
                .offset(dimensionResource(id = R.dimen.padding_double), dimensionResource(id = R.dimen.padding_double))
                .clickable {
                    popBackStack.invoke()
                }
        )
    }
}

@Composable
fun MovieDetailStateWrapper(
    character: Character?,
    modifier: Modifier = Modifier,
    loading: Boolean,
    error: Boolean,
    loadingModifier: Modifier = Modifier
) {
    if (loading) {
        CircularProgressIndicator(
            color = MaterialTheme.colors.primary,
            modifier = loadingModifier
        )
    } else {
        if (error) {
            NoDataScreen()
        } else {
            if (character != null) {
                MovieDetailSection(
                    characterInfo = character,
                    modifier = modifier
                        .offset(y = dimensionResource(id = R.dimen.detail_section_offset))
                )
            }
        }
    }
}

@Composable
fun MovieDetailSection(
    characterInfo: Character,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .offset(y = dimensionResource(id = R.dimen.detail_section_offset_column))
            .verticalScroll(scrollState)
    ) {
        CharacterTitleSection(characterInfo = characterInfo)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer)))
        //CharacterVoteSection(character = characterInfo)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer)))
        CharacterAboutSection(character = characterInfo)
    }
}


