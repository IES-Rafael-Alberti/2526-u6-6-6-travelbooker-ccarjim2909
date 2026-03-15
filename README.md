# Actividad: Desarrollo de Proyecto Software en Kotlin

**ID actividad:** 2425_PRO_u4u5u6_taskManager

**Agrupamiento de la actividad**: Individual 

---

### Descripción: **Ejercicio: Gestor de Reservas para una Agencia de Viajes**

En este ejercicio, crearás una plicación en la que aplicarás los conceptos de Programación Orientada a Objetos (POO) en Kotlin, incluyendo herencia, interfaces, clases abstractas, principios SOLID y arquitectura en capas. La aplicación simula un gestor de reservas para una agencia de viajes, permitiendo la creación y consulta de reservas de vuelo y de hotel. 

#### **Contexto y Objetivo**

Desarrolla una aplicación de consola en Kotlin que permita gestionar **reservas** en una agencia de viajes. Estas reservas se dividen en dos tipos: **Reserva de Vuelo** y **Reserva de Hotel**. Ambas derivan de una superclase o interfaz denominada **Reserva**.

La aplicación debe seguir una **arquitectura en capas**, separando claramente:
- **La capa de presentación (UI):** se encarga de la interacción con el usuario a través de la consola.
- **La capa de lógica de aplicación:** gestiona la lógica de negocio (creación, almacenamiento y manejo de reservas).
- **La capa de acceso a datos:** aunque en este ejercicio se puede utilizar un repositorio en memoria, se debe abstraer su acceso mediante interfaces, aplicando el principio de inversión de dependencias.

#### **Requerimientos Funcionales y No Funcionales**

1. **Arquitectura en Capas y Principio de Inversión de Dependencias**
  - La lógica de negocio debe depender de abstracciones (por ejemplo, interfaces de repositorios) y no de implementaciones concretas.
  - La comunicación entre la interfaz de usuario y la lógica de negocio debe estar claramente separada.

2. **Modelo de Dominio: Reserva, Reserva de Vuelo y Reserva de Hotel**
  - **Reserva (Superclase o Interfaz):**
    - Contendrá la lógica común a todas las reservas, aunque no se permitirá la creación de una instancia de la misma.
    - Posee un **id**. Se asigna automáticamente al crear la instancia. No puede ser nula y no se puede modificar.
    - Posee una **fechaCreacion**. Se asigna automáticamente al crear la instancia. No puede ser nula y no se puede modificar.
    - Posee una **descripcion**. No puede ser nula (por ejemplo, descripción del itinerario o servicio).
    - Debe incluir una propiedad `detalle`, cuyo getter utilice la lógica común para concatenar el *id* y la descripción.
  - **Reserva de Vuelo:**
    - Hereda las propiedades de Reserva.
    - Posee atributos propios: **origen**, **destino** y **horaVuelo**.
    - La propiedad **detalle** se genera dinámicamente, por ejemplo:  
      `id + " - " + descripcion + " - " + origen + " -> " + destino [horaVuelo]`.
    - Su constructor es **privado**. Se debe disponer de un método de clase (companion object) llamado `creaInstancia` para generar una nueva instancia.
    - Sobreescribe `toString` para mostrar formateada toda la información de la reserva de vuelo.
  - **Reserva de Hotel:**
    - Hereda las propiedades de Reserva.
    - Posee atributos propios: **ubicacion** y **numeroNoches**.
    - La propiedad **detalle** se genera dinámicamente, por ejemplo:  
      `id + " - " + descripcion + " - " + ubicacion (numeroNoches)`.
    - Al igual que Reserva de Vuelo, su constructor es privado y se debe utilizar el método `creaInstancia` para crear instancias.
    - Sobreescribe `toString` para mostrar formateada toda la información de la reserva de hotel.

