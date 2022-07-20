
package Controlador;
import Modelo.mod_Conexion;
import Modelo.mod_medicamento;
import Vista.vist_jif_medicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

 //@author SITRAYAS-LENOVO
 
public class ctrl_medicamento implements ActionListener {
    
    vist_jif_medicamento medicamentos;
    mod_medicamento conexion = new mod_medicamento();
    
     public ctrl_medicamento(vist_jif_medicamento medicamento) throws SQLException {
      this.medicamentos=medicamento;
        this.medicamentos.btn_guardar_medicamento.addActionListener((ActionListener) this);
        tipoMedicamentos();
        nBodega();      
     }
     
         public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.medicamentos.btn_guardar_medicamento) {
            
         
            conexion.nombre=this.medicamentos.txt_nombre_medicamento.getText();
            conexion.fecha_ingreso=this.medicamentos.txt_ingreso_medicamento.getText();
            conexion.fecha_vencimiento=this.medicamentos.txt_vencimiento_medicamento.getText();
            conexion.precio_unit=Double.parseDouble(this.medicamentos.txt_precio_medicamento.getText());
            conexion.existencia=Double.parseDouble(this.medicamentos.txt_existencia_medicamento.getText());
            conexion.id_tipo_med=this.medicamentos.cb_tipo_medicamento.getSelectedIndex();
            conexion.id_bodega=this.medicamentos.cb_bodega_medicamento.getSelectedIndex();
            
            boolean datos = conexion.registroMedicamento();
            
            if (datos==true) {
                JOptionPane.showMessageDialog(medicamentos, "Se registro correctamente");
               // tablamed();
            }else {
                JOptionPane.showMessageDialog(medicamentos, "No se pudo registrar");
            }
        }

}
         public void tipoMedicamentos() throws SQLException {
        ResultSet rs = conexion.tipoMedicamento();
        while (rs.next()) {
            this.medicamentos.cb_tipo_medicamento.addItem(rs.getString(1));
        }
         }
         public void nBodega() throws SQLException {
        ResultSet rs = conexion.idBodega();
        while (rs.next()) {
            this.medicamentos.cb_bodega_medicamento.addItem(rs.getString(1));
        }
    }
         
         
}
