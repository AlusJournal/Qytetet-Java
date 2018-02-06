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
        titulo.setPropietario(jugador);
        return titulo;
    }
    
    int calcularValorHipoteca(){
        return (int) (getTitulo().getHipotecaBase() + numCasas * 0.5 * getTitulo().getHipotecaBase() + numHoteles * getTitulo().getHipotecaBase());
    }
    
    int cancelarHipoteca(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int cobrarAlquiler(){
        int costeAlquilerBase = titulo.getAlquilerBase() + (int)(getNumCasas()*0.5 + getNumHoteles()*2);
        titulo.cobrarAlquiler(costeAlquilerBase);
        return costeAlquilerBase; 
    }
    
    int edificarCasa(){
        int nuevoNumero = numCasas + 1;
        setNumCasas(nuevoNumero);
        int costeEdificarCasa = titulo.getPrecioEdificar(); 
        return costeEdificarCasa;
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
        return titulo.getHipotecaBase();
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
        return titulo.getPrecioEdificar(); 
    }
    int hipotecar(){
        titulo.setHipotecada(true);
        return calcularValorHipoteca();
    }
    int precioTotalComprar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean propietarioEncarcelado(){
        return titulo.propietarioEncarcelado();
    }
    boolean sePuedeEdificarCasa(){
        boolean sePuedeEdificar = false; 
        if (numCasas<4){
            sePuedeEdificar = true;
        }
        return sePuedeEdificar;
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
        return titulo.tengoPropietario();
    }
    
    int venderTitulo(){
        titulo.setPropietario(null);
        setNumHoteles(0);
        setNumCasas(0);
        int precioCompra = coste+(numCasas + numHoteles)*titulo.getPrecioEdificar();
        return (int)(precioCompra+titulo.getFactorRevalorizacion()*precioCompra);
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
