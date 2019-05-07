/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package papamama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander
 */
public class funciones {
    
    public void escribir(String nombreArchivo, String texto, boolean conserva)
	{
    File f;
    f = new File(nombreArchivo);

    //Escritura
    try{
    FileWriter w = new FileWriter(f,conserva);
    BufferedWriter bw = new BufferedWriter(w);
    PrintWriter wr = new PrintWriter(bw);

    wr.write(texto);  

    wr.close();
    bw.close();
    }catch(IOException e){};

    }

public String leerln(String nombreArchivo, int ln){
    File f = new File( nombreArchivo );
    BufferedReader entrada;
    String linea=null;
    int k = 0;
    try {
    entrada = new BufferedReader( new FileReader( f ) );
    while(k<=ln){
    entrada.ready();
    linea = entrada.readLine();
    k++;
    }
    return linea;
    }catch (IOException e) {
    e.printStackTrace();
    return null;
    }
    
}

public int nlineas(String nombreArchivo){
    File f = new File( nombreArchivo );
    BufferedReader entrada;
    int n=0;
    try {
    entrada = new BufferedReader( new FileReader( f ) );
    while(entrada.ready()){
    entrada.readLine();
    n++;
    }
    return n;
    }catch (IOException e) {
    e.printStackTrace();
    }
    return n;
}

public void llenarTabla(JTable tablaIngrese, String archivo){
        //++++llenando tabla
        DefaultTableModel modelo=(DefaultTableModel) tablaIngrese.getModel();
        int ncol = tablaIngrese.getColumnCount();
        for(int j=0 ; j<nlineas(archivo) ; j++){
            Object [] fila=new Object[ncol];
            String filabd[] = leerln(archivo, j).split(",");
            for(int h=0 ; h<ncol ; h++){
                fila[h]=filabd[h]; 
            }
            modelo.addRow(fila);
        }
         tablaIngrese.setModel(modelo);
        
        //++++Fin llenando tabla
    }
    
public void limpiarTabla(JTable tabla){
	        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
	            int filas = tabla.getRowCount();
	            for(int i = 0;filas>i; i++) {
	                modelo.removeRow(0);
	            }
	        
	    }

public void eliminarFila(JTable tabla, String archivo){
    int fila = tabla.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel(); 
        modelo.removeRow(fila); 
        
        int tam = tabla.getRowCount();
        
        escribir(archivo, "", false);
        
        for(int i=0 ; i<tam ; i++){
            String linea="";
            for(int h=0 ; h<tabla.getColumnCount() ; h++){
                linea = linea + tabla.getValueAt(i, h);
                if(h != (tabla.getColumnCount()-1))
                    linea = linea + ",";
            }
        escribir(archivo, linea + "\r\n", true);
        }
        limpiarTabla(tabla);
        llenarTabla(tabla,archivo);        
}
    
}