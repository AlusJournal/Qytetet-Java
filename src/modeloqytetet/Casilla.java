/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author Paula Ruiz
 */
public class Casilla {
    private final int numeroCasilla; 
    private int coste;
    private int numHoteles;
    private int numCasas;
    private final TipoCasilla casilla; 
    private TituloPropiedad titulo; 
    
    public Casilla(int numeroCasilla, int coste, TituloPropiedad titulo){
        this.numeroCasilla = numeroCasilla;
        this.coste = coste; 
        numHoteles = 0; 
        numCasas = 0; 
        casilla = TipoCasilla.CALLE; 
        setTituloPropiedad(titulo);
    }
    
    public Casilla(int numeroCasilla, TipoCasilla casilla){
        this.numeroCasilla = numeroCasilla;
        this.casilla = casilla;
    }
    
    public int getNumeroCasilla(){
        return numeroCasilla;
    }
    
    public int getCoste(){
        return coste;
    }
    
    public void setCoste(int coste){
        this.coste = coste;
    }
    
    public int getNumHoteles(){
        return numHoteles;
    }
    
    public void setNumHoteles(int numHoteles){
        this.numHoteles = numHoteles;
    }
    
    public int getNumCasas(){
        return numCasas; 
    }
    
    public void setNumCasas(int numCasas){
        this.numCasas = numCasas;
    }
    
    public TipoCasilla getCasilla(){
        return casilla;
    }
    
    public TituloPropiedad getTitulo(){
        return titulo;
    }
    
    private void setTituloPropiedad(TituloPropiedad titulo){
        this.titulo = titulo;
    }
    
    @Override
    public String toString() {
        return "Casilla{" + "titulo=" + titulo + ", tipo casilla=" + casilla + ", numero casilla=" +
        Integer.toString(numeroCasilla) + ", coste=" +
        Integer.toString(coste) + ", numero de hoteles=" +
        Integer.toString(numHoteles) + ", numero de casas=" +
        Integer.toString(numCasas) + "}";
    }
}
