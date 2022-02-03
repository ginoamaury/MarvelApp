package com.co.ceiba.marvelapp.character

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.co.ceiba.domain.builder.Builder
import com.co.ceiba.marvelapp.MainPage
import com.co.ceiba.marvelapp.ui.character.CharacterAboutSection
import com.co.ceiba.marvelapp.ui.theme.MarvelAppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AboutCharacterSectionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val character = Builder.getCharacter()

    @Test
    fun showAboutSection_whenIsLoaded_isDisplayed(){
        //Arrange
        //Act
        composeTestRule.setContent {
            MarvelAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CharacterAboutSection(character)
                }
            }
        }
        //Assert
        composeTestRule.onNodeWithText(MainPage.resumeSection).assertIsDisplayed()
    }

}