
package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class mod_medicamento {
    public String nombre, fecha_ingreso, fecha_vencimiento;
    public int   id_tipo_med, id_bodega;
    public double precio_unit , existencia;
    mod_Conexion conexion = new mod_Conexion();
    
    public boolean registroMedicamento(){
        try {
            Statement st=conexion.conectarBD().createStatement();
            String sql = "INSERT INTO public.medicamentos(id_bodega, id_tipo_med, nombre, fecha_ingreso, fecha_vencimiento, precio_unit, existencia) VALUES ("+this.id_bodega+", "+this.id_tipo_med+", '"+this.nombre+"', '"+this.fecha_ingreso+"', '"+this.fecha_vencimiento+"', "+this.precio_unit+", "+this.existencia+");";
            st.executeUpdate(sql);
            //cambio abajo
            System.out.println("Datos ingresados correctamente");
            st.close();
             return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
            
            return false;
        }}
        
    public ResultSet consultarMedicamento() {
        try {
            Statement st = conexion.conectarBD().createStatement();
            String sql = "SELECT id_medicamento, id_bodega, id_tipo_med, nombre, fecha_ingreso, fecha_vencimiento, precio_unit, existencia FROM medicamentos;";
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
            return null;
        }
    }

    public ResultSet buscarMedicamento() throws SQLException {
        Statement st = conexion.conectarBD().createStatement();
        String sql = "SELECT id_medicamento, id_bodega, id_tipo_med, nombre, fecha_ingreso, fecha_vencimiento, precio_unit, existencia FROM medicamentos WHERE nombre LIKE '" + this.nombre + "%'";
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

    public ResultSet tipoMedicamento() throws SQLException {
        Statement st = conexion.conectarBD().createStatement();
        String sql = "SELECT nombre FROM tipo_medicamento";
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
    
    public ResultSet idBodega() throws SQLException {
        Statement st = conexion.conectarBD().createStatement();
        String sql = "SELECT nombre FROM bodegas";
        ResultSet rs = st.executeQuery(sql);
        return rs;

  
        }}

