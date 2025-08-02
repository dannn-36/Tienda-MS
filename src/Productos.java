import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Productos implements ListSelectionListener,ActionListener{

	private JFrame frame;
	private PanelLista<Producto> panelL;
	private Configuracion configuracion;
	private CrearProducto crear;
	private EliminarProducto actualizar;
	private Producto producto;
	
	public Productos(Configuracion pConfiguracion) {
		configuracion=pConfiguracion;
		producto = new Producto();
		frame = new JFrame("Gestor de clientes");
		frame.setSize(700, 510);
		frame.setLayout(new BorderLayout());
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		crear = new CrearProducto(pConfiguracion,this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(crear, c);

		actualizar = new EliminarProducto(new Producto(),this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(actualizar, c);

		configuracion.leerProducto();
		panelL = new PanelLista<Producto>(configuracion.getListaProductos(),"Lista productos",this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 200;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(panelL, c);
		
		JButton  cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(10,0,0,0);
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 2;
		pane.add(cancelar, c);

		frame.add(pane);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent evt) {
		int index= panelL.getjList1().getSelectedIndex();
		Producto objCliente = (Producto)panelL.getModeloLista().getElementAt(index);
		System.out.println(objCliente.toString());
		actualizar.getTxtCodigo().setText(objCliente.getCodigo_producto()+"");
		actualizar.getTxtNombre().setText(objCliente.getNombre_producto());
		actualizar.getTxtNit().setText(objCliente.getNIT_proveedor_producto()+"");
		actualizar.getTxtPrecioCompra().setText(objCliente.getPrecio_compra_prosducto()+"");
		actualizar.getTxtPrecioVenta().setText(objCliente.getPrecio_venta_producto()+"");
		producto = objCliente;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if(evento.equalsIgnoreCase("Guardar")) {
			if(crear.validar()){
				Producto objCliente = new Producto();
				objCliente.setCodigo_producto(Integer.parseInt(crear.getTxtCodigo().getText()));
				objCliente.setNombre_producto(crear.getTxtNombre().getText());
				objCliente.setNIT_proveedor_producto(Integer.parseInt(crear.getTxtNit().getText()));
				objCliente.setPrecio_compra_producto(Integer.parseInt(crear.getTxtPrecioCompra().getText()));
				objCliente.setPrecio_venta_producto(Integer.parseInt(crear.getTxtPrecioVenta().getText()));
				panelL.getModeloLista().addElement(objCliente);
				crear.getTxtNombre().setText("");  
				crear.getTxtNit().setText("");
				crear.getTxtPrecioCompra().setText("");
				crear.getTxtPrecioVenta().setText("");
				crear.getTxtCodigo().setText("");
				configuracion.agregarProducto(objCliente);
			}else {
				JOptionPane.showMessageDialog(null, "Campo vacio");
			}
		}else if(evento.equalsIgnoreCase("Eliminar")) {
			Producto objCliente = new Producto();
			objCliente.setCodigo_producto(Integer.parseInt(actualizar.getTxtCodigo().getText()));
			objCliente.setNombre_producto(actualizar.getTxtNombre().getText());
			objCliente.setNIT_proveedor_producto(Integer.parseInt(actualizar.getTxtNit().getText()));
			objCliente.setPrecio_compra_producto(Integer.parseInt(actualizar.getTxtPrecioCompra().getText()));
			objCliente.setPrecio_venta_producto(Integer.parseInt(actualizar.getTxtPrecioVenta().getText()));
			int a = JOptionPane.showConfirmDialog(null, "Segur@?");
			if(a==0) {
				configuracion.eliminarProducto(objCliente);
				new Principal();
				frame.dispose();
			}
		}else if(evento.equalsIgnoreCase("Actualizar")) {
			new ActualizarProducto(configuracion,this.getProducto());
			frame.dispose();
		}else {
			System.out.println("Close");
			new Principal();
			frame.dispose();
		}
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
