package com.plcoding.onboarding_presentation.nutrient_goal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.core.R
import com.plcoding.core.util.UiEvent
import com.plcoding.core_ui.LocalSpacing
import com.plcoding.onboarding_presentation.OnOnboardingFinished
import com.plcoding.onboarding_presentation.components.ActionButton
import com.plcoding.onboarding_presentation.components.UnitTextField
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.flow.Flow

@Destination
@Composable
internal fun NutrientGoalScreen(
    scaffoldState: ScaffoldState,
    onOnboardingFinished: OnOnboardingFinished,
    viewModel: NutrientGoalViewModel = hiltViewModel()
) {
    UiEventEffect(
        uiEvents = viewModel.uiEvent,
        scaffoldState = scaffoldState,
        navigateToNextScreen = onOnboardingFinished::invoke
    )

    NutrientGoalScreenContent(
        state = viewModel.state,
        onEvent = viewModel::onEvent
    )
}

@Composable
private fun NutrientGoalScreenContent(
    state: NutrientGoalState,
    onEvent: (NutrientGoalEvent) -> Unit,
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.what_are_your_nutrient_goals),
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = state.carbsRatio,
                onValueChange = {
                    onEvent(NutrientGoalEvent.OnCarbRatioEnter(it))
                },
                unit = stringResource(id = R.string.percent_carbs)
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = state.proteinRatio,
                onValueChange = {
                    onEvent(NutrientGoalEvent.OnProteinRatioEnter(it))
                },
                unit = stringResource(id = R.string.percent_proteins)
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = state.fatRatio,
                onValueChange = {
                    onEvent(NutrientGoalEvent.OnFatRatioEnter(it))
                },
                unit = stringResource(id = R.string.percent_fats)
            )
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = {
                onEvent(NutrientGoalEvent.OnNextClick)
            },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

@Composable
private fun UiEventEffect(
    uiEvents: Flow<UiEvent>,
    scaffoldState: ScaffoldState,
    navigateToNextScreen: () -> Unit,
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        uiEvents.collect { event ->
            when (event) {
                is UiEvent.Success -> navigateToNextScreen()
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }

                else -> Unit
            }
        }
    }
}
