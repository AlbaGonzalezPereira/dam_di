package com.example.practica3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
//    @FXML
//    private Label welcomeText;

    // creamos las variables para establecer el formato de la moneda local
    private static final NumberFormat moneda = NumberFormat.getCurrencyInstance();
    //establecemos el formato del % de descuento
    private static final NumberFormat descuento = NumberFormat.getPercentInstance();
    //declaramos el descuento cliente y el porcentaje IVA
    private BigDecimal dtoCliente = new BigDecimal(0.10);
    private BigDecimal porcIva = new BigDecimal(0.21);
    @FXML
    private Label labelDto;

    @FXML
    private TextField campoCantidad;

    @FXML
    private TextField campoPrecio;

    @FXML
    private TextField campoIva;

    @FXML
    private Slider campoDto;

    @FXML
    private TextField campoTotal;

    @FXML
    private VBox panelPrincipal;

    @FXML
    private GridPane contenido;

    @FXML
    private Button botonCalcular;

    @FXML
    private Button botonActivarCss;

    @FXML
    private Button botonDesactivarCss;

    @FXML
    protected void onCalcular(ActionEvent event) {
        //System.out.println("probando");
        try {
            BigDecimal cantidad = new BigDecimal(campoCantidad.getText());
            BigDecimal precio = new BigDecimal(campoPrecio.getText());
            BigDecimal importe = cantidad.multiply(precio);
            BigDecimal dto = importe.multiply(dtoCliente);

            //System.out.println(campoIva);
            //System.out.println(campoDto.getValue());
            BigDecimal iva = importe.multiply(porcIva);
            BigDecimal total = (importe.subtract(dto)).add(iva);
            campoTotal.setText(moneda.format(total));
        } catch (NumberFormatException e){
            System.out.println("Debe introducir una cantidad correcta");
        }
        campoCantidad.selectAll(); //selecciona todo el texto
        campoCantidad.requestFocus(); //establece el foco en el campo cantidad

    }

    /**
     * evento que limpia los css del panel
     * @param event
     */
    protected void eliminarCss(ActionEvent event){
        Scene escena = this.panelPrincipal.getScene();
        escena.getStylesheets().clear(); // limpiamos los css
    }

    /**
     * evento que añade estilos al panel
     * @param event
     */
    protected void ponerCss(ActionEvent event){}


    /**
     * para modificar el slider de descuento
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //se pone en escucha el slider (barra de descuento)
        moneda.setRoundingMode(RoundingMode.HALF_UP); //Redondea a un dígito
        campoDto.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number valorAntiguo, Number valorNuevo) {
                dtoCliente = BigDecimal.valueOf(valorNuevo.intValue()/100.0);//para que te de un long
                labelDto.setText(descuento.format(dtoCliente) + " Dto");//formateamos el descuento
            }
        });
    }
}