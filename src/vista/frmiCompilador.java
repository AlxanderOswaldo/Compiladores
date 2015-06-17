/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.awt.Color;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.IDN;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Highlighter;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import jsyntaxpane.DefaultSyntaxKit;
import modelo.Compilador;
import modelo.Lectura;
import modelo.Nodo;

/**
 *
 * @author alxx_pc
 */
public class frmiCompilador extends javax.swing.JInternalFrame {

    ArrayList<Nodo> lista= frmiGenerar.getLista();
    ArrayList<Object> archivos= new ArrayList<>();
      ArrayList<Nodo> listasintactico;
      Lectura l;
       String []reservadas= {"public","class","void"};
        DefaultStyledDocument doc;
        StyleContext sc = new StyleContext();
            StyleContext negro = new StyleContext();
                Style rojo = sc.addStyle("ConstantWidth", null);
                   Style negr = negro.addStyle("ConstantWidth", null);
                    
    public frmiCompilador() {
       
        initComponents();
        leerlistaarchivo();
        mostrarlisaarchivos();
          DefaultSyntaxKit.initKit();
          txEditor.setContentType("text/sql");
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        poupAbrir = new javax.swing.JMenuItem();
        popupCerrar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstArchivos = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaLexico = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaSintactico = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txEditor = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnAbrir = new javax.swing.JMenuItem();
        btnGuardar = new javax.swing.JMenuItem();

        poupAbrir.setText("Abrir");
        poupAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poupAbrirActionPerformed(evt);
            }
        });
        jPopupMenu1.add(poupAbrir);

        popupCerrar.setText("Cerrar");
        popupCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupCerrarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popupCerrar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnEjecutar.setText("Play");
        btnEjecutar.setBorder(new javax.swing.border.MatteBorder(null));
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(btnEjecutar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(368, 368, 368))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEjecutar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        lstArchivos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Arcchivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 3, 14))); // NOI18N
        lstArchivos.setComponentPopupMenu(jPopupMenu1);
        lstArchivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstArchivosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lstArchivos);

        txaLexico.setColumns(20);
        txaLexico.setRows(5);
        txaLexico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Análisis Léxico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18))); // NOI18N
        jScrollPane3.setViewportView(txaLexico);

        txaSintactico.setColumns(20);
        txaSintactico.setRows(5);
        txaSintactico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Análisis Sintáctico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18))); // NOI18N
        jScrollPane4.setViewportView(txaSintactico);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setBorder(javax.swing.BorderFactory.createTitledBorder("Errores"));
        jScrollPane5.setViewportView(jTextArea4);

        txEditor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txEditorKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txEditor);

        jMenu1.setText("Archivo");

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(btnAbrir);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(btnGuardar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
       ArrayList<Nodo> lista= frmiGenerar.getLista();
       Object [][]matriz=frmiGenerar.getM();
        if(lista.size()>0){         
           Compilador c = new Compilador();
           listasintactico=c.getListasintactico();
        c.iniciarTira(txEditor.getText().toUpperCase().replaceAll("[\n\r]"," "));
                   txaLexico.setText(c.AnalisisLexico(lista));
           txaSintactico.setText(c.analisisSintactico(c.getListasintactico(), matriz)); 
//            for (int i = 0; i < c.getListasintactico().size(); i++) {
//                 System.out.println(c.getListasintactico().get(i).getLexema()+" se deben colorearr¡¡¡");
//            }
       }else{
           JOptionPane.showMessageDialog(this, "Cargar tokens y matriz");
       }
        
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
          try
 {
  String nombre="";
  JFileChooser file=new JFileChooser();
  file.showSaveDialog(this);
  File guarda =file.getSelectedFile();
 
  if(guarda !=null)
  {
   /*guardamos el archivo y le damos el formato directamente,
    * si queremos que se guarde en formato doc lo definimos como .doc*/
    FileWriter  save=new FileWriter(guarda+".txt");
    save.write(txEditor.getText());
    save.close();
    String dir=guarda+"";
    archivos.add(dir);
    guardarlistaarchivo();
    mostrarlisaarchivos();
    JOptionPane.showMessageDialog(null,
         "El archivo se a guardado Exitosamente",
             "Información",JOptionPane.INFORMATION_MESSAGE);
    }
 }
  catch(IOException ex)
  {
   JOptionPane.showMessageDialog(null,
        "Su archivo no se ha guardado",
           "Advertencia",JOptionPane.WARNING_MESSAGE);
  }
 
    }//GEN-LAST:event_btnGuardarActionPerformed
