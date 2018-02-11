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
public class Especulador extends Jugador{
    private int fianza;
    
    public Especulador(Jugador jugador, int fianza) {
        super(jugador);
        this.fianza = fianza;
        this.factorEspeculador = 2;
    }
    
    @Override
    protected void pagarImpuestos(int cantidad){
         modificarSaldo((-1)*(cantidad / 2));
    }
    
    @Override
    protected void irACarcel(Casilla casilla){
        boolean evitarCarcel = pagarFianza(fianza);
        if (!evitarCarcel) {
            super.irACarcel(casilla);
        }
    }
    
    @Override
    protected Especulador convertirme(int fianza){
        return this;
    }
    
    private boolean pagarFianza(int cantidad){
        boolean tengoSaldo = tengoSaldo(cantidad);
        if (tengoSaldo) {
            modificarSaldo(-1 * cantidad);
        }
        return tengoSaldo;
    }
    
}
