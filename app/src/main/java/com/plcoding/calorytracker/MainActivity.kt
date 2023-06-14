package com.plcoding.calorytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.plcoding.calorytracker.navigation.RootNavGraph
import com.plcoding.calorytracker.ui.theme.CaloryTrackerTheme
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.onboarding_presentation.OnOnboardingFinished
import com.plcoding.onboarding_presentation.OnboardingNavGraph
import com.plcoding.tracker_presentation.TrackerNavGraph
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.navigation.navigate
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowOnboarding = preferences.loadShouldShowOnboarding()
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    DestinationsNavHost(
                        modifier = Modifier.padding(it),
                        navController = navController,
                        navGraph = RootNavGraph,
                        startRoute = if (shouldShowOnboarding) OnboardingNavGraph else TrackerNavGraph,
                        dependenciesContainerBuilder = {
                            dependency(scaffoldState)
                            dependency(OnboardingNavGraph) {
                                OnOnboardingFinished { navController.navigate(TrackerNavGraph) }
                            }
                        }
                    )
                }

            }
        }
    }
}