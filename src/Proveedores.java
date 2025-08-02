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

public class Proveedores implements ListSelectionListener,ActionListener{

	private JFrame frame;
	private PanelLista<Proveedor> panelL;
	private Configuracion configuracion;
	private CrearProveedor crear;
	private EliminarProveedor actualizar;
	private Proveedor proveedor;
	
	public Proveedores(Configuracion pconfiguracion) {
		configuracion =pconfiguracion;
		proveedor = new Proveedor();
		frame = new JFrame("Gestor de Proveedors");
		frame.setSize(700, 510);
		frame.setLayout(new BorderLayout());
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		crear = new CrearProveedor(configuracion, this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(crear, c);

		actualizar = new EliminarProveedor(new Proveedor(),this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(actualizar, c);

		configuracion.leerProveedor();
		panelL = new PanelLista<Proveedor>(configuracion.getListaProveedores(),"Lista proveedores",this);
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
		Proveedor objProveedor = (Proveedor)panelL.getModeloLista().getElementAt(index);
		System.out.println(objProveedor.toString());
		actualizar.getTxtNombre().setText(objProveedor.getNombre_proveedor());
		actualizar.getTxtNIT().setText(objProveedor.getNIT()+"");
		actualizar.getTxtCorreo().setText(objProveedor.getCiudad());
		actualizar.getTxtDireccion().setText(objProveedor.getDireccion());
		actualizar.getTxtTelefono().setText(objProveedor.getTelefono()+"");
		proveedor = objProveedor;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if(evento.equalsIgnoreCase("Guardar")) {
			if(crear.validar()){
				Proveedor objProveedor = new Proveedor();
				objProveedor.setNIT(Integer.parseInt(crear.getTxtCedula().getText()));
				objProveedor.setNombre_proveedor(crear.getTxtNombre().getText());
				objProveedor.setDireccion(crear.getTxtDireccion().getText());
				objProveedor.setTelefono(Integer.parseInt(crear.getTxtTelefono().getText()));
				objProveedor.setCiudad(crear.getTxtCorreo().getText());
				panelL.getModeloLista().addElement(objProveedor);
				crear.getTxtNombre().setText("");  
				crear.getTxtCedula().setText("");
				crear.getTxtDireccion().setText("");
				crear.getTxtTelefono().setText("");
				crear.getTxtCorreo().setText("");
				configuracion.agregarProveedor(objProveedor);
			}else {
				JOptionPane.showMessageDialog(null, "Campo vacio");
			}
		}else if(evento.equalsIgnoreCase("Eliminar")) {
			Proveedor objProveedor = new Proveedor();
			objProveedor.setNIT(Integer.parseInt(actualizar.getTxtNIT().getText()));
			objProveedor.setNombre_proveedor(actualizar.getTxtNombre().getText());
			objProveedor.setDireccion(actualizar.getTxtDireccion().getText());
			objProveedor.setTelefono(Integer.parseInt(actualizar.getTxtTelefono().getText()));
			objProveedor.setCiudad(actualizar.getTxtCorreo().getText());
			int a = JOptionPane.showConfirmDialog(null, "Segur@?");
			if(a==0) {
				configuracion.eliminarProveedor(objProveedor);
				new Principal();
				frame.dispose();
			}
		}else if(evento.equalsIgnoreCase("Actualizar")) {
			new ActualizarProveedor(configuracion,this.getProveedor());
			frame.dispose();
		}else {
			System.out.println("Close");
			new Principal();
			frame.dispose();
		}
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
}
