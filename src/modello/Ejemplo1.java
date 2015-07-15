/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modello;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java_cup.runtime.Symbol;

/**
 *
 * @author Danny Mencos
 */
public class Ejemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {
        // TODO code application logic here
      Yylex l= new Yylex(new java.io.FileInputStream("./src/modello/entrada.txt"));  
//           while(l.fin!=true){
//         l.next_token();      
////    }
//        System.out.println(l.lexema);
//        System.out.println("Fin archivo");
//        System.out.println("---------------");
//        System.out.println("Analisis Sintáctico");
           ArrayList<String> at= new ArrayList<>();
           at.add(new String("hola"));
    parser sintactico= new parser(l);
    Symbol tree= sintactico.parse();
    try{
    sintactico.parse();
   
    }catch(Exception e){
        System.out.println(e);
    }
       System.out.println(sintactico.mensaje_error);
      int a=3;
    int y = 0;
       while (a==3){
        y++;   
        
        System.out.println(y+"yyyyyyyyyy");
       }
        
    }  
}
