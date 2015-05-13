package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Compilador {

    private List<Token> lista = new ArrayList<>();
    private String tira;
    private Lectura lectura;
    private MatrizTransicion matriz = new MatrizTransicion();

    public void iniciarTira(String tira) {
        this.tira = tira;
        lista.clear();
        lectura = new Lectura(tira);
    }

    public List<Token> getListaToken() {
        return lista;
    }

    public void analisisLexico() {
        while (true) {
            String tokenActual = lectura.getToken();
            if (tokenActual == null) {
                break;
            }
            NodoToken nodo = null;
            Pattern pat = Pattern.compile("[a-zA-Z_][a-zA-Z0-9_]*");
            if (tokenActual.equals("{")) {
                nodo = new NodoToken(Token.LLAVE_A, tokenActual);
            } else if (tokenActual.equals("}")) {
                nodo = new NodoToken(Token.LLAVE_C, tokenActual);
            } else if (tokenActual.equals("(")) {
                nodo = new NodoToken(Token.PAREM_A, tokenActual);
            } else if (tokenActual.equals(")")) {
                nodo = new NodoToken(Token.PAREM_C, tokenActual);
            } else if (tokenActual.equals("public")) {
                nodo = new NodoToken(Token.PUBLIC, tokenActual);
            } else if (tokenActual.equals("class")) {
                nodo = new NodoToken(Token.CLASS, tokenActual);
            } else if (tokenActual.equals("protected")) {
                nodo = new NodoToken(Token.PROTECTED, tokenActual);
            } else if (tokenActual.equals("private")) {
                nodo = new NodoToken(Token.PRIVATE, tokenActual);
            } else if (tokenActual.equals("int") || tokenActual.equals("long")
                    || tokenActual.equals("String") || tokenActual.equals("double")) {
                nodo = new NodoToken(Token.TIPO_DATO, tokenActual);
            } else if (pat.matcher(tokenActual).matches()) {
                nodo = new NodoToken(Token.ID, tokenActual);
            } else {
                nodo = new NodoToken(Token.ERROR, tokenActual);
            }
//            lista.add(nodo);
        }
    }

    

    public String AnalisisLexico(ArrayList<Nodo> token) {
        String mensaje = "";

 Pattern pat = Pattern.compile("[a-zA-Z_][a-zA-Z0-9_]*");
        while (true) {
            String tokenActual = lectura.getToken();
            System.out.println(tokenActual);
            if (tokenActual == null) {
                break;
            } 
            boolean error=true;
            boolean identificador=true;
            if((tokenActual.trim().length()>0) &&(!tokenActual.trim().equals(" "))){
            for (int i = 0; i < token.size(); i++) {
                if (tokenActual.equals(token.get(i).getLexema())) {
                    mensaje += token.get(i).getDescripcion() + "\t -> " + token.get(i).getLexema() + "\n";
                    error=false;
                    identificador=false;
                    break;
                                    } 
            }
            if(identificador==true){
                if (pat.matcher(tokenActual).matches()) {                
                        mensaje += "Identificador" + "\t -> " + tokenActual + "\n"; 
                        error=false;
                        
                }
            }
            if(error==true){
                mensaje += "Error" + "\t -> " + tokenActual+ "\n";
            }   
        }
        }
        return mensaje;
    }

    public void analisisSintactico(ArrayList<Nodo> lista, Object[][]matriz) {
        if (lista.size() > 0) {
            String estadoInicial = "0";
            for (Nodo t : lista) {
                String token=t.getLexema();
                int columna = 0;
                for (int i = 1; i <matriz[0].length; i++) {
                   if(matriz[0][i].toString().equals(token)){
                    columna=i;
                   break;
                   }
                }
                
                 int fila = 0;
                for (int i = 1; i <matriz.length; i++) {
                   if(matriz[i][0].toString().equals(estadoInicial)){
                    fila=i;
                   break;
                   }
                }
                       
               String estadoSiguiente =  (String) matriz[fila][columna];
                if(estadoSiguiente == null){
                    System.out.println("ERROR DE SINTAXIS");
                    return;
                }
                estadoInicial = estadoSiguiente;
            }
            System.out.println("CORRECTO");
        }
    }
   public void AnalisisSintactico() {
        if (lista.size() > 0) {
            int estadoInicial = 0;
//            for (Nodo t : lista) {
//                int estadoSiguiente = matriz.getSiguiente(estadoInicial, t.getToken());
//                if(estadoSiguiente == -1){
//                    System.out.println("ERROR DE SINTAXIS");
//                    return;
//                }
//                estadoInicial = estadoSiguiente;
//            }
            System.out.println("CORRECTO");
        }
    }
    public static void main(String[] args) {
        Compilador c = new Compilador();
        c.iniciarTira("public class Compilador private { ");
        c.analisisLexico();
//        List<NodoToken> ele = c.getListaToken();
//        for (NodoToken e : ele) {
//            System.out.println(Token.getDescripcion(e.getToken()) + "\t -> " + e.getLexema());
//        }
        System.out.println("--------------------------------");
//        c.analisisSintactico();
    }

}
