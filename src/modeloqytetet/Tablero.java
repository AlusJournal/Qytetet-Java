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
public class Tablero {
    private ArrayList<Casilla> casillas;
    private Casilla carcel;
    
    public Tablero(){
        inicializar();
    }
    
    private void inicializar(){
        casillas = new ArrayList();
        
        //Casillas DISTINTAS de tipo Calle
        Casilla salida =  new Casilla(0, TipoCasilla.SALIDA);
        casillas.add(salida);
        Casilla sorpresa1 = new Casilla(3, TipoCasilla.SORPRESA);
        casillas.add(sorpresa1);
        Casilla sorpresa2 = new Casilla(8, TipoCasilla.SORPRESA);
        casillas.add(sorpresa2);
        Casilla sorpresa3 = new Casilla(14, TipoCasilla.SORPRESA);
        casillas.add(sorpresa3);
        this.carcel = new Casilla(15, TipoCasilla.CARCEL);
        casillas.add(this.carcel);
        Casilla juez = new Casilla(5, TipoCasilla.JUEZ);
        casillas.add(juez);
        Casilla parking = new Casilla(10, TipoCasilla.PARKING);
        casillas.add(parking);
        Casilla impuesto = new Casilla(18, TipoCasilla.IMPUESTO);
        casillas.add(impuesto);
        impuesto.setCoste(700);
        
        //Casillas de tipo Calle
        Casilla breakingBad = new Casilla(19, 2000, new TituloPropiedad("Breaking Bad", 100, 20, 1000, 750));
        casillas.add(breakingBad);
        Casilla narcos = new Casilla(17, 1900, new TituloPropiedad("Narcos", 100, 19, 950, 750));
        casillas.add(narcos);
        Casilla strangerThings = new Casilla(16, 1600, new TituloPropiedad("Stranger Things", 95, 18, 875, 650));
        casillas.add(strangerThings);
        Casilla thirteenrw = new Casilla(13, 1500, new TituloPropiedad("Thirteen Reasons Why", 90, 17, 800, 600));
        casillas.add(thirteenrw);
        Casilla theCrown = new Casilla(12, 1350, new TituloPropiedad("The Crown", 85, 16, 650, 500));
        casillas.add(theCrown);
        Casilla oitnb = new Casilla(11, 1300, new TituloPropiedad("Orange is the new Black", 80, 15, 500, 425)); 
        casillas.add(oitnb);
        Casilla houseOfCards = new Casilla(9, 1100, new TituloPropiedad("House of Cards", 75, 14, 450, 350));
        casillas.add(houseOfCards);
        Casilla jessica = new Casilla(7, 1000, new TituloPropiedad("Jessica Jones", 70, 13, 350, 350));
        casillas.add(jessica);
        Casilla gilmoregirls = new Casilla(6, 950, new TituloPropiedad("Girlmore Girls", 65, 12, 300, 300));
        casillas.add(gilmoregirls);
        Casilla senseeight = new Casilla(4, 900, new TituloPropiedad("Sense8", 60, 11, 250, 300)); 
        casillas.add(senseeight);
        Casilla daredevil = new Casilla(2, 800, new TituloPropiedad("Daredevil", 55, 10, 200, 250));
        casillas.add(daredevil);
        Casilla shadowhunters = new Casilla(1, 700, new TituloPropiedad("ShadowHunters", 50, 10, 150, 250));
        casillas.add(shadowhunters);
    }
    
    public Casilla getCarcel(){
        return carcel; 
    }
    
    @Override
    public String toString() {
        return "Tablero{" + "casillas=" + casillas + ", carcel=" + carcel + "}";
    }

}
