package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//@author SITRAYAS-LENOVO
public class mod_cliente {

    public String nombre, num_identificacion, estado_civil, estado;
    public int tipo_identificacion, tipo_cliente;
    
    mod_Conexion conexion = new mod_Conexion();
    public String sexo;

    public boolean registroCliente() {
        try {
            Statement st = conexion.conectarBD().createStatement();
            String sql = "INSERT INTO public.clientes(nombre, tipo_identificacion, num_identificacion, tipo_cliente, estado_civil, estado) VALUES ('" + this.nombre + "', '" + this.tipo_identificacion + "', '" + this.num_identificacion + "', '" + this.tipo_cliente + "', '" + this.estado_civil + "', '" + this.estado + "');";
            st.executeUpdate(sql);

            System.out.println("Datos ingresados correctamente");
            st.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
            return false;
        }

    }

    public ResultSet consultarCliente() {
        try {
            Statement st = conexion.conectarBD().createStatement();
            String sql = "SELECT id_cliente, nombre, tipo_identificacion, num_identificacion, tipo_cliente, estado_civil, estado FROM clientes;";
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
            return null;
        }
    }

    public ResultSet buscarCliente() throws SQLException {
        Statement st = conexion.conectarBD().createStatement();
        String sql = "SELECT id_cliente, nombre, tipo_identificacion, num_identificacion, tipo_cliente, estado_civil, estado FROM clientes WHERE pac_nombre LIKE '" + this.nombre + "%'";
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

    public ResultSet tipoCliente() throws SQLException {
        Statement st = conexion.conectarBD().createStatement();
        String sql = "SELECT nombre FROM tipos_cliente";
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

    public ResultSet tipoIdentificacion() throws SQLException {
        Statement st = conexion.conectarBD().createStatement();
        String sql = "SELECT nombre FROM tipos_identificacion";
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
}
