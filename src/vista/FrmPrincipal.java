/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Archivo;
import modelo.Compilador;
import modelo.Lectura;
import modelo.Matrix;
import modelo.Nodo;

/**
 *
 * @author alxx_pc
 */
public class FrmPrincipal extends javax.swing.JFrame {
    Archivo arc;
   int [][]m;
     ArrayList<Nodo> lista= new ArrayList();
      DefaultTableModel tabla;
         DefaultTableModel tabla2=null;
    public FrmPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEnteros = new javax.swing.JButton();
        btnDecimal = new javax.swing.JButton();
        btnID = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtExpresion = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnReroceder = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNumEstados = new javax.swing.JTextField();
        btnGerenar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldatos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnGuardar = new javax.swing.JMenuItem();
        btnAbrir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Expresiones Regulares:");

        btnEnteros.setText("#E");
        btnEnteros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterosActionPerformed(evt);
            }
        });

        btnDecimal.setText("#D");
        btnDecimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecimalActionPerformed(evt);
            }
        });

        btnID.setText("ID");
        btnID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnteros)
                .addGap(18, 18, 18)
                .addComponent(btnDecimal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnID)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnEnteros)
                    .addComponent(btnDecimal)
                    .addComponent(btnID))
                .addContainerGap())
        );

        btnAdd.setText("ADD =)");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jTable1.setBorder(new javax.swing.border.MatteBorder(null));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Descripción Token");

        jLabel3.setText("Expresión Token");

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anterior2.jpg"))); // NOI18N
        btnInicio.setPreferredSize(new java.awt.Dimension(265, 213));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnReroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anterior1.jpg"))); // NOI18N
        btnReroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRerocederActionPerformed(evt);
            }
        });

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/siguiente1.jpg"))); // NOI18N
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/siguiente2.jpg"))); // NOI18N
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setText("X");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReroceder, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(btnDelete))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReroceder)
                .addGap(18, 18, 18)
                .addComponent(btnSiguiente)
                .addGap(18, 18, 18)
                .addComponent(btnUltimo)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnClear)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(btnAdd))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDescripcion)
                                    .addComponent(txtExpresion, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtExpresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(btnAdd)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(btnClear))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(44, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Tokens", jPanel1);

        jLabel4.setText("# de Estados");

        btnGerenar.setText("Generar");
        btnGerenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenarActionPerformed(evt);
            }
        });

        tbldatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbldatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnGerenar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGerenar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtNumEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Matriz", jPanel2);

        jMenu1.setText("Archivo");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(btnGuardar);

        btnAbrir.setText("Cargar Datos");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(btnAbrir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        for (int i = 0; i < lista.size(); i++) {
         if(lista.get(i).getDescripcion().equals(txtDescripcion.getText())){
             JOptionPane.showMessageDialog(this, "Ya existe el Descripción");
             return;
         } 
         if(lista.get(i).getLexema().equals(txtExpresion.getText())){
             JOptionPane.showMessageDialog(this, "Ya existe el Lexema");
            return;
         } 
        }
        Nodo token= new Nodo(txtDescripcion.getText(), txtExpresion.getText());
lista.add(token);
tabla= (DefaultTableModel) jTable1.getModel();
        String fila[]=  new  String[2];
        fila[0]=token.getDescripcion();
        fila[1]=token.getLexema();
    tabla.addRow(fila);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
 moveralinicio();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnRerocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRerocederActionPerformed
         anterior();
    }//GEN-LAST:event_btnRerocederActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
         siguiente();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
       moveralfinal();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIDActionPerformed
txtExpresion.setText("");
        txtExpresion.setText("[a-zA-Z_][a-zA-Z0-9_]*");
    }//GEN-LAST:event_btnIDActionPerformed

    private void btnDecimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecimalActionPerformed
     txtExpresion.setText("");
        txtExpresion.setText("/^-?[0-9]+([,\\.][0-9]*)?$/");
    }//GEN-LAST:event_btnDecimalActionPerformed

    private void btnEnterosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterosActionPerformed
txtExpresion.setText("");
        txtExpresion.setText("/^[0-9]+$/");
    }//GEN-LAST:event_btnEnterosActionPerformed

    private void btnGerenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenarActionPerformed
         if(txtNumEstados.getText().equals("")){
               JOptionPane.showMessageDialog(null, "Ingrese el # de Estados");
        return;
           }
try{
          final int x= Integer.parseInt(txtNumEstados.getText());
         tabla2 = new DefaultTableModel() {

   @Override
   public boolean isCellEditable(int row, int column) {
//             return column == 0;    
            if(column==0){
            return  false;
            }
       return true;    
   }
};  
//        tabla2 = (DefaultTableModel) tbldatos.getModel();
        tabla2.setColumnCount(0);
        tabla2.setRowCount(0);
//      tabla2.setValueAt(evt, 0, 0);
        tabla2.addColumn("");
      
        tabla2.setRowCount(x);
        for (int i = 0; i < lista.size(); i++) {
            tabla2.addColumn(lista.get(i).getDescripcion());
        }
        for (int i = 0; i < x; i++) {
            tabla2.setValueAt(i, i, 0);
 
        }
    tbldatos.setModel(tabla2);
       tbldatos.getColumnModel().getColumn(0).setCellRenderer(tbldatos.getTableHeader().getDefaultRenderer());
       }catch(Exception e){}
    }//GEN-LAST:event_btnGerenarActionPerformed
          public boolean isCellEditable(int rowIndex, int vColIndex) {
            return false;
        }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       GuardarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
      CargarDatos();
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
      lista.clear();
      llenartabla();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      int y =jTable1.getSelectedRow();
 lista.remove(y);
 llenartabla();
    }//GEN-LAST:event_btnDeleteActionPerformed
