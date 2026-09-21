package com.example.dessertclicker.ui

import com.example.dessertclicker.model.Dessert

// Todo lo que la pantalla necesita para dibujarse: postre actual, ventas e ingresos.
// Antes esto vivía como variables sueltas dentro de DessertClickerApp().
data class DessertClickerUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0,
    val currentDessertPrice: Int = 0,
    val currentDessertImageId: Int = 0
)