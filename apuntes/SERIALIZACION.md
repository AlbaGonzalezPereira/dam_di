# PERSISTENCIA DE COMPONENTES
A veces, necesitamos almacenar el estado de una clase para que perdure a través del tiempo. A esta característica se le llama **persistencia**. Para implementar esto, es necesario que pueda ser almacenada en un archivo y recuperado posteriormente.

El mecanismo que implementa la persistencia se llama **serialización**.

Al proceso de almacenar el estado de una clase en un archivo se le llama **serializar**. Al de recuperarlo después **deserializar**.

Todos Los componentes deben persistir. Para ello, siempre desde el punto de vista Java, deben implementar las interfaces **``java.io.Serializable``** o **``java.io.Externalizable``** que te ofrecen la posibilidad de serialización automática o de programarla según necesidad.

- **Serialización Automática**: el componente implementa la interfaz **Serializable** que proporciona serialización automática mediante la utilización de las herramientas de ``Java Object Serialization``.

    Para poder usar la interfaz serializable debemos tener en cuenta lo siguiente:
    - Las clases que implementan Serializable deben tener un **constructor sin argumentos** que será llamado cuando un objeto sea "reconstituido" desde un fichero ``.ser``.
    - Todos los **campos** excepto static y transient son **serializados**.
    - Se puede programar una **serialización propia** si es necesario implementando los siguientes métodos:
        - ``private void writeObject(java.io.ObjectOutputStream out) throws IOException;``
        - ``private void readObject(java.io.ObjectInputStream in) throws IOExcept;``

- **Serialización programada**: el componente implementa la interfaz Externalizable y sus dos métodos para guardar el componente con un formato específico. Características:
Precisa de la implementación de los métodos readExternal() y writeExternal().
Las clases Externalizable también deben tener un constructor sin argumentos.

## Ejemplo de código:

**``Data.java``**:

```java
package pantallas;

import java.io.Serializable;

/**
 *
 * @author alba_
 */
public class Data implements Serializable{
    private String lugar;
    private String activo;
    private String edicion;
    private int maxParticipantes;

    public Data() {
    }

    public Data(String lugar, String activo, String edicion, int maxParticipantes) {
        this.lugar = lugar;
        this.activo = activo;
        this.edicion = edicion;
        this.maxParticipantes = maxParticipantes;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public int getMaxParticipantes() {
        return maxParticipantes;
    }

    public void setMaxParticipantes(int maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }

    @Override
    public String toString() {
        return "Data{" + "lugar=" + lugar + ", activo=" + activo + ", edicion=" + edicion + ", maxParticipantes=" + maxParticipantes + '}';
    }  
}

```

```java
public class PantallaLugares extends JPanel implements Serializable {

    public PantallaLugares() {
        //Establecemos un borde vacío para dejar márgenes
        this.setBorder(BorderFactory.createEmptyBorder(0, 90, 0, 90));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10, 10, 10);

        /*  ...resto código...  */
        

        //Panel botones 
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.setBackground(Color.WHITE);
        Dimension tamanhoBoton = new Dimension(120, 40);

        //Botón Escribir
        JButton botonEscribir = new JButton("Escribir");
        botonEscribir.setFont(new Font("Reem Kufi", Font.BOLD, 14));
        botonEscribir.setBackground(new Color(58, 110, 165));
        botonEscribir.setForeground(Color.WHITE);
        botonEscribir.setPreferredSize(tamanhoBoton);
        panelBotones.add(botonEscribir);

        //Botón Leer
        JButton botonLeer = new JButton("Leer");
        botonLeer.setFont(new Font("Reem Kufi", Font.BOLD, 14));
        botonLeer.setBackground(new Color(192, 192, 192));
        botonLeer.setForeground(Color.WHITE);
        botonLeer.setPreferredSize(tamanhoBoton);
        panelBotones.add(botonLeer);

        fgbc.gridx = 0;
        fgbc.gridy = 4;
        fgbc.gridwidth = 2;
        fgbc.anchor = GridBagConstraints.CENTER;
        panelFormulario.add(panelBotones, fgbc);


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
```