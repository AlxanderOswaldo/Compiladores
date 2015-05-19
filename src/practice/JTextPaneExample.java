/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practice;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.Color;

public class JTextPaneExample {
public JTextPaneExample(){
try {
String s = "Hola mundo, saludos";
StyleContext sc = new StyleContext();
JFrame f = new JFrame("Ejemplo JTextPane");

DefaultStyledDocument doc = new DefaultStyledDocument(sc);
JTextPane pane = new JTextPane(doc);

doc.insertString(0, s, null);

// Define el estilo
Style rojo = sc.addStyle("ConstantWidth", null);
StyleConstants.setForeground(rojo, Color.red);

Style verde = sc.addStyle("ConstantWidth", null);
StyleConstants.setForeground(verde, Color.green);

Style azul = sc.addStyle("ConstantWidth", null);
StyleConstants.setForeground(azul, Color.blue);

// Aplica el estilo
doc.setCharacterAttributes(0, 4, rojo, false);
doc.setCharacterAttributes(5, 5, verde, false);
doc.setCharacterAttributes(12, 7, azul, false);

f.getContentPane().add(new JScrollPane(pane));
f.setSize(400, 300);
f.setVisible(true);
} catch (Exception e) {
System.out.println(e.getMessage());
}

}
public static void main(String[] args){
JTextPaneExample valod = new JTextPaneExample();
}
}
