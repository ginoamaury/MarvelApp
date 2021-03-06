# MarvelApp 
Marvelapp es una aplicacion movil desarrollada en Kotlin la cual muestra los personajes de marvel y su informaci贸n usando el API de MARVEL 

## Informaci贸n general 馃殌

El proyecto consta de una aplicaci贸n que muestra un listado de personajes de marvel usando el api [MARVEL](https://developer.marvel.com/), al dar tap en alguna de ellas muestra un detalle del personaje


### Requerimientos 馃搵

* Min SDK version 23
* Target SDK version 31
* [API](https://developer.marvel.com/) MARVEL
* Al abrir la aplicaci贸n se debe busca la informaci贸n de manera local
* Si no se encuentra informaci贸n de manera local se procede a buscarse mediante el servicio web
* Si la informaci贸n encontrada localmente fue almacenada hace m谩s de un dia, debe buscarse en el servicio web y persistir la nueva informaci贸n encontrada

## Servicios 馃摉
_Puedes hacer lo siguiente en la aplicaci贸n_

### Lista de personajes 
La aplicaci贸n te muestra los personajes por orden alfabetico

### Informaci贸n detallada de personaje
La aplicaci贸n te muestra informacion detallada del personaje como su historia

### Filtar personaje
La aplicaci贸n te permite filtrar a los personajes por nombre


## Arquitectura 馃搵
Se propuso como arquitectura para el proyecto una arquitectura limpia como DDD enfocada en el modelo de dominio y en el apartado de aplicaci贸n se us贸 MVVM 

Se us贸 el dise帽o guiado por el dominio ya que provee una estructura de pr谩cticas y terminolog铆as para tomar decisiones de dise帽o que enfoquen y aceleren el manejo de dominios complejos en los proyectos de software. 

## Estructura del proyecto
Se identifican 3 modulos
* App - Como capa de presentaci贸n
* Domain - Como capa de dominio donde encontramos nuestras reglas de negocio y nuestros servicios 
* Infrastructure - Como capa mas externa donde encontramos los detalles (Base Datos, Cliente Htt, etc)

## Construido con 馃洜锔?

### [Retrofit](https://square.github.io/retrofit/) - Cliente HTTP
Como cliente HTTP para el consumo de servicios Rest se us贸 鈥淩etrofit鈥?  ya que facilita este trabajo en aplicaciones Android, reduciendo el c贸digo repetitivo usando JSON como modelo de datos 
### [Room](https://developer.android.com/jetpack/androidx/releases/room) - Persistencia de datos
Para la base de datos se us贸 Room ya que es una biblioteca de persistencias que nos brinda una capa de abstracci贸n para SQLite permitiendo acceder a la base de datos facilmente ademas de ser la recomendada por Android
### [Hilt](https://dagger.dev/hilt/) - Inyecci贸n de dependencias
Para realizar la inyecci贸n de dependencias se us贸 la librer铆a 鈥淗ilt鈥?  la cual proporciona una forma est谩ndar de usar la inyecci贸n de dependencias y es recomendado oficialmente para el desarrollo de Android
### [Flow](https://developer.android.com/kotlin/flow) - Programaci贸n As铆ncrona
Se implement贸 Flow como flujo de datos, se usa para recibir actualizaciones en vivo desde la base de datos, y desde el servicio
### [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Para administrar la interfaz de usuario
Para almacenar y administrar datos relacionados con la IU de manera optimizada para los ciclos de vida.
### [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started) - Navegaci贸n de interfaz de usuario
El componente Navigation de Android Jetpack te permite implementar la navegaci贸n, desde simples clics de botones hasta patrones m谩s complejos, como las barras de apps y los paneles laterales de navegaci贸n. El componente Navigation tambi茅n garantiza una experiencia del usuario coherente y predecible
### [Compose](https://developer.android.com/jetpack/compose) - Interfaz de usuario
Jetpack Compose es el kit de herramientas moderno de Android para compilar IU nativas. Simplifica y acelera el desarrollo de la IU en Android.
### [JUnit](https://junit.org/junit5/) - Testing
JUnit como Framework para la automatizaci贸n de las pruebas (tanto unitarias, como de integraci贸n) en los proyectos Software.
### [Mockito](https://site.mockito.org/) - Crear Mocks de objetos en Testing
Mockito es un marco de prueba de c贸digo abierto para Java. El marco permite la creaci贸n de objetos dobles de prueba en pruebas unitarias automatizadas con el prop贸sito de desarrollo basado en pruebas o desarrollo basado en comportamiento.
### [Coil](https://coil-kt.github.io/coil/getting_started/) - Framework para carga de im谩genes
Una biblioteca de carga de im谩genes para Android respaldada por Kotlin Coroutines, Coil realiza una serie de optimizaciones, incluido el almacenamiento en cach茅 de memoria y disco, la reducci贸n de la muestra de la imagen en la memoria, la reutilizaci贸n de mapas de bits, la pausa/cancelaci贸n autom谩tica de solicitudes y m谩s.
### [ModelMapper](http://modelmapper.org/) - Mapear Objetos
ModelMapper es una biblioteca de mapeo de objetos inteligente y segura para la refactorizaci贸n.

## Version 馃搶

**Version name :** 1.0


