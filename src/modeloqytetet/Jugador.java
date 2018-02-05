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
    private final String nombre;
    private int saldo;
    private Sorpresa cartaLibertad;
    private Casilla casillaActual;
    private ArrayList<TituloPropiedad> propiedades;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        this.encarcelado = false;
        this.saldo = 7500;
        this.propiedades = new ArrayList();
    }
    
    public Casilla getCasillaActual(){
        return casillaActual;
    }
    
    public boolean getEncarcelado(){
        return encarcelado;
    }
    
    public boolean tengoPropiedades(){
        boolean tengo = true;
        if(propiedades.size() == 0)
            tengo = false;
        return tengo;
    }
    boolean actualizarPosicion(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean comprarTitulo(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    Sorpresa devolverCartaLibertad(){
        Sorpresa antiguaCarta = cartaLibertad;
        Qytetet.getInstance().getMazo().add(antiguaCarta);
        cartaLibertad = null;
        return antiguaCarta;
    }
    void irACarcel(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void modificarSaldo(int cantidad){
        saldo += cantidad;
    }
    int obtenerCapital(){
        int capital = saldo;
        for(TituloPropiedad p: propiedades){
            capital += p.getCasilla().getNumHoteles()*p.getPrecioEdificar() + p.getCasilla().getNumCasas()*p.getPrecioEdificar();
            if(p.getHipotecada() == true )
                capital = capital - p.getHipotecaBase();
        }
        return capital;
    }
    ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada){
        ArrayList<TituloPropiedad> titulos = new ArrayList();
  
        if(hipotecada){
            for(TituloPropiedad p: propiedades){
                if(p.getHipotecada()){
                    titulos.add(p);

                }
            }
        }
        else{
            for(TituloPropiedad p: propiedades){
                if(!p.getHipotecada()){
                    titulos.add(p);
                }
            }
        }
        return titulos;
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
    boolean puedoVenderPropiedad(Casilla casilla){
        boolean puedo = false;
        if (esDeMiPropiedad(casilla)){
            puedo = true;
        }
        return puedo;
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
        boolean tengo = false;
        if (cartaLibertad != null){
            tengo = true; 
        }
        return tengo;
    }
    void venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    int cuantasCasasHotelesTengo(){
        int total = 0;
        for(TituloPropiedad titulo: propiedades){
            total += titulo.getCasilla().getNumCasas() + titulo.getCasilla().getNumHoteles();
        }
        return total; 
    }
    void eliminarDeMisPropiedades(Casilla casilla){
        if(esDeMiPropiedad(casilla)){
            propiedades.remove(casilla.getTitulo());
        }
    }
    boolean esDeMiPropiedad(Casilla casilla){
        boolean tengo = false;
        for (TituloPropiedad titulo : propiedades){
            if (titulo.getCasilla() == casilla){
                tengo = true;
            }
        }
        return tengo;
    }
    boolean tengoSaldo(int cantidad){
        boolean tengo = false;
        if (cantidad < saldo){
            tengo = true;
        }
        return tengo;
    }
    
    void setSaldo(int cantidad) {
        this.saldo = cantidad;
    }
    
    public int getSaldo() {
        return this.saldo;
    }
    
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", saldo=" + saldo + "}";
    }
}