public void guardarlistaarchivo(){
    try{
XMLEncoder o = new XMLEncoder(new FileOutputStream("Archivos"));
                o.writeObject(archivos);
                o.close();
                }catch(Exception e){}
}
public void leerlistaarchivo(){
    try{
    XMLDecoder i = new XMLDecoder(new FileInputStream("Archivos"));
       Object z = i.readObject();
     archivos= (ArrayList<Object>) z;
       }catch(Exception e){}
}
public void mostrarlisaarchivos(){
   lstArchivos.setListData(archivos.toArray());
}
    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
      
  String aux="";   
  String texto="";
  try{
   /**llamamos el metodo que permite cargar la ventana*/
   JFileChooser file=new JFileChooser();
   file.showOpenDialog(this);
   /**abrimos el archivo seleccionado*/
   File abre=file.getSelectedFile();
 
   /**recorremos el archivo, lo leemos para plasmarlo
   *en el area de texto*/
   if(abre!=null){     
      FileReader archivos=new FileReader(abre);
      BufferedReader lee=new BufferedReader(archivos);
      while((aux=lee.readLine())!=null) {
         texto+= aux+ "\n";
      }
         lee.close();
    }
    txEditor.setText(texto);
   }
   catch(IOException ex){
     JOptionPane.showMessageDialog(null,ex+"" +
           "\nNo se ha encontrado el archivo",
                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
    }
 
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void lstArchivosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstArchivosMouseReleased
      if(evt.isPopupTrigger()){
          int indx=lstArchivos.locationToIndex(evt.getPoint());
          if(indx!=-1){
            
 lstArchivos.setSelectedIndex(indx);  
          jPopupMenu1.setLocation(evt.getLocationOnScreen());
          
          
          }
         
      }
        
               
    }//GEN-LAST:event_lstArchivosMouseReleased

    private void poupAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poupAbrirActionPerformed
       String dir= (String) lstArchivos.getSelectedValue();
        System.out.println(dir);
         String aux="";   
  String texto="";
  try{
   File abre=new File(dir);
   /**recorremos el archivo, lo leemos para plasmarlo
   *en el area de texto*/
   if(abre!=null){     
      FileReader archivos=new FileReader(abre);
      BufferedReader lee=new BufferedReader(archivos);
      while((aux=lee.readLine())!=null) {
         texto+= aux+ "\n";
      }
         lee.close();
    }
    txEditor.setText(texto);
   }
   catch(IOException ex){
     JOptionPane.showMessageDialog(null,ex+"" +
           "\nNo se ha encontrado el archivo",
                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_poupAbrirActionPerformed

    private void popupCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupCerrarActionPerformed
              int x= lstArchivos.getSelectedIndex();
             archivos.remove(x);
             lstArchivos.setListData(archivos.toArray());
    }//GEN-LAST:event_popupCerrarActionPerformed

    private void txEditorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txEditorKeyReleased
        btnEjecutarActionPerformed(null);
    }//GEN-LAST:event_txEditorKeyReleased

          //public ArrayList<Nodo> getLista(){
//     ArrayList<Nodo> a; 
//       Lectura l= new Lectura(txpCodigo.getText().replaceAll("\n", ""));
//    while (true) {
//          Nodo x;
//            String tokenActual = l.getToken();
//                      if (tokenActual == null) {
//                break;
//            }
//           x= new Nodo(title, tokenActual);
//    }
//        return null; 
//}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAbrir;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JMenuItem btnGuardar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JList lstArchivos;
    private javax.swing.JMenuItem popupCerrar;
    private javax.swing.JMenuItem poupAbrir;
    private javax.swing.JEditorPane txEditor;
    private javax.swing.JTextArea txaLexico;
    private javax.swing.JTextArea txaSintactico;
    // End of variables declaration//GEN-END:variables
}
