package modelo;

public class Lectura {

    private int pos;
    private String cadena;

    public Lectura(String cadena) {
        pos = 0;
        this.cadena = cadena;
    }

    private void eliminarEspacios() {
        while (pos < cadena.length()
                && cadena.charAt(pos) == ' ') {
            pos++;
        }
    }

    private String leerToken() {
        eliminarEspacios();
        String retorno = "";
        String separadores = "+-*/{},.;=[]&| ()<>'#";
        while (pos < cadena.length()
                && separadores.indexOf("" + cadena.charAt(pos)) < 0) {
            retorno = retorno + cadena.charAt(pos);
            pos++;
        }
        if (pos < cadena.length() && retorno.equals("")) {
            retorno = "" + cadena.charAt(pos);
            pos++;
        }
        if (pos == cadena.length() && retorno.equals("")) {
            return null;
        }
        return retorno;
    }

    public String getToken() {
        return leerToken();
    }

    public static void main(String[] args) {
        Lectura lec = new Lectura("int a=12;");
        while (true) {
            String cad = lec.getToken();
            if (cad == null) {
                break;
            }
            System.out.println(cad);
        }

    }
}
