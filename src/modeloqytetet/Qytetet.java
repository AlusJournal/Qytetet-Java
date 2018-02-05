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
public class Qytetet {
    //Singleton
    private static Qytetet instance = new Qytetet();
    
    private Qytetet(){  
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
       throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public boolean cancelarHipoteca(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public boolean comprarTituloPropiedad(){
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    
    public boolean edificarCasa(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");  
    }
    public boolean edificarHotel(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    public Sorpresa getCartaActual(){
        return cartaActual; 
    }
    public Jugador getJugadorActual(){
        return jugadorActual;
    }
    public boolean hipotecarPropiedad(Casilla casilla)
    {
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    public void inicializarJuego(ArrayList<String> nombres){
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    public boolean jugar(){
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    public ArrayList<String> obtenerRanking(){
        throw new UnsupportedOperationException("Sin implementar"); 
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
        throw new UnsupportedOperationException("Sin implementar"); 
    }
    private void encarcelarJugador(){
        throw new UnsupportedOperationException("Sin implementar"); 
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
