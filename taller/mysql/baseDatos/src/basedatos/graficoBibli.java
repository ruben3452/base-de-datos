
package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

public class graficoBibli extends javax.swing.JFrame {
DefaultTableModel almacenajtable;
Connection conexion;
Statement sentencia;

    public graficoBibli() {
        initComponents();
        ConectarABaseDatos();
        mostrarLibros();
        tamanoColumna();
                    }
    public void ConectarABaseDatos(){
       
        // cargamos el controlador jdbc
        try {
            Class.forName("com.mysql.jdbc.Driver");//Carga el controlador
        }catch (Exception e) { 
            System.out.println(e);
        }
        // abrirmos la base de datos y accedemos a ella
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
            }catch (Exception e) { 
            System.out.println(e);
        }
       
        try {
            sentencia=conexion.createStatement (
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        }catch (Exception e) { 
            System.out.println(e);
        } 
    }
    
    public void mostrarLibros() {
       
        try{
            ResultSet r = sentencia.executeQuery("SELECT * FROM bdatos");
           
            String titulos[]={"ISBN","NombreLibro","NombreEditorial","añopublicacion","nropaginas","valordecompra","nrocopias","ubicacion"};
            almacenajtable=new DefaultTableModel(null,titulos);
            String fila[]=new String[8];
            while(r.next()){
                fila[0]=r.getString("ISBN");
                fila[1]=r.getString("NombreLibro");
                fila[2]=r.getString("NombreEditorial");
                fila[3]=r.getString("añopublicacion");
                fila[4]=r.getString("nropaginas");
                fila[5]=r.getString("valordecompra");
                fila[6]=r.getString("nrocopias");
                fila[7]=r.getString("ubicacion");
                almacenajtable.addRow(fila);   
            }
            jTable1.setModel(almacenajtable);
            tamanoColumna();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al extraer los datos de la tabla");
        }
    }

    public void tamanoColumna(){
        
        jTable1.getColumnModel().getColumn(0).setWidth(150);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(150);
        jTable1.getColumnModel().getColumn(0).setMinWidth(140);
        
        jTable1.getColumnModel().getColumn(1).setWidth(150);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(150);
        jTable1.getColumnModel().getColumn(1).setMinWidth(120);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogNuevo = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jBDialogNCancelar = new javax.swing.JButton();
        jBDialogNAceptar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jDialogEditar = new javax.swing.JDialog();
        jBtDialogECancelar = new javax.swing.JButton();
        jBtDialogEAceptar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBt1Borrar = new javax.swing.JButton();
        jBt2Nuevo = new javax.swing.JButton();
        jBt3Editar = new javax.swing.JButton();
        jBt4Cerrar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ISBN");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre Libro");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre Editorial");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("año publicacion");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("nro paginas");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("valor de compra");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("nro copias");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("ubicacion");

