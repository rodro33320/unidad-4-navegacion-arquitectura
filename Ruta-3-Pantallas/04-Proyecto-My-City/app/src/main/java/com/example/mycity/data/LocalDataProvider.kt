package com.example.mycity.data

object LocalDataProvider {
    val recommendations = listOf(
        // Cafeterías
        Recommendation(
            id = 1,
            name = "Café Central",
            category = Category.COFFEE_SHOPS,
            shortDescription = "Cafetería histórica de jazz al lado de la Plaza de Santa Ana.",
            longDescription = "Un café con más de cuarenta años de historia, famoso por sus actuaciones de jazz en vivo y un ambiente bohemio inigualable. Ideal para leer, conversar o saborear un café clásico madrileño con repostería artesanal.",
            address = "Plaza del Ángel, 10, 28012 Madrid",
            openingHours = "09:00 - 00:00"
        ),
        Recommendation(
            id = 2,
            name = "Toma Café",
            category = Category.COFFEE_SHOPS,
            shortDescription = "Pioneros del café de especialidad en Malasaña.",
            longDescription = "Un local pequeño pero con una vibra excelente, conocido por servir uno de los mejores cafés de especialidad de la ciudad. Tuestan sus propios granos y ofrecen tostadas creativas deliciosas.",
            address = "Calle de la Palma, 49, 28004 Madrid",
            openingHours = "08:00 - 20:00"
        ),
        Recommendation(
            id = 3,
            name = "Misión Café",
            category = Category.COFFEE_SHOPS,
            shortDescription = "Diseño moderno y panadería excepcional.",
            longDescription = "Espacio de estética minimalista donde la preparación del café es un arte. Cuentan con una máquina de espresso de última generación y bollería recién horneada en su propio taller.",
            address = "Calle de los Reyes, 5, 28015 Madrid",
            openingHours = "09:00 - 19:00"
        ),

        // Restaurantes
        Recommendation(
            id = 4,
            name = "Sobrino de Botín",
            category = Category.RESTAURANTS,
            shortDescription = "El restaurante más antiguo del mundo según el Libro Guinness.",
            longDescription = "Fundado en 1725, este restaurante es famoso por su cochinillo y cordero asados al estilo castellano en su horno de leña original. Un viaje culinario en el tiempo en pleno corazón de Madrid.",
            address = "Calle de Cuchilleros, 17, 28005 Madrid",
            openingHours = "13:00 - 16:00, 20:00 - 23:30"
        ),
        Recommendation(
            id = 5,
            name = "Casa Lucio",
            category = Category.RESTAURANTS,
            shortDescription = "Legendario por sus 'huevos estrellados'.",
            longDescription = "Un clásico de la cocina tradicional madrileña. Políticos, artistas y lugareños acuden aquí para disfrutar de su plato estrella, los huevos rotos, servidos con una sencillez y calidad inigualables.",
            address = "Calle de la Cava Baja, 35, 28005 Madrid",
            openingHours = "13:00 - 16:00, 20:30 - 00:00"
        ),
        Recommendation(
            id = 6,
            name = "La Sanabresa",
            category = Category.RESTAURANTS,
            shortDescription = "Casa de comidas tradicional y económica.",
            longDescription = "Una taberna auténtica del barrio de las Letras que ofrece menús del día caseros, abundantes y llenos de sabor tradicional. Famosa por sus berenjenas, cocido madrileño y trato familiar.",
            address = "Calle de Amor de Dios, 12, 28014 Madrid",
            openingHours = "13:00 - 16:00, 20:00 - 23:00"
        ),

        // Parques
        Recommendation(
            id = 7,
            name = "Parque del Retiro",
            category = Category.PARKS,
            shortDescription = "El pulmón verde central e histórico de Madrid.",
            longDescription = "Un oasis de 125 hectáreas que alberga el majestuoso Palacio de Cristal, un estanque grande para pasear en barca y hermosos jardines como la Rosaleda. Declarado Patrimonio de la Humanidad.",
            address = "Plaza de la Independencia, 7, 28001 Madrid",
            openingHours = "06:00 - 22:00"
        ),
        Recommendation(
            id = 8,
            name = "El Capricho",
            category = Category.PARKS,
            shortDescription = "Un jardín romántico y joya oculta de la ciudad.",
            longDescription = "Diseñado a finales del siglo XVIII, es uno de los parques más hermosos y menos conocidos de Madrid. Cuenta con templos, riachuelos artificiales, un laberinto de laureles y un búnker de la Guerra Civil.",
            address = "Paseo de la Alameda de Osuna, 25, 28042 Madrid",
            openingHours = "09:00 - 20:00 (Solo fines de semana)"
        ),
        Recommendation(
            id = 9,
            name = "Casa de Campo",
            category = Category.PARKS,
            shortDescription = "Inmenso espacio natural e histórico.",
            longDescription = "El parque público más grande de Madrid, ideal para el senderismo, ciclismo y actividades familiares. Cuenta con un gran lago rodeado de restaurantes, teleférico, el Zoo y el Parque de Atracciones.",
            address = "Paseo de Extremadura, 28011 Madrid",
            openingHours = "Abierto 24 horas"
        ),

        // Lugares Históricos
        Recommendation(
            id = 10,
            name = "Palacio Real de Madrid",
            category = Category.HISTORICAL_SITES,
            shortDescription = "La residencia oficial de la familia real española.",
            longDescription = "El palacio real más grande de Europa Occidental, con una arquitectura barroca impresionante, salones oficiales majestuosos, la Real Armería y hermosas vistas hacia los Jardines de Sabatini.",
            address = "Calle de Bailén, s/n, 28071 Madrid",
            openingHours = "10:00 - 19:00"
        ),
        Recommendation(
            id = 11,
            name = "Plaza Mayor",
            category = Category.HISTORICAL_SITES,
            shortDescription = "El corazón histórico del Madrid de los Austrias.",
            longDescription = "Una plaza porticada espectacular diseñada en el siglo XVII. Ha albergado mercados, fiestas populares y eventos históricos. Famosa hoy en día por sus terrazas y sus tradicionales bocadillos de calamares.",
            address = "Plaza Mayor, 28012 Madrid",
            openingHours = "Acceso libre 24 horas"
        ),
        Recommendation(
            id = 12,
            name = "Templo de Debod",
            category = Category.HISTORICAL_SITES,
            shortDescription = "Auténtico templo egipcio del siglo II a.C.",
            longDescription = "Donado por Egipto a España en gratitud por la ayuda en el salvamento de los templos de Nubia. Situado en una colina cerca de Plaza de España, es el mejor lugar de la ciudad para contemplar atardeceres mágicos.",
            address = "Calle de Ferraz, 1, 28008 Madrid",
            openingHours = "10:00 - 20:00"
        )
    )
}
