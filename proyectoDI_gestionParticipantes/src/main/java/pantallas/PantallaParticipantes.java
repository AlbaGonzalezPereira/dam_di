
package pantallas;

import DAO.AulaDAO;
import entidades.Aula;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author alba_
 */
public class PantallaParticipantes extends JPanel {

    public PantallaParticipantes() {
               
       //Establecemos un borde vacío para dejar márgenes
        this.setBorder(BorderFactory.createEmptyBorder(0, 90, 0, 90));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10, 10, 10);

        //Título Principal de la pantalla
        JLabel titulo = new JLabel("Gestión de participantes");
        //titulo.setHorizontalAlignment(JLabel.CENTER); //si lo queremos centrar
        titulo.setFont(new java.awt.Font("Reem Kufi", 1, 26));
        titulo.setForeground(new java.awt.Color(69, 123, 157));
        this.setBackground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(titulo, gbc);

                      
        //Creamos un panel formulario para el participante con un fieldset y legend
        JPanel panelFormularioParticipante = new JPanel(new GridBagLayout());
        panelFormularioParticipante.setBackground(Color.WHITE);
        TitledBorder leyenda = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Participante",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Reem Kufi", Font.BOLD, 22),
                new Color(29, 53, 87)
        );
        panelFormularioParticipante.setBorder(leyenda);

        GridBagConstraints fgbc = new GridBagConstraints();
        fgbc.insets = new Insets(5, 5, 5, 5);
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        fgbc.weightx = 1.0;

        //Campo Nombre
        JLabel nomNombreP = new JLabel("Nombre");
        nomNombreP.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        nomNombreP.setForeground(new Color(29, 53, 87));
        fgbc.gridx = 0;
        fgbc.gridy = 0;
        fgbc.gridwidth = 1;
        panelFormularioParticipante.add(nomNombreP, fgbc);

        JTextField nombre = new JTextField();
        nombre.setPreferredSize(new Dimension(200, 30));
        nombre.setFont(new Font("Reem Kufi", Font.PLAIN, 14));
        fgbc.gridx = 1;
        fgbc.gridy = 0;
        panelFormularioParticipante.add(nombre, fgbc);


        //Campo Apellidos
        JLabel nomApellidos = new JLabel("Apellidos");
        nomApellidos.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        nomApellidos.setForeground(new Color(29, 53, 87));
        fgbc.gridx = 0;
        fgbc.gridy = 1;
        panelFormularioParticipante.add(nomApellidos, fgbc);

        JTextField apellidos = new JTextField();
        apellidos.setPreferredSize(new Dimension(200, 30));
        apellidos.setFont(new Font("Reem Kufi", Font.PLAIN, 14));
        fgbc.gridx = 1;
        fgbc.gridy = 1;
        panelFormularioParticipante.add(apellidos, fgbc);

        
        //Campo Curso Escolar
        JLabel nomCurso = new JLabel("Curso escolar");
        nomCurso.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        nomCurso.setForeground(new Color(29, 53, 87));
        fgbc.gridx = 0;
        fgbc.gridy = 2;
        panelFormularioParticipante.add(nomCurso, fgbc);

        JComboBox<String> curso = new JComboBox<>(new String[]{"-----", "EI", "1ºEP", "2ºEP", "3ºEP", "4ºEP", "5ºEP", "6ºEP", "1ºESO"});
        curso.setFont(new Font("Reem Kufi", Font.PLAIN, 14));
        fgbc.gridx = 1;
        fgbc.gridy = 2;
        panelFormularioParticipante.add(curso, fgbc);
        
        //Campo Centro educativo
        JLabel nomCentro = new JLabel("Centro educativo");
        nomCentro.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        nomCentro.setForeground(new Color(29, 53, 87));
        fgbc.gridx = 0;
        fgbc.gridy = 3;
        panelFormularioParticipante.add(nomCentro, fgbc);

        JTextField centro = new JTextField();
        centro.setPreferredSize(new Dimension(200, 30));
        centro.setFont(new Font("Reem Kufi", Font.PLAIN, 14));
        fgbc.gridx = 1;
        fgbc.gridy = 3;
        panelFormularioParticipante.add(centro, fgbc);
        
        //Campo elegir aula
        JLabel nomAula = new JLabel("Aula en las que desea participar:");
        nomAula.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        nomAula.setForeground(new Color(29, 53, 87));
        fgbc.gridx = 0;
        fgbc.gridy = 6;
        panelFormularioParticipante.add(nomAula, fgbc);
        
        
        JPanel panelAulas = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        panelAulas.setBackground(Color.WHITE);
        //Esto será dinámico, cogiendo de las aulas activas de la base de datos
        AulaDAO aulaDao = new AulaDAO();
        List<Aula> aulas = aulaDao.getActivas();
        for (Aula aula : aulas) {
            JCheckBox checkboxaulas = new JCheckBox(aula.getNombreAula());
            checkboxaulas.setBackground(Color.WHITE);
            checkboxaulas.setFont(new Font("Reem Kufi", Font.PLAIN, 16));
            panelAulas.add(checkboxaulas);
            
        }
                
        fgbc.gridx = 1;
        fgbc.gridy = 6;
        panelFormularioParticipante.add(panelAulas, fgbc);
        
        //Creamos un panel formulario para el familiar con un fieldset y legend
        JPanel panelFormularioFamiliar = new JPanel(new GridBagLayout());
        panelFormularioFamiliar.setBackground(Color.WHITE);
        TitledBorder leyenda2 = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Tutor o tutora",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Reem Kufi", Font.BOLD, 22),
                new Color(29, 53, 87)
        );
        panelFormularioFamiliar.setBorder(leyenda2);

        GridBagConstraints fgbc2 = new GridBagConstraints();
        fgbc2.insets = new Insets(5, 5, 5, 5);
        fgbc2.fill = GridBagConstraints.HORIZONTAL;
        fgbc2.weightx = 1.0;
        
        //Campo Nombre Tutor
        JLabel nomNombreT = new JLabel("Nombre");
        nomNombreT.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        nomNombreT.setForeground(new Color(29, 53, 87));
        fgbc2.gridx = 0;
        fgbc2.gridy = 0;
        fgbc2.gridwidth = 1;
        panelFormularioFamiliar.add(nomNombreT, fgbc2);

        JTextField nombreT = new JTextField();
        nombreT.setPreferredSize(new Dimension(200, 30));
        nombreT.setFont(new Font("Reem Kufi", Font.PLAIN, 14));
        fgbc2.gridx = 1;
        fgbc2.gridy = 0;
        panelFormularioFamiliar.add(nombreT, fgbc2);


        //Campo Apellidos Tutor
        JLabel nomApellidosT = new JLabel("Apellidos");
        nomApellidosT.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        nomApellidosT.setForeground(new Color(29, 53, 87));
        fgbc2.gridx = 0;
        fgbc2.gridy = 1;
        panelFormularioFamiliar.add(nomApellidosT, fgbc2);
        
        JTextField apellidosT = new JTextField();
        apellidosT.setPreferredSize(new Dimension(200, 30));
        apellidosT.setFont(new Font("Reem Kufi", Font.PLAIN, 14));
        fgbc2.gridx = 1;
        fgbc2.gridy = 1;
        panelFormularioFamiliar.add(apellidosT, fgbc2);
        
        //Campo DNI
        JLabel nomDni = new JLabel("DNI");
        nomDni.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        nomDni.setForeground(new Color(29, 53, 87));
        fgbc2.gridx = 0;
        fgbc2.gridy = 2;
        panelFormularioFamiliar.add(nomDni, fgbc2);

        JTextField dni = new JTextField();
        dni.setPreferredSize(new Dimension(200, 30));
        dni.setFont(new Font("Reem Kufi", Font.PLAIN, 14));
        fgbc2.gridx = 1;
        fgbc2.gridy = 2;
        panelFormularioFamiliar.add(dni, fgbc2);

        //Campo Telefono
        JLabel nomTelf = new JLabel("Teléfono");
        nomTelf.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        nomTelf.setForeground(new Color(29, 53, 87));
        fgbc2.gridx = 0;
        fgbc2.gridy = 3;
        panelFormularioFamiliar.add(nomTelf, fgbc2);

        JTextField telf = new JTextField();
        telf.setPreferredSize(new Dimension(200, 30));
        telf.setFont(new Font("Reem Kufi", Font.PLAIN, 14));
        fgbc2.gridx = 1;
        fgbc2.gridy = 3;
        panelFormularioFamiliar.add(telf, fgbc2);
        
        //Campo email
        JLabel nomMail = new JLabel("Email");
        nomMail.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        nomMail.setForeground(new Color(29, 53, 87));
        fgbc2.gridx = 0;
        fgbc2.gridy = 4;
        panelFormularioFamiliar.add(nomMail, fgbc2);

        JTextField mail = new JTextField();
        mail.setPreferredSize(new Dimension(200, 30));
        mail.setFont(new Font("Reem Kufi", Font.PLAIN, 14));
        fgbc2.gridx = 1;
        fgbc2.gridy = 4;
        panelFormularioFamiliar.add(mail, fgbc2);
            
               
        //Panel botones 
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.setBackground(Color.WHITE);
        Dimension tamanhoBoton = new Dimension(120, 40);

        //Botón Registrar
        JButton botonRegistrar = new JButton("Incribir");
        botonRegistrar.setFont(new Font("Reem Kufi", Font.BOLD, 14));
        botonRegistrar.setBackground(new Color(0, 145, 173));
        botonRegistrar.setForeground(Color.WHITE);
        botonRegistrar.setPreferredSize(tamanhoBoton);
        panelBotones.add(botonRegistrar);

        //Botón Cancelar
        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setFont(new Font("Reem Kufi", Font.BOLD, 14));
        botonCancelar.setBackground(new Color(230, 57, 70));
        botonCancelar.setForeground(Color.WHITE);
        botonCancelar.setPreferredSize(tamanhoBoton);
        panelBotones.add(botonCancelar);

        
        // Agregamos los fieldsetPanel (con la leyenda) al panel principal
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);
        this.add(panelFormularioParticipante, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);
        this.add(panelFormularioFamiliar, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);
        this.add(panelBotones, gbc);

        

    }
    
    
}
