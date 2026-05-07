# Mandatos de Arquitectura y Desarrollo

Estas reglas son fundamentales para este proyecto y deben seguirse estrictamente en cada intervención.

## Visión del Proyecto: AlpaChange
Plataforma universitaria para estudiantes de la **UNTELS** (Universidad Nacional Tecnológica de Lima Sur) inspirada en Change.org. Permite crear peticiones, evaluar docentes y reportar contenido.

### Reglas de Negocio Críticas
- **Dominio:** Solo correos `@untels.edu.pe`.
- **Verificación:** Obligatoria para interactuar (votar, comentar, crear).
- **Archivado:** Automático si el crecimiento de votos cae por debajo del 10% del periodo anterior después de 8 días.
- **Privacidad:** Uso de **Alias** para comentarios y peticiones.
- **Filtros:** Validación automática de lenguaje inapropiado en títulos, descripciones, comentarios y alias.
- **Docentes:** Reseña única por profesor/curso; evaluación en 4 categorías (1-5).

## Arquitectura de Carpetas Obligatoria

```text
app/src/main/
├── java/com/tuapp/
│   ├── ui/
│   │   ├── screens/
│   │   │   └── <pantalla>/
│   │   │       ├── <Pantalla>Activity.kt
│   │   │       └── <Pantalla>ViewModel.kt
│   │   └── components/
│   │       └── (componentes visuales reutilizables)
│   ├── data/
│   │   ├── model/         → Clases de datos (data classes)
│   │   ├── repository/    → Quien obtiene y provee los datos
│   │   └── network/       → Configuración de API / Retrofit
│   └── utils/
│       ├── Constants.kt   → Valores fijos de la app
│       ├── Extensions.kt  → Funciones de extensión de Kotlin
│       └── Helpers.kt     → Funciones auxiliares generales
│
└── res/
    ├── layout/            → Archivos XML de diseño de pantallas
    ├── values/
    │   ├── colors.xml     → ÚNICO lugar donde se definen colores
    │   ├── strings.xml    → ÚNICO lugar donde se definen textos
    │   ├── themes.xml     → Estilos y temas globales
    │   └── dimens.xml     → Tamaños, márgenes y paddings
    ├── drawable/          → Íconos, imágenes y formas vectoriales
    ├── font/              → Fuentes tipográficas
    └── mipmap/            → Ícono de la aplicación
```

## Reglas Estrictas

1.  **Colores:**
    *   Prohibido hardcodear colores en XML o Kotlin.
    *   Definir en `res/values/colors.xml`.
    *   Referenciar como `@color/nombre_color` o `ContextCompat.getColor(...)`.
    *   En `colors.xml`, agrupar con comentarios: `<!-- ===== COLORES DE X ===== -->`.

2.  **Textos:**
    *   Prohibido hardcodear textos visibles.
    *   Definir en `res/values/strings.xml`.
    *   Referenciar como `@string/nombre` o `getString(R.string.nombre)`.

3.  **Tamaños:**
    *   Márgenes, paddings y fuentes en `res/values/dimens.xml`.
    *   Referenciar como `@dimen/nombre`.

4.  **Layouts:**
    *   Convención: `activity_<nombre>.xml`, `fragment_<nombre>.xml`, `item_<nombre>.xml`, `dialog_<nombre>.xml`.

5.  **Lógica y Vistas (MVVM):**
    *   Activity: Solo eventos de UI y navegación.
    *   ViewModel: Lógica de negocio y estado.
    *   Repository: Fuente de datos única para el ViewModel.

6.  **Comentarios:**
    *   Cada archivo debe iniciar con un comentario de una línea explicando su propósito.

## Protocolo de Generación de Código

Al generar código, siempre incluir:
1.  Ruta exacta del archivo.
2.  Nombre del archivo.
3.  Contenido completo.
4.  Línea final indicando archivos impactados.
