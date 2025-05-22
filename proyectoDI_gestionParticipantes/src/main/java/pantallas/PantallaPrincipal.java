package pantallas;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alba_
 */
public class PantallaPrincipal extends JPanel {

    public PantallaPrincipal() {

        // Establece un layout en columna para organizar los JLabel
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Define el ancho máximo permitido para los JLabel
        int maxAncho = 500;
        JPanel panelPantalla = new JPanel();
        panelPantalla.setBackground(Color.WHITE);
        panelPantalla.setLayout(new BoxLayout(panelPantalla, BoxLayout.Y_AXIS));
        JLabel titulo = new JLabel("Promoviendo la Seguridad Vial");
        titulo.setPreferredSize(new Dimension(430, 120)); // (x, y, ancho, alto)       
        JLabel tituloInf = new JLabel("Infantil");
        tituloInf.setPreferredSize(new Dimension(150, 120)); // (x, y, ancho, alto)
        JLabel parrafo1 = new JLabel("<html><body style='width: " + maxAncho + "px; padding-bottom: 10px; text-align: center;'>"
                + "Un compromiso firme con la adquisición de hábitos y comportamientos adecuados para usar vías como peatones, pasajeros, ciclistas o futuros conductores."
                + "</body></html>");
        JLabel parrafo2 = new JLabel("<html><body style='width: " + maxAncho + "px; padding: 10px; text-align: center;'>"
                + "Trabajamos para sensibilizar, educar en valores como el respeto y la responsabilidad con el fin de prevenir accidentes en nuestras vías."
                + "</body></html>");
        JLabel parrafo3 = new JLabel("<html><body style='width: " + maxAncho + "px; padding-top: 20px; text-align: center;'>"
                + "Conocer las normas y señales puede salvar vidas"
                + "</body></html>");

        /*
        JLabel titulo = new JLabel("Promoviendo la Seguridad Vial");
        JLabel tituloInf = new JLabel("Infantil");
        JLabel parrafo1 = new JLabel("Un compromiso firme con la adquisición de hábitos y comportamientos adecuados para usar vías como peatones, pasajeros, ciclistas o futuros conductores.");
        JLabel parrafo2 = new JLabel("Trabajamos para sensibilizar, educar en valores como el respeto y la responsabiliad con el fin de prevenir accidentes en nuestras vías.");
        JLabel parrafo3 = new JLabel("Conocer las normas y señales puede salvar vidas");
         */
        //estilos:
        tituloInf.setForeground(new java.awt.Color(69, 123, 157));
        titulo.setFont(new java.awt.Font("Reem Kufi", 1, 30));
        tituloInf.setFont(new java.awt.Font("Reem Kufi", 1, 30));
        parrafo1.setSize(700, 100);
        parrafo1.setFont(new java.awt.Font("Reem Kufi", 1, 20));
        parrafo2.setFont(new java.awt.Font("Reem Kufi", 1, 20));
        parrafo3.setFont(new java.awt.Font("Reem Kufi", 1, 24));
        parrafo1.setForeground(new java.awt.Color(102, 102, 102));
        parrafo2.setForeground(new java.awt.Color(102, 102, 102));
        parrafo3.setForeground(new java.awt.Color(230, 57, 70));
        this.setBackground(Color.WHITE);

        panelPantalla.add(parrafo1);
        panelPantalla.add(parrafo2);
        panelPantalla.add(parrafo3);

        //añadimos a pantalla principal
        this.add(titulo);
        this.add(tituloInf);
        this.add(panelPantalla);

    }

}
