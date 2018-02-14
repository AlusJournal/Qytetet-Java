/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Paula
 */
public class Qytetet {
    //Singleton
    private static Qytetet instance = new Qytetet();
    
    private Qytetet(){
        inicializarTablero();
        inicializarCartasSorpresa();
    }
    
    public static Qytetet getInstance(){
        return instance; 
    }
    
    //Metodos
    public int MAX_JUGADORES = 4;
    int MAX_CARTAS = 10; 
    int MAX_CASILLAS = 20; 
    int PRECIO_LIBERTAD = 200; 
    int SALDO_SALIDA = 1000; 
    
    private final ArrayList<Sorpresa> mazo = new ArrayList<>();
    private final ArrayList<Jugador> jugadores = new ArrayList<>();
    private Jugador jugadorActual; 
    private Sorpresa cartaActual;
    private Tablero tablero;
    
    public boolean aplicarSorpresa(){
       boolean tienePropietario = false;
       if (cartaActual.getTipo()==TipoSorpresa.PAGARCOBRAR){
           jugadorActual.modificarSaldo(cartaActual.getValor());
       }
       else if (cartaActual.getTipo()==TipoSorpresa.IRACASILLA){
           boolean esCarcel = tablero.esCasillaCarcel(cartaActual.getValor());
           if(esCarcel){
               encarcelarJugador();
           }
           else{
               Casilla nuevaCasilla = tablero.obtenerCasillaNumero(cartaActual.getValor());
               tienePropietario = jugadorActual.actualizarPosicion(nuevaCasilla);
           }
       }
       else if (cartaActual.getTipo()==TipoSorpresa.PORCASAHOTEL){
           jugadorActual.pagarCobrarPorCasaYHotel(cartaActual.getValor());
       }
       else if (cartaActual.getTipo()==TipoSorpresa.PORJUGADOR){
           for (Jugador j: jugadores){
               if (j!=jugadorActual){
                   j.modificarSaldo(cartaActual.getValor());
                   jugadorActual.modificarSaldo((-1)*cartaActual.getValor());
               }
           }
       }
       else if(cartaActual.getTipo()==TipoSorpresa.CONVERTIRME){
           Especulador jugador_especulador = jugadorActual.convertirme(cartaActual.getValor());
           jugadores.remove(jugadorActual);
           jugadorActual = jugador_especulador;
           jugadores.add(jugadorActual);
       }
       
       if (cartaActual.getTipo()==TipoSorpresa.SALIRCARCEL){
           jugadorActual.setCartaLibertad(cartaActual);
       }
       else{
           mazo.add(cartaActual);
       }
       
       return tienePropietario;
    }
    
    public boolean cancelarHipoteca(Casilla casilla){
        boolean puedoHipotecar = false;
        if(casilla.soyEdificable()){
            Calle calle = (Calle) casilla;
            boolean sePuedeHipotecar = calle.estaHipotecada();
            if(sePuedeHipotecar){
                puedoHipotecar = !jugadorActual.puedoHipotecar(calle);
                if(puedoHipotecar){
                    int cantidadRecibida = calle.hipotecar();
                    jugadorActual.modificarSaldo((-1)*cantidadRecibida);
                }
            }
        }
        return puedoHipotecar;
    }
    
    public boolean comprarTituloPropiedad(){
        boolean puedoComprar = jugadorActual.comprarTitulo();
        return puedoComprar;
    }
    
    public boolean edificarCasa(Casilla casilla){
        boolean puedoEdificar = false;
        if (casilla.soyEdificable()){
            Calle calle = (Calle) casilla;
            boolean sePuedeEdificar = calle.sePuedeEdificarCasa();
            if(sePuedeEdificar){
                puedoEdificar = jugadorActual.puedoEdificarCasa(calle);
                if (puedoEdificar){
                    int costeEdificarCasa = calle.edificarCasa();
                    jugadorActual.modificarSaldo(costeEdificarCasa);
                }
            }
        }
        return puedoEdificar; 
    }
    
    public boolean edificarHotel(Casilla casilla){
         boolean puedoEdificar = false;
        if (casilla.soyEdificable()){
            Calle calle = (Calle) casilla;
            boolean sePuedeEdificar = calle.sePuedeEdificarHotel();
            if(sePuedeEdificar){
                puedoEdificar = jugadorActual.puedoEdificarHotel(calle);
                if (puedoEdificar){
                    int costeEdificarHotel = calle.edificarHotel();
                    jugadorActual.modificarSaldo(costeEdificarHotel);
                }
            }
        }
        return puedoEdificar; 
    }
    
    public Sorpresa getCartaActual(){
        return cartaActual; 
    }
    
    public Jugador getJugadorActual(){
        return jugadorActual;
    }
    
    public boolean hipotecarPropiedad(Casilla casilla){
        boolean puedoHipotecar = false;
        if(casilla.soyEdificable()){
            Calle calle = (Calle) casilla;
            boolean sePuedeHipotecar = !calle.estaHipotecada();
            if(sePuedeHipotecar){
                puedoHipotecar = jugadorActual.puedoHipotecar(calle);
                if(puedoHipotecar){
                    int cantidadRecibida = calle.hipotecar();
                    jugadorActual.modificarSaldo(cantidadRecibida);
                }
            }
        }
        return puedoHipotecar;
    }
    
