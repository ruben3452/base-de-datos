

package basedbiblioteca;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
by rbn
 */
public class leerEscribir {
   // funcion escribe en un txt
    public void escribirtxt(String rutax, String cadenax) {
       
    File archivo=new File(rutax);
        try{
            
            FileWriter escribirtxt = new FileWriter(archivo, true); 
            BufferedWriter rf = new BufferedWriter(escribirtxt);
            rf.write(cadenax);
            archivo.delete();
            rf.newLine();
            rf.close();
        }catch(Exception e){
            System.out.println("Error E/S: "+e);
        }
    }
    //lee un txt
    public String leert(String rutax) {
        ArrayList array = new ArrayList();
        String linex = "";
        String retorx = "";
        File archivo = new File(rutax);
    try {
    FileReader leerArchivo = new FileReader(archivo);
    BufferedReader fb = new BufferedReader(leerArchivo);
    while ((linex = fb.readLine()) != null){
    retorx += linex + "\n";
   }
    fb.close();
            
            }catch(Exception e){
            System.out.println("Error E/S: "+e);
        }
  return retorx;
    }   
}
