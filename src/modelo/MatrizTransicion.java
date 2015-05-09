package modelo;

public class MatrizTransicion {

    private int[][] matriz = new int[12][11];

    public MatrizTransicion() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = -1;
            }
        }
        matriz[0][Token.PUBLIC] = 1;
        matriz[1][Token.CLASS] = 2;
        matriz[2][Token.ID] = 3;
        matriz[3][Token.LLAVE_A] = 4;
        matriz[4][Token.PUBLIC] = 5;
        matriz[4][Token.PROTECTED] = 5;
        matriz[4][Token.PRIVATE] = 5;
        matriz[5][Token.TIPO_DATO] = 6;
        matriz[6][Token.ID] = 7;
        matriz[7][Token.PAREM_A] = 8;
        matriz[8][Token.PAREM_C] = 9;
        matriz[9][Token.LLAVE_A] = 10;
        matriz[10][Token.LLAVE_C] = 11;
        matriz[11][Token.PUBLIC] = 5;
        matriz[11][Token.PROTECTED] = 5;
        matriz[11][Token.PRIVATE] = 5;
        matriz[11][Token.LLAVE_C] = 12;
    }
    
    public int getSiguiente(int estadoInicial,int token){
        return matriz[estadoInicial][token];
    }

}
