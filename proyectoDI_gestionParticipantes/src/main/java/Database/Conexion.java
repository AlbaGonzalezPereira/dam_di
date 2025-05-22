package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase que se va a encargar de realizar la conexión a la base de datos y el cierre de la misma
 * @author alba_
 */
public class Conexion {
    private static Connection con = null;//establecemos la conexión a null
    
    /**
     * método para establecer la conexión
     * @return - Connection
     */
    public static Connection openConnection(){
        try {
            //creamos la variable url
            String url = "jdbc:mysql://localhost/proyectodi?allowPublicKeyRetrieval=true&useSSL=false";
            con = DriverManager.getConnection(url, "root", "");//facemos a conexión
            System.out.println("Conexión creada");//comprobamos que hace la conexión
            //con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con; //devolvemos a conexión
    }
    
    /**
     * método para cerrar la conexión
     */
    public static void closeConnection(){
        try {
            if (con != null) { //comprobamos si la conexión no es null
                con.close(); //cerramos la conexión
                con = null; //asignamos null al obxecto Connection
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}