3. **Buenas Prácticas y Principios SOLID**
  - Utiliza el principio de **inversión de dependencias**: la lógica de negocio no debe depender de clases concretas para el almacenamiento de las reservas.
  - Documenta y comenta el código de forma clara, explicando las decisiones de diseño, especialmente aquellas que no están explícitamente indicadas en la descripción.
  - Separa los métodos estáticos (en Kotlin se implementan mediante *companion objects*) y asegúrate de que la creación de instancias se haga mediante el método `creaInstancia`.
  - Integra el uso de **clases genéricas** (por ejemplo, en la implementación del repositorio) y **expresiones regulares** para validar ciertos formatos de entrada (por ejemplo, el formato de la hora en la Reserva de Vuelo).

4. **Interfaz de Usuario (Consola)**
  - La aplicación debe interactuar con el usuario a través de la consola, mostrando un menú que permita:
    - Crear una nueva reserva (seleccionando entre Reserva de Vuelo o Reserva de Hotel).
    - Listar todas las reservas registradas, mostrando el detalle de cada reserva mediante polimorfismo.
  - La capa de presentación debe comunicarse con la lógica de negocio a través de interfaces o abstracciones.

5. **Lógica de Aplicación**
  - Implementa un servicio (por ejemplo, `ReservaService`) que gestione la creación, almacenamiento (en memoria) y consulta de reservas.
  - Este servicio debe depender de una interfaz de repositorio (por ejemplo, `IReservaRepository`), permitiendo cambiar la implementación del almacenamiento sin afectar la lógica de negocio. Es decir, debéis aplicar el ppio DIP e inyectar en esta clase `ReservaService` un repositorio a través de la abstracción `IReservaRepository`.

#### **Objetivos del Ejercicio**

- Demostrar la comprensión de los fundamentos de la Programación Orientada a Objetos mediante la instanciación y uso de objetos.
- Aplicar conceptos avanzados de POO como herencia, clases abstractas e interfaces.
- Crear y utilizar clases que hagan uso de genéricos.
- Aplicar principios SOLID, especialmente la inversión de dependencias.
- Emplear expresiones regulares para la validación de entradas.
- Integrar y utilizar librerías externas para extender la funcionalidad del proyecto.
- Documentar y presentar el código de manera clara y comprensible.

#### **Trabajo a Realizar**

1. **Definición de Clases y Estructura del Proyecto**
  - Organiza el proyecto en paquetes (o módulos) que representen cada capa:
    - `presentacion` para la interfaz de usuario.
    - `servicios` (o `aplicacion`) para la lógica de negocio.
    - `datos` para la implementación del repositorio (en memoria).
    - `dominio` para definir las clases **Reserva**, **Reserva de Vuelo** y **Reserva de Hotel**.

2. **Implementación del Modelo de Dominio**
  - Define la superclase o interfaz `Reserva` que incluya:
    - Las propiedades comunes (`id`, `fechaCreacion`, `descripcion` y `detalle`).
    - La lógica compartida que consideres necesaria.
  - Implementa las clases `Reserva de Vuelo` y `Reserva de Hotel` siguiendo las especificaciones:
    - Campos inmutables (por ejemplo, `id` y `fechaCreacion` generados automáticamente).
    - Las propiedades específicas de cada una (`origen`, `destino`, `horaVuelo`) y (`ubicacion`, `numeroNoches`)
    - Constructores privados con el método `creaInstancia` en el *companion object*.
    - Propiedad `detalle` que concatene la información de forma dinámica.

3. **Desarrollo de la Lógica de Aplicación**
  - Implementa un servicio (`ReservaService`) que:
    - Utilice una interfaz de repositorio (`IReservaRepository`) para almacenar y recuperar reservas (`agregar` y `obtenerTodas`).
    - Permita la creación de nuevas reservas mediante métodos que invoquen `creaInstancia` de cada clase.
  - Aplica el principio de inversión de dependencias, de modo que el servicio dependa de la abstracción, no de una implementación concreta.

4. **Interfaz de Usuario (Consola)**
  - Desarrolla una interfaz de usuario en consola que muestre un menú con las siguientes opciones:
    - **Opción 1:** Crear nueva reserva (se debe preguntar al usuario si desea crear una Reserva de Vuelo o de Hotel, y solicitar los datos requeridos).
    - **Opción 2:** Listar todas las reservas registradas, mostrando el detalle (id y descripción) de cada reserva.
  - La capa de presentación debe comunicarse con el servicio para realizar las operaciones solicitadas.

