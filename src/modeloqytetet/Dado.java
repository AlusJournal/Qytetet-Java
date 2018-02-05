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
public class Dado {
    //Singleton
    private static Dado instance = new Dado();
    
    private Dado(){
    }
    
    public Dado getInstance(){
        return instance;
    }
    
    //Metodos
    int tirar(){
        throw new UnsupportedOperationException("Sin implementar"); 
    }
}
