package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mod_Login {
    public String usuario;
    public String contrasena;
    
    mod_Conexion conexion = new mod_Conexion();

    public ResultSet consultarUsuario() throws SQLException {
        Statement st = conexion.conectarBD().createStatement();
        String sql = "SELECT * FROM usuarios WHERE "
                + "usr_usuario = '" + this.usuario + "'"
                + "and usr_password = '" + this.contrasena + "'";
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
}
