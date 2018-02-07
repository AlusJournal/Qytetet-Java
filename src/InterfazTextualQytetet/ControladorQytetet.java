/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazTextualQytetet;

import java.util.ArrayList;
import modeloqytetet.Casilla;
import modeloqytetet.Jugador;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.Qytetet;
import modeloqytetet.TituloPropiedad;

/**
 *
 * @author Paula Ruiz
 */
public class ControladorQytetet {
   private Qytetet juego;
   private Jugador jugador;
   private Casilla casilla;
   private VistaTextualQytetet vista; 
   
   private ControladorQytetet(){
       inicializacionJuego();
       desarrolloJuego();
   }
   
   public void desarrolloJuego(){
        boolean finalJuego = false;
        while(!finalJuego){
            vista.mostrar("Turno de Jugador " + jugador.getNombre() + " con saldo= " + jugador.getSaldo());
            boolean sigueJugando = true;

            if(jugador.getEncarcelado()){
                vista.mostrar("Estas en la carcel");
                MetodoSalirCarcel metodo = null;
                switch(vista.menuSalirCarcel()){
                    case 0: 
                        metodo = MetodoSalirCarcel.TIRANDODADO;
                        break;
                    case 1:
                        metodo = MetodoSalirCarcel.PAGANDOLIBERTAD;
                        break;
                }

                boolean sale = juego.intentarSalirCarcel(metodo);
                if(sale){
                    vista.mostrar("!Lo has conseguido! Has podido salir de la carcel, sigues jugando.");
                }
                else{
                    vista.mostrar("No has conseguido salir de la carcel, pierdes turno.");
                    sigueJugando = false; 
                }

            }

            if(sigueJugando){
                boolean tienePropietario = juego.jugar();
                vista.mostrar("Ahora estas en la casilla -> " + jugador.getCasillaActual());
                switch(jugador.getCasillaActual().getTipo()){
                    case SORPRESA:
                        vista.mostrar("·Has caído en una casilla sorpresa");
                        vista.mostrar(juego.getCartaActual().toString());
                        boolean nuevaCasilla = juego.aplicarSorpresa();
                        if (nuevaCasilla) {
                            vista.mostrar(" ·Has caído en una propiedad con propietario y has pagado su alquiler");
                        }
                        break;
                    case CALLE: 
                        if (tienePropietario) {
                            vista.mostrar("·Has caído en una casilla con propietario");
                        } 
                        else {
                            vista.mostrar("·Esta casilla no tiene propietario");
                            boolean comprar = vista.elegirQuieroComprar();
                            if (comprar) {
                                boolean puedoComprar = juego.comprarTituloPropiedad();
                                if (puedoComprar) {
                                    vista.mostrar("Has comprado la casilla -> " + jugador.getCasillaActual().getNumeroCasilla());
                                } 
                                else {
                                    vista.mostrar("No puedes comprar la casilla -> " + jugador.getCasillaActual().getNumeroCasilla());
                                }
                            }
                        }
                        break;
                }
            }

            if((!jugador.getEncarcelado())&&(jugador.tengoPropiedades())&&(jugador.getSaldo() > 0)){
                int opcion = vista.menuGestionInmobiliaria();
                ArrayList<String> listaPropiedades = new ArrayList();
                ArrayList<Casilla> casillas = new ArrayList();
                if(opcion == 5){
                    casillas = juego.propiedadesHipotecadasJugador(true);
                }
                else{
                    casillas = juego.propiedadesHipotecadasJugador(false);
                }
                for(Casilla c : casillas){
                    listaPropiedades.add(c.getTitulo().getNombre());
                }
                int propiedadElegida = 0;
                if(listaPropiedades.size() > 0 && opcion != 0){
                    propiedadElegida = vista.menuElegirPropiedad(listaPropiedades);
                }
                boolean puedo;
                switch (opcion){
                    case 1:
                        puedo = juego.edificarCasa(casillas.get(propiedadElegida));
                        if(puedo){
                            vista.mostrar("Has podido construir una casa.");
                        }
                        else{
                            vista.mostrar("No se ha podido construir la casa.");
                        }
                        break;
                    case 2:
                        puedo = juego.edificarHotel(casillas.get(propiedadElegida));
                        if(puedo){
                            vista.mostrar("Has podido construir un hotel.");
                        }
                        else{
                            vista.mostrar("No se ha podido construir el hotel.");
                        }
                        break;
                    case 3:
                        juego.venderPropiedad(casillas.get(propiedadElegida));
                        break;
                    case 4:
                        juego.hipotecarPropiedad(casillas.get(propiedadElegida));
                        break;
                    case 5:
                        juego.cancelarHipoteca(casillas.get(propiedadElegida));
                        break;
                    default:
                        break;
                }
            }

            if (jugador.getSaldo() <= 0) {
                    vista.mostrar(jugador.getNombre() + " ha caído en bancarrota. FINAL DEL JUEGO");
                    finalJuego = true;
                } 
            else {
                    jugador = juego.siguienteJugador();
                    casilla = jugador.getCasillaActual();
                }
        }
        
        ArrayList<String> nombres = juego.obtenerRanking();
        for(String nombre:nombres){
            vista.mostrar(nombre);
        }
   }
   
   private Casilla elegirPropiedad(ArrayList<Casilla> propiedades){
       vista.mostrar("\tCasilla\tTitulo");
        int seleccion;
        ArrayList<String> listaPropiedades= new ArrayList();
        for ( Casilla c: propiedades) {
            listaPropiedades.add( "\t"+c.getNumeroCasilla()+"\t"+c.getTitulo().getNombre()); 
        }
        seleccion=vista.menuElegirPropiedad(listaPropiedades);  
        return propiedades.get(seleccion);
   }
   
   public void inicializacionJuego(){
       juego = Qytetet.getInstance();
       vista = new VistaTextualQytetet();
       
       ArrayList<String> nombres = new ArrayList();
       nombres = vista.obtenerNombreJugadores();
       juego.inicializarJuego(nombres);

       jugador = juego.getJugadorActual();
       casilla = jugador.getCasillaActual(); 
   }
   
   public static void main(String[] args) {
        ControladorQytetet qytetet = new ControladorQytetet();
    }
   
}
