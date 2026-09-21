package com.example.mycity.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.data.Category
import com.example.mycity.data.Recommendation
import com.example.mycity.ui.screens.CategoryListScreen
import com.example.mycity.ui.screens.RecommendationDetailScreen
import com.example.mycity.ui.screens.RecommendationListScreen
import com.example.mycity.ui.screens.getCategoryIcon
import com.example.mycity.ui.utils.MyCityContentType
import com.example.mycity.ui.utils.MyCityNavigationType

@Composable
fun MyCityApp(
    navigationType: MyCityNavigationType,
    contentType: MyCityContentType,
    modifier: Modifier = Modifier,
    viewModel: MyCityViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val navController = rememberNavController()

    if (contentType == MyCityContentType.LIST_AND_DETAIL) {
        LargeScreenLayout(
            uiState = uiState,
            navigationType = navigationType,
            onCategorySelected = { viewModel.updateCurrentCategory(it) },
            onRecommendationSelected = { viewModel.updateCurrentRecommendation(it) },
            modifier = modifier
        )
    } else {
        CompactScreenLayout(
            uiState = uiState,
            navController = navController,
            viewModel = viewModel,
            modifier = modifier
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompactScreenLayout(
    uiState: MyCityUiState,
    navController: NavHostController,
    viewModel: MyCityViewModel,
    modifier: Modifier = Modifier
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route ?: "categories"

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = when (currentRoute) {
                            "categories" -> "Explora Madrid"
                            "recommendations" -> uiState.currentCategory.title
                            "detail" -> uiState.currentRecommendation.name
                            else -> "Mi Ciudad"
                        },
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    if (currentRoute != "categories") {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Volver")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "categories",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("categories") {
                CategoryListScreen(
                    categories = uiState.categories,
                    onCategoryClick = { category ->
                        viewModel.updateCurrentCategory(category)
                        navController.navigate("recommendations")
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
            composable("recommendations") {
                RecommendationListScreen(
                    recommendations = uiState.recommendationList,
                    onRecommendationClick = { recommendation ->
                        viewModel.updateCurrentRecommendation(recommendation)
                        navController.navigate("detail")
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
            composable("detail") {
                RecommendationDetailScreen(
                    recommendation = uiState.currentRecommendation
                )
            }
        }
    }
}

@Composable
fun LargeScreenLayout(
    uiState: MyCityUiState,
    navigationType: MyCityNavigationType,
    onCategorySelected: (Category) -> Unit,
    onRecommendationSelected: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    if (navigationType == MyCityNavigationType.PERMANENT_NAVIGATION_DRAWER) {
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(Modifier.width(260.dp)) {
                    Column(Modifier.padding(16.dp)) {
                        Text(
                            text = "Mi Ciudad: Madrid",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                        uiState.categories.forEach { category ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                                    .clickable { onCategorySelected(category) },
                                colors = CardDefaults.cardColors(
                                    containerColor = if (uiState.currentCategory == category)
                                        MaterialTheme.colorScheme.primaryContainer
                                    else
                                        MaterialTheme.colorScheme.surfaceVariant
                                )
                            ) {
                                Row(
                                    modifier = Modifier.padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(imageVector = getCategoryIcon(category), contentDescription = null)
                                    Spacer(Modifier.width(12.dp))
                                    Text(category.title, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            },
            modifier = modifier
        ) {
            DualPanelContent(uiState, onRecommendationSelected)
        }
    } else {
        Row(modifier = modifier.fillMaxSize()) {
            NavigationRail {
                Spacer(Modifier.weight(1f))
                uiState.categories.forEach { category ->
                    NavigationRailItem(
                        selected = uiState.currentCategory == category,
                        onClick = { onCategorySelected(category) },
                        icon = { Icon(imageVector = getCategoryIcon(category), contentDescription = category.title) },
                        label = { Text(category.title) }
                    )
                }
                Spacer(Modifier.weight(1f))
            }
            DualPanelContent(uiState, onRecommendationSelected)
        }
    }
}

@Composable
fun DualPanelContent(
    uiState: MyCityUiState,
    onRecommendationSelected: (Recommendation) -> Unit
) {
    Row(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            Text(
                text = uiState.currentCategory.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            RecommendationListScreen(
                recommendations = uiState.recommendationList,
                onRecommendationClick = onRecommendationSelected
            )
        }
        Card(
            modifier = Modifier
                .weight(1.3f)
                .fillMaxHeight()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            RecommendationDetailScreen(
                recommendation = uiState.currentRecommendation
            )
        }
    }
}
