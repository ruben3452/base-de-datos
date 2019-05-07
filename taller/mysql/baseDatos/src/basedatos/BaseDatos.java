
package basedatos;

import javax.swing.JFrame;

/**
 *
 * @author orihime
 */
public class BaseDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Conectar conexion =new Conectar();
        conexion.conexion();
        
     // NuevaVentana v=new NuevaVentana();
	//	v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	v.setVisible(true);
         graficoBibli graphs1 = new graficoBibli ();
    graphs1.setVisible(true);
    graphs1.setLocationRelativeTo(null);
        
    }
    
}
