# JAVA HELP

En el caso de aplicaciones Java, para generar ficheros de ayuda se utiliza JavaHelp. Cuando activamos el sistema JavaHelp en nuestra aplicación, lo primero que se hace es leer el archivo de ayuda especificado para esa aplicación. El fichero de ayuda define la ayuda para esa aplicación. 

Generalmente, un fichero de ayuda incluye la siguiente **información**:

- **Mapa del fichero**. El mapa del fichero se utiliza para asociar los "Identificadores de tema" con el nombre de la URL o rute de tema HTML en el fichero de ayuda.
- **Vista de Información**. Presenta la información descrita en los navegadores de fichero de ayuda. El estándar que se utiliza es: tabla de contenidos, índice y búsqueda de texto completo. Algunos navegadores presentan un glosario y favoritos.
- **Título del fichero de ayuda**. Este título aparece en la barra de título de la ventana del fichero de ayuda y en las ventanas secundarias del fichero de ayuda.
- **Identificar de inicio (Home ID)**. El nombre del identificador por defecto que se mostrará cuando el visor de ayuda sea invocado sin especificar un ID.
- **Presentación**. Son las ventanas en las que se muestran los temas de ayuda.
- **Sub-Ficheros de ayuda**. Los ficheros de ayuda pueden estar formados por ficheros más pequeños.
- I**mplementación**. Esta sección es opcional y crea un registro que proporciona datos clave para definir la asignación de la clase ``HelpBroker`` para usar el método ``HelpSet.createHelpBroker``. 

## Ficheros JavaHelp
Los ficheros de ayuda JavaHelp son ficheros de ayuda en línea que se implementan para aplicaciones Java, para ello se utiliza el sistema JavaHelp. 

JavaHelp hace referencia tanto al sistema de creación de ayuda como al formato del fichero de ayuda en línea. Los ficheros de ayuda JavaHelp se pueden visualizar en el navegador JavaHelp. 

Los ficheros de ayuda JavaHelp están escritos en el lenguaje Java, y básicamente es utilizado por aplicaciones Java. El formato del fichero está basado en XML (Acrónimo de eXtensible Markup Language ("lenguaje de marcas extensible"), es un metalenguaje de etiquetas que permite definir la gramática de lenguajes específicos).

Para la **creación de un sistema de ayuda**, hay que realizar los siguientes pasos:

1-. **Creación de los temas de ayuda**. Lo primero que se debe definir, son los temas de ayuda para el usuario. Los temas de ayuda se denominan topics, y es necesario crear en este paso los "topics" HTML, que nos van a servir para organizar los contenidos de la ayuda.

2-. **Creación de los ficheros metadatos JavaHelp**. El sistema de ayuda JavaHelp, necesita la creación de un conjunto de ficheros, que permite organizar la información, y la navegación y búsqueda, dentro del sistema de ayuda. 

Estos **ficheros** son:

- Fichero map.
- Fichero HelpSet. Este fichero, junto con el fichero map y los topics HTML, son imprescindibles para crear el sistema de ayuda.
- Fichero de tabla de contenidos.
- Fichero índice.
- Fichero con la base de datos de búsqueda.

## Fichero HelpSet (ayuda.hs)

En este fichero se fusionan y configuran todos los ficheros que forman la ayuda. Es el único fichero, del fichero de ayuda, que se referencia por la aplicación. Al igual que el fichero map, su sintaxis está basada en XML y tiene la extensión "``hs``". Este fichero va a contener toda la información necesaria, para que se pueda ejecutar el sistema de ayuda.

Este fichero, contiene información acerca del fichero map que se utiliza para relacionar las páginas HTML de la ayuda con sus identificadores. El helpset también contiene información sobre los navegadores que se emplean en el HelpSet, es decir, la tabla de contenidos, índice y búsqueda.

El fichero helpset, tiene un "**tag**" especial, que es ``<Home ID>``, que sirve para identificar la página que se mostrará, cuando se solicite la ayuda sin especificar ningún identificador concreto.

Ejemplo del contenido de un fichero helpset:

```xml
<?xml version="1.0" encoding='ISO-8859-1'?>
<!DOCTYPE helpset PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 1.0//EN" "http://java.sun.com/products/javahelp/helpset_1_0.dtd">


<helpset version="1.0">
  <title>Tarea JavaHelp</title>
  <maps>
    <!-- Pagina por defecto al mostrar la ayuda -->
    <homeID>ventana_inicio</homeID>
    <!-- Que mapa deseamos -->
    <mapref location="map.jhm" />
  </maps>

  <!-- Las Vistas que deseamos mostrar en la ayuda -->
  <view>
    <name>Tabla Contenidos</name>
    <label>Tabla de contenidos</label>
    <type>javax.help.TOCView</type>
    <data>toc.xml</data>
  </view>

  <view>
    <name>Indice</name>
    <label>El indice</label>
    <type>javax.help.IndexView</type>
    <data>indice.xml</data>
  </view>

  <view>
    <name>Buscar</name>
    <label>Buscar</label>
    <type>javax.help.SearchView</type>
    <data engine="com.sun.java.help.search.DefaultSearchEngine">
      JavaHelpSearch
    </data>
  </view>

</helpset>
```

