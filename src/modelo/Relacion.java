/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author fabian
 */
public class Relacion{
    
    private String nombre;
    private Graphics2D forma;
    private Estado de;
    private Estado hacia;
    public int variacion=0;
    
    public  Relacion(String nombre,Estado a,Estado b,JPanel padre)
    {
        this.nombre=nombre;        
        de=a;
        hacia=b;        
        forma=(Graphics2D)padre.getGraphics();
    }
        
    public void dibujar()
    {
        
        int x1=de.getxA();
        int y1=-de.getyA();
        
        int x2=hacia.getxA();
        int y2=-hacia.getyA();

        String pos="";
        if(x1>x2+90 || x2>x1+90)
        {
            pos=(x1>x2)?"":"";
        }
        else
            pos=(y1>y2)?"":"";    
//        
        if(de.equals(hacia))
        {
            forma.setColor(Color.black);
            forma.drawArc(de.getxA()+(de.tamx/3), de.getyA()-de.tamy, de.tamx/2, de.tamy*3, 0, 180);
            forma.setColor(Color.red);
            //System.out.println("igual ---"+this+"--de"+this.getDe().getRelaciones());
            forma.drawString(nombre,de.getxA()+(de.tamx/3), de.getyA()-de.tamy);
            return;
        }
        forma.setColor(Color.black);
        forma.setFont(new Font("Arial", Font.BOLD, 12));
        
        forma.drawLine(de.getxA()+(de.tamx/2), de.getyA()+(de.tamy/2)+variacion,hacia.getxA()+(hacia.tamx/2), hacia.getyA()+(hacia.tamy/2)+variacion);
        int x=(de.getxA()+hacia.getxA())/2;//+de.tamx;//(-de.getxA())/2;
        int y=(de.getyA()+hacia.getyA())/2;//+de.tamy;//(hacia.getyA()-de.getyA())/2;
    
        forma.setColor(Color.red);
        forma.drawString(pos+" "+nombre, x+20+variacion, y+20+variacion);
        forma.setColor(Color.black);
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    public Estado getDe() {
        return de;
    }

    public void setDe(Estado de) {
        this.de = de;
    }

    public Estado getHacia() {
        return hacia;
    }

    public void setHacia(Estado hacia) {
        this.hacia = hacia;
    }
    
    public String toString()
    {
        return nombre+" de "+de.getNombre()+" hacia "+hacia.getNombre();
    }
}
