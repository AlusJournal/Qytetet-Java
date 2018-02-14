/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author Paula
 */
public abstract class Casilla {
    private final int numeroCasilla; 
    private final TipoCasilla casilla; 
    protected int coste=0;
    
    public Casilla(int numeroCasilla, TipoCasilla casilla){
        this.numeroCasilla = numeroCasilla;
        this.casilla = casilla;
    }
    
    public TipoCasilla getTipo(){
        return casilla;
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
    
    abstract boolean soyEdificable();
    
    @Override
    public String toString() {
        return "Casilla{" + "Tipo casilla=" + casilla + ", numero casilla=" +
        Integer.toString(numeroCasilla) + "}";
    }
}
