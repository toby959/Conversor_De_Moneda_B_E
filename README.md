<h1> Conversor De Moneda Back End</h1>


Este es un proyecto en Java que permite realizar la conversión de varias monedas utilizando tasas de conversión actualizadas. El conversor toma una cantidad en una moneda de origen y la convierte a otra moneda destino, basándose en las tasas de conversión que obtiene de un servicio de API externo.

## Funcionalidades

- Convertir entre diferentes tipos de monedas: USD, ARS, BRL, COP, BOB.
- Realizar conversiones de moneda basadas en tasas de cambio actuales.
- Manejo de errores para entradas no válidas o monedas no soportadas.
- Sistema de menús para seleccionar las monedas a convertir y realizar las operaciones.

## Estructura del Proyecto

El proyecto está dividido en las siguientes partes principales:

### 1. **Modelos**

Esta carpeta contiene las clases que representan la respuesta de la API de conversión de moneda.

- `ApiResponse`: Clase que almacena la respuesta de la API que incluye las tasas de conversión. Esta clase incluye un `Map<String, Double>` llamado `conversion_rates`, que contiene las tasas de conversión de las monedas.
  
### 2. **Servicios**

- `ConversionService`: Clase encargada de realizar la conversión de las monedas. Utiliza la información de tasas de cambio obtenidas desde la API para calcular el valor convertido. Esta clase maneja diferentes opciones para convertir entre monedas específicas, como USD a ARS, USD a BRL, etc.
  
- `ApiService`: Servicio encargado de hacer la solicitud a la API externa para obtener las tasas de conversión actuales. Esta clase maneja la comunicación con el API y devuelve los datos necesarios al `ConversionService`.

### 3. **Principal**

Esta clase contiene el punto de entrada principal de la aplicación y maneja la interacción con el usuario. Permite seleccionar la opción de conversión deseada y realizar el cálculo de la conversión con las tasas de cambio obtenidas.

## Cómo Funciona

1. **Entrada del Usuario**: El usuario selecciona una opción de conversión de moneda (por ejemplo, USD a ARS o BRL a USD).
2. **Obtención de Tasas**: El `ApiService` consulta la API externa para obtener las tasas de cambio actuales.
3. **Cálculo de Conversión**: El `ConversionService` toma las tasas de conversión desde la respuesta de la API y calcula el valor convertido basado en la cantidad introducida por el usuario.
4. **Resultados**: El resultado de la conversión se imprime en la consola, mostrando la cantidad original y la cantidad convertida en la moneda destino.

## Monedas Soportadas

El conversor de moneda actualmente soporta las siguientes conversiones:

1. USD a ARS
2. ARS a USD
3. USD a BRL
4. BRL a USD
5. USD a COP
6. COP a USD
7. USD a BOB

## Requisitos

Para ejecutar este proyecto, se requiere:

- **Java 17** o superior.
- Un entorno de desarrollo como **IntelliJ IDEA** o **Eclipse**.
- Conexión a internet (para obtener las tasas de cambio desde la API).

## Uso

1. Clona este repositorio.
2. Abre el proyecto en IntelliJ IDEA o cualquier entorno de desarrollo que prefieras.
3. Configura el SDK de Java (JDK 17 o superior).
4. Ejecuta la clase `Principal` para iniciar la aplicación.

## Ejemplo de Uso

Al iniciar la aplicación, se te presentará un menú con opciones. Por ejemplo, si seleccionas la opción "1", el sistema convertirá dólares estadounidenses (USD) a pesos argentinos (ARS).

Ejemplo de entrada:

Selecciona una opción:

Convertir de USD a ARS
Convertir de ARS a USD ...
yaml
Copiar código

Ejemplo de salida:
Ingrese la cantidad a convertir: 100 100 USD = 9,500 ARS

markdown
Copiar código

## Manejo de Errores

- Si el usuario introduce una opción no válida, el programa imprimirá un mensaje de error y pedirá una nueva entrada.
- Si la API no puede proporcionar una tasa de conversión para una moneda específica, se mostrará un mensaje de error.

## Futuras Mejoras

- Añadir más opciones de conversión entre otras monedas.
- Implementar una interfaz gráfica de usuario (GUI) para hacer la interacción más intuitiva.
- Guardar las conversiones recientes para referencia futura.
- Agregar más robustez en el manejo de excepciones y errores de la API.

## Contribuciones

Si deseas contribuir a este proyecto, siéntete libre de hacer un fork del repositorio y abrir un pull request con tus mejoras. Todos los comentarios y sugerencias son bienvenidos.

## Licencia

Este proyecto está licenciado bajo la [Licencia MIT](LICENSE).



