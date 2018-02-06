/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.Random;

/**
 *
 * @author Paula Ruiz
 */
public class Dado {
    //Singleton
    private static Dado instance = new Dado();
    
    private Dado(){
    }
    
    public static Dado getInstance(){
        return instance;
    }
    
    //Metodos
    int tirar(){
        Random rnd = new Random();
        int i = rnd.nextInt(5);
        i++;
        return i;
    }
}
