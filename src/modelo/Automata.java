
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author fabian
 */
public class Automata {   
    
    public static final String lamda="^";
    
    private Conjunto<String> estados;
    private Conjunto<String> alfabeto;
    private Conjunto<Integer> inicio;
    private Conjunto<Integer> fin;
    private String [][] relacion;

    
    public Automata(){}
    
    public Conjunto<String> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(Conjunto<String> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public Conjunto<String> getEstados() {
        return estados;
    }

    public void setEstados(Conjunto<String> estados) {
        this.estados = estados;
    }

    public Conjunto<Integer> getFin() {
        return fin;
    }

    public void setFin(Conjunto<Integer> fin) {
        this.fin = fin;
    }

    public Conjunto<Integer> getInicio() {
        return inicio;
    }

    public void setInicio(Conjunto<Integer> inicio) {
        this.inicio = inicio;
    }

    public String[][] getRelacion() {
        return relacion;
    }

    public void setRelacion(String[][] relacion) {
        this.relacion = relacion;
    }
    
    

    public Automata(Conjunto<String> estados, Conjunto<String> alfabeto, Conjunto<Integer> inicio, Conjunto<Integer> fin, String[][] relacion) {
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.inicio = inicio;
        this.fin = fin;
        this.relacion = relacion;
        
        this.estados.validarIguales();
        this.alfabeto.validarIguales();
        this.inicio.validarIguales();
        this.fin.validarIguales();
        
//        if(this.alfabeto.getElementos().contains(Automata.lamda))
//        {
//            this.alfabeto.getElementos().remove(Automata.lamda);
//            this.alfabeto.getElementos().add(Automata.lamda);
//            System.out.println(alfabeto.getElementos());
//        }
//        
    }
    

    
    
    public boolean validarInicialesFinales()
    {
        for (Integer item : inicio.getElementos()) {
            if(item >= estados.getElementos().size())
                return false;
        }
        for (Integer item : fin.getElementos()) {
            if(item >= estados.getElementos().size())
                return false;
        }
        return true;
    } 
        
    
    public boolean esAFD()
    {
        if(inicio.getElementos().size()==1 && !alfabeto.getElementos().contains(lamda))
        {
            for (int i = 0; i < relacion.length; i++) {
                for (int j = 0; j < relacion[i].length; j++) {
   
                    if(relacion[i][j].length()>1)
                        return false;
                }
            }
            return true;
        }
        return false;
    }
    
    
    public ArrayList<String> lamdaClausura(String elemento,ArrayList<String>ant)
    {
        ArrayList<String> el=new ArrayList<String>();
        el.add(elemento);
        if(alfabeto.getElementos().contains(Automata.lamda))
        {
            int columna=alfabeto.getElementos().indexOf(Automata.lamda);
            int fila=estados.getElementos().indexOf(elemento);
            //ArrayList<String>aux=new ArrayList<String>();
            String [] caminos=relacion[fila][columna].split(",");
            if(ant!=null )
            {                
                for (int i = 0; i < caminos.length; i++) {
                    if(!caminos[i].equals("") && !ant.contains(caminos[i]))
                    {                        
                        el.addAll(lamdaClausura(caminos[i], el));
                    }
                }
            }else
            {
                for (int i = 0; i < caminos.length; i++) {
                    //System.out.println("---"+caminos[0]);
                    if(!caminos[i].equals(""))
                    {                        
                        el.addAll(lamdaClausura(caminos[i], el));
                    }
                }
            }           
        }
        return el;
    }
    
    
    
    
    
    public Automata convertirAFD()
    {
        if(!esAFD())
        {
            System.out.println("Es afd___________");
            ArrayList<Conjunto<String>>nEstados=new ArrayList<Conjunto<String>>();
            ArrayList<String>nRelaciones=new ArrayList<String>();
            ArrayList<String>tmp=new ArrayList<String>();
            for (Integer i  : inicio.getElementos()) {                
                tmp.add(estados.getElementos().get(i));                
            }
            nEstados.add(new Conjunto<String>(tmp));
            
            for(int i=0;i<nEstados.size();i++)
            {
                tmp=new ArrayList<String>();
                for(String s:nEstados.get(i).getElementos())
                {
                    tmp.addAll(lamdaClausura(s, null));
                }
                Conjunto<String>aux=new Conjunto<String>(tmp);
                aux.validarIguales();
                if(i==0)
                {
                    nEstados.get(0).setElementos(tmp);
                }
                System.out.println(aux.getElementos()+"lamda clausura de "+nEstados.get(i).getElementos());
                for(int j=0;j<alfabeto.getElementos().size();j++)
                {                    
                    //tmp=aux.getElementos();
                    tmp=new ArrayList<String>();
                    if(alfabeto.getElementos().get(j).equals(Automata.lamda))continue;
                    for (int k=0;k<aux.getElementos().size();k++) {
                        String s=aux.getElementos().get(k);
                        int fila=estados.getElementos().indexOf(s);
                        System.out.println(fila+"-"+j+"----"+relacion[fila][j]);
                        if(!relacion[fila][j].equals(""))
                        {
                            tmp.addAll(Arrays.asList(relacion[fila][j].split(",")));
                        }
                    }
                    Conjunto<String>aux2=new Conjunto<String>(tmp);
                    aux2.validarIguales();
                    //System.out.println(aux.getElementos()+"conjunto");
                    int cnt=0;
                    for(Conjunto<String>c:nEstados)
                    {
                        if(c.equals(aux2))
                        {
                            cnt=nEstados.indexOf(c);
                            break;
                        }
                    }
                    String r;
                    if(cnt==0 && !aux2.getElementos().isEmpty())
                    {
                        nEstados.add(aux2);
                        r=nEstados.size()-1+"";
                        System.out.println("Nuevo Conjunto"+aux2.getElementos());
                        
                    }else if(aux2.getElementos().isEmpty())
                    {
                        r="";
                    }else
                    {
                        r=cnt+"";
                    }
                    nRelaciones.add(r);
                }
            }
            System.out.println("Array relacion:"+nRelaciones);
            //construir automata;
            ArrayList<String>ne=new ArrayList<String>();
            ArrayList<Integer>f=new ArrayList<Integer>();
            for(int i=0;i<nEstados.size();i++)
            {
                ne.add("q"+i);
                for (Integer item: fin.getElementos()) {
                    String s=estados.getElementos().get(item);
                    
                    if(nEstados.get(i).getElementos().contains(s))
                        f.add(i);
                }
            }
            
            ArrayList<String>na=new ArrayList<String>();
            for (int i=0;i<alfabeto.getElementos().size();i++) {
                
                if(!alfabeto.getElementos().get(i).equals(Automata.lamda))
                    na.add(alfabeto.getElementos().get(i));
                
            }
            String [][]r=new String [ne.size()][na.size()];
            for (int i = 0; i < r.length; i++) {
                for (int j = 0; j < r[0].length; j++) {
                    
                    r[i][j]="q"+nRelaciones.remove(0);
                    r[i][j]=(r[i][j].equals("q"))?"":r[i][j];
                    //System.out.print(r[i][j]+"-");
                }
                //System.out.println("");
            }
            
            ArrayList<Integer>i=new ArrayList<Integer>();i.add(0);
            
            
            
            
            
            
            return new Automata(new Conjunto<String>(ne), new Conjunto<String>(na), new Conjunto<Integer>(i), new Conjunto<Integer>(f), r);
        }
        return null;
    }
    
}
