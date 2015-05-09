package modelo;

public class Token {
    public static final int PUBLIC=0;
    public static int CLASS=1;
    public static int ID=2;
    public static int LLAVE_A=3;
    public static int PROTECTED=4;
    public static int PRIVATE=5;
    public static int TIPO_DATO=6;
    public static int PAREM_A=7;
    public static int PAREM_C=8;
    public static int LLAVE_C=9;
    public static int ERROR=10;
     
    private static final String []nombres={"PUBLIC","CLASS","ID","LLAVE_A",
    "PROTECTED", "PRIVATE","TIPO_DATO","PAREM_A","PAREM_C","LLAVE_C","ERROR"};
    
    public static String getDescripcion(int token){
        return nombres[token];
    }
}