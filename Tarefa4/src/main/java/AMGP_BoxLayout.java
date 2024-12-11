
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
 * Creación dun formulario cun BoxLayout
 * @author alba_
 */
public class AMGP_BoxLayout { 
    public void inicializar(){
        //Creamos o frame
        JFrame frame = new JFrame("FormularioBox Tarefa 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        frame.setSize(550, 325); //Definimos o tamaño do frame
        
        //Establecemos o layout do frame como BoxLayout
        JPanel principal = new JPanel();
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
        
        //Creamos as filas
        JPanel fila1 = new JPanel();
        fila1.setLayout(new BoxLayout(fila1, BoxLayout.X_AXIS));
        JPanel fila2 = new JPanel();
        fila2.setLayout(new BoxLayout(fila2, BoxLayout.X_AXIS));
        JPanel fila3 = new JPanel();
        fila3.setLayout(new BoxLayout(fila3, BoxLayout.X_AXIS));
        JPanel fila4 = new JPanel();
        fila4.setLayout(new BoxLayout(fila4, BoxLayout.X_AXIS));
        JPanel fila5 = new JPanel();
        fila5.setLayout(new BoxLayout(fila5, BoxLayout.X_AXIS));
        JPanel fila6 = new JPanel();
        fila6.setLayout(new BoxLayout(fila6, BoxLayout.X_AXIS));
        
        /*****************************Profesión*****************************/
        JPanel prof = new JPanel();
        prof.setLayout(new BoxLayout(prof, BoxLayout.X_AXIS));
        JLabel profesion = new JLabel("Profesión");
        prof.add(profesion);
        JTextField textoProf = new JTextField(15);
        prof.add(textoProf);
        
        /*********************************Edad*******************************/
        JPanel ed = new JPanel();
        ed.setLayout(new BoxLayout(ed, BoxLayout.X_AXIS));
        JLabel edad = new JLabel("Edad");
        ed.add(edad);     
        String[] rangos = { "Entre 18 y 30 años", "Entre 31 y 45 años", "Entre 41 y 60 años", "Más de 61 años" };
        JComboBox<String> edades = new JComboBox<>(rangos);       
        ed.add(edades);
        
        //engadimos prof e ed á fila1
        fila1.add(prof);
        fila1.add(ed);
        principal.add(fila1);//engadimos fila1 a principal
        
        /*******************************hermanos******************************/
        JPanel herm = new JPanel();
        herm.setLayout(new BoxLayout(herm, BoxLayout.X_AXIS));
        JLabel nHermanos = new JLabel("Nº Hermanos");
        herm.add(nHermanos);   
        JSpinner hermanos = new JSpinner();
        herm.add(hermanos);
        fila2.add(herm);
        principal.add(fila2);
        
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
        fila3.add(panelSexo);
        principal.add(fila3);
        
        /******************************panel practica deporte**********************************/
        JPanel dep = new JPanel();
        dep.setLayout(new BoxLayout(dep, BoxLayout.X_AXIS));
        JCheckBox practica = new JCheckBox("¿Practica algún deporte?");
        dep.add(practica);
        
        JPanel dep2 = new JPanel();
        dep2.setLayout(new BoxLayout(dep2, BoxLayout.X_AXIS));
        JLabel cual = new JLabel("¿Cuál?");
        dep2.add(cual);
        String[] deportes = { "Fútbol", "Tenis", "Tenis de mesa", "Baloncesto", "Badminton" };
        JList<String> listado = new JList(deportes);
        listado.setVisibleRowCount(4);
        Border bordeGris = BorderFactory.createLineBorder(Color.GRAY, 1);
        listado.setBorder(bordeGris);  // Asignar el borde al JList
        dep2.add(listado);
        
        fila4.add(dep);
        fila4.add(dep2);
        principal.add(fila4);

        /***************************separador********************************/
        JSeparator separador = new JSeparator();
        principal.add(separador);
        
        /**************************panel marcar******************************/
        //o metemos en dúas filas para que quede visualmente mellor       
        JLabel marque = new JLabel("Marque de 1 a 10 su grado de afición a:");
        fila5.add(marque);
        principal.add(fila5);
        
        //creamos un panel na fila6 con dúas seccións
        JPanel marc = new JPanel();
        marc.setLayout(new BoxLayout(marc, BoxLayout.X_AXIS));
        JPanel izq = new JPanel();
        izq.setLayout(new BoxLayout(izq, BoxLayout.Y_AXIS));
        JPanel der = new JPanel();
        der.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        marc.add(izq);
        marc.add(der);
        fila6.add(marc);
        principal.add(fila6);
              
        JPanel com = new JPanel();
        com.setLayout(new BoxLayout(com, BoxLayout.X_AXIS));
        JLabel compras = new JLabel("Compras");
        com.add(compras);        
        JSlider sliderCompras =new JSlider(1, 10, 1);
        sliderCompras.setMajorTickSpacing(1);
        sliderCompras.setPaintLabels(true);
        com.add(sliderCompras);

        JPanel tele = new JPanel();
        tele.setLayout(new BoxLayout(tele, BoxLayout.X_AXIS));        
        JLabel tv = new JLabel("Ver la televisión");
        tele.add(tv);
        JSlider sliderTv =new JSlider(1, 10, 1);
        sliderTv.setMajorTickSpacing(1);
        sliderTv.setPaintLabels(true);
        tele.add(sliderTv);

        JPanel film = new JPanel();
        film.setLayout(new BoxLayout(film, BoxLayout.X_AXIS));    
        JLabel cine = new JLabel("Ir al cine");
        film.add(cine);
        JSlider sliderCine =new JSlider(1, 10, 1);
        sliderCine.setMajorTickSpacing(1);
        sliderCine.setPaintLabels(true);
        film.add(sliderCine);
        
        izq.add(com);
        izq.add(tele);
        izq.add(film);
               
        /***************************Jpanel botones****************************/
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton aceptar = new JButton("ACEPTAR");
        JButton cancelar = new JButton("CANCELAR");
        panelBotones.add(aceptar);
        panelBotones.add(cancelar);
        der.add(panelBotones);
          
        //engadimos o frame a principal e o facemos visible
        frame.add(principal);
        frame.setVisible(true);
       
    }
    
}
