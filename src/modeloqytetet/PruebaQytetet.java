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
public class PruebaQytetet {
    private final ArrayList<Sorpresa> mazo = new ArrayList(); 
    private Tablero tablero = new Tablero(); 
    
    private void inicializarSorpresas(){
        mazo.add(new Sorpresa ("Te hemos pillado con chanclas y calcetines, lo sentimos, ¡debes ir a la carcel!", tablero.getCarcel().getNumeroCasilla(), TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa ("Un fan anónimo ha pagado tu fianza. Sales de la cárcel", 0, TipoSorpresa.SALIRCARCEL));
        mazo.add(new Sorpresa ("¡Felicidades! hoy es el día de tu no cumpleaños, recibes un regalo de todos", 200, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa ("La liga antisupersticion te envia de viaje al numero 13", 13, TipoSorpresa.IRACASILLA));
    }
    
    public ArrayList<Sorpresa> valorCero(){
        ArrayList<Sorpresa> nueva = new ArrayList();
        for (Sorpresa s : mazo){
            if (s.getValor() > 0){
                nueva.add(s);
            }
        }
        return nueva;
    }
    
    public ArrayList<Sorpresa> tipoIrACasilla(){
        ArrayList<Sorpresa> nueva = new ArrayList();
        for (Sorpresa s : mazo){
            if (s.getTipo() == TipoSorpresa.IRACASILLA ){
                nueva.add(s);
            }
        }
        return nueva;
    }
    
    public ArrayList<Sorpresa> tipoArgumento (TipoSorpresa tipo){
        ArrayList<Sorpresa> nueva = new ArrayList();
        for (Sorpresa s: mazo){
            if (s.getTipo() == tipo){
                nueva.add(s);
            }
        }
        return nueva; 
    }
    
    public static void main(String[] args) {
       PruebaQytetet prueba = new PruebaQytetet(); 
       prueba.inicializarSorpresas();
       ArrayList<Sorpresa> nueva =new ArrayList(); 
       nueva = prueba.valorCero();
       System.out.println(nueva);
       nueva = prueba.tipoArgumento(TipoSorpresa.SALIRCARCEL);
       System.out.println(nueva);
       nueva = prueba.tipoIrACasilla(); 
       System.out.println(nueva);
    }
    
    
}
