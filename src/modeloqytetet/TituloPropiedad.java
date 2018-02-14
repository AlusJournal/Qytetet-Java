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
public class TituloPropiedad {
    private final String nombre;
    private boolean hipotecada; 
    private final int alquilerBase; 
    private final float factorRevalorizacion; 
    private final int hipotecaBase; 
    private final int precioEdificar; 
    private Jugador propietario;
    private Casilla casilla;
    
    public TituloPropiedad(String nombre, int alquilerBase, float factorRevalorizacion, int hipotecaBase, int precioEdificar){
        this.nombre = nombre; 
        this.hipotecada = false; 
        this.alquilerBase = alquilerBase;
        this.factorRevalorizacion = factorRevalorizacion; 
        this.hipotecaBase = hipotecaBase; 
        this.precioEdificar = precioEdificar;
    }
    
    void cobrarAlquiler(int coste){
        propietario.modificarSaldo((-1)*coste);
    }
    
    public int getAlquilerBase(){
        return alquilerBase; 
    }
    
    public float getFactorRevalorizacion(){
        return factorRevalorizacion; 
    }
    
    public int getHipotecaBase(){
        return hipotecaBase;
    }
    
    public boolean getHipotecada(){
        return hipotecada; 
    }
    
    public String getNombre(){
        return nombre; 
    }
       
    public int getPrecioEdificar(){
        return precioEdificar;
    }
    
    public Jugador getPropietario(){
        return propietario;
    }
    
    boolean propietarioEncarcelado(){
        return propietario.getEncarcelado();
    }
    
    public void setCasilla(Casilla casilla){
        this.casilla = casilla;
    }
    
    public void setHipotecada(boolean hipotecada){
        this.hipotecada = hipotecada; 
    }
    
    public void setPropietario(Jugador propietario){
        this.propietario = propietario;
    }
    
    boolean tengoPropietario(){
        boolean propietario = false;
        if (this.propietario != null){
            propietario = true;
        }
        return propietario;
    }
    
    Casilla getCasilla(){
        return casilla;
    }
    
    
    @Override
    public String toString() {
        return "Titulo Propiedad{" + "nombre=" + nombre + ", hipotecada=" + hipotecada + ", alquiler base=" +
        Integer.toString(alquilerBase) + ", factor revalorizacion=" +
        Float.toString(factorRevalorizacion) + ", hipoteca base=" +
        Integer.toString(hipotecaBase) + ", precio edificar=" +
        Integer.toString(precioEdificar) + "}";
    }
}
