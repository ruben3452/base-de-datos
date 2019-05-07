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
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Fijo extends InterfaceDB {

    final int tamTexto = 20;

    public Fijo(File archivo) {
        super(archivo);
    }

    @Override
    
    /*Toma la posicion y dice articulo en posicion y empiza a buscar el articulo en la posicion 0, articulo en la posicion 1
      articulo en la posicion 2 y asi sucesivamente hasta que este se vuelva nulo cuando este se vuelva nulo es porque ya no
      se pudo leer mas en este momento devuelve la lista articulos, si el valor es diferente de nulo lo añade a la lista 
      aumenta la posicion y sigue a la siguiente posicion*/ 
    
    public LinkedList<articulo> listarDatos() {
        LinkedList<articulo> articulos = new LinkedList<>();
            articulo tmp=null;
            int pos=0;
            while (true) {
                tmp=articuloEn(pos);
                if (tmp==null){break;}
                articulos.add(tmp);
                pos++;
            }
        return articulos;
    }

    /*abre el aceso al archivo dice que es modo lectoescritura y le dice que se pare al final del arhivo y comienza a hacer
     lo mismo*/
    
    @Override
    public boolean ingresarArticulo(articulo dato) {
        try {
            RandomAccessFile arch = new RandomAccessFile(archivo, "rw");
            arch.seek(arch.length()); //se posiciona al final
            arch.writeInt(dato.codigo);
            String stmp = dato.nombre;
            if (stmp.length() > tamTexto) {
                stmp = stmp.substring(0, tamTexto);
            }

            while (stmp.length() < tamTexto) {
                stmp += (char) 0;
            }
            arch.writeChars(stmp);
            arch.writeInt(dato.cantidad);
            arch.writeInt(dato.valor);
            arch.close();
            return true;

    /* cuando le decimos ingresar y el articulo o existe el intenta crearlo si no lo puede hacer nos lanza alguuno
       de estos dos errores que nos dicen que el articulo no pudo ser creado*/
            
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe");
            return false;
        } catch (IOException ex) {
            System.out.println("Error leyendo el archivo");
            return false;
        }

    }

    /* nos pide el codigo que tiene el articulo que vamos a modificar, el busca el articulo y nos devuelve la posicion
       si es mayor que 0 o -1 si el articulo no existe*/
    
    @Override
    public boolean modificarArticulo(int codigoPrevio, articulo dato) {
        long pos = buscarArticulo(codigoPrevio);
        if (pos<0){return false;}
        try {
            RandomAccessFile arch = new RandomAccessFile(archivo, "rw");
            arch.seek(pos);
            arch.writeInt(dato.codigo);
            String stmp = dato.nombre;
            if (stmp.length() > tamTexto) {
                stmp = stmp.substring(0, tamTexto);
            }

            while (stmp.length() < tamTexto) {
                stmp += (char) 0;
            }
            arch.writeChars(stmp);
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

    /*busca el aticulo si lo ecuentra bien sino se sale; calcula el tamaño del articulo que va a eliminar
      y el resto lo pasa para adelante para reescribir los bytes*/
    
    @Override
    public boolean eliminarArticulo(int codigo) {
        long aelim= buscarArticulo(codigo);
        if (aelim<0){return false;}
        int tamArticulo = (4*3)+(2*tamTexto);
        long posFuente=aelim+tamArticulo;
        long posDestino=aelim;
        try {
            RandomAccessFile arch = new RandomAccessFile(archivo, "rw");
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

    /* nos pide el codigo del articulo que estamos buscando para buscar el articulo en la lista */
    
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
                        break;
                    } else {
                        arch.skipBytes(tamTexto * 2);
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

    @Override
    public articulo articuloEn(int posicion) {
       long realPos = (posicion*(12+(tamTexto*2)));
       return articuloEnPosicionReal(realPos);
    }
    
/*abre el archivo si la posicion que usted le da es mayor al tamaño del archivo quiere decir que usted esta leyendo
  fuera del archivo entonces le devuelve nulo sino le dice al archivo que se pare en la posicion que yo le doy*/
    
    @Override
    
    public articulo articuloEnPosicionReal(long posicion) {
        articulo refArticulo = null;
        try {
            RandomAccessFile arch = new RandomAccessFile(archivo, "r");
            if (posicion>=arch.length()){return refArticulo;}
            arch.seek(posicion);
            int cod = arch.readInt();
            String nombre = "";
            char ctmp;
            for (int i = 0; i < tamTexto; i++) {
                ctmp = arch.readChar();
                if (ctmp != 0) {
                    nombre += ctmp;
                }
            }
            int cantidad = arch.readInt();
            int valor = arch.readInt();

            refArticulo = new articulo(cod, nombre, cantidad, valor);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Fijo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Fijo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return refArticulo;
    }

    @Override
    
    /* mas que todo parte visual que parte funcional*/
    
    public articulo buscarArticuloPorCodigo(int codigo) {
        long pos = buscarArticulo(codigo);
        if (pos<0){return null;}
        return articuloEnPosicionReal(pos);
    
    }
    
    
}
