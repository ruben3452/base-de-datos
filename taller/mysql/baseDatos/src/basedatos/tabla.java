
package basedatos;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author orihime
 */
public class tabla {
    public static void main(String[] args)
	{
		NuevaVentana v=new NuevaVentana();
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setVisible(true);
	}
}
class NuevaVentana extends JFrame{
	private static final int ancho=600;
	private static final int largo=130;
	public NuevaVentana(){
		this.setTitle("Prueba Tabla");
		this.setSize(ancho,largo);
		NuevoPanel p=new NuevoPanel();
		add(p);
	}
}
class NuevoPanel extends JPanel{
	DefaultTableModel modelo=new DefaultTableModel();
	{
            //imprine los titulos de las columnas
		modelo.addColumn("ISBN");
		modelo.addColumn("NombreLibro");
                modelo.addColumn("NombreEditorial");
		modelo.addColumn("añopublicacion");
                modelo.addColumn("nropaginas");
		modelo.addColumn("valordecompra");
                modelo.addColumn("nrocopias");
		modelo.addColumn("ubicacion");
		
	}
	JTable tabla=new JTable(modelo);
	JScrollPane scroll=new JScrollPane(tabla);
	public NuevoPanel(){
		this.setLayout(new BorderLayout());
		add(scroll,BorderLayout.CENTER);
		mostrarTabla();
	}
	public void mostrarTabla(){
		 try
	        {
	            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
	            Connection conexion = DriverManager.getConnection ("jdbc:mysql://"
                            + "localhost/biblioteca","root", "");
	            Statement s = conexion.createStatement();
	            ResultSet rs = s.executeQuery ("select * from bdatos");
	            Object[] fila=new Object[8];
	            while (rs.next())
	            {
                        //lee los datos de la tabla  y los coloca en la tabla
                        
	                fila[0]=rs.getString ("ISBN");
	                fila[1]=rs.getString ("NombreLibro");
                        fila[2]=rs.getString ("NombreEditorial");
	                fila[3]=rs.getInt ("añopublicacion");
	                fila[4]=rs.getInt ("nropaginas");
	                fila[5]=rs.getDouble ("valordecompra");
                        fila[6]=rs.getInt ("nrocopias");
	                fila[7]=rs.getString ("ubicacion");
	        		modelo.addRow(fila);
	        	}
	            conexion.close();
	        }
	        catch (Exception e)
	        {
	            System.out.println(e);
	        }
	}
}