private void GuardarDatos() {  
        try {
         int estados[][];  
            if(tabla2!=null){
//     Matrix m= new Matrix();
                estados    = new int[tabla2.getRowCount()][tabla2.getColumnCount()-1]; 
                        for (int i = 0; i < tabla2.getRowCount(); i++) {
                for (int j = 1; j < tabla2.getColumnCount(); j++) {
                    if(tabla2.getValueAt(i, j)!=null){
                       String x=(String) tabla2.getValueAt(i, j);
                  estados[i][j-1]= Integer.parseInt(x);
            
                    }
                }
            }
                        for (int i = 0; i < estados.length; i++) {
                            for (int j = 0; j < estados.length; j++) {
                                System.out.print(estados[i][j]);  
                            }
                            System.out.println("");
                }
              
//                        arc.setMatriz(m);
                        JOptionPane.showMessageDialog(this, "Guardado¡¡¡");
             }else{
                estados=null;
                System.out.println("null-_-");
            }            
            arc= new Archivo(lista, estados);
            
            XMLEncoder o = new XMLEncoder(new FileOutputStream("Tokens"));
            o.writeObject(arc);
            o.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    //Cargar arrays de XML
    private void CargarDatos() {
        try {
            XMLDecoder i = new XMLDecoder(new FileInputStream("Tokens"));
            ArrayList<Archivo> arch= new ArrayList<>();
     
           tabla= (DefaultTableModel) jTable1.getModel();
           
           Object z=  i.readObject();
//           lista= (ArrayList<Nodo>) arch.get(0).getLista();
         Archivo d=(Archivo) z;
      
       lista= (ArrayList<Nodo>) d.getLista();
       if(d.getMatriz()!=null){
           System.out.println("Matriz¡¡¡");
           int a[][]= (int[][]) d.getMatriz();
             tabla2=(DefaultTableModel) tbldatos.getModel();
             
             for (int j = 0; j < tabla2.getRowCount(); j++) {
                 for (int k = 1; k < tabla2.getColumnCount(); k++) {
                 tabla2.setValueAt(a[j][k-1], j, k);
                 }
           }
       }
//              lista = (ArrayList<Nodo>) i.readObject();
                         llenartabla();
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
       
    }
   public void moveralinicio (){
    try{
  int tam= lista.size();
    int y =jTable1.getSelectedRow();
Nodo x=lista.get(y);
 lista.remove(y);
 Nodo[]aux= new Nodo[tam-1];
        for (int i = 0; i < tam-1; i++) {
          aux[i]=lista.get(i);
        }
                
 lista.clear();
 lista.add(x);
        for (int i = 0; i < tam-1; i++) {
            lista.add(aux[i]);
        }       
   llenartabla();
   }catch(Exception e){}
}
public void moveralfinal (){
    try{
  int tam= lista.size();
    int y =jTable1.getSelectedRow();
Nodo x=lista.get(y);
 lista.remove(y);
 Nodo[]aux= new Nodo[tam-1];
        for (int i = 0; i < tam-1; i++) {
          aux[i]=lista.get(i);
        }              
 lista.clear();
        for (int i = 0; i < tam-1; i++) {
            lista.add(aux[i]);
        }
        lista.add(x);
           llenartabla();
   }catch(Exception e){}
}
public void anterior (){
    try{
    int y =jTable1.getSelectedRow();
    int x=y-1;
Nodo actual=lista.get(y);
Nodo anterior=lista.get(y-1);
 lista.remove(y);
 lista.remove(x);
lista.add(x, actual);
lista.add(y, anterior);
           llenartabla();
   }catch(Exception e){}
}
public void siguiente (){
    try{
    int arriba =jTable1.getSelectedRow();
    int abajo=arriba+1;
Nodo actual=lista.get(arriba);
Nodo siguiente=lista.get(abajo);
 lista.remove(arriba);
 lista.add(arriba, siguiente);
 lista.remove(abajo);
 lista.add(abajo,actual);


           llenartabla();
   }catch(Exception e){}
}
public  void llenartabla(){
    try{
   removerfilas();
    for (int i = 0; i < lista.size(); i++) {
      String fila[]=  new  String[2]; 
        fila[0]=lista.get(i).getDescripcion();
        fila[1]=lista.get(i).getLexema();
        tabla.addRow(fila);
    }
      
   }catch(Exception e){} 
}
public void removerfilas(){
     try {
            DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
            int filas=jTable1.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
}
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAbrir;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDecimal;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEnteros;
    private javax.swing.JButton btnGerenar;
    private javax.swing.JMenuItem btnGuardar;
    private javax.swing.JButton btnID;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnReroceder;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbldatos;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtExpresion;
    private javax.swing.JTextField txtNumEstados;
    // End of variables declaration//GEN-END:variables
}
