package com.tarea01u2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    private Timeline timeline;
    private ArrayList<Image> imagenesInfantil;
    private ArrayList<Image> imagenesRomantico;
    private ArrayList<Image> imagenesTerror;
    private String seleccionada;

    @FXML
    private Button infantil;

    @FXML
    private Button romantico;

    @FXML
    private Button terror;

    @FXML
    private Button reiniciar;

    @FXML
    private Button salir;

    @FXML
    private ImageView imagen;

    @FXML
    protected void onbotonSalir(ActionEvent evento){
       System.exit(0);
    }

    @FXML
    protected void onbotonReiniciar(ActionEvent evento){
        System.out.println(evento.getSource());
        Button b=(Button) evento.getSource();
        Scene escena = b.getScene();
        escena.getStylesheets().clear();
        imagen.setImage(null);
        timeline.stop();
    }

    @FXML
    protected void asignarEstilo(ActionEvent evento){
        String rutaCSS;
        Scene escena;
        System.out.println(evento.getSource());
        Button b=(Button) evento.getSource();
        seleccionada = b.getId();
        timeline.stop(); //para que pare la animación
        switch (seleccionada){
            case "infantil":
                rutaCSS = getClass().getResource("css/styleInf.css").toExternalForm();
                escena = b.getScene();
                escena.getStylesheets().clear();
                escena.getStylesheets().add(rutaCSS);
                imagen.setImage(imagenesInfantil.get(0));
                timeline.play(); //inicia la animación
                break;
            case "romantico":
                rutaCSS = getClass().getResource("css/styleRom.css").toExternalForm();
                escena = b.getScene();
                escena.getStylesheets().clear();
                escena.getStylesheets().add(rutaCSS);
                imagen.setImage(imagenesRomantico.get(0));
                timeline.play(); //inicia la animación
                break;
            case "terror":
                rutaCSS = getClass().getResource("css/styleTer.css").toExternalForm();
                escena = b.getScene();
                escena.getStylesheets().clear();
                escena.getStylesheets().add(rutaCSS);
                imagen.setImage(imagenesTerror.get(0));
                timeline.play(); //inicia la animación
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline = new Timeline(new KeyFrame(Duration.seconds(5), event->cambiarImagen()));
        timeline.setCycleCount(2);//para que lo haga una vez cada cambio de imagen
        imagenesInfantil = new ArrayList<>();
        imagenesRomantico = new ArrayList<>();
        imagenesTerror = new ArrayList<>();
        String[] rutas1= {"img/infantil1.PNG","img/infantil2.PNG","img/infantil3.PNG"};
        String[] rutas2= {"img/romantica1.PNG","img/romantica2.PNG","img/romantica3.PNG"};
        String[] rutas3= {"img/terror1.PNG","img/terror2.PNG","img/terror3.PNG"};
        cargarImagenes(rutas1,imagenesInfantil);
        cargarImagenes(rutas2,imagenesRomantico);
        cargarImagenes(rutas3,imagenesTerror);
    }

    private void cargarImagenes(String[] rutas, ArrayList<Image> imagenes) {
        String rutaFormateada;
        for (int i = 0; i < rutas.length; i++) {
            rutaFormateada=getClass().getResource(rutas[i]).toExternalForm();
            imagenes.add(new Image(rutaFormateada));
        }
    }

    private void cambiarImagen() {
        System.out.println("Cambiando imagen");
        ArrayList<Image> seleccion = new ArrayList<>();
        switch (seleccionada) {
            case "infantil":
                seleccion = imagenesInfantil;
                break;
            case "romantico":
                seleccion = imagenesRomantico;
                break;
            case "terror":
                seleccion = imagenesTerror;
                break;
        }
        int actual = seleccion.indexOf(imagen.getImage());
        imagen.setImage(seleccion.get(actual+1));
    }
}
