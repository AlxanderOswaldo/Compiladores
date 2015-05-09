
package modelo;


public class Archivo {

    private Object lista;
    private Object matriz;

    public Archivo() {
    }

    public Archivo(Object lista, Object matriz) {
        this.lista = lista;
        this.matriz = matriz;
    }

    /**
     * @return the lista
     */
    public Object getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(Object lista) {
        this.lista = lista;
    }

    /**
     * @return the matriz
     */
    public Object getMatriz() {
        return matriz;
    }

    /**
     * @param matriz the matriz to set
     */
    public void setMatriz(Object matriz) {
        this.matriz = matriz;
    }
    
}
