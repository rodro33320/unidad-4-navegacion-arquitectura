package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertClickerViewModel : ViewModel() {

    // Propiedad de respaldo: privada y mutable, solo editable dentro de esta clase
    private val _uiState = MutableStateFlow(
        DessertClickerUiState(
            currentDessertPrice = Datasource.dessertList[0].price,
            currentDessertImageId = Datasource.dessertList[0].imageId
        )
    )
    // Pública y de solo lectura, la IU la observa pero no la modifica
    val uiState: StateFlow<DessertClickerUiState> = _uiState.asStateFlow()

    // EVENTO: se llama cada vez que el usuario toca el postre
    fun onDessertClicked() {
        // Determina cuál es el próximo postre a mostrar
        val currentDessertIndex = _uiState.value.currentDessertIndex
        val nextDessertIndex = determineDessertIndex(_uiState.value.dessertsSold + 1)

        _uiState.update { currentState ->
            currentState.copy(
                revenue = currentState.revenue + currentState.currentDessertPrice,
                dessertsSold = currentState.dessertsSold + 1,
                currentDessertIndex = nextDessertIndex,
                currentDessertPrice = Datasource.dessertList[nextDessertIndex].price,
                currentDessertImageId = Datasource.dessertList[nextDessertIndex].imageId
            )
        }
    }

    // Lógica auxiliar: decide qué postre mostrar según cuántos se vendieron.
    // Misma lógica que estaba antes en MainActivity, solo que ahora vive aquí.
    private fun determineDessertIndex(dessertsSold: Int): Int {
        var dessertIndex = 0
        for (index in Datasource.dessertList.indices) {
            if (dessertsSold >= Datasource.dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else {
                break
            }
        }
        return dessertIndex
    }
}