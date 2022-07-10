package Controlador;

import Modelo.mod_Login;
import Vista.vis_Login;
import Vista.vis_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ctrl_Login implements ActionListener {

    vis_Login login;
    mod_Login m_login = new mod_Login();

    public ctrl_Login(vis_Login _login) {
        this.login = _login;
        this.login.btnIniciar.addActionListener(this);
        this.login.btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.login.btnIniciar) {
            try {
                int aux = 0;
                m_login.usuario = this.login.txtUsuario.getText();
                m_login.contrasena = this.login.txtContrasena.getText();

                ResultSet rs = m_login.consultarUsuario();
                
                while( rs.next() ) {
                    aux = 1;
                }
                
                if ( aux == 1 ) {
                    vis_Principal prin = new vis_Principal();
                    ctrl_Principal c_prin = new ctrl_Principal(prin);
                    prin.setVisible(true);
                    this.login.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(login, "Acceso Denegado.");
                }
                    
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(login, "Error al buscar el usuario y/o contraseña.");
            }
        }
        if (e.getSource() == this.login.btnSalir) {
            int resp = JOptionPane.showConfirmDialog(login, "¿Está seguro que desea salir del programa?");
            if (resp == 0) {
                System.exit(resp);
            }
        }
    }

}
