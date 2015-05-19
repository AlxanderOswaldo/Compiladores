/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alxx_pc
 */
public class Patrones {
   String palabra;

    public Patrones(String palabra) {
        this.palabra = palabra;
    }
   public void patrons(){
       int count=0;
       Pattern p= Pattern.compile("^public$");
       Matcher m= p.matcher(palabra);
     while(m.find()){
         count++;
           System.out.println(count); 
       }
//           System.out.println("No lo reconoce");
       
   }
    public void lookingAt(){
       int count=0;
       Pattern p= Pattern.compile("^public$");
       Matcher m= p.matcher(palabra);
     while(m.lookingAt()){
         count++;
           System.out.println(count+"--looking At"); 
       }
//           System.out.println("No lo reconoce");
       
   }
    public static void main(String[] args) {
        Patrones p= new Patrones("publicc");
        p.patrons();
        p.lookingAt();
    }
}