        jBDialogNCancelar.setText("Cancelar");
        jBDialogNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDialogNCancelarActionPerformed(evt);
            }
        });

        jBDialogNAceptar.setText("Aceptar");
        jBDialogNAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDialogNAceptarActionPerformed(evt);
            }
        });

        jLabel6.setText("Nuevo Libro");

        javax.swing.GroupLayout jDialogNuevoLayout = new javax.swing.GroupLayout(jDialogNuevo.getContentPane());
        jDialogNuevo.getContentPane().setLayout(jDialogNuevoLayout);
        jDialogNuevoLayout.setHorizontalGroup(
            jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNuevoLayout.createSequentialGroup()
                .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDialogNuevoLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel6))
                    .addGroup(jDialogNuevoLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogNuevoLayout.createSequentialGroup()
                                .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel10)
                                    .addComponent(jBDialogNCancelar))
                                .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDialogNuevoLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField5)
                                            .addComponent(jTextField8)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogNuevoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBDialogNAceptar)
                                        .addGap(12, 12, 12))))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDialogNuevoLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(jTextField3)))))
                    .addGroup(jDialogNuevoLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(42, 42, 42)
                        .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 23, Short.MAX_VALUE))
        );
        jDialogNuevoLayout.setVerticalGroup(
            jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNuevoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(10, 10, 10)
                .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBDialogNAceptar)
                    .addComponent(jBDialogNCancelar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jBtDialogECancelar.setText("Cancelar");
        jBtDialogECancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDialogECancelarActionPerformed(evt);
            }
        });

        jBtDialogEAceptar.setText("Aceptar");
        jBtDialogEAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDialogEAceptarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("ubicacion");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("nro copias");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("valor de compra");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("nro paginas");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("año publicacion");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Nombre Editorial");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Nombre Libro");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("ISBN");

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jLabel5.setText("Editar Libro");

        javax.swing.GroupLayout jDialogEditarLayout = new javax.swing.GroupLayout(jDialogEditar.getContentPane());
        jDialogEditar.getContentPane().setLayout(jDialogEditarLayout);
        jDialogEditarLayout.setHorizontalGroup(
            jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditarLayout.createSequentialGroup()
                .addGroup(jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogEditarLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel21)
                        .addGap(101, 101, 101)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogEditarLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel20)
                        .addGap(47, 47, 47)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogEditarLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel19)
                        .addGap(30, 30, 30)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogEditarLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jBtDialogECancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogEditarLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogEditarLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(73, 73, 73)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogEditarLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(67, 67, 67)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogEditarLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(30, 30, 30)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogEditarLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogEditarLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(59, 59, 59)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogEditarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogEditarLayout.createSequentialGroup()
                        .addComponent(jBtDialogEAceptar)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogEditarLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(181, 181, 181))))
        );
        jDialogEditarLayout.setVerticalGroup(
            jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditarLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtDialogEAceptar)
                    .addComponent(jBtDialogECancelar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicación Flores de mi jardín (Borrador)");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Biblioteca");
        jLabel9.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        jBt1Borrar.setText("Borrar");
        jBt1Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBt1BorrarActionPerformed(evt);
            }
        });

        jBt2Nuevo.setText("Nuevo");
        jBt2Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBt2NuevoActionPerformed(evt);
            }
        });

        jBt3Editar.setText("Editar");
        jBt3Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBt3EditarActionPerformed(evt);
            }
        });

        jBt4Cerrar.setText("Cerrar");
        jBt4Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBt4CerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBt1Borrar)
                .addGap(18, 18, 18)
                .addComponent(jBt2Nuevo)
                .addGap(18, 18, 18)
                .addComponent(jBt3Editar)
                .addGap(18, 18, 18)
                .addComponent(jBt4Cerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBt1Borrar)
                    .addComponent(jBt2Nuevo)
                    .addComponent(jBt3Editar)
                    .addComponent(jBt4Cerrar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 308, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBt1BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBt1BorrarActionPerformed
       
        int filsel;
        String ISBN;
        int resp;
        try{
            filsel=jTable1.getSelectedRow();
            if (filsel==-1) {
                JOptionPane.showMessageDialog(null,"Debes seleccionar el ejemplar a borrar");
            }else {
                resp=JOptionPane.showConfirmDialog(null,"Desea eliminar el Ejemplar seleccionado",
                    "Eliminar",JOptionPane.YES_NO_OPTION);
                if (resp==JOptionPane.YES_OPTION){
                    almacenajtable=(DefaultTableModel) jTable1.getModel();
                    ISBN=(String) almacenajtable.getValueAt(filsel,0);
                    sentencia.executeUpdate("delete from bdatos where ISBN='"+ISBN+"'");
                    mostrarLibros();
                }
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el Ejemplar");
        }
    }//GEN-LAST:event_jBt1BorrarActionPerformed

    private void jBt2NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBt2NuevoActionPerformed
        
        jDialogNuevo.setSize(450,430);
        jDialogNuevo.setModal(true);
        jDialogNuevo.setVisible(true);
        mostrarLibros();
    }//GEN-LAST:event_jBt2NuevoActionPerformed

    private void jBt3EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBt3EditarActionPerformed
        
        int filaseleccionada;
        String ISBN,NombreLibro,NombreEditorial,añopublicacion,nropaginas,valordecompra,nrocopias,ubicacion;
        filaseleccionada=jTable1.getSelectedRow();
        if (filaseleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un libro, Gracias");
        }else{
            almacenajtable=(DefaultTableModel)jTable1.getModel();
            ISBN=(String)almacenajtable.getValueAt(filaseleccionada, 0);
            NombreLibro=(String)almacenajtable.getValueAt(filaseleccionada, 1);
            NombreEditorial=(String)almacenajtable.getValueAt(filaseleccionada, 2);
            añopublicacion=(String)almacenajtable.getValueAt(filaseleccionada, 3);
            nropaginas=(String)almacenajtable.getValueAt(filaseleccionada, 4);
            valordecompra=(String)almacenajtable.getValueAt(filaseleccionada, 5);
            nrocopias=(String)almacenajtable.getValueAt(filaseleccionada, 6);
            ubicacion=(String)almacenajtable.getValueAt(filaseleccionada, 7);
           
           
            ISBN=jTextField1.getText();
            NombreLibro=jTextField2.getText();
            NombreEditorial=jTextField3.getText();
            añopublicacion=jTextField4.getText();
            nropaginas=jTextField5.getText();
            valordecompra=jTextField6.getText();
            nrocopias=jTextField7.getText();
            ubicacion=jTextField8.getText();
                     
            jDialogEditar.setSize(460,430);
            jDialogEditar.setModal(true);
            jDialogEditar.setVisible(true);
            mostrarLibros();  
        }
    }//GEN-LAST:event_jBt3EditarActionPerformed

    private void jBt4CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBt4CerrarActionPerformed
        int resp;
        try{
            resp=JOptionPane.showConfirmDialog(null,"¿Desea cerrar "
                    + "la base de datos y salir de la aplicación?",
                    "Salir",JOptionPane.YES_NO_OPTION);
                if (resp==JOptionPane.YES_OPTION){
                    conexion.close();
                    System.exit(0);
        }
        }catch (Exception e){
                    System.out.println(e);
        }        
    }//GEN-LAST:event_jBt4CerrarActionPerformed

    private void jBDialogNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDialogNCancelarActionPerformed
        
        jDialogNuevo.dispose();
    }//GEN-LAST:event_jBDialogNCancelarActionPerformed

    private void jBDialogNAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDialogNAceptarActionPerformed
       
        String ISBN,NombreLibro,NombreEditorial,añopublicacion,nropaginas,valordecompra,nrocopias,ubicacion;

        String consulta;
        try {
            ISBN=jTextField1.getText();
            NombreLibro=jTextField2.getText();
            NombreEditorial=jTextField3.getText();
            añopublicacion=jTextField4.getText();
            nropaginas=jTextField5.getText();
            valordecompra=jTextField6.getText();
            nrocopias=jTextField7.getText();
            ubicacion=jTextField8.getText();
            consulta="insert into bdatos values('"+ISBN+"','"+NombreLibro+"','"+NombreEditorial+"','"+añopublicacion+"','"+nropaginas+"','"+valordecompra+"','"+nrocopias+"','"+ubicacion+"')";
           
            sentencia.executeUpdate(consulta);
            jDialogNuevo.dispose();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al introducir nuevo libro");
        }
    }//GEN-LAST:event_jBDialogNAceptarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jBtDialogECancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDialogECancelarActionPerformed
        // TODO add your handling code here:
        jDialogEditar.dispose();
    }//GEN-LAST:event_jBtDialogECancelarActionPerformed

    private void jBtDialogEAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDialogEAceptarActionPerformed
        String ISBN,NombreLibro,NombreEditorial,añopublicacion,nropaginas,valordecompra,nrocopias,ubicacion;
      
        String sql1, sql2, sql3,sql4,sql5,sql6,sql7,sql8;
        try {
            ISBN=jTextField1.getText();
            NombreLibro=jTextField2.getText();
            NombreEditorial=jTextField3.getText();
            añopublicacion=jTextField4.getText();
            nropaginas=jTextField5.getText();
            valordecompra=jTextField6.getText();
            nrocopias=jTextField7.getText();
            ubicacion=jTextField8.getText();

            //sql1="UPDATE bdatos SET ISBN='"+ISBN+"'"+ "WHERE ISBN='"+ISBN+"'";
            sql2="UPDATE bdatos SET NombreLibro='"+NombreLibro+"'"+ "WHERE ISBN='"+ISBN+"'";
            sql3="UPDATE bdatos SET NombreEditorial='"+NombreEditorial+"'"+ "WHERE ISBN='"+ISBN+"'";
            sql4="UPDATE bdatos SET añopublicacion='"+añopublicacion+"'"+ "WHERE ISBN='"+ISBN+"'";
            sql5="UPDATE bdatos SET nropaginas='"+nropaginas+"'"+ "WHERE ISBN='"+ISBN+"'";
            sql6="UPDATE bdatos SET valordecompra='"+valordecompra+"'"+ "WHERE ISBN='"+ISBN+"'";
            sql7="UPDATE bdatos SET nrocopias='"+nrocopias+"'"+ "WHERE ISBN='"+ISBN+"'";
            sql8="UPDATE bdatos SET ubicacion='"+ubicacion+"'"+ "WHERE ISBN='"+ISBN+"'";

           // sentencia.executeUpdate(sql1);
            sentencia.executeUpdate(sql2);
            sentencia.executeUpdate(sql3);
            sentencia.executeUpdate(sql4);
            sentencia.executeUpdate(sql5);
            sentencia.executeUpdate(sql6);
            sentencia.executeUpdate(sql7);
            sentencia.executeUpdate(sql8);

            jDialogEditar.dispose();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al modificar el libro");
        }
    }//GEN-LAST:event_jBtDialogEAceptarActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed
    
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
            java.util.logging.Logger.getLogger(graficoBibli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(graficoBibli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(graficoBibli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(graficoBibli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new graficoBibli().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDialogNAceptar;
    private javax.swing.JButton jBDialogNCancelar;
    private javax.swing.JButton jBt1Borrar;
    private javax.swing.JButton jBt2Nuevo;
    private javax.swing.JButton jBt3Editar;
    private javax.swing.JButton jBt4Cerrar;
    private javax.swing.JButton jBtDialogEAceptar;
    private javax.swing.JButton jBtDialogECancelar;
    private javax.swing.JDialog jDialogEditar;
    private javax.swing.JDialog jDialogNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

  

    
}
