
package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author orihime
 */
 //public static void main(String[] args) {
public class Conectar {
   
   
    
    public static void  conexion(){
        Connection conect= null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            System.out.println("Driver ODBC cargado");
            conect= DriverManager.getConnection("jdbc:mysql://localhost/biblioteca","root","");
            System.out.println("Conexion realizada con la base de datos");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error"+e);
        } 
    }
    
    
}


