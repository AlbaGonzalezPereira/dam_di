
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author alba_
 */
public class Formulario extends JFrame {

    public Formulario() throws HeadlessException {
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lbTitulo = new JLabel("Formulario");
        lbTitulo.setFont(new java.awt.Font("Calibri", 1, 22));
        gbc.gridx = 0; // columna
        gbc.gridy = 0; // fila
        gbc.insets = new Insets(10, 10, 10, 10); // margen
        this.add(lbTitulo, gbc);

        JLabel lbNombre = new JLabel("Nombre");
        gbc.gridx = 0; // columna
        gbc.gridy = 1; // fila
        gbc.insets = new Insets(10, 10, 10, 10); // margen
        this.add(lbNombre, gbc);

        //JTextField nombre = new JTextField();
        TextFieldPersonalizado nombre = new TextFieldPersonalizado(15, Color.MAGENTA);
        gbc.gridx = 1; // columna
        gbc.gridy = 1; // fila
        gbc.insets = new Insets(10, 10, 10, 10); // margen
        this.add(nombre, gbc);

        JLabel lbEdad = new JLabel("Edad");
        gbc.gridx = 0; // columna
        gbc.gridy = 2; // fila
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(lbEdad, gbc);

        TextFieldPersonalizado edad = new TextFieldPersonalizado(15, Color.magenta);
        gbc.gridx = 1; // columna
        gbc.gridy = 2; // fila
        gbc.insets = new Insets(10, 10, 10, 10); // margen
        this.add(edad, gbc);

        JButton botonColor = new JButton("Selecciona un color");
        botonColor.setBackground(Color.green);
        gbc.gridx = 0; // columna
        gbc.gridy = 3; // fila
        gbc.insets = new Insets(10, 10, 10, 10); // margen
        this.add(botonColor, gbc);

        JButton botonGuardar = new JButton("Guardar datos");
        botonGuardar.setBackground(Color.yellow);
        gbc.gridx = 1; // columna
        gbc.gridy = 3; // fila
        gbc.insets = new Insets(10, 10, 10, 10); // margen
        this.add(botonGuardar, gbc);

        JButton botonCargar = new JButton("Cargar datos");
        botonCargar.setBackground(Color.orange);
        gbc.gridx = 2; // columna
        gbc.gridy = 3; // fila
        gbc.insets = new Insets(10, 10, 10, 10); // margen
        this.add(botonCargar, gbc);

        JFrame frame = this;

        botonColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser colorChooser = new JColorChooser();

                //creamos un okListener (del dialogo)
                ActionListener ok = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Color colorElegido = colorChooser.getColor();
                        nombre.setColorFondo(colorElegido);
                        edad.setColorFondo(colorElegido);
                    }
                };

                //creamos el cancelarListener (cancelar del dialogo)
                ActionListener cancelar = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Selección cancelada");
                    }
                };

                //Creamos el diálogo para que elija un color:
                // JDialog dialogoColor = JColorChooser.createDialog(null, "Elige un color", true, colorChooser, ok, cancelar);
                JDialog dialogoColor = JColorChooser.createDialog(frame, "Elige un color", true, colorChooser, ok, cancelar);
                //visibilizamos el diálogo:
                dialogoColor.setVisible(true);
            }
        });
        this.setVisible(true);

        //evento del botón guardar que va a guardar los valores de los textField en un fichero:
//        botonGuardar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //guardamos los datos recogidos de los textField en un objeto de la clase Datos
//                Datos datos = new Datos(nombre.getText(), Integer.parseInt(edad.getText()));
//                try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("datosRecogidos.txt")));) {
//                    oos.writeObject(datos); //escribimos el objeto en el archivo
//
//                    //limpiamos los textField para que no aparezcan los datos después de guardarse:
//                    nombre.setText("");
//                    edad.setText("");
//                } catch (IOException ex) {
//                    Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        });
////evento del botón cargar: carga los datos guardados del formulario:
//        botonCargar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("datosRecogidos.txt")));) {
//                    Datos datosLeidos = (Datos) ois.readObject(); //leemos el objeto y lo guardamos en una variable. Hacemos un cast
//                    //los cargamos en su textfield
//                    nombre.setText(datosLeidos.getValorNombre());
//                    edad.setText(String.valueOf(datosLeidos.getValorEdad())); //pasamos el int a String
//
//                } catch (IOException ex) {
//                    Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//con el JFileChooser para que nos diga donde guardarlos:
        JFileChooser filechooser = new JFileChooser(); //creamos un filechooser
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //abrimos un diálogo para guardar
                int respuesta = filechooser.showSaveDialog(null);//muestra un popup de guardar
                File archivo = null; //creamos el file
                if (respuesta == JFileChooser.APPROVE_OPTION) { //si le dio a aceptar
                    archivo = filechooser.getSelectedFile(); //recogemos lo que devuelve el filechooser en un File     
                    //guardamos los datos recogidos de los textField en un objeto de la clase Datos
                    Datos datos = new Datos(nombre.getText(), Integer.parseInt(edad.getText()));
                    try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));) {
                        oos.writeObject(datos); //escribimos el objeto en el archivo

                        //limpiamos los textField para que no aparezcan los datos después de guardarse:
                        nombre.setText("");
                        edad.setText("");
                    } catch (IOException ex) {
                        Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });

        //evento del botón cargar: carga los datos guardados del formulario:
        botonCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 int respuesta = filechooser.showOpenDialog(null);//muestra un popup de abrir diálogo
                File archivo = null; //creamos el file
                if (respuesta == JFileChooser.APPROVE_OPTION) { //si le dio a aceptar
                    archivo = filechooser.getSelectedFile(); //recogemos lo que devuelve el filechooser en un File     
                try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));) {
                    Datos datosLeidos = (Datos) ois.readObject(); //leemos el objeto y lo guardamos en una variable. Hacemos un cast
                    //los cargamos en su textfield
                    nombre.setText(datosLeidos.getValorNombre());
                    edad.setText(String.valueOf(datosLeidos.getValorEdad())); //pasamos el int a String

                } catch (IOException ex) {
                    Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
        });
    }

}
