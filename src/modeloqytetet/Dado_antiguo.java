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
public class Dado_antiguo {
    //Singleton
    private static Dado_antiguo instance = new Dado_antiguo();
    
    private Dado_antiguo(){
    }
    
    public static Dado_antiguo getInstance(){
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