## Fichero Índice (indice.xml)
Utiliza sintaxis XML. Sirve para describir la distribución y contenido que va a tener nuestro sistema de ayuda.

Ejemplo del contenido de un fichero indice:
```xml
<?xml version='1.0' encoding='ISO-8859-1'  ?>
<!DOCTYPE index
  PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp Index Version 1.0//EN"
         "http://java.sun.com/products/javahelp/index_1_0.dtd">
<index version="1.0">
        <indexitem text="Ventana inicio"    target="ventana_inicio"/>
        <indexitem text="Ventana participantes"    target="ventana_primaria"/>
        <indexitem text="Ventana grupos"    target="ventana_secundaria"/>
        <indexitem text="Ventana lugares"    target="ventana_terciaria"/>
</index>
```

## Fichero Map (map.jhm)

El fichero map, tiene la extensión ``jhm`` (JavaHelp Map) y sirve para asociar todos los ficheros HTML, imágenes, etc. con un identificador. La sintaxis de este fichero se basa en XML.

Ejemplo del contenido de un fichero map: 
```xml
<?xml version='1.0' encoding='ISO-8859-1'?>
<!DOCTYPE map
PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp Map Version 2.0//EN"
"http://java.sun.com/products/javahelp/map_2_0.dtd">
<map version="1.0">
   <mapID target="ventana_inicio" url="paginas/ayuda_inicio.html" />
   <mapID target="ventana_primaria" url="paginas/ayuda_participantes.html" />
   <mapID target="ventana_secundaria" url="paginas/ayuda_grupos.html" />
   <mapID target="ventana_terciaria" url="paginas/ayuda_lugares.html" />
</map>
```

## Fichero Tabla de contenidos (toc.xml)

El fichero TOC (Table of Contents), sirve para describir el contenido de la ayuda y su distribución en la tabla de contenidos. Como los demás ficheros de configuración de JavaHelp, su sintaxis se encuentra basada en XML. 

Ejemplo del contenido de un fichero TOC:
```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<toc version="1.0"> <!--  categoryclosedimage="FolderClosed" categoryopenimage="FolderOpened"  
topicimage="ItemIco"-->
    <tocitem text="Ventana inicio"    target="ventana_inicio">
        <tocitem text="Ventana participantes"    target="ventana_primaria"/>
        <tocitem text="Ventana grupos"    target="ventana_secundaria"/>
        <tocitem text="Ventana lugares"    target="ventana_terciaria"/>
    </tocitem>
</toc>
``` 
## Añadir ayuda a las aplicaciones Java

Para poder incorporar la ayuda implementada en JavaHelp, es necesario añadir al proyecto un conjunto de librerías y de paquetes.

Utilizaremos la clase ``HelpSet`` que nos permite utilizar desde una aplicación Java, todos los ficheros y datos que constituyen el sistema de ayuda, como puede ser el fichero helpset, la tabla de contenidos, el índice, etc. 

Dentro de esta clase, vamos a necesitar los métodos ``findHelpSet``, que localiza el fichero helpset y devuelve su URL y el método ``createHelpBroker``, que nos permite crear un objeto HelpBroker.

Para poder utilizar esta clase, será necesario importar a nuestro proyecto el paquete javax.help a través de la instrucción:

```java
import javax.help.*
```

También será necesario utilizar la clase ``HelpBroker``. Se encarga de visualizar el contenido de la ayuda en la aplicación. Para ello, incorpora una serie de métodos que facilitan la incorporación de ayuda en la aplicación. Al igual que la clase HelpSet, forma parte del paquete javax.help.

Dentro de esta clase destacan los ``métodos``:

- ``enableHelpKey``: que habilita la tecla de ayuda sobre un componente.
- ``enableHelpOnButton``: que permite que se despliegue la ayuda cuando se presiona un botón o un determinado elemento del menú.
- ``enableHelp``: que nos indica el tema de ayuda a mostrar, cuando se pulsa la tecla de ayuda sobre un determinado componente.

## Método ponLaAyuda()
```java
/**
 * Hace que el item del menu y la pulsacion de F1 visualicen la ayuda.
 */
private void ponLaAyuda() {
    try {
        // Cargamos el fichero de ayuda desde el classpath (dentro del JAR)
        ClassLoader cl = this.getClass().getClassLoader();
        URL hsURL = HelpSet.findHelpSet(cl, "ayuda/ayuda.hs"); //localizamos el fichero helpset

        HelpSet helpset = new HelpSet(cl, hsURL); //creamos un objeto helpset
        HelpBroker hb = helpset.createHelpBroker(); //creamos objeto helpbroker

        // Asociamos la ayuda del item al botón al pulsarlo y a F1 en ventana_inicio.
        hb.enableHelpOnButton(btnAxuda, "ventana_inicio", helpset);
        hb.enableHelpKey(getContentPane(), "ventana_inicio",
                helpset); //Hacemos que el componente responda a la pulsación de la tecla de ayuda F1.

    } catch (Exception e) {
        e.printStackTrace();
    }
}
```