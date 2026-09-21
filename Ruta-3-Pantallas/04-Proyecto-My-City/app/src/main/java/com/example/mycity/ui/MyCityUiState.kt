package com.example.mycity.ui

import com.example.mycity.data.Category
import com.example.mycity.data.LocalDataProvider
import com.example.mycity.data.Recommendation

data class MyCityUiState(
    val categories: List<Category> = Category.entries,
    val currentCategory: Category = Category.COFFEE_SHOPS,
    val recommendationList: List<Recommendation> = LocalDataProvider.recommendations.filter { it.category == Category.COFFEE_SHOPS },
    val currentRecommendation: Recommendation = recommendationList.first(),
    val isShowingListPage: Boolean = true
)
