package com.example.unscramble.ui

// Data class = modelo INMUTABLE del estado de la pantalla.
// Vive en "ui" porque es estado de presentación, no dato crudo del juego.


// punto numero 1
data class GameUiState(
    val currentScrambledWord: String = "",
    val currentWordCount: Int = 1,
    val score: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val isGameOver: Boolean = false
)