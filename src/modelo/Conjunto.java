/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author fabian
 */
public class Conjunto <T>{   

    private ArrayList<T> elementos;

    public Conjunto() {
    }

    
    
    
    public Conjunto(ArrayList<T> elementos) {
        this.elementos = elementos;
    }
    
    public void validarIguales()
    {
        if(elementos.isEmpty())return;
        for (int i=0;i<elementos.size();i++) {
            T s=elementos.get(i);
            int aux=0;
            for (int j=0;j<elementos.size();j++) {
                if(elementos.get(i).equals(elementos.get(j)))
                    aux++;
            }
            //System.out.println("remover "+aux+"de "+elementos.get(i));
            for(int k=1;k<aux;k++)
            {
                elementos.remove(s);
            }
        }
    }
    
    public boolean insertar(T item)
    {
        for (T e : elementos) {
            if(item.equals(e))
                return false;
        }
        elementos.add(item);
        return true;
    }
    
    public boolean eliminar(T item)
    {
        for (int i=0;i<elementos.size();i++) {
            if(item.equals(elementos.get(i)))
            {
                elementos.remove(i);
                return true;
            }
                
        }
        return false;
    }

    public ArrayList<T> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<T> elementos) {
        this.elementos = elementos;
    }
    
//    public boolean iguales(Conjunto<T>b)
//    {
//        if(b.getElementos().size()==this.elementos.size())
//        {
//            for(T item : b.getElementos())
//            {
//                if(!this.elementos.contains(item))
//                {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }
    
    
    
    public boolean equals(Conjunto<T> b)
    {
         if(b.getElementos().size()==this.elementos.size())
        {
            for(T item : b.getElementos())
            {
                if(!this.elementos.contains(item))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    @Override
    public boolean equals(Object o)
    {
        Conjunto<T>b=(Conjunto<T>)o;
         if(b.getElementos().size()==this.elementos.size())
        {
            for(T item : b.getElementos())
            {
                if(!this.elementos.contains(item))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
//    
//    
//    
//    public boolean esSubC(Conjunto<T> b)
//    {
//        if(elementos.isEmpty() || b.getElementos().isEmpty())return false;
//        for (T item : b.getElementos()) {
//            if(!elementos.contains(b))
//                return false;
//        }
//        return true;
//    }
}
