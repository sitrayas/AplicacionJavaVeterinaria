package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class mod_Pacientes {
    public String nombre, especie, color, sexo, raza, fecNac;
    public int edad;
    
    mod_Conexion conexion = new mod_Conexion();
    
    public boolean regP(){
        try {
            Statement st=conexion.conectarBD().createStatement();
            String sql = "insert into pacientes (pac_nombre, pac_edad, pac_sexo, pac_especie, pac_raza, pac_color, pac_fecha_nac) values ('" + this.nombre + "', '" + this.edad + "', '" + this.sexo + "', '" + this.especie + "', '" + this.raza+ "', '" + this.color + "', '" + this.fecNac + "');";
            st.executeUpdate(sql);
            //cambio abajo
            System.out.println("Datos ingresados correctamente");
            st.close();
             return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
            
            return false;
        } 
        }
    
    public ResultSet consultas(){
        try {
            Statement st=conexion.conectarBD().createStatement();
            String sql ="SELECT pac_nombre, pac_edad, pac_sexo, pac_especie, pac_raza, pac_color, pac_fecha_nac FROM pacientes";
            ResultSet rs=st.executeQuery(sql);
            return rs;
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Error: "+ex);
            return null;
        }
    } 
    
        public ResultSet consultarEspecie(){
        try {
            Statement st=conexion.conectarBD().createStatement();
            String sql ="SELECT pac_nombre, pac_edad, pac_sexo, pac_especie, pac_raza, pac_color, pac_fecha_nac FROM pacientes";
            ResultSet rs=st.executeQuery(sql);
            return rs;
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Error: "+ex);
            return null;
    }
    public ResultSet buscarPaciente() throws {
        try {
            Statement st=conexion.conectarBD().createStatement();
            String sql ="SELECT pac_nombre, pac_edad, pac_sexo, pac_especie, pac_raza, pac_color, pac_fecha_nac FROM pacientes";
            ResultSet rs=st.executeQuery(sql);
            return rs;
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Error: "+ex);
            return null;
}}}
