package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.Category
import com.example.mycity.data.LocalDataProvider
import com.example.mycity.data.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    fun updateCurrentCategory(category: Category) {
        val filteredList = LocalDataProvider.recommendations.filter { it.category == category }
        _uiState.update {
            it.copy(
                currentCategory = category,
                recommendationList = filteredList,
                currentRecommendation = filteredList.first(),
                isShowingListPage = true
            )
        }
    }

    fun updateCurrentRecommendation(recommendation: Recommendation) {
        _uiState.update {
            it.copy(
                currentRecommendation = recommendation,
                isShowingListPage = false
            )
        }
    }

    fun navigateBackToList() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }
}
