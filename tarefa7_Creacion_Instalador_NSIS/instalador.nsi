;Utilizamos Modern UI, unha librería
!include "MUI2.nsh"

;Estrutura xeral
Name "Instalador de Ponte a Conducir" ;Título do instalador
Outfile "InstaladorPonteConducir.exe"
Unicode True
;Directorio por defecto de instalación
InstallDir "$PROGRAMFILES\ponteconducir" ; carpeta onde se instalará a aplicación

; Privilexios para o instalador (administrador)
RequestExecutionLevel admin
!define MUI_ABORTWARNING

;Definimos as páxinas o xanelas
!insertmacro MUI_PAGE_COMPONENTS
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_INSTFILES
!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES

;Configuramos o idioma
!insertmacro MUI_LANGUAGE "Spanish"

;Páxina de benvida, directorio de instalación e progreso
;Page directory
;Page instfiles

;Definimos o componente a instalar
Section "Instalar" SecDummy

  ;Creamos o directorio de instalación
  SetOutPath "$INSTDIR"

  ;Copiamos o archivo JAR
  File "pruebaJavaHelp.jar"   ; Ruta ao .jar xerado por Ant

  ;Creamos a carpeta lib no directorio de instalación
  SetOutPath "$INSTDIR\lib"

  ;Copiamos o contido de lib
  File "lib\javahelp-2.0.02.jar"

  ;Creamos o desinstalador
  WriteUninstaller "$INSTDIR\Uninstall.exe" ;Definimos a opción de desinstalar 

SectionEnd

;Descripcións que aparecen co compoñente
LangString DESC_SecDummy ${LANG_SPANISH} "Instalación do ficheiro Ponte a Conducir"
!insertmacro MUI_FUNCTION_DESCRIPTION_BEGIN
    !insertmacro MUI_DESCRIPTION_TEXT ${SecDummy} $(DESC_SecDummy)
!insertmacro MUI_FUNCTION_DESCRIPTION_END

;Definimos a sección para desinstalador
Section "Uninstall"
  Delete "$INSTDIR\pruebaJavaHelp.jar"
  Delete "$INSTDIR\lib\javahelp-2.0.02.jar"
  Delete "$INSTDIR\Uninstall.exe"
  RMDir "$INSTDIR\lib"
  RMDir "$INSTDIR"
SectionEnd
