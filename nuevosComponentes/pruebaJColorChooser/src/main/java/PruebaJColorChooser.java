import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author alba_
 */
public class PruebaJColorChooser {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JColorChooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        //Creamos un panel y un botón
        JPanel panel = new JPanel();
        JButton elegir = new JButton("Elige un color");
        
        /**
         * cuando se pulse el botón aparecerá un JColorChooser, que nos permitirá modificar el color del panel
         */
        elegir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser colorChooser = new JColorChooser();
                Color c = colorChooser.getColor();
                
                ActionListener okListener = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //si se hace clic en Aceptar
                        Color colorSeleccionado = colorChooser.getColor();
                        panel.setBackground(colorSeleccionado);
                    }
                };
                
                //si se cancela
                ActionListener cancelListener = (ActionEvent e1) ->{
                    System.out.println("Se ha cancelado la elección del color");
                };
                
                //creamos el cuadro de diálogo
                JDialog dialogo =JColorChooser.createDialog(frame, "Elige un color", true, colorChooser, okListener, cancelListener);
                
                //mostramos el cuadro de diálogo
                dialogo.setVisible(true);
            }
        });
        
        panel.add(elegir);
        frame.add(panel);
        frame.setVisible(true);
    }
}