5. **Documentación y Pruebas**
  - Comenta el código de forma clara, explicando las decisiones de diseño y la aplicación de los principios SOLID.
  - Realiza pruebas y depura la aplicación para asegurar su correcto funcionamiento.

### Recursos

- Apuntes dados en clase sobre programación orientada a objetos, Kotlin, uso de IDEs, y manejo de librerías.
- Recursos vistos en clase, incluyendo ejemplos de código, documentación de Kotlin, y guías de uso de librerías.

### Evaluación y calificación

**RA y CE evaluados**: Resultados de Aprendizaje 2, 4, 6, 7 y Criterios de Evaluación asociados.

**Conlleva presentación**: SI

**Rúbrica**: Más adelante se enviará o mostrará la rúbrica de esta práctica.

### Entrega

> **La entrega tiene que cumplir las condiciones de entrega para poder ser calificada. En caso de no cumplirlas podría calificarse como no entregada.**
>
- **Conlleva la entrega de URL a repositorio:** El contenido se entregará en un repositorio GitHub. 
- **Respuestas a las preguntas:** Deben contestarse, de manera clara y detallada en este fichero, README.md

    - Al final del documento, incluid un nuevo apartado, que se llame: "Entrega de la Práctica", dónde nos realicéis una pequeña introducción explicativa de vuestro tema, es decir, el problema que vais a solucionar y cómo lo habéis resuelto. Podéis incluir los subapartados que consideréis necesarios (estructura de carpetas, explicación y organización de clases, instrucciones de instalación, manual de usuario, ejemplos de funcionamiento, etc.)

    - **MUY IMPORTANTE!!** Incluir un subapartado ("Respuestas a las preguntas planteadas") dónde se resuelvan las preguntas de evaluación que os realizamos a continuación. De forma clara y detallada, incluyendo enlaces al código que justifica vuestra respuesta si es necesario.

# Preguntas para la Evaluación

