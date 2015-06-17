package Graficador;

import java.awt.Color;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Grafo implements java.io.Serializable{
    private ArrayList<NodoG> listaNodo;

    public Grafo(){
        listaNodo = new ArrayList<NodoG>();
    }
    public boolean adjuntarNodo(NodoG nodo){
        NodoG nodoTemp = buscarNodo(nodo.getDato());
        if(nodoTemp == null){
            listaNodo.add(nodo);
            return true;
        }else{
            return false;
        }
    }
   public void setListaNodonull(){
       listaNodo.clear();
   }
    public void crearEnlacesDirigido(NodoG padre,NodoG adyacente,Arista arista){
        if(padre != null && adyacente != null){
            padre.addNodoAdyacente(arista,adyacente);
        }
    }
    
    public void crearEnlacesNoDirigido(NodoG padre,NodoG adyacente,Arista arista){
        crearEnlacesDirigido(padre, adyacente, arista);
        crearEnlacesDirigido(adyacente,padre, arista);
    }
    
//    public void crearEnlaces(Object datoPadre,Object datoAdyacenete,Arista via){
//        Nodo padre = buscarNodo(datoPadre);
//        Nodo adyacente = buscarNodo(datoAdyacenete);
//        crearEnlaces(padre, adyacente, via);
//    }
    
    public NodoG buscarNodo(Object dato){
        NodoG temp = null;        
        if(dato != null){
            for(NodoG nodo:listaNodo){
                if(dato.equals(nodo.getDato())){
                    temp = nodo;              
                }
            }
        }
        return temp;
    }
    public NodoG buscarNodo(int x, int y){
        NodoG nodoAuxiliar = null;
        for(int i = 0; i < listaNodo.size(); i++){
            int xNodo = listaNodo.get(i).getCirculo().getX();
            int yNodo = listaNodo.get(i).getCirculo().getY();
            if(x > xNodo && x < (xNodo + listaNodo.get(i).getCirculo().getDiametro())){
                if(y > yNodo && y < (yNodo + listaNodo.get(i).getCirculo().getDiametro())){
                    nodoAuxiliar = listaNodo.get(i);
                    break;
                }
            }
        }
        return nodoAuxiliar;
    }
    
    public ArrayList<NodoG> getAdyacentes(Object dato){
        ArrayList<NodoG> lista = null;
        NodoG principal = buscarNodo(dato);
        ArrayList<Enlace> aristas = principal.getListaNodoAdyacente();
        if(aristas != null){
            for(int i = 0; i < aristas.size();i++){
                lista.add(aristas.get(i).getNodo());
            }
        }
        return lista;
    }
    public ArrayList<NodoG> getListaNodos(){
        return listaNodo;
    }
    public boolean isAdyacente(NodoG n1,NodoG n2){
        boolean aux = false;
        ArrayList<Enlace> listaAristas = n1.getListaNodoAdyacente();
        if(listaAristas != null){
            for(int i = 0;i < listaAristas.size();i++){
                if(listaAristas.get(i).getNodo() == n2){
                    aux = true;
                }
            }
        }
        return aux;
    }
    public boolean isAdyacente(Object datoNodoInicio,Object datoNodoDestino){
        boolean aux = false;
        NodoG n1 = buscarNodo(datoNodoInicio);
        NodoG n2 = buscarNodo(datoNodoDestino);
        ArrayList<Enlace> listaAristas = n1.getListaNodoAdyacente();
        if(listaAristas != null){
            for(int i = 0;i < listaAristas.size();i++){
                if(listaAristas.get(i).getNodo() == n2){
                    aux = true;
                }
            }
        }
        return aux;
    }
    public Arista getArista(Object datoNodo1,Object datoNodo2){
        return getArista(buscarNodo(datoNodo1),buscarNodo(datoNodo2));
    }
    public Arista getArista(String nombreVia){
        Arista aux = null;
        if(nombreVia != null){
            ArrayList<NodoG> listaN = listaNodo;
            for(NodoG nd:listaN){
                ArrayList<Enlace> lA = nd.getListaNodoAdyacente();
                for(Enlace enlace:lA){
                    if(enlace.getArista().getNombreArista().equals(nombreVia)){
                        aux = enlace.getArista();
                    }
                }
            }
        }
        return aux;
    }
    public Arista getArista(NodoG n1,NodoG n2){
        Arista aux = null;
        if(isAdyacente(n1, n2)){
            ArrayList<Enlace> listaAristas = n1.getListaNodoAdyacente();
            for(int i = 0;i < listaAristas.size();i++){
                if(listaAristas.get(i).getNodo() == n2){
                    aux = listaAristas.get(i).getArista();
                }
            }
        }else if(isAdyacente(n2, n1)){
            aux = getArista(n2, n1);
        }
        return aux;
    }
    public Enlace getEnlace(Object datoNodo1,Object datoNodo2){
        Enlace aux = null;
        if(isAdyacente(datoNodo1, datoNodo2)){
            NodoG n1 = buscarNodo(datoNodo1);
            NodoG n2 = buscarNodo(datoNodo2);
            ArrayList<Enlace> listaAristas = n1.getListaNodoAdyacente();
            for(int i = 0;i < listaAristas.size();i++){
                if(listaAristas.get(i).getNodo() == n2){
                    aux = listaAristas.get(i);
                }
            }
        }
        else if(isAdyacente(datoNodo2, datoNodo1)){
            aux = getEnlace(datoNodo2, datoNodo1);
        }
        return aux;
    }
    public void reiniciarGrafoParaDisjktra(){
        for(NodoG n:listaNodo){
            n.setMarca(false);
            n.setNodoAntecesorDisjktra(null);
            n.setLongitudCamino(-1);
        }
    }

    public boolean eliminarNodo(NodoG nodo){
        boolean retornado = false;
        if(nodo !=null){
            retornado = listaNodo.remove(nodo);
        }
        return retornado;
    }
    
    public void reiniciarColores() {
        if(listaNodo != null){
            for(NodoG nodo: listaNodo){
                nodo.getCirculo().setColor(Color.yellow);
            ArrayList<Enlace> la = nodo.getListaNodoAdyacente();
                if(la != null){
                    for(Enlace enlace:la){
                        if(enlace.getArista().isHabilitado()){
                            enlace.getArista().getLineaQuebrada().setColor(Color.black);
                            enlace.getArista().getLineaQuebrada().setGrosorLinea(1);
                        }
                    }
                }
            }
        }        
    }
    public ArrayList<Arista> aristasEntrante(NodoG nodo){
        ArrayList<Arista> listaArista = null;
        for(NodoG n:listaNodo){
            ArrayList<Enlace> enlaces = n.getListaNodoAdyacente();
            if(enlaces != null){
                listaArista = new ArrayList<Arista>();
                for(Enlace e:enlaces){
                    if(e.getNodo()==nodo){
                        listaArista.add(e.getArista());
                    }
                }
            }
        }
        return listaArista;
    }
    public ArrayList<Arista> aristasSaliente(NodoG nodo){
        ArrayList<Arista> listaArista = null;
        if(nodo != null){
            if(listaNodo.contains(nodo)){                
                ArrayList<Enlace> listaEnlace = nodo.getListaNodoAdyacente();
                if(listaArista != null){
                    listaArista = new ArrayList<Arista>();
                    for(Enlace e:listaEnlace){
                        listaArista.add(e.getArista());
                    }
                }
            }
        }
        return listaArista;
    }
    
    private void eliminarAristas(NodoG nodo){
        ArrayList<Arista> aristas = aristasSaliente(nodo);        
        for(Arista a:aristas){
            a = null;
        }
    }
    public void eliminarAristasSalientes(NodoG nodo){
        ArrayList<Arista> aristas = aristasSaliente(nodo);        
        eliminarAristas(nodo);
    }
    public void eliminarAristasEntrante(NodoG nodo){
        ArrayList<Arista> aristas = aristasEntrante(nodo)        ;
        eliminarAristas(nodo);
    }
     public void guardar(String directorio) {
    ArrayList<Grafo> array=new ArrayList<>();
    try{
 XMLEncoder encoder = new XMLEncoder(new FileOutputStream(directorio));
// 
//           for (int i = 0; i < listaNodo.size(); i++) {
//           
//               if(i<NumElementos){
//               array.add((Nota)A[i]);  
//               }
//               else {
//               array.add(null);
//               }
//        }
   
           encoder.writeObject(array);
            encoder.close();
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
    
  JOptionPane.showMessageDialog(null, "El archivo fue guardado satisfactoriamente");
}
 
     public void Cargar(java.io.File file){
        Archivo archivo=new Archivo(file);
        listaNodo=(ArrayList<NodoG>) archivo.Recuperar();
    }
}