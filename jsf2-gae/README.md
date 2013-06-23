jsf2-gae
===============

Aplicativo web de demostración, desarrollado con el framework JavaServer Faces 2 (JSF) que es el framework web MVC estandar de la especificación Java EE. Este projeto fue desarrollado para la plataforma cloud de Google, o App Engine. La capa de persistencia es implementada utilizando Objectify, un framework de persistencia a alto nível para el DataStore de App Engine.

El objetivo de esta aplicación es servir como contenido de estudo de desarrollo de soluciones  web, utilizando una tecnologia productiva, y para la implementación de una nueva.

Ud. puede acceder a la aplicacion en Google App Engine através del url: http://joedayzdemo-jsf2gae.appspot.com/listaMercadorias.jsf

Detalles de la implementación
-----------------------------
Tecnologias utilizadas en la implementación:
* JSF 2: utilizamos el framework JavaServer Faces, siguiendo el modelo arquitetural MVC y el uso de componentes visuales para la construcción de interfaces gráficas (front-end);
* Bootstrap: framework para front-end, define una serie de definiciones CSS y código JavaScript para la creación de layouts en la web, incluyendo tipografica, formularios, tablas, etc.
* Objectify: framework que define un API a alto nível para trabajar con el mecanismo de persistencia de App Engine, el DataStore.
* App Engine: configuraciones necessárias para ejecutar una aplicación en el ambiente cloud de Google;

Pré-requisitos
--------------
* JDK - versión 1.6 de Java, una versión soportada por App Engine;
* Eclipse - recomendamos Eclipse JUNO con el plugin de Google para App Engine, facilitando el trabajo de implementación;
* Plugin de Google para Eclipse - plugin con soporte de implementación para App Engine;
* Versión del SKD de App Engine: 1.7.3;
* JSF: utilizamos una implementación Mojarra versión 2.1, modificado para  ignorar InitialContext (hack de la clase WebConfiguration);
* Objectify: versión 4;

Saber más
---------
http://academias.joedayz.pe
http://campus.joedayz.pe
