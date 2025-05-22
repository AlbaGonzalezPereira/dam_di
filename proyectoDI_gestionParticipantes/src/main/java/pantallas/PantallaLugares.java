package pantallas;

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
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import DAO.*;
import entidades.Aula;
import javax.swing.JOptionPane;

/**
 *
 * @author alba_
 */
public class PantallaLugares extends JPanel implements Serializable {

    public PantallaLugares() {
        //Establecemos un borde vacío para dejar márgenes
        this.setBorder(BorderFactory.createEmptyBorder(0, 90, 0, 90));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10, 10, 10);

        //Título Principal de la pantalla
        JLabel titulo = new JLabel("Gestión de lugares realización");
        //titulo.setHorizontalAlignment(JLabel.CENTER); //si lo queremos centrar
        titulo.setFont(new java.awt.Font("Reem Kufi", 1, 26));
        titulo.setForeground(new java.awt.Color(69, 123, 157));
        this.setBackground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(titulo, gbc);

        //Separador horizontal (simula un <hr>)
//        JSeparator separador = new JSeparator();
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.gridwidth = 2;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.insets = new Insets(0, 10, 10, 10); 
//        this.add(separador, gbc);
              
        //Creamos un panel formulario con un fieldset y legend
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(Color.WHITE);
        TitledBorder leyenda = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Registrar aulas",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Reem Kufi", Font.BOLD, 22),
                new Color(29, 53, 87)
        );
        panelFormulario.setBorder(leyenda);

        GridBagConstraints fgbc = new GridBagConstraints();
        fgbc.insets = new Insets(10, 10, 10, 10);
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        fgbc.weightx = 1.0;

        //Campo Lugar
        JLabel nomLugar = new JLabel("Lugar");
        nomLugar.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        nomLugar.setForeground(new Color(29, 53, 87));
        fgbc.gridx = 0;
        fgbc.gridy = 0;
        fgbc.gridwidth = 1;
        panelFormulario.add(nomLugar, fgbc);

        JTextField lugar = new JTextField();
        lugar.setPreferredSize(new Dimension(200, 30));
        lugar.setFont(new Font("Reem Kufi", Font.PLAIN, 14));
        fgbc.gridx = 1;
        fgbc.gridy = 0;
        panelFormulario.add(lugar, fgbc);

        //Campo Aula activa
        JLabel aulaActiva = new JLabel("Aula activa");
        aulaActiva.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        aulaActiva.setForeground(new Color(29, 53, 87));
        fgbc.gridx = 0;
        fgbc.gridy = 1;
        panelFormulario.add(aulaActiva, fgbc);

        JComboBox<String> activo = new JComboBox<>(new String[]{"-----", "Sí", "No"});
        activo.setFont(new Font("Reem Kufi", Font.PLAIN, 14));
        fgbc.gridx = 1;
        fgbc.gridy = 1;
        panelFormulario.add(activo, fgbc);

        //Campo Edición
        JLabel nomEdicion = new JLabel("Edición");
        nomEdicion.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        nomEdicion.setForeground(new Color(29, 53, 87));
        fgbc.gridx = 0;
        fgbc.gridy = 2;
        panelFormulario.add(nomEdicion, fgbc);

        JTextField edicion = new JTextField();
        edicion.setPreferredSize(new Dimension(200, 30));
        edicion.setFont(new Font("Reem Kufi", Font.PLAIN, 14));
        fgbc.gridx = 1;
        fgbc.gridy = 2;
        panelFormulario.add(edicion, fgbc);

        //Campo Máximo participantes
        JLabel nomMaxParticipantes = new JLabel("Máximo participantes");
        nomMaxParticipantes.setFont(new Font("Reem Kufi", Font.BOLD, 16));
        nomMaxParticipantes.setForeground(new Color(29, 53, 87));
        fgbc.gridx = 0;
        fgbc.gridy = 3;
        panelFormulario.add(nomMaxParticipantes, fgbc);

        JTextField maxParticipantes = new JTextField();
        maxParticipantes.setPreferredSize(new Dimension(200, 30));
        maxParticipantes.setFont(new Font("Reem Kufi", Font.PLAIN, 14));
        fgbc.gridx = 1;
        fgbc.gridy = 3;
        panelFormulario.add(maxParticipantes, fgbc);

        //Panel botones 
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.setBackground(Color.WHITE);
        Dimension tamanhoBoton = new Dimension(120, 40);

        //Botón Registrar
        JButton botonRegistrar = new JButton("Registrar");
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

        //Botón Escribir
        JButton botonEscribir = new JButton("Escribir");
        botonEscribir.setFont(new Font("Reem Kufi", Font.BOLD, 14));
        botonEscribir.setBackground(new Color(58, 110, 165));
        botonEscribir.setForeground(Color.WHITE);
        botonEscribir.setPreferredSize(tamanhoBoton);
        //panelBotones.add(botonEscribir);

        //Botón Leer
        JButton botonLeer = new JButton("Leer");
        botonLeer.setFont(new Font("Reem Kufi", Font.BOLD, 14));
        botonLeer.setBackground(new Color(192, 192, 192));
        botonLeer.setForeground(Color.WHITE);
        botonLeer.setPreferredSize(tamanhoBoton);
        //panelBotones.add(botonLeer);

        fgbc.gridx = 0;
        fgbc.gridy = 4;
        fgbc.gridwidth = 2;
        fgbc.anchor = GridBagConstraints.CENTER;
        panelFormulario.add(panelBotones, fgbc);

        // Agregamos el fieldsetPanel (con la leyenda) al panel principal
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);
        this.add(panelFormulario, gbc);

        PantallaLugares objetoLugares = this;

        //Eventos botones Registrar y cancelar
        botonRegistrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Activa activa;
                // comprobamos que ha rellenado todos los campos
                if(lugar.getText()=="" || edicion.getText() == "" || maxParticipantes.getText() == ""){
                    JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos");
                    return;   
                }
                
                if(activo.getSelectedIndex()==1){
                    activa = Activa.SI;
                }else if(activo.getSelectedIndex()==2){
                    activa = Activa.NO;
                }else{
                    JOptionPane.showMessageDialog(null, "Selecciona aula activa o no activa");
                    return;
                }
                Aula aula = new Aula(lugar.getText(),activa, edicion.getText() ,Integer.parseInt(maxParticipantes.getText()));
                AulaDAO aulaDao = new AulaDAO();
                aulaDao.add(aula);
                JOptionPane.showMessageDialog(null, "Aula creada correctamente");
                lugar.setText("");
                activo.setSelectedIndex(0);
                edicion.setText("");
                maxParticipantes.setText("");
            }
        });
        //Eventos botones Escribir y Leer
        botonEscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lugarTem = lugar.getText();
                String activoTem = (String) activo.getSelectedItem();
                String edicionTem = edicion.getText();
                int maxParticipantesTem = Integer.parseInt(maxParticipantes.getText());
                try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("registroAulas.txt"));) {

                    Data dataEscritos = new Data(lugarTem, activoTem, edicionTem, maxParticipantesTem);
                    oos.writeObject(dataEscritos);
                    
                    // Borramos el contenido de los campos una vez escritos
                    lugar.setText("");
                    activo.setSelectedIndex(0);
                    edicion.setText("");
                    maxParticipantes.setText("");

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PantallaLugares.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PantallaLugares.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        botonLeer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream("registroAulas.txt"));) {
                    Data dataLeidos = (Data) ois.readObject();
                    lugar.setText(dataLeidos.getLugar());
                    activo.setSelectedItem(dataLeidos.getActivo());
                    edicion.setText(dataLeidos.getEdicion());
                    maxParticipantes.setText(String.valueOf(dataLeidos.getMaxParticipantes()));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PantallaLugares.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PantallaLugares.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PantallaLugares.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

}
