package modelo;

public class Nodo {
    private String descripcion;
    private String lexema;
public int matriz[][];
    public Nodo() {
    }

    public Nodo(String descripcion, String lexema) {
        this.descripcion = descripcion;
        this.lexema = lexema;      
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the lexema
     */
    public String getLexema() {
        return lexema;
    }

    /**
     * @param lexema the lexema to set
     */
    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    /**
     * @return the token
     */
   
}
