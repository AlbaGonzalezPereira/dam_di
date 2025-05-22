package pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author alba_
 */
public class PantallaGrupos extends JPanel {

    public PantallaGrupos() {
        JLabel titulo = new JLabel("Gestión de grupos");
        titulo.setFont(new java.awt.Font("Reem Kufi", 1, 26)); 
        titulo.setForeground(new java.awt.Color(69, 123, 157));
        this.setBackground(Color.WHITE);
        this.add(titulo);

        // Panel contenedor
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label de grupo rojos
        JLabel grupoRojos = new JLabel("Grupo Rojos");
        grupoRojos.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        grupoRojos.setForeground(Color.BLACK);
        grupoRojos.setAlignmentX(Component.LEFT_ALIGNMENT);
        grupoRojos.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));

        // Barra de progreso
        JProgressBar barraRojos = new JProgressBar(0, 100);
        barraRojos.setValue(40);
        barraRojos.setStringPainted(true);
        barraRojos.setString("40% Participantes");
        barraRojos.setBackground(Color.LIGHT_GRAY);
        barraRojos.setForeground(Color.RED);
        barraRojos.setPreferredSize(new Dimension(300, 25));
        
        // Label de grupo amarillos
        JLabel grupoAmarillos = new JLabel("Grupo Amarillos");
        grupoAmarillos.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        grupoAmarillos.setForeground(Color.BLACK);
        grupoAmarillos.setAlignmentX(Component.LEFT_ALIGNMENT);
        grupoAmarillos.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));

        // Barra de progreso
        JProgressBar barraAmarillos = new JProgressBar(0, 100);
        barraAmarillos.setValue(30); 
        barraAmarillos.setStringPainted(true);
        barraAmarillos.setString("30% Participantes");
        barraAmarillos.setBackground(Color.LIGHT_GRAY);
        barraAmarillos.setForeground(Color.YELLOW);
        barraAmarillos.setPreferredSize(new Dimension(300, 25));
        
        // Label de grupo verdes
        JLabel grupoVerdes = new JLabel("Grupo Verdes");
        grupoVerdes.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        grupoVerdes.setForeground(Color.BLACK);
        grupoVerdes.setAlignmentX(Component.LEFT_ALIGNMENT);
        grupoVerdes.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));

        // Barra de progreso
        JProgressBar barraVerdes = new JProgressBar(0, 100);
        barraVerdes.setValue(20); 
        barraVerdes.setStringPainted(true);
        barraVerdes.setString("20% Participantes");
        barraVerdes.setBackground(Color.LIGHT_GRAY);
        barraVerdes.setForeground(Color.GREEN);
        barraVerdes.setPreferredSize(new Dimension(300, 25));
        
        // Label de grupo azules
        JLabel grupoAzules = new JLabel("Grupo Azules");
        grupoAzules.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        grupoAzules.setForeground(Color.BLACK);
        grupoAzules.setAlignmentX(Component.LEFT_ALIGNMENT);
        grupoAzules.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));

        // Barra de progreso
        JProgressBar barraAzules = new JProgressBar(0, 100);
        barraAzules.setValue(10); 
        barraAzules.setStringPainted(true);
        barraAzules.setString("10% Participantes");
        barraAzules.setBackground(Color.LIGHT_GRAY);
        barraAzules.setForeground(Color.CYAN);
        barraAzules.setPreferredSize(new Dimension(300, 25));

        // Agregamos componentes al panel
        panel.add(titulo);
        panel.add(grupoRojos);
        panel.add(barraRojos);
        panel.add(grupoAmarillos);
        panel.add(barraAmarillos);
        panel.add(grupoVerdes);
        panel.add(barraVerdes);
        panel.add(grupoAzules);
        panel.add(barraAzules);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
       
}
