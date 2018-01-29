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
public class Sorpresa {
    private final String texto; 
    private final TipoSorpresa tipo; 
    private final int valor; 
    
    public Sorpresa(String texto, int valor, TipoSorpresa tipo){
        this.texto = texto; 
        this.valor = valor;
        this.tipo = tipo; 
    }
    
    String getTexto(){
        return texto;
    }
    
    TipoSorpresa getTipo(){
        return tipo; 
    }
    
    int getValor(){
        return valor; 
    }
    
    @Override
    public String toString() {
        return "Sorpresa{" + "texto=" + texto + ", valor=" +
        Integer.toString(valor) + ", tipo=" + tipo + "}";
    }
}
