package com.ventanaemergente.ventanas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VentanaController implements Initializable {

    private static final Integer creditosTotal = 20;
    private Integer creditosSuma = 0;
    @FXML
    public ArrayList<Modulo> modulosAlumno;

    @FXML
    public Alumno alumno;

    @FXML
    private Button botonEmergente;

    @FXML
    private Button botonGuardar;

    @FXML
    private TextField nombre;

    @FXML
    private TextField apellidos;

    @FXML
    private TextField nif;

    @FXML
    private TextField codigoPostal;

    @FXML
    private TextField email;

    @FXML
    private CheckBox programacion;

    @FXML
    private CheckBox desenvolvemento;

    @FXML
    private CheckBox accesoDatos;

    @FXML
    private CheckBox psProcesos;

    @FXML
    private CheckBox baseDatos;

    @FXML
    private CheckBox dispMoviles;


    @FXML
    private void guardar(){
    String nom = nombre.getText().trim();
    String apel = apellidos.getText().trim();
    String dni = nif.getText().trim();
    String cp = codigoPostal.getText().trim();
    String mail = email.getText().trim();
    alumno = new Alumno(nom, apel, dni, cp, mail, modulosAlumno);
    mostrarAlertResultados(alumno.toString());
}
    @FXML
    private void mostrarAlertResultados(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alumno matriculado");
        alerta.setWidth(400);
        alerta.setHeight(400);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    protected void onGuardar(ActionEvent event) throws Exception{
        guardar();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modulosAlumno = new ArrayList<>();
        programacion.setUserData(8);
        desenvolvemento.setUserData(7);
        accesoDatos.setUserData(10);
        psProcesos.setUserData(7);
        baseDatos.setUserData(8);
        dispMoviles.setUserData(5);
    }

    @FXML
    private void onChangeModulos(ActionEvent evento){
        Integer creditos = 0;
        CheckBox casilla = new CheckBox();
        casilla = (CheckBox) evento.getSource();
        Modulo modulo = new Modulo();
        if(casilla.isSelected()){
            switch (casilla.getId()){
                case "psProcesos":
                    creditos = (Integer) psProcesos.getUserData();
                    break;
                case "programacion":
                    creditos = (Integer) programacion.getUserData();
                    break;
                case "desenvolvemento":
                    creditos = (Integer) desenvolvemento.getUserData();
                    break;
                case "accesoDatos":
                    creditos = (Integer) accesoDatos.getUserData();
                    break;
                case "baseDatos":
                    creditos = (Integer) baseDatos.getUserData();
                    break;
                case "dispMoviles":
                    creditos = (Integer) dispMoviles.getUserData();
                    break;
            };

            if(superaCreditos((Integer) creditos)) {
                casilla.setSelected(false);
                mostrarAlertResultados("Superas el número de créditos");
                creditosSuma = creditosSuma - creditos;
            }else{
                modulo.setHoras(creditos);
                modulo.setNombre(casilla.getId());
                modulosAlumno.add(modulo);


            }
        }else{
            switch (casilla.getId()){
                case "psProcesos":
                    creditos = (Integer) psProcesos.getUserData();
                    break;
                case "programacion":
                    creditos = (Integer) programacion.getUserData();
                    break;
                case "desenvolvemento":
                    creditos = (Integer) desenvolvemento.getUserData();
                    break;
                case "accesoDatos":
                    creditos = (Integer) accesoDatos.getUserData();
                    break;
                case "baseDatos":
                    creditos = (Integer) baseDatos.getUserData();
                    break;
                case "dispMoviles":
                    creditos = (Integer) dispMoviles.getUserData();
                    break;
            };
            creditosSuma = creditosSuma - creditos;
            Modulo moduloEliminar = new Modulo(casilla.getId(), creditos);
            modulosAlumno.remove(moduloEliminar);
            modulosAlumno.removeIf(m->m.getNombre().equals(moduloEliminar.getNombre()));

            for (Modulo m: modulosAlumno)
                System.out.println(m.getNombre());
        }
    }
    public boolean superaCreditos(Integer creditos){
        creditosSuma=creditosSuma+creditos;
        if(creditosSuma>creditosTotal)
            return true;
        return false;
    }

//    @FXML
//    protected void onbotonEmergenteClick() throws Exception {
//
//
//            try {
//
//                // Cargo la vista
//                FXMLLoader loader = new FXMLLoader(VentanaApp.class.getResource("ventanaEmergente.fxml"));
//
//                // Cargo la ventana
//                Parent root = loader.load();
//
//                // Creo el Scene
//                Scene scene = new Scene(root);
//                Stage stage = new Stage();
//                stage.setTitle("Error, debe .....!");
//                stage.initModality(Modality.APPLICATION_MODAL);
//                stage.setScene(scene);
//                stage.showAndWait();
//
//            } catch (IOException e) {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setHeaderText(null);
//                alert.setTitle("Error");
//                alert.setContentText(e.getMessage());
//                System.out.println(e.getMessage().toString());
//                alert.showAndWait();
//            }
//
//        }



}