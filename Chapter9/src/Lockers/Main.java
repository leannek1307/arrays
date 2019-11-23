/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lockers;

import java.util.*;
/**
 *
 * @author leannekim
 */
public class Main {
    public static void main(String[] args) {
        
        boolean[] lockers = new boolean[100];
        
        for (int i = 0; i < lockers.length; i++){           // set all lockers to true(open)
            lockers[i] = true;
        }

//      switch condition for every 2nd locker
        for (int i = 1; i < lockers.length; i += 2) {       
            if(lockers[i] == true){
                lockers[i] = false;
            } else {
                lockers[i] = true;
            }
        }
        
//        switch condition for every 3rd locker
        for (int i = 1; i < lockers.length; i += 3){        
            if(lockers[i] == true){
                lockers[i] = false;
            } else {
                lockers[i] = true;
            }
        }
        
//        switch condition for every 4th locker
        for (int i = 1; i < lockers.length; i += 4){
            if(lockers[i] == true){
                lockers[i] = false;
            } else {
                lockers[i] = true;
            }
        }
        
//        print condition of lockers (true = open, false = closed)
        for (int i = 0; i < lockers.length; i++){
            System.out.println(lockers[i]);
        }
    }
}

