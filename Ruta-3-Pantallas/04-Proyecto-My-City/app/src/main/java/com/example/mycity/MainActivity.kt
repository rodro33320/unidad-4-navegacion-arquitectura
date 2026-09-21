package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import com.example.mycity.ui.MyCityApp
import com.example.mycity.ui.utils.MyCityContentType
import com.example.mycity.ui.utils.MyCityNavigationType

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSize = calculateWindowSizeClass(this)
                    val navigationType: MyCityNavigationType
                    val contentType: MyCityContentType

                    when (windowSize.widthSizeClass) {
                        WindowWidthSizeClass.Compact -> {
                            navigationType = MyCityNavigationType.BOTTOM_NAVIGATION
                            contentType = MyCityContentType.LIST_ONLY
                        }
                        WindowWidthSizeClass.Medium -> {
                            navigationType = MyCityNavigationType.NAVIGATION_RAIL
                            contentType = MyCityContentType.LIST_ONLY
                        }
                        WindowWidthSizeClass.Expanded -> {
                            navigationType = MyCityNavigationType.PERMANENT_NAVIGATION_DRAWER
                            contentType = MyCityContentType.LIST_AND_DETAIL
                        }
                        else -> {
                            navigationType = MyCityNavigationType.BOTTOM_NAVIGATION
                            contentType = MyCityContentType.LIST_ONLY
                        }
                    }

                    MyCityApp(
                        navigationType = navigationType,
                        contentType = contentType
                    )
                }
            }
        }
    }
}
