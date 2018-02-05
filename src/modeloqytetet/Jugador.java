/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author Paula Ruiz
 */
public class Jugador {
    private boolean encarcelado;
    private String nombre;
    private int saldo;
    private Sorpresa cartaLibertad;
    private Casilla casillaActual;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        this.encarcelado = false;
        this.saldo = 7500;
    }
    
    public Casilla getCasillaActual(){
        return casillaActual;
    }
    
    public boolean getEncarcelado(){
        return encarcelado;
    }
    
    public boolean tengoPropiedades(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean actualizarPosicion(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean comprarTitulo(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    Sorpresa devolverCartaLibertad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void irACarcel(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void modificarSaldo(int cantidad){
       throw new UnsupportedOperationException("Sin implementar"); 
    }
    int obtenerCapital(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void pagarCobrarPorCasaYHotel(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean pagarLibertad(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean puedoEdificarCasa(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean puedoEdificarHotel(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean puedoHipotecar(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean puedoPagarHipoteca(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void puedoVenderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void setCartaLibertad(Sorpresa carta){
        this.cartaLibertad = carta;
    }
    void setCasillaActual(Casilla casilla){
        this.casillaActual = casilla;
    }
    void setEncarcelado(boolean encarcelado){
        this.encarcelado = encarcelado;
    }
    boolean tengoCartaLibertad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    int cuantasCasasHotelesTengo(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void eliminarDeMisPropiedades(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean esDeMipropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean tengoSaldo(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", saldo=" + saldo + "}";
    }
}
