package Graficador;

public class Grafoalxx {

    String madyacencia[][];

//    public Grafo(String[][] madyacencia) {
//        this.madyacencia = madyacencia;
//    }
    public String[][] vertices(String[] vertices) {
        madyacencia = new String[vertices.length + 1][vertices.length + 1];
       
        for (int i = 1; i < vertices.length+1; i++) {
            madyacencia[0][i] = vertices[i - 1];
        }
        for (int i = 1; i < vertices.length + 1; i++) {
            madyacencia[i][0] = vertices[i - 1];
        }
        madyacencia[0][0]="0";
        for (int i = 1; i < madyacencia.length; i++) {
            for (int j = 1; j < madyacencia.length; j++) {
                madyacencia[i][j]="0";
            }
  
        }
           madyacencia[1][2]="1";
              madyacencia[5][6]="1";
                 madyacencia[3][3]="1";
                    madyacencia[4][2]="1";
                      madyacencia[6][2]="1";
              madyacencia[6][6]="1";
                 madyacencia[1][3]="1";
                    madyacencia[5][2]="1";
        return madyacencia;
    }
public String adyacentes(){
    String adyacentes="";
    for (int i = 1; i < madyacencia.length; i++) {
        for (int j = 1; j < madyacencia.length; j++) {
            if(madyacencia[i][j].equals("1")){
               String fila= madyacencia[i][0];
                String columna= madyacencia[0][j];
                adyacentes+=fila+"----"+columna+"\n";
            }
        }
    }
        return adyacentes ;
}
    public static void main(String[] args) {
        Grafoalxx grafo = new Grafoalxx();
        String[] vertices = {"A", "B", "C", "D", "E", "F"};
        for (int i = 0; i < vertices.length + 1; i++) {
            for (int j = 0; j < vertices.length+1; j++) {
                System.out.print(grafo.vertices(vertices)[i][j] + "--");
            }
            System.out.println(" ");
        }
        System.out.println("Los vértices adyacentes son:");
        System.out.println(grafo.adyacentes());
    }
}
