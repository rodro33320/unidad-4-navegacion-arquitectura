package com.example.mycity.data

enum class Category(
    val title: String,
    val description: String
) {
    COFFEE_SHOPS("Cafeterías", "Lugares acogedores para disfrutar del mejor café y repostería."),
    RESTAURANTS("Restaurantes", "Establecimientos culinarios para saborear la gastronomía madrileña."),
    PARKS("Parques y Naturaleza", "Espacios verdes y zonas naturales para relajarse al aire libre."),
    HISTORICAL_SITES("Lugares Históricos", "Monumentos y sitios emblemáticos llenos de historia y cultura.")
}
