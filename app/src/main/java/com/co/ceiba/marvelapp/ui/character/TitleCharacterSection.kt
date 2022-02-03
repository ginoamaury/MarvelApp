package com.co.ceiba.marvelapp.ui.character

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.co.ceiba.domain.models.Character
import com.co.ceiba.marvelapp.R
import com.co.ceiba.marvelapp.ui.theme.MarvelTypography
import java.util.*

@Composable
fun CharacterTitleSection(characterInfo: Character) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.testTag(stringResource(id = R.string.title_section_tag))
    ) {
        Text(
            text = characterInfo.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
            fontWeight = FontWeight.Bold,
            fontSize = MarvelTypography.h4.fontSize,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onSurface
        )
        Text(
            text = "${stringResource(id = R.string.release_date)} ${characterInfo.modified.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.ROOT
                ) else it.toString()
            }.substring(0,10)}",
            fontWeight = FontWeight.Bold,
            fontSize = MarvelTypography.subtitle1.fontSize,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.secondary
        )
    }
}

@Composable
fun CharacterVoteSection(
    character: Character,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            modifier = modifier.size(dimensionResource(id = R.dimen.icon_size)),
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(id = R.string.icon_star_description)
        )
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacer)))
        Text(
            text = "${stringResource(id = R.string.vote_average)}: ",
            color = MaterialTheme.colors.onSurface,
            fontSize = MarvelTypography.caption.fontSize,
        )
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacer_double)))
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            modifier = modifier.size(dimensionResource(id = R.dimen.icon_size)),
            tint = MaterialTheme.colors.secondary,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacer)))
        Text(
            text = "${stringResource(id = R.string.total_votes)}: ",
            color = MaterialTheme.colors.onSurface,
            fontSize = MarvelTypography.caption.fontSize,
        )
    }

}