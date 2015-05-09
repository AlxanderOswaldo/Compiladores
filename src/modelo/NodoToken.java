package modelo;

public class NodoToken {
    private int token;
    private String lexema;

    public NodoToken() {
    }
//..
    public NodoToken(int token, String lexema) {
        this.token = token;
        this.lexema = lexema;
    }

    /**
     * @return the token
     */
    public int getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(int token) {
        this.token = token;
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
    
    
}
