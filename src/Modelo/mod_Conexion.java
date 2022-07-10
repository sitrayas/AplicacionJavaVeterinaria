package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class mod_Conexion {

    public Connection conectarBD() {
        try {
            //Conectandome a la base de datos
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pvbd",
                    "postgres",
                    "root");
            return conn;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos: " + ex);
            return null;
        }
    }
}




