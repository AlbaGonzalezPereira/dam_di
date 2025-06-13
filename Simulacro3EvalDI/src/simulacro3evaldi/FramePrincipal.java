package simulacro3evaldi;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author alba_
 */
public class FramePrincipal extends JFrame {

    JFileChooser filechooser = new JFileChooser();
    private File origen = new File("/");
    private File destino = new File("/");

    public FramePrincipal() {
        //creamos el JFram:
        JFrame frame = new JFrame("Repaso3Eval");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Contenedor principal con BoxLayout vertical
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Título
        JLabel titulo = new JLabel("Repasando DI");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrado horizontal
        titulo.setFont(new Font("Calibri", Font.BOLD, 20)); // Fuente más grande y negrita
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); // Espacio debajo del título

        // Panel para nombre
        JPanel panelNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField tfnombre = new JTextField(20);
        JLabel lbnombre = new JLabel("Nombre: ");
        lbnombre.setFont(new Font("Calibri", Font.BOLD, 12));
        tfnombre.setText("Introduzca nombre"); //si queremos poner un placeholder
        panelNombre.add(lbnombre);
        panelNombre.add(tfnombre);

        //Panel para apellidos
        JPanel panelApellidos = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField tfapellidos = new JTextField(20);
        JLabel lbapellidos = new JLabel("Apellidos: ");
        lbapellidos.setFont(new Font("Calibri", Font.BOLD, 12));
        panelApellidos.add(lbapellidos);
        panelApellidos.add(tfapellidos);

        //Panel botones Serializar
        JPanel panelBotonesSerializar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton botonLeer = new JButton("Leer archivo");
        JButton botonEscribir = new JButton("Escribir");
        panelBotonesSerializar.add(botonLeer);
        panelBotonesSerializar.add(botonEscribir);

        //Panel botones File
        JPanel panelBotonesFile = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton botonElegirColor = new JButton("Elegir Color");
        JButton botonGuardar = new JButton("Guardar archivo");
        JButton botonSubir = new JButton("Subir archivo");

        //Añadimos botones
        panelBotonesFile.add(botonElegirColor);
        panelBotonesFile.add(botonSubir);
        panelBotonesFile.add(botonGuardar);

        // Agregamos componentes al panel principal
        panelPrincipal.add(titulo);
        panelPrincipal.add(panelNombre);
        panelPrincipal.add(panelApellidos);
        panelPrincipal.add(panelBotonesSerializar);
        panelPrincipal.add(panelBotonesFile);

        //Añadimos una progressBar:
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(25);
        progressBar.setForeground(Color.red); // Color de el %
        progressBar.setBackground(Color.WHITE);
        progressBar.setStringPainted(true); // Muestra el número
        panelPrincipal.add(progressBar);

        //Añadimos panel principal y visualizamos
        frame.add(panelPrincipal);
        frame.setVisible(true);

        /**
         * *************************FileChooser**************************************
         */
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = filechooser.showOpenDialog(null);
                if (respuesta == JFileChooser.APPROVE_OPTION) {
                    destino = filechooser.getSelectedFile();

                    Path or = Paths.get(origen.getAbsolutePath());
                    Path des = Paths.get(destino.getAbsolutePath());

                    try {
                        Files.copy(or, des, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    System.out.println("Se ha cancelado la subida");
                }
            }
        });

        botonSubir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = filechooser.showOpenDialog(null);
                if (respuesta == JFileChooser.APPROVE_OPTION) {
                    origen = filechooser.getSelectedFile();

                } else {
                    System.out.println("Se ha cancelado la subida");
                }
            }
        });

        filechooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName().toLowerCase();
                return file.isDirectory() || name.endsWith(".png") || name.endsWith(".jpg");
            }

            @Override
            public String getDescription() {
                return "Archivos (.jpg, .png) y directorios";
            }
        });
        /**
         * ********************SERIALIZABLE*****************************
         */
        botonEscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoNombre = tfnombre.getText();
                String textoApellidos = tfapellidos.getText();

                try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personas.txt"));) {
                    Persona persona = new Persona(textoNombre, textoApellidos);
                    oos.writeObject(persona);

                    //borramos contenido
                    tfnombre.setText("");
                    tfapellidos.setText("");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        botonLeer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personas.txt"));) {

                    Persona persona = (Persona) ois.readObject();
                    tfnombre.setText(persona.getNombre());
                    tfapellidos.setText(persona.getApellidos());

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        botonElegirColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser colorChooser = new JColorChooser();
                Color color = colorChooser.getColor();

                //si es ok
                ActionListener okListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Color colorSeleccionado = colorChooser.getColor();
                        botonGuardar.setBackground(colorSeleccionado);
                    }
                };

                //si se cancela
                ActionListener cancelListener = (ActionEvent e1) -> {
                    System.out.println("Se ha cancelado elegir color");
                };

                JDialog dialogo = JColorChooser.createDialog(frame, "Elige un color", true, colorChooser, okListener, cancelListener);

                dialogo.setVisible(true);
            }
        });
    }

}
