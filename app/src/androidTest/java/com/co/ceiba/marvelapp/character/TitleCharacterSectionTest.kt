package com.co.ceiba.marvelapp.character

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.co.ceiba.domain.builder.Builder
import com.co.ceiba.marvelapp.MainPage
import com.co.ceiba.marvelapp.ui.character.CharacterTitleSection
import com.co.ceiba.marvelapp.ui.character.CharacterVoteSection
import com.co.ceiba.marvelapp.ui.theme.MarvelAppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TitleCharacterSectionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val character = Builder.getCharacter()

    @Test
    fun showTitleSection_whenIsLoaded_isDisplayed(){
        //Arrange
        //Act
        composeTestRule.setContent {
            MarvelAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CharacterTitleSection(character)
                }
            }
        }
        //Assert
        composeTestRule.onNodeWithTag(MainPage.titleSection).assertIsDisplayed()
    }

    @Test
    fun showVote_whenIsLoaded_isDisplayed(){
        //Arrange
        //Act
        composeTestRule.setContent {
            MarvelAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CharacterVoteSection(character)
                }
            }
        }
        //Assert
        composeTestRule.onNodeWithContentDescription(MainPage.iconStar).assertIsDisplayed()
    }

}