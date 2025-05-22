package principal;

import DAO.Activa;
import DAO.AulaDAO;
import Database.Conexion;
import entidades.Aula;
import pantallas.PantallaPrincipal;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pantallas.PantallaGrupos;
import pantallas.PantallaLugares;
import pantallas.PantallaParticipantes;

/**
 *
 * @author alba_
 */
public class Principal {

    public static void main(String[] args) {

        //creamos la conexión
        try ( Connection con = Conexion.openConnection()) {//creamos a conexión 
            crearInicio(); //creamos el inicio
            //comprobaciones:
//            Aula aula = new Aula("Poio", Activa.SI, "2022", 120);
//            AulaDAO aulaDao = new AulaDAO();
//            System.out.println(aulaDao.getAll());
//            aulaDao.add(aula);
        } catch (Exception ex) {
            System.out.println("Error en la conexión" + ex.getMessage());
        }

    }

    private static void crearInicio() {

        //Creamos el frame principal
        JFrame frame = new JFrame("Aplicación seguridad vial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        //Creamos el CardLayout:
        CardLayout cardlayout = new CardLayout();
        JPanel principal = new JPanel(cardlayout); //panel principal

        //Creamos los paneles del cardlayout por cada pantalla activa
        PantallaPrincipal panelPrincipal = new PantallaPrincipal();
        PantallaParticipantes panelParticipante = new PantallaParticipantes();
        PantallaGrupos panelGrupos = new PantallaGrupos();
        PantallaLugares panelLugares = new PantallaLugares();

        principal.add(panelPrincipal, "Inicio");
        principal.add(panelParticipante, "Participantes");
        principal.add(panelGrupos, "Grupos");
        principal.add(panelLugares, "Lugares");

        // Nombres de los botones
        String[] nombresBotones = {"Participantes", "Grupos", "Lugares"};

        // Creamos el array de botones
        JButton[] botones = new JButton[nombresBotones.length];

        // Inicializamos cada botón en el array
        for (int i = 0; i < nombresBotones.length; i++) {
            botones[i] = new JButton(nombresBotones[i]);
        }

        // Añadimos las propiedades:
        for (int i = 0; i < 3; i++) {
            botones[i].setBackground(new java.awt.Color(69, 123, 157));
            botones[i].setFont(new java.awt.Font("Reem Kufi", 1, 15));
            botones[i].setForeground(new java.awt.Color(241, 250, 238));
            botones[i].setPreferredSize(new Dimension(130, 40));

            // Capturamos una referencia local al botón actual
            JButton botonMenu = botones[i];

            // añadimos evento para que cuando hagamos hover, cambie el color
            botonMenu.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    botonMenu.setBackground(new java.awt.Color(29, 53, 87));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    botonMenu.setBackground(new java.awt.Color(69, 123, 157));
                }
            });
        }

        //Agregamos los eventos para los botones:
        botones[0].addActionListener((e) -> {
            frame.setSize(800, 800);
            cardlayout.show(principal, "Participantes");
        });

        botones[1].addActionListener((e) -> {
            cardlayout.show(principal, "Grupos");
        });

        botones[2].addActionListener((e) -> {
            frame.setSize(800, 600);
            cardlayout.show(principal, "Lugares");
        });

        // Creamos el panel de encabezado
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBackground(new Color(0xa8dadc));
        //encabezado.setPreferredSize(new Dimension(800, 100));

        // Panel izquierdo para el logo
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(new Color(0xa8dadc));
        JLabel logo = new JLabel(new ImageIcon("logo.png"));
        ImageIcon imagenOriginal = new ImageIcon("logo.png");
        Image imagenModificada = imagenOriginal.getImage().getScaledInstance(100, 40, Image.SCALE_SMOOTH);
        ImageIcon imagenFinal = new ImageIcon(imagenModificada);
        logo.setIcon(imagenFinal);
        panelLogo.add(logo);

        // Añadimos un evento de clic al logo
        logo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardlayout.show(principal, "Inicio");
            }
        });

        // Panel el título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.LINE_AXIS));
        panelTitulo.setBackground(new Color(0xa8dadc));
        JLabel titulo = new JLabel("Ponte a Conducir");
        //titulo.setAlignmentY(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("Reem Kufi", Font.BOLD, 22));
        // Ajustamos márgenes del título para separar logo de botones
        titulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20)); // Margen izquierdo y derecho
        panelTitulo.add(titulo);

        //creamos el panel de los botones:
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(0xa8dadc));

        for (int i = 0; i < 3; i++) {
            panelBotones.add(botones[i]);

        }

        // Añadimos los elementos creados al encabezado
        encabezado.add(panelLogo, BorderLayout.WEST);
        encabezado.add(panelTitulo, BorderLayout.CENTER);
        encabezado.add(panelBotones, BorderLayout.EAST);

        //Panel footer
        JPanel pie = new JPanel(new BorderLayout());
        pie.setBackground(new Color(0xa8dadc));
        pie.setPreferredSize(new Dimension(800, 35));
        JLabel autora = new JLabel("© Alba González 2025");
        autora.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));
        pie.add(autora);

        //Agregamos los paneles
        frame.setLayout(new BorderLayout());
        frame.add(principal, BorderLayout.CENTER);
        frame.add(encabezado, BorderLayout.NORTH);
        frame.add(pie, BorderLayout.SOUTH);

        //Mostramos la ventana
        frame.setVisible(true);

    }

}
