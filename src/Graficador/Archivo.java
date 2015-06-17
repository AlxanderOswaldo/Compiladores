package Graficador;

import java.io.*;
/**
 * Es una clase que ns permite manejar archivos sarializados
 * de cualquier objeto. Es una plantilla
 * @author Nosferatualx
 */
public class Archivo <A>{
    private File file;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;

    public Archivo(File file) {
        this.file=file;
    }
    
    private void Escribir(A obj)throws IOException{
        salida=new ObjectOutputStream(new FileOutputStream(file));
        if(salida!=null)
            salida.writeObject(obj);
        if(salida!=null)
            salida.close();
    }
    
    private A Leer()throws IOException,ClassNotFoundException{
        entrada=new ObjectInputStream(new FileInputStream(file));
        A obj=null;
        if(entrada!=null)
            obj=(A)entrada.readObject();
        if(entrada!=null)
            entrada.close();
        return obj;
    }
    
    public boolean Salvar(A objetos){
        try{
            if(!file.exists())
                file.createNewFile();
            Escribir(objetos);
            return true;
        }catch(IOException exc){
            javax.swing.JOptionPane.showMessageDialog(null, 
                    "Error en  la Lectura del Archivo\n"+
                    exc.getMessage());
            return false;
        }
    }
 
    public A Recuperar(){
        A aux=null;
        try {
            aux=Leer();
            return aux;
        } catch (EOFException eof) {
            return aux;
        }
        catch(IOException exc){
            javax.swing.JOptionPane.showMessageDialog(null, 
                    "Erro en  la Lectura del Archivo\n"+
                    exc.getMessage());
            return aux;
        }
        catch (ClassNotFoundException cf){
            javax.swing.JOptionPane.showMessageDialog(null, 
                    "Archivo Inexistente"+
                    cf.getMessage());
            return aux;
        }
    }
    
}

