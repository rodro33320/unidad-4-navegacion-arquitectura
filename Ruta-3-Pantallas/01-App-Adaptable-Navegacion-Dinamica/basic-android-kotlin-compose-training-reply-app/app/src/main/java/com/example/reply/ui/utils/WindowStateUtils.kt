/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.reply.ui.utils

// Representa los 3 tipos de navegación adaptable que puede mostrar la app,
// uno por cada clase de tamaño de ventana (Compact, Medium, Expanded)
enum class ReplyNavigationType {
    BOTTOM_NAVIGATION,
    NAVIGATION_RAIL,
    PERMANENT_NAVIGATION_DRAWER
}

// Representa los tipos de distribución de contenido adaptables (solo lista o lista y detalle)
enum class ReplyContentType {
    LIST_ONLY,
    LIST_AND_DETAIL
}