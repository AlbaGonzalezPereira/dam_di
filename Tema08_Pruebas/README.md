# REALIZACIÓN DE PRUEBAS
La realización de pruebas de software consume tiempo y recursos, pero es fundamental para que los fallos de la aplicación sean mínimos.

Para asegurar la **calidad**, debemos hacer uso de las **pruebas de software**.

Calidad no es sólo que el software funcione bien y que vaya rápido, sino que además implica que satisfaga las expectativas de los clientes, usabilidad, confiabilidad, coste, eficiencia y cumplimiento de los estándares.

Asegurar los requisitos de calidad de software lleva un coste y trabajo asociado.

La ausencia o la mala gestión de una estrategia de pruebas en un proyecto software pueden suponer:

- Falta de satisfacción de los clientes.
- Fallos en la explotación por defectos no detectados y eliminados a tiempo.
- Altos costes finales, por el tiempo empleado en corregir defectos.

Descubrir un error se considera el **éxito** de una prueba.

En definitiva, buscamos reducir los **riesgos por la aparición de defectos** en los procesos de implantación y explotación de las aplicaciones. Todo ello mediante la **detección temprana de problemas y errores**. Con todo esto se pretende desarrollar un nivel de confianza sobre la disponibilidad (en tiempo) y la fiabilidad (a lo largo del tiempo) de los productos desarrollados, acorde a las expectativas del cliente.

Las **pruebas** deben entenderse como:

- **Verificación**: El producto que se está construyendo funciona correctamente; es decir, es capaz de realizar la tarea para la cual ha sido diseñado.
- **Validación**: El producto terminado, además de ser correcto, es conforme con lo que el cliente había esperado.


Cuanto más tarde es encontrado un defecto más cuesta (en tiempo, recursos y dinero) su corrección. Por tanto, la **estrategia de pruebas** contribuye al ahorro de coste del proyecto.

**Los defectos se introducen, en su mayoría, durante la fase de análisis de requisitos y diseño, pero suelen ser detectadas durante las pruebas de aceptación y en la explotación (que son las fases donde resulta más costosa económicamente su reparación)**.

## Tipos de pruebas

Los **tipos de pruebas al software** se pueden clasificar en:

- **Pruebas unitarias**: se realizan a módulos o clases del programa, por separado. Es decir, a cada unidad que compone la aplicación. Para hacerlas, debemos de tener en cuenta:

  - La interfaz del módulo o componente.
  - El impacto de datos globales sobre el módulo.
  - Las estructuras de datos en el módulo.
  - Las condiciones límite.
  - Los distintos caminos de ejecución de las estructuras de control.

- **Pruebas de integración**: integran componentes y módulos del programa según un orden preestablecido. Se prueba el funcionamiento de la interrelación de todos los módulos.La prueba de integración verifica la interacción entre componentes del sistema.

Dependiendo de la filosofía de integración, se definen dos técnicas: **ascendentes** y **descendentes**.

- **Pruebas de sistema**: validan que la aplicación tenga la funcionalidad que el usuario final espera de ella. Las pruebas de sistema se ven como una "caja negra".

Las pruebas de sistema verifican el comportamiento del sistema en su conjunto. En concreto, se comprueban los requisitos no funcionales de la aplicación:

  - Seguridad.
  - Velocidad.
  - Exactitud.
  - Fiabilidad.

También se prueban los interfaces externos con otros sistemas, utilidades, unidades físicas y el entorno operativo.

Entre las pruebas de sistema más relevantes, encontramos las de ***Configuración*** y ***Recuperación***.

- **Pruebas de regresión**: después de realizar algún tipo de modificación en el código del programa, consisten en volver a ejecutar un conjunto de pruebas que se han llevado a cabo anteriormente para asegurarse de que los cambios no han propagado efectos colaterales no deseados.

- **Pruebas funcionales**: su objetivo es detectar errores en la implementación de los requerimientos. 

Son pruebas de **caja negra** y las personas encargadas de realizar las pruebas, no les importa cómo se generan las respuestas, sólo analizan las salidas de la aplicación frente a sus entradas.

Las pruebas funcionales intentan responder a las preguntas: "*¿funciona esta utilidad de la aplicación?*", "*¿el usuario podrá hacer esto?*".


- **Pruebas de capacidad y rendimiento**. 
  - La prueba de ***capacidad*** (también conocida como *prueba de resistencia o stress*) ejecuta un sistema de forma que demande recursos en cantidad, frecuencia o volúmenes anormales. Tiene como finalidad determinar la capacidad del programa para soportar entradas incorrectas. 
  - La de ***rendimiento*** determina los tiempos de respuesta (lo rápido que realiza una tarea un sistema en condiciones de trabajo), el espacio que ocupan los módulos en disco y en memoria, el flujo de datos que se genera, etc.

- **Pruebas de uso de recursos**: también conocidas como ***pruebas de eficiencia***, se encargan de optimizar el uso de los recursos software y hardware de una aplicación. Se desarrolla un conjunto de técnicas que garantice un uso eficiente de los recursos.

- **Pruebas de seguridad**: la prueba de seguridad intenta verificar que los mecanismos de protección incorporados en nuestro sistema lo protegen de accesos no autorizados. Es decir, determinan los niveles de permiso de usuarios, las operaciones de acceso al sistema y acceso a los datos.

En concreto, se intenta verificar que el **sistema es robusto** frente a problemas de seguridad, tales como:

  - Intentar conseguir las claves de acceso de cualquier forma.
  - Atacar con software a medida.
  - Bloquear el sistema.
  - Provocar errores del sistema, entrando durante su recuperación.

- **Pruebas de usuario**: este tipo de prueba (también conocida como de usabilidad) se refiere a asegurar que la interfaz de usuario (GUI) sea amigable, intuitiva y que funcione correctamente.

Podemos evaluar la usabilidad de una aplicación midiendo la manera en que el usuario realiza una tarea concreta, el tiempo y **número de clics** que supone acabarla y los errores que comete durante el proceso.


- **Pruebas de aceptación**: estas pruebas son realizadas por el cliente final. Consisten en pruebas funcionales sobre el sistema completo. Se realizan sobre el producto terminado y nunca durante el desarrollo del sistema o de la aplicación.

Para su ejecución se suelen emplear dos técnicas de aceptación: **alfa** y **beta**:

  - **Pruebas alfa**: Las lleva a cabo el cliente en el lugar donde se ha desarrollado la aplicación y en presencia del desarrollador. El cliente utilizará la aplicación como lo haría en su lugar de trabajo. Se utiliza un entorno controlado con las mismas condiciones que hay en el lugar de trabajo habitual. 

  - **Pruebas beta**: Las lleva a cabo el cliente, pero ya en su lugar de trabajo. A diferencia de las pruebas alfa, el desarrollador ya no está presente durante su realización, por lo que estas pruebas se denominan "en vivo", puesto que no se ejecutan en un entorno controlado. 