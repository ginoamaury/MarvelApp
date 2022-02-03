# MarvelApp 
Marvelapp es una aplicacion movil desarrollada en Kotlin la cual muestra los personajes de marvel y su información usando el API de MARVEL 

## Información general 🚀

El proyecto consta de una aplicación que muestra un listado de personajes de marvel usando el api [MARVEL](https://developer.marvel.com/), al dar tap en alguna de ellas muestra un detalle del personaje


### Requerimientos 📋

* Min SDK version 23
* Target SDK version 31
* [API](https://developer.marvel.com/) MARVEL
* Al abrir la aplicación se debe busca la información de manera local
* Si no se encuentra información de manera local se procede a buscarse mediante el servicio web
* Si la información encontrada localmente fue almacenada hace más de un dia, debe buscarse en el servicio web y persistir la nueva información encontrada

## Servicios 📖
_Puedes hacer lo siguiente en la aplicación_

### Lista de personajes 
La aplicación te muestra los personajes por orden alfabetico

### Información detallada de personaje
La aplicación te muestra informacion detallada del personaje como su historia

### Filtar personaje
La aplicación te permite filtrar a los personajes por nombre


## Arquitectura 📋
Se propuso como arquitectura para el proyecto una arquitectura limpia como DDD enfocada en el modelo de dominio y en el apartado de aplicación se usó MVVM 

Se usó el diseño guiado por el dominio ya que provee una estructura de prácticas y terminologías para tomar decisiones de diseño que enfoquen y aceleren el manejo de dominios complejos en los proyectos de software. 

## Estructura del proyecto
Se identifican 3 modulos
* App - Como capa de presentación
* Domain - Como capa de dominio donde encontramos nuestras reglas de negocio y nuestros servicios 
* Infrastructure - Como capa mas externa donde encontramos los detalles (Base Datos, Cliente Htt, etc)

## Construido con 🛠️

### [Retrofit](https://square.github.io/retrofit/) - Cliente HTTP
Como cliente HTTP para el consumo de servicios Rest se usó “Retrofit”  ya que facilita este trabajo en aplicaciones Android, reduciendo el código repetitivo usando JSON como modelo de datos 
### [Room](https://developer.android.com/jetpack/androidx/releases/room) - Persistencia de datos
Para la base de datos se usó Room ya que es una biblioteca de persistencias que nos brinda una capa de abstracción para SQLite permitiendo acceder a la base de datos facilmente ademas de ser la recomendada por Android
### [Hilt](https://dagger.dev/hilt/) - Inyección de dependencias
Para realizar la inyección de dependencias se usó la librería “Hilt”  la cual proporciona una forma estándar de usar la inyección de dependencias y es recomendado oficialmente para el desarrollo de Android
### [Flow](https://developer.android.com/kotlin/flow) - Programación Asíncrona
Se implementó Flow como flujo de datos, se usa para recibir actualizaciones en vivo desde la base de datos, y desde el servicio
### [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Para administrar la interfaz de usuario
Para almacenar y administrar datos relacionados con la IU de manera optimizada para los ciclos de vida.
### [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started) - Navegación de interfaz de usuario
El componente Navigation de Android Jetpack te permite implementar la navegación, desde simples clics de botones hasta patrones más complejos, como las barras de apps y los paneles laterales de navegación. El componente Navigation también garantiza una experiencia del usuario coherente y predecible
### [Compose](https://developer.android.com/jetpack/compose) - Interfaz de usuario
Jetpack Compose es el kit de herramientas moderno de Android para compilar IU nativas. Simplifica y acelera el desarrollo de la IU en Android.
### [JUnit](https://junit.org/junit5/) - Testing
JUnit como Framework para la automatización de las pruebas (tanto unitarias, como de integración) en los proyectos Software.
### [Mockito](https://site.mockito.org/) - Crear Mocks de objetos en Testing
Mockito es un marco de prueba de código abierto para Java. El marco permite la creación de objetos dobles de prueba en pruebas unitarias automatizadas con el propósito de desarrollo basado en pruebas o desarrollo basado en comportamiento.
### [Coil](https://coil-kt.github.io/coil/getting_started/) - Framework para carga de imágenes
Una biblioteca de carga de imágenes para Android respaldada por Kotlin Coroutines, Coil realiza una serie de optimizaciones, incluido el almacenamiento en caché de memoria y disco, la reducción de la muestra de la imagen en la memoria, la reutilización de mapas de bits, la pausa/cancelación automática de solicitudes y más.
### [ModelMapper](http://modelmapper.org/) - Mapear Objetos
ModelMapper es una biblioteca de mapeo de objetos inteligente y segura para la refactorización.

## Version 📌

**Version name :** 1.0


