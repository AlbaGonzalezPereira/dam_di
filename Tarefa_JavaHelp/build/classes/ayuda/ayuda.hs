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