package Controlador;

import Vista.vis_Principal;
import Vista.vis_Login;
import Vista.vis_jif_Pacientes;
import Vista.vis_jif_cliente;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ctrl_Principal implements MouseListener, ActionListener {

    vis_Principal principal;

    public ctrl_Principal(vis_Principal principal) {
        this.principal = principal;
        this.principal.lblPacientes.addMouseListener(this);
        this.principal.lblCliente.addMouseListener(this);
        this.principal.lblCerrarSesion.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.principal.lblPacientes) {
            vis_jif_Pacientes pacientes = new vis_jif_Pacientes();
            try {
                ctrl_pacientes c_pacientes = new ctrl_pacientes(pacientes);
            } catch (SQLException ex) {
                Logger.getLogger(ctrl_Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.principal.jp_Contenedor.add(pacientes);
            pacientes.setVisible(true);

        } else if (e.getSource() == this.principal.lblCerrarSesion) {
            vis_Login login = new vis_Login();
            ctrl_Login c_login = new ctrl_Login(login);
            login.setVisible(true);
            this.principal.dispose();

        } else if (e.getSource() == this.principal.lblCliente) {
            try {
                vis_jif_cliente v_cli = new vis_jif_cliente();
                ctrl_cliente c_cli = new ctrl_cliente (v_cli);
                this.principal.jp_Contenedor.add(v_cli);
                v_cli.setVisible(true);

            } catch (SQLException ex) {
                Logger.getLogger(ctrl_Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
