package com.plcoding.calorytracker.navigation

import androidx.compose.ui.ExperimentalComposeUiApi
import coil.annotation.ExperimentalCoilApi
import com.plcoding.onboarding_presentation.OnboardingNavGraph
import com.plcoding.tracker_presentation.TrackerNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec

@ExperimentalCoilApi
@ExperimentalComposeUiApi
object RootNavGraph: NavGraphSpec {

    override val route = "root"

    override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()

    override val startRoute = OnboardingNavGraph

    override val nestedNavGraphs = listOf(
        OnboardingNavGraph,
        TrackerNavGraph
    )
}