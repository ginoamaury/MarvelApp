package com.co.ceiba.marvelapp.functional


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.co.ceiba.marvelapp.MainActivity
import com.co.ceiba.marvelapp.MainPage
import com.co.ceiba.marvelapp.Navigation
import com.co.ceiba.marvelapp.ui.theme.MarvelAppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*
import kotlin.concurrent.schedule

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>(MainActivity::class.java)

    @ExperimentalFoundationApi
    @ExperimentalTestApi
    @Test
    fun getAllCharacters_whenAllIsRight_okResult() {
        //Arrange
        val delay = 1000L
        val showSplashScreen = false
        composeTestRule.setContent {
            MarvelAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation({}, showSplashScreen)
                }
            }
        }
        AsyncTimer.start(delay)
        composeTestRule.waitUntil (
            condition = { AsyncTimer.expired },
            timeoutMillis = delay + 1000
        )
        //Act
        val list = composeTestRule.onNode(hasTestTag(MainPage.movieList), useUnmergedTree = true)
        //Assert
        list.assertIsDisplayed().performGesture { swipeDown() }.performClick()

    }

    @ExperimentalFoundationApi
    @ExperimentalTestApi
    @Test
    fun getAllCharacters_andShowDetailScreen_okResult() {

        //Arrange
        val delay = 1000L
        val showSplashScreen = false
        composeTestRule.setContent {
            MarvelAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation({}, showSplashScreen)
                }
            }
        }
        AsyncTimer.start(delay)
        composeTestRule.waitUntil (
            condition = { AsyncTimer.expired },
            timeoutMillis = delay + 3000
        )
        //Act
        val list = composeTestRule.onNode(hasTestTag(MainPage.movieList), useUnmergedTree = true)
        //Assert
        list.assertIsDisplayed().performGesture { swipeDown() }.performClick()

        AsyncTimer.start(delay)
        composeTestRule.waitUntil (
            condition = { AsyncTimer.expired },
            timeoutMillis = delay + 3000
        )

        composeTestRule.onNode(hasTestTag(MainPage.detailScreen), useUnmergedTree = true)
            .assertIsDisplayed()

    }

    object AsyncTimer {
        var expired = false
        fun start(delay: Long = 3000){
            expired = false
            Timer().schedule(delay) {
                expired = true
            }
        }
    }


}