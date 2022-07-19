
package Controlador;
import Modelo.mod_Conexion;
import Modelo.mod_cliente;
import Vista.vis_jif_cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//author SITRAYAS
 
public class ctrl_cliente implements ActionListener {
    
    
    vis_jif_cliente pacientes;
    mod_cliente conexion = new mod_cliente();
    
   public ctrl_cliente(vis_jif_cliente pacientes) throws SQLException {
        
        this.pacientes=pacientes;
        this.pacientes.btn_guardar_cliente.addActionListener((ActionListener) this);
        this.pacientes.btn_buscar_cliente.addActionListener((ActionListener) this);
     // this.pacientes.btn_seleccionar_cliente.addActionListener(this);
        tablac();
      //llenarComboCliente();
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.pacientes.btn_guardar_cliente) {
            
          //conexion.id_cliente=this.pacientes.txt_identificacion_cliente.getText();
            conexion.nombre=this.pacientes.txt_nombre_cliente.getText();
            conexion.num_identificacion=this.pacientes.txt_num_identificacion_cliente.getText();
          //conexion.estado_civil=this.pacientes.cb_estado_civil_cliente.getText();
            conexion.sexo=this.pacientes.txt_sexo_cliente.getText();
            conexion.estado=this.pacientes.txt_estado_cliente.getText();
            conexion.tipo_identificacion=this.pacientes.cb_tipo_identificacion_cliente.getSelectedItem().toString();
            conexion.tipo_cliente=this.pacientes.cb_tipo_clientes.getSelectedItem().toString();
            boolean datos = conexion.registroCliente();
            
            if (datos==true) {
                JOptionPane.showMessageDialog(pacientes, "Se registro correctamente");
                tablac();
            }else {
                JOptionPane.showMessageDialog(pacientes, "No se pudo registrar");
            }
        }  
       
           if (e.getSource()== this.pacientes.btn_buscar_cliente){
               try{ 
            DefaultTableModel tablac = (DefaultTableModel) this.pacientes.tablacliente.getModel();
            tablac.setColumnCount(0);
            tablac.setRowCount(0);
            tablac.addColumn("Id_cliente");
            tablac.addColumn("Nombre");
            tablac.addColumn("Tipo de Identificacion");
            tablac.addColumn("Numero de Identificacion");
            tablac.addColumn("Estado Civil");
            tablac.addColumn("Estado");
           
            
            conexion.nombre = this.pacientes.txt_buscar_cliente.getText();
            ResultSet rs= conexion.buscarCliente();
            String[] registroCliente = new String [6];
               
             while (rs.next()) {     
                 registroCliente[0]=rs.getString("id_cliente");
                 registroCliente[1]=rs.getString("nombre");
                 registroCliente[2]=rs.getString("tipo_identificacion");
                 registroCliente[3]=rs.getString("num_identificacion");
                 registroCliente[4]=rs.getString("estado_civil");
                 registroCliente[5]=rs.getString("estado");
                tablac.addRow(registroCliente);
            }
             } catch (SQLException ex) {
                   JOptionPane.showMessageDialog( pacientes, " Error a buscar paciente");
               }
            
               }else if (e.getSource()==this.pacientes.btn_selecccionar_cliente){
                  if (this.pacientes.tablacliente.getSelectedRowCount () == 1){
                     int fila= this.pacientes.tablacliente.getSelectedRow();
                    
//                                
                    pacientes.txt_nombre_cliente.setText(this.pacientes.tablacliente.getValueAt(fila,0).toString());
                  // pacientes.cb_tipo_identificacion_cliente.setText(this.pacientes.tablacliente.getValueAt(fila, 1).toString());
                    pacientes.txt_num_identificacion_cliente.setText(this.pacientes.tablacliente.getValueAt(fila,2).toString());
                 //  pacientes.cb_estado_civil_cliente.setText(this.pacientes.tablacliente.getValueAt(fila,3).toString());
                    pacientes.txt_estado_cliente.setText(this.pacientes.tablacliente.getValueAt(fila,4).toString());
                   //pacientes.txt_fecha_nac.setText(this.pacientes.tablacliente.getValueAt(fila,5).toString());
                  
                  }
               }
           }

            
    
    public void tablac(){
                try {
            mod_cliente modCl = new mod_cliente();
            DefaultTableModel tablac = (DefaultTableModel) this.pacientes.tablacliente.getModel();
            tablac.setColumnCount(0);
            tablac.setRowCount(0);
            
            
            tablac.addColumn("id_cliente");
            tablac.addColumn("Nombre");
            tablac.addColumn("Tipo Identificacion");
            tablac.addColumn("Numero Identificacion");
            tablac.addColumn("Estado Civil");
            tablac.addColumn("Estado");
            //tablac.addColumn("F.nac");
            
            ResultSet rs=modCl.consultarCliente();
            String[] registroCliente = new String [6];
               
             while (rs.next()) {     
                 registroCliente[0]=rs.getString("id_cliente");
                 registroCliente[1]=rs.getString("nombre");
                 registroCliente[2]=rs.getString("tipo_identificacion");
                 registroCliente[3]=rs.getString("num_identificacion");
                 registroCliente[4]=rs.getString("estado_civil");
                 registroCliente[5]=rs.getString("estado");
               
                 
                tablac.addRow(registroCliente);
            }
                    } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    }
    
//    public void llenarComboCliente() throws SQLException {
//        ResultSet rs = conexion.consultarCliente();
//        
//        while ( rs.next()){
//            this.pacientes.cb_cliente.addItem(rs.getString("pac_especie"));
//        }
//        
//        
//    }
}