    public void inicializarJuego(ArrayList<String> nombres){
        inicializarJugadores(nombres);
        inicializarCartasSorpresa();
        inicializarTablero();
        salidaJugadores();
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
        boolean libre = false; 
        if(metodo == MetodoSalirCarcel.TIRANDODADO){
            int valorDado = GUIQytetet.Dado.getInstance().nextNumber();
            if (valorDado>5){
                libre = true;
            }
        }
        else if(metodo == MetodoSalirCarcel.PAGANDOLIBERTAD){
            boolean tengoSaldo = jugadorActual.pagarLibertad((-1)*PRECIO_LIBERTAD);
            libre = tengoSaldo;
        }
        
        if(libre){
            jugadorActual.setEncarcelado(false);
        }
        
        return libre;
    }
    
    public boolean jugar(){
         int valorDado = GUIQytetet.Dado.getInstance().nextNumber();
         Casilla casillaPosicion = jugadorActual.getCasillaActual();
         Casilla nuevaCasilla = tablero.obtenerNuevaCasilla(casillaPosicion, valorDado);
         boolean tienePropietario = jugadorActual.actualizarPosicion(nuevaCasilla);
         if(!nuevaCasilla.soyEdificable()){
             if(nuevaCasilla.getTipo() == TipoCasilla.JUEZ){
                 encarcelarJugador();
             }
             else if(nuevaCasilla.getTipo() == TipoCasilla.SORPRESA){
                 cartaActual = mazo.get(0);
                 mazo.remove(0);
             }
         }
         return tienePropietario;
    }
    
    public ArrayList<String> obtenerRanking(){
        ArrayList<String> ranking = new ArrayList();
        for(Jugador jugador:jugadores){
            int capital = jugador.obtenerCapital();
            String resultado = jugador.getNombre() + "\tSaldo: " + Integer.toString(capital);
            ranking.add(resultado);
        }
        return ranking;
    }
    
    public ArrayList<Casilla> propiedadesHipotecadasJugador(boolean hipotecada){
        ArrayList<TituloPropiedad> titulos = jugadorActual.obtenerPropiedadesHipotecadas(hipotecada);
        ArrayList<Casilla> casillas = new ArrayList();
        
        for (TituloPropiedad t: titulos){
            casillas.add(t.getCasilla());
        }
        
        return casillas;
    }
    public Jugador siguienteJugador(){
         int indice = jugadores.indexOf(jugadorActual);
         if (indice < (jugadores.size()-1))
            jugadorActual = jugadores.get(indice+1);
        else
            jugadorActual = jugadores.get(0);
        return jugadorActual;
    }
    public boolean venderPropiedad(Casilla casilla){
        boolean puedoVender = false;
        if(casilla.soyEdificable()){
            Calle calle = (Calle) casilla;
            puedoVender = jugadorActual.puedoVenderPropiedad(calle);
        if(puedoVender)
            jugadorActual.venderPropiedad(calle);
        }
        return puedoVender;
    }
    private void encarcelarJugador(){
        if(!jugadorActual.tengoCartaLibertad()){
            Casilla casillaCarcel = tablero.getCarcel();
            jugadorActual.irACarcel(casillaCarcel);
        }
        else{
            Sorpresa carta = jugadorActual.devolverCartaLibertad();
            mazo.add(carta);
        }
    }
    private void inicializarCartasSorpresa(){
        mazo.add(new Sorpresa("La DEA te ha pillado con cocaína y pasarás un tiempo en Litchfield", tablero.getCarcel().getNumeroCasilla(), TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Encuentras un acceso al Upside Down y te lleva directo a Jackson", 16, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Te han invitado a una fiesta por la noche en casa de Jessica", 13, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Los otros jugadores han probado tu producto azul y te pagan unos cuantos gramos", 500, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Jessica Jones ha expuesto tus secretos y pagas a los testigos para que nadie hable", -400, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Cada celda de pabellón te pagan por tus servicios al protegerles", 300, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Taylor ha decidido que tu hotel está contruido en un lugar histórico de Stars Hollow", -400, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("El Presidente te otorga un presupuesto solicitado", 600, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Matt Murdock te ha defendido en un juicio y debes pagar sus honorarios", -700, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Elisabeth II te ha dado un indulto y puedes abandonar la prisión", 0, TipoSorpresa.SALIRCARCEL));
        mazo.add(new Sorpresa("¿Pero a tu no te avisaron de que el hotel duMort era peligroso? Pues parace que tarde, ahora eres vampiro", 3000, TipoSorpresa.CONVERTIRME));
        mazo.add(new Sorpresa("¿Esconder la verdad? Todos lo hemos hecho alguna vez, bienvenida Mentirosa -A.", 5000, TipoSorpresa.CONVERTIRME));
        Collections.shuffle(mazo);
    }
    private void inicializarJugadores(ArrayList<String> nombres){
        for (String j: nombres){
            jugadores.add(new Jugador(j));
        } 
    }
    
    private void inicializarTablero(){
        tablero = new Tablero();  
    }
    
    private void salidaJugadores(){
        for (Jugador j: jugadores){
            j.setCasillaActual(tablero.obtenerCasillaNumero(0));
            j.setSaldo(7500);
        }
        
        jugadorActual = jugadores.get((int) (Math.random() * jugadores.size()));
    }
    
    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }
    
    public ArrayList<Sorpresa> getMazo() {
        return this.mazo;
    }
}
