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
        setTitulo(titulo);
    }
    
    public Casilla(int numeroCasilla, TipoCasilla casilla){
        this.numeroCasilla = numeroCasilla;
        this.casilla = casilla;
    }
    
    public TipoCasilla getTipo(){
        return casilla;
    }
    
    public TituloPropiedad getTitulo(){
        return titulo;
    }
    
    TituloPropiedad asignarPropietario(Jugador jugador){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularValorHipoteca(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int cancelarHipoteca(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int cobrarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int edificarCasa(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int edificarHotel(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean estaHipotecada(){
        return titulo.getHipotecada();
    }
    
    public int getCoste(){
        return coste;
    }
    
    int getCosteHipoteca(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public int getNumeroCasilla(){
        return numeroCasilla;
    }
    
    public int getNumCasas(){
        return numCasas; 
    }
    
    public int getNumHoteles(){
        return numHoteles;
    }
    
    int getPrecioEdificar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    int hipotecar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    int precioTotalComprar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean propietarioEncarcelado(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean sePuedeEdificarCasa(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean sePuedeEdificarHotel(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void setNumHoteles(int numHoteles){
        this.numHoteles = numHoteles;
    }
    
    public void setNumCasas(int numCasas){
        this.numCasas = numCasas;
    }
    
    boolean soyEdificable(){
        boolean esEdificable = false;
        if (casilla == TipoCasilla.CALLE){
            esEdificable = true; 
        }
        
        return esEdificable; 
    }
    
    boolean tengoPropietario(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int venderTitulo(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void setTitulo(TituloPropiedad titulo){
        this.titulo = titulo;
    }
    
    void asignarTituloPropiedad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void setCoste(int coste){
        this.coste = coste;
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
