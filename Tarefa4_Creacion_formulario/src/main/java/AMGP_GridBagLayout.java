
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * Creación dun formulario cun GridBagLayout
 * @author alba_
 */
public class AMGP_GridBagLayout { 
    public void inicializar(){
        JFrame frame = new JFrame("FormularioGrid Tarefa 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Definimos o tamaño do frame
        frame.setSize(550, 450);
        
        //Establecemos o layout do frame como GridBagLayout
        frame.setLayout(new GridBagLayout());
        
        //Creamos o obxecto GridBagConstraints, onde se indicarán en que fila e 
        //en que columna van os elementos
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; //os compoñentes enchen o espazo dispoñible
        gbc.insets = new Insets(5,5,5,5);//poñemos un padding
        
        /*****************************Profesión*****************************/
        //Definimos o JLabel profesión na posición 0,0
        gbc.gridx = 0; //columna 0
        gbc.gridy = 0; //fila 0
        gbc.gridwidth = 1;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        JLabel profesion = new JLabel("Profesión");
        frame.add(profesion, gbc);
        
        //definimos o compoñente JTextField profesión 0,1
        gbc.gridx = 1; //columna 0
        gbc.gridy = 0; //fila 0
        gbc.gridwidth = 2;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        JTextField textoProf = new JTextField(30);
        frame.add(textoProf, gbc);
        
        /*********************************Edad*******************************/
        gbc.gridx = 3; //columna 0
        gbc.gridy = 0; //fila 0
        gbc.gridwidth = 1;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        JLabel edad = new JLabel("Edad");
        frame.add(edad, gbc);
        
        String[] rangos = { "Entre 18 y 30 años", "Entre 31 y 45 años", "Entre 41 y 60 años", "Más de 61 años" };
        JComboBox<String> edades = new JComboBox<>(rangos);
        gbc.gridx = 4; //columna 0
        gbc.gridy = 0; //fila 0
        gbc.gridwidth = 1;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas 
        frame.add(edades, gbc);
        
        /*******************************Nº hermanos******************************/
        //Definimos o JLabel hermanos
        gbc.gridx = 0; //columna 0
        gbc.gridy = 1; //fila 0
        gbc.gridwidth = 1;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        JLabel nHermanos = new JLabel("Nº Hermanos");
        frame.add(nHermanos, gbc);
        
        JSpinner hermanos = new JSpinner();
        gbc.gridx = 1; //columna 0
        gbc.gridy = 1; //fila 0
        gbc.gridwidth = 1;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas 
        frame.add(hermanos, gbc);
        
        /***************************Jpanel sexo******************************/
        //creamos o Jpanel de sexo
        JPanel panelSexo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JLabel sexo = new JLabel("Sexo");
        panelSexo.add(sexo);
        JRadioButton sexo1 = new JRadioButton("HOMBRE");
        panelSexo.add(sexo1);
        JRadioButton sexo2 = new JRadioButton("MUJER");
        panelSexo.add(sexo2);
        //poñemos borde e padding
        Border borde = BorderFactory.createLineBorder(Color.BLACK, 2); // Borde de cor negra e grosor 2
        Border padding = new EmptyBorder(5, 5, 5, 5); //engadimos padding
        panelSexo.setBorder(BorderFactory.createCompoundBorder(borde, padding)); //poñemos borde e padding
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        frame.add(panelSexo, gbc);
        
        /******************************panel practica deporte**********************************/
        gbc.gridx = 0; //columna 0
        gbc.gridy = 3; //fila 0
        gbc.gridwidth = 2;//número de columnas ocupadas
        gbc.gridheight = 2; //número de filas ocupadas
        JCheckBox practica = new JCheckBox("¿Practica algún deporte?");
        frame.add(practica, gbc);
        
        gbc.gridx = 3; //columna 0
        gbc.gridy = 3; //fila 0
        gbc.gridwidth = 1;//número de columnas ocupadas
        gbc.gridheight = 2; //número de filas ocupadas
        JLabel cual = new JLabel("¿Cuál?");
        frame.add(cual, gbc);
        
        String[] deportes = { "Fútbol", "Tenis", "Tenis de mesa", "Baloncesto", "Badminton" };
        gbc.gridx = 4; //columna 0
        gbc.gridy = 3; //fila 0
        gbc.gridwidth = 1;//número de columnas ocupadas
        gbc.gridheight = 2; //número de filas ocupadas
        JList<String> listado = new JList(deportes);
        listado.setVisibleRowCount(4);
        Border bordeGris = BorderFactory.createLineBorder(Color.GRAY, 1);
        listado.setBorder(bordeGris);  // Asignar el borde al JList
        frame.add(listado, gbc);
        //poñemos o listado con flechas de scroll
//        JScrollPane scroll = new JScrollPane(listado);
//        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        
//        frame.add(scroll, gbc);

        /***************************separador********************************/
        gbc.gridx = 0; //columna 0
        gbc.gridy = 7; //fila 0
        gbc.gridwidth = 5;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        JSeparator separador = new JSeparator();
        frame.add(separador, gbc);
        
        /**************************panel marcar******************************/
        gbc.gridx = 0; //columna 0
        gbc.gridy = 8; //fila 0
        gbc.gridwidth = 4;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        JLabel marque = new JLabel("Marque de 1 a 10 su grado de afición a:");
        frame.add(marque, gbc);
        
        gbc.gridx = 0; //columna 0
        gbc.gridy = 9; //fila 0
        gbc.gridwidth = 1;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        JLabel compras = new JLabel("Compras");
        frame.add(compras, gbc);
        
        gbc.gridx = 1; //columna 0
        gbc.gridy = 9; //fila 0
        gbc.gridwidth = 2;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        JSlider sliderCompras =new JSlider(1, 10, 1);
        sliderCompras.setMajorTickSpacing(1);
        sliderCompras.setPaintLabels(true);
        frame.add(sliderCompras, gbc);
        
        gbc.gridx = 0; //columna 0
        gbc.gridy = 10; //fila 0
        gbc.gridwidth = 1;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        JLabel tv = new JLabel("Ver la televisión");
        frame.add(tv, gbc);
        
        gbc.gridx = 1; //columna 0
        gbc.gridy = 10; //fila 0
        gbc.gridwidth = 2;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        JSlider sliderTv =new JSlider(1, 10, 1);
        sliderTv.setMajorTickSpacing(1);
        sliderTv.setPaintLabels(true);
        frame.add(sliderTv, gbc);
        
        gbc.gridx = 0; //columna 0
        gbc.gridy = 11; //fila 0
        gbc.gridwidth = 2;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        JLabel cine = new JLabel("Ir al cine");
        //gbc.anchor = GridBagConstraints.CENTER;
        frame.add(cine, gbc);
        
        gbc.gridx = 1; //columna 0
        gbc.gridy = 11; //fila 0
        gbc.gridwidth = 2;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        JSlider sliderCine =new JSlider(1, 10, 1);
        sliderCine.setMajorTickSpacing(1);
        sliderCine.setPaintLabels(true);
        frame.add(sliderCine, gbc);
        
        /***************************Jpanel botones****************************/
        //creamos un Jpanel para meter os botóns, un ao lado do outro
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton aceptar = new JButton("ACEPTAR");
        JButton cancelar = new JButton("CANCELAR");
        panelBotones.add(aceptar);
        panelBotones.add(cancelar);
        gbc.gridx = 3; //columna 0
        gbc.gridy = 9; //fila 0
        gbc.gridwidth = 2;//número de columnas ocupadas
        gbc.gridheight = 1; //número de filas ocupadas
        frame.add(panelBotones, gbc);
               
        //facemos visible o frame
        frame.setVisible(true);
       
    }
    
}
