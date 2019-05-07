/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package basedbiblioteca;

import java.io.Serializable;

/**
 *by rbn
 * @author orihime
 */
//clase que se encarga de organisar el areglo de datos 
public class datosLibros implements Serializable {
    public String isbm;
    public String nombreLibro;
    public String nombreEditorial;
    public int añoPublicacion;
    public int nroDpaginas;
    public float valorDcompra;
    public int nroDcopias;
    public String ubicacionEstantes;

    public datosLibros() {
    }

    public datosLibros(String isbm, String nombreLibro, String nombreEditorial, int añoPublicacion, int nroDpaginas, float valorDcompra, int nroDcopias, String ubicacionEstantes) {
        this.isbm = isbm;
        this.nombreLibro = nombreLibro;
        this.nombreEditorial = nombreEditorial;
        this.añoPublicacion = añoPublicacion;
        this.nroDpaginas = nroDpaginas;
        this.valorDcompra = valorDcompra;
        this.nroDcopias = nroDcopias;
        this.ubicacionEstantes = ubicacionEstantes;
    }

    public String getIsbm() {
        return isbm;
    }

    public void setIsbm(String isbm) {
        this.isbm = isbm;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public int getNroDpaginas() {
        return nroDpaginas;
    }

    public void setNroDpaginas(int nroDpaginas) {
        this.nroDpaginas = nroDpaginas;
    }

    public float getValorDcompra() {
        return valorDcompra;
    }

    public void setValorDcompra(float valorDcompra) {
        this.valorDcompra = valorDcompra;
    }

    public int getNroDcopias() {
        return nroDcopias;
    }

    public void setNroDcopias(int nroDcopias) {
        this.nroDcopias = nroDcopias;
    }

    public String getUbicacionEstantes() {
        return ubicacionEstantes;
    }

    public void setUbicacionEstantes(String ubicacionEstantes) {
        this.ubicacionEstantes = ubicacionEstantes;
    }
    
    
}
