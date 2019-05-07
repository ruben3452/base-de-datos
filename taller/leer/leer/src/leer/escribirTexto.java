

package leer;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *

 */
public class escribirTexto {
    // public ArrayList<datos2> datos2 = new ArrayList<datos2>();
   // datos2 datox2; 
    public void escribirtxt(String nombre,String direccion,int telefono) {
            
         
        // datos2 datosx2 = new datos2();
         //String nombre="canela";
       
         try{
            //FileWriter w = new FileWriter(f,cons);
           

             
             RandomAccessFile rf = new RandomAccessFile("archivo.txt","rw");
            //FileWriter fw=new FileWriter("archivo.txt");
           
            rf = new RandomAccessFile("archivo.txt","rw");
           

    

        
        

        
      
            
            
            
            //fw.write("pepe,calle 6564, 213654");  
            rf.writeUTF(nombre);
            
            rf.writeUTF(direccion);
            rf.writeInt(telefono);
            
            
            rf.close();
                
           
            
            
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    }
    
    public void leert() {
   // datos2 datosx2 = new datos2();
         //String nombre="canela";
       
         try{
         RandomAccessFile fs=new RandomAccessFile("archivo.txt","r");
        int valor=fs.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fs.read();
            }
          
            fs.close();
            
            }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    }
    
    
}
