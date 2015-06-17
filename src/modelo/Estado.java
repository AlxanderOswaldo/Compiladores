/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;
import vista.PnlLienzo;

/**
 *
 * @author fabian
 */
public class Estado {

    private String nombre;
    private ArrayList<Relacion> relaciones;
    private Graphics2D forma;
    private JPanel padre;

    private boolean inicio;
    private boolean fin;
    private int xA;
    private int yA;
    public final int tamx = 40;
    public final int tamy = 40;

    public Estado(String nombre, int x, int y, JPanel padre) {

        this.nombre = nombre;
        this.xA = x;
        this.yA = y;
        this.padre = padre;
        this.relaciones = new ArrayList<Relacion>();
        this.forma = (Graphics2D) padre.getGraphics();
        this.inicio = false;
        this.fin = false;

        padre.addMouseListener(new MouseListener() {

            MouseMotionListener ml = new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    setxA(e.getX());
                    setyA(e.getY());
                    dibujarYLimpiar();
                    PnlLienzo pl = (PnlLienzo) getPadre();
                    pl.pintar();
//                    //dibujar();
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet.");
                }
            };

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getX() > getxA() && e.getX() < (getxA() + tamx) && e.getY() > getyA() && e.getY() < (getyA() + tamy)) {
                    //System.out.println("++++"+actual().getNombre());
                    PnlLienzo pl = (PnlLienzo) getPadre();
                    if (pl.relacionActual.equals("")) {
                        return;
                    }
                    if (pl.actual == null) {
                        pl.actual = actual();
                        System.out.println("actual " + actual().nombre);
                    } else {
                        pl.actual.agregarRelacion(actual(), pl.relacionActual);
                        //System.out.println(pl.actual.relaciones);
                        pl.actual = null;
                        pl.relacionActual = "";
                        System.out.println("rel agregada");
                    }

                    pl.pintar();
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                //dibujar();
                if (e.getX() > getxA() && e.getX() < (getxA() + tamx) && e.getY() > getyA() && e.getY() < (getyA() + tamy)) {
                    getPadre().addMouseMotionListener(ml);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                getPadre().removeMouseMotionListener(ml);
                //dibujar();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }

    public Graphics2D getForma() {
        return forma;
    }

    public void setForma(Graphics2D forma) {
        this.forma = forma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public JPanel getPadre() {
        return padre;
    }

    public void setPadre(JPanel padre) {
        this.padre = padre;
    }

    public ArrayList<Relacion> getRelaciones() {
        return relaciones;
    }

    public void setRelaciones(ArrayList<Relacion> relaciones) {
        this.relaciones = relaciones;
    }

    public int getxA() {
        return xA;
    }

    public void setxA(int xA) {
        this.xA = xA;
    }

    public int getyA() {
        return yA;
    }

    public void setyA(int yA) {
        this.yA = yA;
    }

    public boolean isFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    public boolean agregarRelacion(Estado ADonde, String nombre) {
        int cnt = 0;
        for (Relacion r : relaciones) {
            if (r.getHacia().equals(ADonde)) {
                r.setNombre(r.getNombre() + "|" + nombre);//cnt+=10;
                return true;
            }
        }
        Relacion r = new Relacion(nombre, this, ADonde, padre);
        //r.variacion=cnt;//(cnt==20)?20-cnt:cnt;                
        relaciones.add(r);

        System.out.println("----------------" + ADonde.getRelaciones());
        System.out.println("----------------" + relaciones);

        for (Relacion r2 : ADonde.relaciones) {
            System.out.println(r2.getDe().getNombre() + " " + this.getNombre());
            if (r2.getHacia().getNombre().equals(this.getNombre())) {
                cnt += 10;
                r2.variacion = (cnt > 20) ? 20 - cnt : cnt;
                System.out.println("-----------------------variacion");
            }
        }
        return true;
    }

    public void dibujarYLimpiar() {
        forma.setColor(Color.white);
        forma.fillRect(0, 0, padre.getWidth(), padre.getHeight());
        forma.setColor(Color.black);
//        forma.drawOval(xA, yA, tamx, tamy);
//        for(Relacion r:relaciones)
//        {
//            r.dibujar();                    
//        }
    }

    public void dibujar() {
        for (Relacion r : relaciones) {
            r.dibujar();
        }
    }

    public void dibujarCirculos() {
        forma.setColor(Color.white);
        forma.fillOval(xA, yA, tamx, tamy);
        forma.setColor(Color.black);
        forma.drawOval(xA, yA, tamx, tamy);
        forma.setFont(new Font("Arial", Font.BOLD, 20));
        forma.drawString(nombre, xA + 13, yA + 23);
        if (isInicio()) {
            forma.drawString("=>", xA - 20, yA + (tamy / 2));
        }
        if (isFin()) {
            forma.drawString("=>", xA + tamx, yA + (tamy / 2));
        }
    }

    public static void dibujarVarios(ArrayList<Estado> est) {
        for (Estado e : est) {
            e.dibujar();
        }
        for (Estado e : est) {
            e.dibujarCirculos();
        }
    }

    public String relacionesCon(String relacion) {
        String salida = "";
        for (Relacion r : relaciones) {
            if (Arrays.asList(r.getNombre().split("|")).contains(relacion)) {
                salida += r.getHacia().nombre + ",";
            }
        }
        return salida;
    }

    public Estado actual() {
        return this;
    }
}
