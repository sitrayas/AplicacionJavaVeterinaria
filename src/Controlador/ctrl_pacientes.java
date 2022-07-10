package Controlador;

import Modelo.mod_Conexion;
import Modelo.mod_Pacientes;
import Vista.vis_jif_Pacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ctrl_pacientes implements ActionListener{

    vis_jif_Pacientes pacientes;
    mod_Pacientes conexion = new mod_Pacientes();
    
   public ctrl_pacientes(vis_jif_Pacientes pacientes) {
        
        this.pacientes=pacientes;
        tabla();
        llenarComboEspecies();
   
        
        this.pacientes.btn_guardar.addActionListener(this);
        
        //this.pacientes.btn_salir.addActionListener(this);
       // this.pacientes.btn_eliminar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.pacientes.btn_guardar) {
            
            conexion.color=this.pacientes.txt_color.getText();
           // conexion.especie=this.pacientes.txt_especie.getText();
            conexion.fecNac=this.pacientes.txt_fecha_nac.getText();
            conexion.nombre=this.pacientes.txt_nombre.getText();
            conexion.raza=this.pacientes.txt_raza.getText();
            conexion.sexo=this.pacientes.txt_sexo.getText();
            conexion.edad=Integer.parseInt(this.pacientes.txt_edad.getText());
            
            boolean datos = conexion.regP();
            
            if (datos==true) {
                JOptionPane.showMessageDialog(this.pacientes, "Se registro correctamente");
                tabla();
            }else {
                JOptionPane.showMessageDialog(this.pacientes, "No se pudo registrar");
            }
        }
        if (e.getSource()== this.pacientes.btn_buscar_paciente){
            
            
        
        }
       
    }
    
    public void tabla(){
                try {
            mod_Pacientes modP = new mod_Pacientes();
            DefaultTableModel tablapac = (DefaultTableModel) this.pacientes.tabla_pacientes.getModel();
            tablapac.setColumnCount(0);
            tablapac.setRowCount(0);
            
            
            tablapac.addColumn("Nombre");
            tablapac.addColumn("Edad");
            tablapac.addColumn("Sexo");
            tablapac.addColumn("Especie");
            tablapac.addColumn("Raza");
            tablapac.addColumn("Color");
            tablapac.addColumn("F.nac");
            
            ResultSet rs=modP.consultas();
            String regP []= new String [7];
            
            while (rs.next()) {     
                
                regP[0]=rs.getString("pac_nombre");
                regP[1]=rs.getString("pac_edad");
                regP[2]=rs.getString("pac_sexo");
                regP[3]=rs.getString("pac_especie");
                regP[4]=rs.getString("pac_raza");
                regP[5]=rs.getString("pac_color");
                regP[6]=rs.getString("pac_fecha_nac");
                tablapac.addRow(regP);
            }
                    } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    }
    
    
    
    
    public void llenarComboEspecies ()throws SQLException {
        ResultSet rs = conexion.consultarEspecies();
        
        while ( rs.next()){
            this.pacientes.cb_especie.addItem(rs.getString("tipo_paciente"));
        }
        
        
    }
}