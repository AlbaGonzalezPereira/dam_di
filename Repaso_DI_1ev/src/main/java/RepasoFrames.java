import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author alba_
 */
public class RepasoFrames extends JFrame {

    public RepasoFrames() {
        //creamos el JFram:
        JFrame frame = new JFrame("Repaso1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        
        //Añadimos botones:
        JButton botonAc = new JButton("Aceptar");
        JButton botonCan = new JButton("Cancelar");
        
        //Establecemos el Borderlayout:
//        frame.setLayout(new BorderLayout());
//        frame.add(botonAc, BorderLayout.NORTH); //añadimos el botón al layout y lo ponemos en la posición norte
//        frame.add(botonCan, BorderLayout.SOUTH);
        
        //Establecemos el GridLayout:
//        frame.setLayout(new GridLayout(2, 1, 5, 15));
//        frame.add(botonAc);
//        frame.add(botonCan);

//        //Establecemos el GridBagLayout:
//        frame.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.BOTH;
//        
//        //primer elemento ocupa 2 columnas:
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridheight = 1;
//        gbc.gridwidth = 2;
//        //gbc.weightx = 1.0; // Distribuir espacio horizontalmente
//        frame.add(botonAc, gbc);
//        
//        //segundo elemento ocupa 1 columna y está situado a la derecha:
//        gbc.gridx = 2;
//        gbc.gridy = 1;
//        gbc.gridheight = 1;
//        gbc.gridwidth = 1;
//        //gbc.weightx = 0.5; // Distribuir espacio horizontalmente
//        frame.add(botonCan, gbc);

//        //Establecemos el Cardlayout:
//        CardLayout cl = new CardLayout();
//        JPanel panelCard = new JPanel(cl); //asignamos el cardlayout
//        
//        //Creamos un nuevo JPanel:
//        JPanel panel1 = new JPanel();
//        panel1.setBackground(Color.MAGENTA); //asignamos color al panel
//        panel1.add(new JLabel("Panel Magenta"));
//        
//        JPanel panel2 = new JPanel();
//        panel2.setBackground(Color.LIGHT_GRAY); //asignamos color al panel
//        panel2.add(new JLabel("Panel Gris"));
//        
//        JPanel panel3 = new JPanel();
//        panel3.add(botonAc);
//        panel3.add(botonCan);
//        
//        //añadimos los paneles de colores al panelCard:
//        panelCard.add(panel1,"panel1");
//        panelCard.add(panel2,"panel2");
//        
//        
//        frame.setLayout(new 
//        GridLayout(2, 1));
//        frame.add(panelCard);
//        frame.add(panel3);
//        
//        botonAc.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cl.show(panelCard,"panel2");
//            }
//        });

        //Establecemos el FlowLayout:
        JPanel panelFlow = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JTextField tf1 = new JTextField(30);
        tf1.setText("Probando textField");
        panelFlow.add(botonAc);
        panelFlow.add(botonCan);
        panelFlow.add(tf1);
        
        JOptionPane.showConfirmDialog(null, "Probando");
        tf1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "foco perdido?");
                if (opcion == JOptionPane.YES_OPTION){
                    System.out.println("Foco perdido");
                } else if (opcion == JOptionPane.NO_OPTION) {
                    System.out.println("Foco no perdido");    
                } else if(opcion == JOptionPane.CANCEL_OPTION) {
                    System.out.println("Cancelaste");
                } else{
                    System.out.println("Ni idea de lo que pasó");
                }
            }
        });
        
        frame.add(panelFlow);
        
        //visualizamos el frame:
        frame.setVisible(true);
       
        
    }
    
    
}
