
import DB.InterfaceDB;
import DB.Dinamico;
import DB.Fijo;
import otros.articulo;
import java.io.File;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Principal extends javax.swing.JFrame {

    
    
    InterfaceDB AlmActual; //clase con el metodo de almacenamiento Actual
    Dinamico dinamico; //almacenamiento de longitud dinamica
    Fijo fijo; // almacenamiento longitud fija
    
    
    /**
     * Creates new form ventana_datos
     * crea los archivos para el almacenmiento dinamico y/o estatico
     */
    public Principal() {
        initComponents();
        dinamico  = new Dinamico(new File("dinamica.txt"));
        fijo = new Fijo(new File("fija.txt"));
        
        AlmActual = fijo;
        
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnEliminar = new javax.swing.JButton();
        btnBuscarPosicion = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaArticulos = new javax.swing.JList();
        rbdinamico = new javax.swing.JRadioButton();
        rbestatico = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscarPosicion.setText("Buscar en Posicion");
        btnBuscarPosicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPosicionActionPerformed(evt);
            }
        });

        btnListar.setText("Listar Articulos");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar Por Codigo");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        listaArticulos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaArticulos.setMaximumSize(new java.awt.Dimension(550000000, 1400000000));
        jScrollPane1.setViewportView(listaArticulos);

        buttonGroup1.add(rbdinamico);
        rbdinamico.setText("Longitud Variable");
        rbdinamico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbdinamicoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbestatico);
        rbestatico.setSelected(true);
        rbestatico.setText("Longitud Fija");
        rbestatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbestaticoActionPerformed(evt);
            }
        });

        jLabel1.setText("Metodo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbestatico)
                            .addComponent(rbdinamico))))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPosicion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarPosicion)
                    .addComponent(btnListar)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbestatico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbdinamico)
                .addGap(64, 64, 64)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * crea una nueva ventana de tipo agregarArticulo
     * @param evt 
     */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        (new agregarArticulo(AlmActual)).setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    
    /**
     * busca a un articulo por su codigo; si existe, crea una ventana de tipo modificarArticulo
     * para modificar dicho articulo
     * @param evt 
     */
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String scodigo = JOptionPane.showInputDialog(rootPane,"Codigo: ");
           if (scodigo==null || scodigo.equals("")){return;}
           int codigo = Integer.valueOf(scodigo);
           
        articulo art = AlmActual.buscarArticuloPorCodigo(codigo);
        if (art==null){
            JOptionPane.showMessageDialog(rootPane,"No existe un articulo con ese codigo");
        }
        else{
            (new modificarArticulo(AlmActual,art.codigo)).setVisible(true);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * busca a un articulo por su codigo; si existe, lo elimina
     * @param evt 
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        String scodigo = JOptionPane.showInputDialog(rootPane,"Codigo: ");
           if (scodigo==null || scodigo.equals("")){return;}
           int codigo = Integer.valueOf(scodigo);
           
        articulo art = AlmActual.buscarArticuloPorCodigo(codigo);
        if (art==null){
            JOptionPane.showMessageDialog(rootPane,"No existe un articulo con ese codigo");
        }
        else if (AlmActual.eliminarArticulo(art.codigo)){
            JOptionPane.showMessageDialog(rootPane,"Articulo Eliminado");
            
        }else{
            JOptionPane.showMessageDialog(rootPane,"Error eliminando el articulo");
            
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    
    /**
     * busca a un articulo por su codigo, si existe muestra la información del articulo
     * @param evt 
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
           String scodigo = JOptionPane.showInputDialog(rootPane,"Codigo: ");
           if (scodigo!=null && !scodigo.equals("")){
               int codigo = Integer.valueOf(scodigo);
               articulo _articulo = AlmActual.buscarArticuloPorCodigo(codigo);
               if (_articulo==null){
                   JOptionPane.showMessageDialog(rootPane,"No existe un articulo con el codigo ingresado");
               }else{
                   String formato="<html>"
                    + "<b>Codigo:</b> "+_articulo.codigo
                    +"<br/> <b>Nombre:</b> "+_articulo.nombre
                    +"<br/> <b>Cantidad:</b> "+_articulo.cantidad
                    +"<br/> <b>Valor:</b> "+_articulo.valor
                    +"<br/><br/></html>";
                   JOptionPane.showMessageDialog(rootPane, formato);
               }
           }
    }//GEN-LAST:event_btnBuscarActionPerformed

    /*
     * busca a un archivo en la posicion dada, solo funciona para archivos de longitud fija
     * 
     */
    private void btnBuscarPosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPosicionActionPerformed
       //si esta usando almacenamiento dinamico, no hace nada. solo funciona con almacenamiento fijo
        if (rbdinamico.isSelected()){return;}
        String spos = JOptionPane.showInputDialog(rootPane,"Posicion: ");
           if (spos!=null && !spos.equals("")){
               int pos = Integer.valueOf(spos);
               articulo _articulo = AlmActual.articuloEn(pos);
               if (_articulo==null){
                   JOptionPane.showMessageDialog(rootPane,"No existe un articulo en la posición ingresada");
               }else{
                   String formato="<html>"
                    + "<b>Codigo:</b> "+_articulo.codigo
                    +"<br/> <b>Nombre:</b> "+_articulo.nombre
                    +"<br/> <b>Cantidad:</b> "+_articulo.cantidad
                    +"<br/> <b>Valor:</b> "+_articulo.valor
                    +"<br/><br/></html>";
            JOptionPane.showMessageDialog(rootPane, formato);
               }
           }
    }//GEN-LAST:event_btnBuscarPosicionActionPerformed

    /**
     * carga todos los articulos almacenados, y los muestra al usuario
     */
    public void listar(){
        LinkedList<articulo> articulos = AlmActual.listarDatos();
        DefaultListModel<String> modelo = new DefaultListModel();
        for(articulo art: articulos){
            String formato="<html>"
                    + "<b>Codigo:</b> "+art.codigo
                    +"<br/> <b>Nombre:</b> "+art.nombre
                    +"<br/> <b>Cantidad:</b> "+art.cantidad
                    +"<br/> <b>Valor:</b> "+art.valor
                    +"<br/><br/></html>";
            modelo.addElement(formato);
        }
        
        listaArticulos.setModel(modelo);
    }
    
    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        listar();
    }//GEN-LAST:event_btnListarActionPerformed

    
    
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    
    /**
     * cambia el metodo de almacenamiento actual al fijo
     * @param evt 
     */
    private void rbestaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbestaticoActionPerformed
        if (rbestatico.isSelected()){
            AlmActual=fijo;
        }
    }//GEN-LAST:event_rbestaticoActionPerformed

    
    
    /**
     * cambia el metodo de almacenamiento actual al dinamico
     * @param evt 
     */
    private void rbdinamicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbdinamicoActionPerformed
        if (rbdinamico.isSelected()){
            AlmActual=dinamico;
        }
    }//GEN-LAST:event_rbdinamicoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarPosicion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaArticulos;
    private javax.swing.JRadioButton rbdinamico;
    private javax.swing.JRadioButton rbestatico;
    // End of variables declaration//GEN-END:variables
}