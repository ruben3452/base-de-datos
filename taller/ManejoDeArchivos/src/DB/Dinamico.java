package DB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import otros.articulo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Dinamico extends InterfaceDB {

    public Dinamico(File archivo) {
        super(archivo);
    }

    @Override

    
    
    public LinkedList<articulo> listarDatos() {
        LinkedList<articulo> articulos = new LinkedList<>();

        try {
            //abre el archivo en modo lectura
            RandomAccessFile arch = new RandomAccessFile(archivo, "r");
            try {
                while (true) {
                    //si llega al final se sale del ciclo
                    if (arch.getFilePointer() == arch.length()) {
                        break;
                    }
                    //lee los datos
                    int codigo = arch.readInt();
                    int longNom = arch.readInt(); //tamaño del nombre
                    String nombre = ""; //lee el nombre
                    for (int i = 0; i < longNom; i++) {
                        nombre += arch.readChar();
                    }
                    int cantidad = arch.readInt(); //lee la cantidad
                    int valor = arch.readInt(); //lee el valor

                    articulo art = new articulo(codigo, nombre, cantidad, valor);
                    articulos.add(art); //añade el articulo a la lista
                }
            } catch (Exception ex) {
            } finally {
                try {
                    arch.close();
                } catch (IOException ex) {
                }
            }


        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no Encontrado");
        }
        //
        return articulos;
    }

    @Override
    
    /* se para al final mete el codigo luego ete el tamaño dle nombre como un entero luego el nimbre, luego la cantidad
       luego el valor; siemrpe an agregados al final*/
    
    public boolean ingresarArticulo(articulo dato) {
        try {
            RandomAccessFile arch = new RandomAccessFile(archivo, "rw");
            arch.seek(arch.length()); //se posiciona al final
            arch.writeInt(dato.codigo);
            int tamNombre = dato.nombre.length();
            arch.writeInt(tamNombre);
            arch.writeChars(dato.nombre);
            arch.writeInt(dato.cantidad);
            arch.writeInt(dato.valor);
            arch.close();
            return true;

        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe");
            return false;
        } catch (IOException ex) {
            System.out.println("Error leyendo el archivo");
            return false;
        }

    }

    /* busca el articulo toma la posicion si no al encuntra se sale, despues calcula el tamano a lo que esta e el archivo
       luego se lo calcula a lo que va a meter; calcula la diferencia; se para al final del archivo y va movieno todos los
       bytes*/
    
    public boolean modificarArticulo(int codigoPrevio, articulo dato) {
        long pos = buscarArticulo(codigoPrevio);
        if (pos < 0) {
            return false;
        }
        try {
            RandomAccessFile arch = new RandomAccessFile(archivo, "rw");
            //calcula el tamaño actual del articulo
            arch.seek(pos + 4); //donde esta la longitud del nombre
            int tamNombreActual = arch.readInt();
            int tamArticuloActual = 16 + (tamNombreActual * 2);
            long posArticuloSiguiente = pos + tamArticuloActual;
            int tamArticuloNuevo = 16 + (dato.nombre.length() * 2); 
            
            //ha calculado el tamaño del articulo en el archivo y el tamaño del nuevo articulo
            if (tamArticuloNuevo > tamArticuloActual) { //necesita mas espacio, mueve los bytes siguientes hacia atras
                long posFuente = arch.length() - 1;
                arch.setLength(arch.length() + (tamArticuloNuevo - tamArticuloActual));
                long posDestino = arch.length() - 1;
                //desplaza los bytes hacia el final

                /*Reescribe los bytes*/
                
                byte tmp;
                while (posFuente >= posArticuloSiguiente) {
                    arch.seek(posFuente);
                    tmp = arch.readByte();
                    arch.seek(posDestino);
                    arch.writeByte(tmp);
                    posDestino--;
                    posFuente--;
                }
            } else if (tamArticuloNuevo - tamArticuloActual < 0) { //mueve los bytes siguientes hacia adelante
                long tamArchivo = arch.length();
                long posFuente = posArticuloSiguiente;
                long posDestino = posArticuloSiguiente - (tamArticuloActual - tamArticuloNuevo);
                byte tmp;
                while (posFuente < tamArchivo) {
                    arch.seek(posFuente);
                    tmp = arch.readByte();
                    arch.seek(posDestino);
                    arch.writeByte(tmp);
                    posDestino++;
                    posFuente++;
                    
                }
                arch.setLength(posDestino);
            }

            arch.seek(pos); //vuelve a la posicion original
            arch.writeInt(dato.codigo);
            arch.writeInt(dato.nombre.length());
            arch.writeChars(dato.nombre);
            arch.writeInt(dato.cantidad);
            arch.writeInt(dato.valor);
            arch.close();
            return true;

        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe");
            return false;
        } catch (IOException ex) {
            System.out.println("Error leyendo el archivo");
            return false;
        }
    }

    /* optiene la posicion en el archivo, para calcular el tamana tiene que sacar el tamaño del nombre (salta 4 bytes)
       luego mulltiplica por 2 le suma 16*/
    
    @Override
    public boolean eliminarArticulo(int codigo) {
       long aelim= buscarArticulo(codigo);
        if (aelim<0){return false;}
        try {
            RandomAccessFile arch = new RandomAccessFile(archivo, "rw");
            arch.seek(aelim + 4); //donde esta la longitud del nombre
            int tamNombreActual = arch.readInt();
            int tamArticulo = 16 + (tamNombreActual * 2);
            long posFuente=aelim+tamArticulo;
            long posDestino=aelim;
            
            byte tmp;
            long tamArchivo=arch.length();
            while(posFuente<tamArchivo){
               arch.seek(posFuente);
               tmp=arch.readByte();
               arch.seek(posDestino);
               arch.writeByte(tmp);
               posDestino++;
               posFuente++;
               
            }
            arch.setLength(posDestino);
            arch.close();
            return true;

        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe");
            return false;
        } catch (IOException ex) {
            System.out.println("Error leyendo el archivo");
            return false;
        }
    }

    @Override
    public long buscarArticulo(int coddato) {
        try {
            long refArticulo = -1;
            RandomAccessFile arch = new RandomAccessFile(archivo, "r");

            try {
                int cod;
                String nombre = "";
                int cantidad;
                int valor;
                char ctmp;
                while (true) {
                    if (arch.length() - arch.getFilePointer() == 0) {
                        break;
                    }
                    cod = arch.readInt();
                    if (cod == coddato) {
                        refArticulo = arch.getFilePointer() - 4;
                    } else {
                        int tamNombre = arch.readInt();
                        arch.skipBytes(tamNombre * 2);
                        arch.skipBytes(4);
                        arch.skipBytes(4);

                    }
                }
            } catch (IOException ex) {
                System.out.println("Error leyendo el archivo");
            } finally {
                try {
                    arch.close();
                } catch (IOException ex) {
                    Logger.getLogger(Fijo.class.getName()).log(Level.SEVERE, null, ex);
                }
                return refArticulo;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe");
            return -1;
        }
    }

    /*no lo quisimos borrar por la interfaz grafica*/
    
    @Override
    public articulo articuloEn(int posicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    
    /*toma la posicion normal en el archivo lee el codigo la posicion la cantidad y el valor y devuelve como un articulo
      busca el articulo s existe en una posicion la devuelve*/      
    @Override
    public articulo articuloEnPosicionReal(long posicion) {
        articulo refArticulo = null;
        try {
            RandomAccessFile arch = new RandomAccessFile(archivo, "r");
            if (posicion >= arch.length()) {
                return refArticulo;
            }
            arch.seek(posicion);
            int cod = arch.readInt();
            int tamNombre = arch.readInt();
            String nombre = "";

            for (int i = 0; i < tamNombre; i++) {
                nombre += (char) arch.readChar();
            }
            int cantidad = arch.readInt();
            int valor = arch.readInt();
            refArticulo = new articulo(cod, nombre, cantidad, valor);


        } catch (FileNotFoundException ex) {
            Logger.getLogger(Fijo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Fijo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return refArticulo;
    }

    @Override
    public articulo buscarArticuloPorCodigo(int codigo) {
        long pos = buscarArticulo(codigo);
        if (pos < 0) {
            return null;
        }
        return articuloEnPosicionReal(pos);

    }
}
