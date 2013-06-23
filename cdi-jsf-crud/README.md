cdi-jsf-crud
===============
Aplicativo web demostración, desarrollado con las tecnologias: CDI, JSF, EJB e JPA. El proposito de esta demo es demostrar como la tecnologia Contexts and Dependency Injection (CDI), puede ser uma alternativa interesante de implementación en conjunto con  JSF y EJB. Los datos de la aplicación son persistidos en la base de datos MySQL. El proyecto fue desarrollado con tecnologias soportadas por el Web Profile de la plataforma Java EE.

La aplicación fue implementada en CloudBees, una plataforma de cloud computing (PaaS) para tecnologias de la familia Java.


Detalles de la implementación
-----------------------------
Tecnologias utilizadas en la implementación:

* CDI: tecnologia Java EE, con capacidad de controlar el ciclo de vida y resolver las dependencias entre diferentes objetos Java. Con CDI es posible desarrollar un diseño flexible, favoreciendo la reutilización y un bajo acoplamiento entre los componentes. El provider CDI utilizado es Weld (JBoss);
* Primefaces: extensión de JSF, que provee de una serie de componentes visuales iterativos. Su proposito es acelerar el desarrollo Web, con foco en la calidad y eficiencia en interfaces graficas;
* JSF 2: utilizamos o framework JavaServer Faces, seguindo o modelo arquitetural MVC e o uso de componentes visuais para a construção das interfaces gráficas (front-end);
* EJB 3: una plataforma Java EE que define una serie de componentes para el desarrollo de aplicaciones corporativas especializadas. Con EJBs es posible desarrollar aplicaciones distribuídas; integración/conectividad con sistemas legados; procesamiento assíncrono basado en Colas/ Mensajes; control transaccional; entre otros;
* JPA: API de alto nível, estandar de la tecnologia Java, para definir el mapeo de objetos relacionales (ORM);
* Hibernate: proveedor JPA, responsable por resolver el ORM;
* Bean Validation: mecanismo estandar de Java para determinar reglas de validación, a través, de anotaciones;

Pré-requisitos
--------------
* JDK - versión 1.6 de Java, o uno mas reciente;
* Eclipse - Eclipse JUNO;
* Plugin para Eclipse - JBoss Tools;
* Maven - para build y dependencias.
* Application Server Java EE - JBoss AS 6 o 7 (EAP);
* MySQL - versión 5 o mas reciente;

Saber mas
----------
http://academias.joedayz.pe
http://campus.joedayz.pe
