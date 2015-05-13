/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Compilador;
import modelo.Lectura;
import modelo.Nodo;

/**
 *
 * @author alxx_pc
 */
public class frmiCompilador extends javax.swing.JInternalFrame {

    ArrayList<Nodo> lista= frmiGenerar.getLista();
    public frmiCompilador() {
        initComponents();
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(lista.get(i).getDescripcion()+"---lista cargada¡¡");
//        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstArchivos = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaCodigo = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaLexico = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaSintactico = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnAbrir = new javax.swing.JMenuItem();
        btnGuardar = new javax.swing.JMenuItem();

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
                .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEjecutar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        lstArchivos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Arcchivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 3, 14))); // NOI18N
        jScrollPane1.setViewportView(lstArchivos);

        txaCodigo.setColumns(20);
        txaCodigo.setRows(5);
        txaCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txaCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txaCodigoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txaCodigo);

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

        jMenu1.setText("Archivo");

        btnAbrir.setText("Abrir");
        jMenu1.add(btnAbrir);

        btnGuardar.setText("Guardar");
        jMenu1.add(btnGuardar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txaCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaCodigoKeyPressed
//        String codigo= txaCodigo.getText();
//        String tokens[]= codigo.split("[ |,|(|)|{|}]");
//        for (int i = 0; i < tokens.length; i++) {
//            System.out.println(tokens[i]);
//        }
//        System.out.println(tokens.length);
    }//GEN-LAST:event_txaCodigoKeyPressed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
       ArrayList<Nodo> lista= frmiGenerar.getLista();
       Object [][]matriz=frmiGenerar.getM();
        if(lista.size()>0){         
           Compilador c = new Compilador();
        c.iniciarTira(txaCodigo.getText().replaceAll("\n", ""));
                   txaLexico.setText(c.AnalisisLexico(lista));
           txaSintactico.setText(c.analisisSintactico(c.getListasintactico(), matriz)); 
       }else{
           JOptionPane.showMessageDialog(this, "Cargar tokens y matriz");
       }
        
    }//GEN-LAST:event_btnEjecutarActionPerformed
public ArrayList<Nodo> getLista(){
     ArrayList<Nodo> a;
   
       Lectura l= new Lectura(txaCodigo.getText().replaceAll("\n", ""));
    while (true) {
          Nodo x;
            String tokenActual = l.getToken();
                      if (tokenActual == null) {
                break;
            }
           x= new Nodo(title, tokenActual);
    }
        return null;
  
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAbrir;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JMenuItem btnGuardar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JList lstArchivos;
    private javax.swing.JTextArea txaCodigo;
    private javax.swing.JTextArea txaLexico;
    private javax.swing.JTextArea txaSintactico;
    // End of variables declaration//GEN-END:variables
}
