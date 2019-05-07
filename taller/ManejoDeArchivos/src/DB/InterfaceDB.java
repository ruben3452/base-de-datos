package DB;


import java.io.File;
import java.util.LinkedList;
import otros.articulo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public abstract class InterfaceDB {

    File archivo;

    public InterfaceDB(File archivo) {
        this.archivo = archivo;
    }
    
    
    /*
     * Retorna una lista con todos los articulos que existen en el archivo.
     */
    public abstract LinkedList<articulo> listarDatos();

    /**
     * agrega un articulo al final del archivo
     * @param dato articulo a agregar
     * @return  true si el articulo fue agregado
     */
    public abstract boolean ingresarArticulo(articulo dato);
    
    /**
     * modifica un articulo, sin alterar su posicion en el archivo
     * @param codigoPrevio el codigo anterior del articulo
     * @param dato toda la nueva inforcacion
     * @return true si la modificación fue exitosa
     */
    public abstract boolean modificarArticulo(int codigoPrevio, articulo dato);

    
    /**
     * elimina un articulo del archivo
     * @param dato codigo del articulo a eliminar
     * @return  true si el archivo fue eliminado
     */
    public abstract boolean eliminarArticulo(int dato);
    
    /**
     * busca un articulo con el codigo ingresado
     * @param codigo el codigo del articulo
     * @return la posicion del articulo en el archivo
     */
    abstract long buscarArticulo(int codigo);
    
    /**
     * busca un articulo con el codigo ingresado
     * @param codigo el codigo del articulo
     * @return la posicion del articulo en el archivo
     */
    public abstract articulo buscarArticuloPorCodigo(int codigo);
    
    /**
     * retorna el articulo que se encuentra en la posicion dada
     * 
     * @param posicion posicion del articulo [0,n]
     * @return el articulo ubicado en esa posicion, nulo si la posicion no es valida
     */
    public abstract articulo articuloEn(int posicion);
    
    
    /**FIJO
     * intenta leer como un articulo la información presente desde una posición en el archivo indicada
     * @param posicion posicion dentro del archivo
     * @return la información leida en forma de articulo.
     */
    public abstract articulo articuloEnPosicionReal(long posicion);
    
    
    
}
