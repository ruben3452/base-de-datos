/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leer;
import java.io.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 *
 */
public class leertxt {
  
   public void leer() {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      
      try {
         
         archivo = new File ("archivo.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
       
         String linea;
         while((linea=br.readLine())!=null)
             
             System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
        
         try{                   
            if( null != fr ){  
               fr.close();    
            }                 
         }catch (Exception e2){
            e2.printStackTrace();
         }
      }
      

   }
}  