Este conjunto de preguntas está diseñado para ayudarte a reflexionar sobre cómo has aplicado los criterios de evaluación en tu proyecto. Al responderlas, [**asegúrate de hacer referencia y enlazar al código relevante**](https://docs.github.com/es/get-started/writing-on-github/working-with-advanced-formatting/creating-a-permanent-link-to-a-code-snippet) en tu `README.md`, facilitando así la evaluación de tu trabajo.
* * * * *
## **Criterio global 1: Instancia objetos y hacer uso de ellos**
- **(2.a, 2.b, 2.c, 2.d, 2.f, 2.h, 4.e, 4.f)**: Describe cómo has instanciado y utilizado objetos en tu proyecto. ¿Cómo has aplicado los constructores y pasado parámetros a los métodos? Proporciona ejemplos específicos de tu código.
  
En el proyecto se crean objetos para representar las reservas de la agencia de viajes. Estas reservas se instancian utilizando métodos que reciben parámetros con la información necesaria.

Por ejemplo, para crear una reserva de vuelo se utiliza el método `creaInstancia`  de la clase `ReservaVuelo`:

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/c697ef048ad4718fdffe000444dae4d1b1f6e95d/src/main/kotlin/servicio/ReservaService.kt#L20

Después de crear el objeto, se almacena en el repositorio mediante el método `agregar`:

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/c697ef048ad4718fdffe000444dae4d1b1f6e95d/src/main/kotlin/servicio/ReservaService.kt#L22

También se crean objetos al iniciar la aplicación, como el repositorio y el servicio:

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/c697ef048ad4718fdffe000444dae4d1b1f6e95d/src/main/kotlin/presentacion/Main.kt#L82-L83

Estos objetos permiten gestionar la creación y almacenamiento de las reservas.

* * * * *

## **Criterio global 2: Crear y llamar métodos estáticos**
- **(4.h)**: ¿Has definido algún método/propiedad estático en tu proyecto? ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?
- **(2.e)**: ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?

En Kotlin los métodos estáticos se implementan mediante `companion object`.

En mi proyecto se utilizan en las clases `ReservaVuelo`  y `ReservaHotel`  para crear nuevas reservas mediante el método `creaInstancia`.

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/c697ef048ad4718fdffe000444dae4d1b1f6e95d/src/main/kotlin/dominio/ReservaHotel.kt#L29-L42

El objetivo de este método es controlar la creación de objetos y validar los datos antes de generar la reserva.

Este método se llama desde la clase `ReservaService`:

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/c697ef048ad4718fdffe000444dae4d1b1f6e95d/src/main/kotlin/servicio/ReservaService.kt#L20

Se decidió hacerlo estático porque no es necesario tener una instancia previa para poder crear una nueva reserva.

* * * * *

## **Criterio global 3: Uso de entornos**
- **(2.i)**: ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? Describe el proceso de creación, compilación, y prueba de tu programa.

Para el desarrollo del proyecto utilicé un IDE como IntelliJ IDEA.

Primero creé el proyecto en Kotlin y después organicé el código en diferentes paquetes (`dominio`, `datos`, `servicios`  y `presentacion`) para separar las capas de la aplicación.

El IDE me permitió escribir el código con ayuda del autocompletado, detectar errores y ejecutar el programa para probar su funcionamiento. Las pruebas se realizaron utilizando el menú de consola para crear y listar reservas.

* * * * *

## **Criterio global 4: Definir clases y su contenido**
- **(4.a, 4.b, 4.c, 4.d, 4.g)**: Explica sobre un ejemplo de tu código, cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, métodos y constructores y modificadores del control de acceso a métodos y propiedades, para representar al objeto del mundo real. ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda?

En el proyecto se definieron varias clases que representan los objetos del sistema de reservas.

La clase abstracta `Reserva`  contiene las propiedades comunes de todas las reservas, como el `id`, la `fechaCreacion`  y la `descripcion`.

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/c697ef048ad4718fdffe000444dae4d1b1f6e95d/src/main/kotlin/dominio/Reserva.kt#L13-L21

A partir de esta clase se crean otras clases más específicas como `ReservaVuelo`  y `ReservaHotel`, que añaden propiedades propias como el origen y destino del vuelo o la ubicación del hotel.

Estas clases permiten representar los diferentes tipos de reservas que puede gestionar la aplicación.

* * * * *

## **Criterio global 5: Herencia y uso de clases abstractas e interfaces**
- **(4.g, 7.a, 7.b, 7.c, 7.i, 7.j)**: Describe sobre tu código cómo has implementado la herencia y/o utilizado interfaces en tu proyecto. ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? Mostrando tu código, contesta qué principios has utilizado y qué beneficio has obtenido.

En el proyecto se utiliza herencia mediante la clase abstracta `Reserva`. Las clases `ReservaVuelo`  y `ReservaHotel`  heredan de esta clase y reutilizan sus propiedades comunes.

También se utiliza una interfaz llamada `IReservaRepository`  que define los métodos para guardar y obtener reservas.

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/f347c31aa3d980cad07d117907684353fceabb05/src/main/kotlin/datos/IReservaRepository.kt#L10-L15

La clase `ReservaService`  depende de esta interfaz en lugar de depender de una implementación concreta, aplicando el principio **DIP**  de SOLID.

Esto hace que el diseño sea más flexible y fácil de modificar.

* * * * *

## **Criterio global 6: Diseño de jerarquía de clases**
- **(7.d, 7.e, 7.f, 7.g)**: Presenta la jerarquía de clases que diseñaste. ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción?

La jerarquía de clases del proyecto es la siguiente:

    Reserva
    │
    ├─ ReservaVuelo
    └─ ReservaHotel

`Reserva`  es la clase base y las otras dos clases son especializaciones de esta.

Se realizaron pruebas ejecutando el programa y creando diferentes reservas desde el menú de consola para comprobar que la jerarquía funcionaba correctamente.

El tipo de herencia utilizado es **especialización**, ya que cada clase representa un tipo específico de reserva.

* * * * *

## **Criterio global 7: Librerías de clases**
- **(2.g, 4.i)**: Describe cualquier librería externa que hayas incorporado en tu proyecto. Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto.

En el proyecto se utilizan algunas librerías estándar de Java y Kotlin.

Por ejemplo:

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/f347c31aa3d980cad07d117907684353fceabb05/src/main/kotlin/dominio/Reserva.kt#L3
  
Esta librería se utiliza para registrar la fecha de creación de cada reserva:

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/f347c31aa3d980cad07d117907684353fceabb05/src/main/kotlin/dominio/Reserva.kt#L17

También se utiliza:

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/f347c31aa3d980cad07d117907684353fceabb05/src/main/kotlin/dominio/Reserva.kt#L4

para generar identificadores únicos para cada reserva.

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/f347c31aa3d980cad07d117907684353fceabb05/src/main/kotlin/dominio/Reserva.kt#L15

Estas librerías permiten añadir funcionalidades útiles sin tener que programarlas manualmente.

* * * * *

## **Criterio global 8: Documentado**
- **(7.h)**: Muestra ejemplos de cómo has documentado y comentado tu código. ¿Que herramientas has utilizado? ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código?

El proyecto se ha documentado utilizando **comentarios KDoc**  en cada clase y función principal, además de nombres descriptivos y organización por paquetes.

-   Cada clase (`Reserva`, `ReservaVuelo`, `ReservaHotel`, `ReservaService`, `IReservaRepository`, `ReservaRepositoryMemoria`) tiene un comentario que explica su **propósito**  y las **propiedades o métodos clave**.

-   `Main.kt`  también está documentado para explicar que es el **punto de entrada**, el **menú de consola**, y las funciones que crean o listan reservas.

-   Los comentarios se han mantenido **resumidos**  para no sobrecargar el código, pero permiten entender **qué hace cada parte y cómo interactúan las clases**.

-   Además, se ha usado **estructura de paquetes y nombres claros**  como otra forma de documentación implícita, facilitando la comprensión y mantenimiento del proyecto.
* * * * *

## **Criterio global 9: Genéricos**
- **(6.f)**: Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. ¿Qué beneficio has obtenido?

En este proyecto **no se ha implementado un repositorio genérico real**, sino que se ha utilizado un repositorio concreto (`ReservaRepositoryMemoria`) que solo almacena objetos de tipo `Reserva`.

Sin embargo, se puede explicar cómo se aplicaría un **genérico**  en este contexto:

Si quisiéramos aplicar genéricos en el proyecto, podríamos crear un repositorio genérico que acepte cualquier tipo `T`, en lugar de depender de un tipo concreto como `Reserva`. Por ejemplo, se podría definir una clase:

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/8c8cfd72bd040f5075ea06c299189ab34d7bede0/src/main/kotlin/datos/RepositorioGenerico.kt#L3-L7

 Esto permitiría almacenar cualquier tipo de objeto (por ejemplo `ReservaVuelo`, `ReservaHotel`  o cualquier otro tipo) sin duplicar código.

El beneficio de usar genéricos es **flexibilidad y reutilización de código**, ya que se podría crear un repositorio único que funcione para distintos tipos de datos sin cambiar la lógica.

En mi proyecto no se ha usado directamente porque el enunciado solo pedía manejar reservas, pero el concepto de genéricos queda claro y podría aplicarse fácilmente en futuros desarrollos.

* * * * *

## **Criterio global 10: Expresiones Regulares**
- **(6.g)**: Muestra ejemplos de tu código donde hayas utilizado las expresiones regulares. ¿Qué beneficio has obtenido?

En el proyecto se utilizan expresiones regulares para validar el formato de la hora de vuelo.

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/8c8cfd72bd040f5075ea06c299189ab34d7bede0/src/main/kotlin/dominio/ReservaVuelo.kt#L34

Esta expresión comprueba que la hora tenga el formato **HH:mm**.

Después se valida utilizando:

  https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ccarjim2909/blob/8c8cfd72bd040f5075ea06c299189ab34d7bede0/src/main/kotlin/dominio/ReservaVuelo.kt#L36-L38

El beneficio es que se asegura que el usuario introduce una hora válida antes de crear la reserva.

