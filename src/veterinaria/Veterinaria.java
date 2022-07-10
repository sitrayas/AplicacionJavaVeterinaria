package veterinaria;

import Controlador.ctrl_Login;
import Vista.vis_Login;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Veterinaria {

    public static void main(String[] args) {
                                
        vis_Login login = new vis_Login();
        ctrl_Login ctrl = new ctrl_Login(login);
        login.setVisible(true);
    }
}
