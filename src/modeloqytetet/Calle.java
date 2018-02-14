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
public class Calle extends Casilla {
    private int numHoteles;
    private int numCasas;
    private TituloPropiedad titulo;
    
    public Calle (int numeroCasilla, int coste, TituloPropiedad titulo){
        super(numeroCasilla, TipoCasilla.CALLE);
        this.numCasas = 0;
        this.numHoteles = 0; 
        this.coste = coste;
        setTitulo(titulo);
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
        int nuevoNumero = numHoteles + 1;
        setNumHoteles(nuevoNumero);
        int costeEdificarHotel = titulo.getPrecioEdificar(); 
        return costeEdificarHotel;
    }
    
    boolean estaHipotecada(){
        return titulo.getHipotecada();
    }
    
    int getCosteHipoteca(){
        return titulo.getHipotecaBase();
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
        if (numCasas<(getTitulo().getPropietario().getFactorEspeculador()*4)){
            sePuedeEdificar = true;
        }
        return sePuedeEdificar;
    }
    boolean sePuedeEdificarHotel(){
        boolean sePuedeEdificar = false;
        if(numCasas>(getTitulo().getPropietario().getFactorEspeculador()*4)){
            if(numHoteles<(getTitulo().getPropietario().getFactorEspeculador()*4)){
                sePuedeEdificar = true;
            }
        }
        return sePuedeEdificar;
    }
    
    public void setNumHoteles(int numHoteles){
        this.numHoteles = numHoteles;
    }
    
    public void setNumCasas(int numCasas){
        this.numCasas = numCasas;
    }
    
    boolean tengoPropietario(){
        return titulo.tengoPropietario();
    }
    
    int venderTitulo(){
        titulo.setPropietario(null);
        int precioCompra = coste+(numCasas + numHoteles)*titulo.getPrecioEdificar();
        setNumHoteles(0);
        setNumCasas(0);
        return (int)(precioCompra+titulo.getFactorRevalorizacion()*precioCompra);
    }
    
    void asignarTituloPropiedad(){
        throw new UnsupportedOperationException("Sin implementar");
    }  
    
    private void setTitulo(TituloPropiedad titulo){
        this.titulo = titulo;
        this.titulo.setCasilla(this);
    }
    
    @Override
    boolean soyEdificable() {
        return true;
    }
    
    @Override
    public String toString() {
        return "Calle{" + "titulo=" + titulo + ", numero casilla=" +
        Integer.toString(getNumeroCasilla()) + ", coste=" +
        Integer.toString(coste) + ", numero de hoteles=" +
        Integer.toString(numHoteles) + ", numero de casas=" +
        Integer.toString(numCasas) + "}";
    }
}
