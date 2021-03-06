/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package papamama;

import javax.swing.JOptionPane;

/**
 *
 * @author Alexander
 */
public class Informe extends javax.swing.JFrame {
    funciones miFuncion = new funciones();
    String archivoh = "hijos.txt";
    String archivop = "padres.txt";

    /**
     * Creates new form Informe
     */
    public Informe() {
        initComponents();
        miFuncion.llenarTabla(tablaHijos, archivoh);
        miFuncion.llenarTabla(tablaPadres, archivop);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPadres = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHijos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoPadres = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        textoHijos = new javax.swing.JTextArea();

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Informe General");

        jLabel1.setText("Padres");

        tablaPadres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Edad", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPadres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPadresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPadres);

        jLabel3.setText("Hijos");

        tablaHijos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Edad", "Papá", "Mamá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaHijos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaHijosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaHijos);

        textoPadres.setColumns(20);
        textoPadres.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        textoPadres.setRows(5);
        jScrollPane3.setViewportView(textoPadres);

        textoHijos.setColumns(20);
        textoHijos.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        textoHijos.setRows(5);
        jScrollPane4.setViewportView(textoHijos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(239, 239, 239))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaPadresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPadresMouseClicked
        // TODO add your handling code here:
        String info="";
        String filap[] = miFuncion.leerln(archivop, tablaPadres.getSelectedRow()).split(",");
        
        for(int k=0; k<miFuncion.nlineas(archivoh) ; k++){
            String filah[] = miFuncion.leerln(archivoh, k).split(",");
            if(filah[2].equals(filap[0]) || filah[3].equals(filap[0]) ){
                info = info + filah[0] + ",";
            }
        }
        textoPadres.setText("Los hijos de " + filap[0] + " son: " + info);
        
        
    }//GEN-LAST:event_tablaPadresMouseClicked

    private void tablaHijosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaHijosMouseClicked
        // TODO add your handling code here:
        String infop="",hcomp="",hm="",hp="",infocomp,infopp,infopm;
        String filah[] = miFuncion.leerln(archivoh, tablaHijos.getSelectedRow()).split(",");
        
        for(int k=0; k<miFuncion.nlineas(archivoh) ; k++){
            String filah2[] = miFuncion.leerln(archivoh, k).split(",");
           // JOptionPane.showMessageDialog(null, filah[2]+" y "+filah2[0]);
            
            if( (filah[2].equals(filah2[2]) ) && (filah[3].equals(filah2[3])) && (!filah[0].equals(filah2[0])) ){
                hcomp=hcomp+filah2[0]+", ";
            }
            if( (filah[2].equals(filah2[2]) ) && (!filah[3].equals(filah2[3])) && (!filah[0].equals(filah2[0])) ){
                hp=hp+filah2[0]+", ";
            }
            if( (!filah[2].equals(filah2[2]) ) && (filah[3].equals(filah2[3])) && (!filah[0].equals(filah2[0])) ){
                hm=hm+filah2[0]+", ";
            }
            
        }
        infop = "El padre de " + filah[0] + " es: " + filah[2] + ", La madre es: " + filah[3] +"\r\n";
        infocomp = "Hermanos por padre y madre: " + hcomp +"\r\n";
        infopp = "Hermanos por solo padre: " + hp +"\r\n";
        infopm = "Hermanos por solo madre: " + hm +"\r\n";
        textoHijos.setText(infop + infocomp + infopp + infopm);
    }//GEN-LAST:event_tablaHijosMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informe().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tablaHijos;
    private javax.swing.JTable tablaPadres;
    private javax.swing.JTextArea textoHijos;
    private javax.swing.JTextArea textoPadres;
    // End of variables declaration//GEN-END:variables
}
