/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author Paula
 */
public class Jugador {
    private boolean encarcelado;
    private final String nombre;
    private int saldo;
    private Sorpresa cartaLibertad;
    private Casilla casillaActual;
    private ArrayList<TituloPropiedad> propiedades;
    static int factorEspeculador = 1;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        this.encarcelado = false;
        this.saldo = 7500;
        this.propiedades = new ArrayList();
    }
    
    protected Jugador(Jugador jugador){
        this.nombre = jugador.nombre;
        this.encarcelado = jugador.encarcelado;
        this.saldo = jugador.saldo;
        this.casillaActual = jugador.casillaActual;
        this.cartaLibertad = jugador.cartaLibertad;
        
        this.propiedades = new ArrayList<>();
        for (TituloPropiedad propiedad: jugador.propiedades){
            this.propiedades = jugador.propiedades;
        }
    }
    
    public Casilla getCasillaActual(){
        return casillaActual;
    }
    
    public boolean getEncarcelado(){
        return encarcelado;
    }
    
    public boolean tengoPropiedades(){
        boolean tengo = true;
        if(propiedades.isEmpty())
            tengo = false;
        return tengo;
    }
    
    protected boolean actualizarPosicion(Casilla casilla){
        if(casilla.getNumeroCasilla() < casillaActual.getNumeroCasilla()){
            modificarSaldo(Qytetet.getInstance().SALDO_SALIDA);
        }
        boolean tienePropietario = false;
        setCasillaActual(casilla);
        if(casilla.soyEdificable()){
            Calle calle = (Calle) casilla;
            tienePropietario = calle.tengoPropietario();
            if(calle.tengoPropietario()){
                if (!calle.propietarioEncarcelado()){
                    int costeAlquiler = calle.cobrarAlquiler();
                    modificarSaldo((-1)*costeAlquiler);
                }
            }
        }
        
        if (casilla.getTipo() == TipoCasilla.IMPUESTO){
            int coste = casilla.getCoste();
            pagarImpuestos(coste);
        }
        return tienePropietario;
    }
    
    protected void pagarImpuestos(int cantidad){
        modificarSaldo((-1)*cantidad);
    }
    
    protected Especulador convertirme(int fianza){
        return new Especulador(this, fianza);
    }
    
    boolean comprarTitulo(){
        boolean puedoComprar = false;
        if (casillaActual.soyEdificable()){
            Calle calle = (Calle) casillaActual;
            boolean tengoPropietario = calle.tengoPropietario();
            if(!tengoPropietario){
                int costeCompra = calle.getCoste();
                if (costeCompra <= getSaldo()){
                    TituloPropiedad titulo = calle.asignarPropietario(this);
                    propiedades.add(titulo);
                    modificarSaldo((-1)*costeCompra);
                    puedoComprar = true; 
                }
            }
        }
        return puedoComprar;
    }
    
    Sorpresa devolverCartaLibertad(){
        Sorpresa antiguaCarta = cartaLibertad;
        Qytetet.getInstance().getMazo().add(antiguaCarta);
        cartaLibertad = null;
        return antiguaCarta;
    }
    
    void irACarcel(Casilla casilla){
        setCasillaActual(casilla);
        setEncarcelado(true);
    }
    
    void modificarSaldo(int cantidad){
        saldo += cantidad;
    }
    
    int obtenerCapital(){
        int capital = saldo;
        for(TituloPropiedad p: propiedades){
            Calle calle = (Calle) p.getCasilla();
            capital += calle.getNumHoteles()*p.getPrecioEdificar() + calle.getNumCasas()*p.getPrecioEdificar();
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
        int numeroTotal = cuantasCasasHotelesTengo();
        modificarSaldo(numeroTotal*cantidad);
    }
    
    boolean pagarLibertad(int cantidad){
        boolean tengoSaldo = tengoSaldo(cantidad);
        if(tengoSaldo){
            modificarSaldo((-1)*cantidad);
        }
        return tengoSaldo; 
    }
    
    boolean puedoEdificarCasa(Calle calle){
        boolean esMia = esDeMiPropiedad(calle);
        boolean tengoSaldo = false;
        if(esMia){
            int costeEdificarCasa = calle.getPrecioEdificar();
            tengoSaldo = tengoSaldo(costeEdificarCasa);
        }
        return (esMia && tengoSaldo);
    }
    
    boolean puedoEdificarHotel(Calle calle){
        boolean esMia = esDeMiPropiedad(calle);
        boolean tengoSaldo = false;
        if(esMia){
            int costeEdificarHotel = calle.getPrecioEdificar();
            tengoSaldo = tengoSaldo(costeEdificarHotel);
        }
        return (esMia && tengoSaldo);
    }
    
    boolean puedoHipotecar(Calle calle){
        return (esDeMiPropiedad(calle) && !calle.getTitulo().getHipotecada()) ;
    }
    
    boolean puedoPagarHipoteca(Calle calle){
        boolean puedoPagar=false;
        if(puedoHipotecar(calle)&& saldo>calle.getCoste()){
            puedoPagar=true;   
        }
        return puedoPagar;
    }
    
    boolean puedoVenderPropiedad(Calle calle){
        boolean puedo = false;
        if (esDeMiPropiedad(calle)){
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
    
    void venderPropiedad(Calle calle){
        int precioVenta = calle.venderTitulo();
        calle.getTitulo().setPropietario(null);
        calle.setNumCasas(0);
        calle.setNumHoteles(0);
        modificarSaldo(precioVenta);
        eliminarDeMisPropiedades(calle);
    }
    
    int cuantasCasasHotelesTengo(){
        int total = 0;
        for(TituloPropiedad titulo: propiedades){
            Calle calle = (Calle) titulo.getCasilla();
            total += calle.getNumCasas() + calle.getNumHoteles();
        }
        return total; 
    }
    
    void eliminarDeMisPropiedades(Calle calle){
        if(esDeMiPropiedad(calle)){
            propiedades.remove(calle.getTitulo());
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
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getFactorEspeculador() {
        return factorEspeculador;
    }
    
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", saldo=" + saldo + "}";
    }

}
