package com.co.ceiba.marvelapp.ui.character

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.co.ceiba.domain.models.Character
import com.co.ceiba.marvelapp.R
import com.co.ceiba.marvelapp.ui.theme.MarvelTypography

@Composable
fun CharacterAboutSection(
    character: Character,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.resume_title),
            color = MaterialTheme.colors.onSurface,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer)))
        Text(
            text = character.description,
            color = MaterialTheme.colors.onSurface,
            fontSize = MarvelTypography.caption.fontSize,
            textAlign = TextAlign.Justify
        )
    }
}