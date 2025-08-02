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

public class Clientes implements ListSelectionListener,ActionListener{

	private JFrame frame;
	private PanelLista<Cliente> panelL;
	private Configuracion configuracion;
	private CrearCliente crear;
	private EliminarCliente actualizar;
	private Cliente cliente;
	
	public Clientes(Configuracion pConfiguracion) {
		configuracion=pConfiguracion;
		cliente = new Cliente();
		frame = new JFrame("Gestor de clientes");
		frame.setSize(700, 510);
		frame.setLayout(new BorderLayout());
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		crear = new CrearCliente(pConfiguracion,this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(crear, c);

		actualizar = new EliminarCliente(new Cliente(),this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(actualizar, c);

		configuracion.leerClientes();
		panelL = new PanelLista<Cliente>(configuracion.getListaClientes(),"Lista clientes",this);
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
		Cliente objCliente = (Cliente)panelL.getModeloLista().getElementAt(index);
		System.out.println(objCliente.toString());
		actualizar.getTxtNombre().setText(objCliente.getNombre_completo());
		actualizar.getTxtCedula().setText(objCliente.getCedula());
		actualizar.getTxtCorreo().setText(objCliente.getCorreo_electronico());
		actualizar.getTxtDireccion().setText(objCliente.getDireccion());
		actualizar.getTxtTelefono().setText(objCliente.getTelefono()+"");
		cliente = objCliente;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if(evento.equalsIgnoreCase("Guardar")) {
			if(crear.validar()){
				Cliente objCliente = new Cliente();
				objCliente.setCedula(crear.getTxtCedula().getText());
				objCliente.setNombre_completo(crear.getTxtNombre().getText());
				objCliente.setDireccion(crear.getTxtDireccion().getText());
				objCliente.setTelefono(Integer.parseInt(crear.getTxtTelefono().getText()));
				objCliente.setCorreo_electronico(crear.getTxtCorreo().getText());
				panelL.getModeloLista().addElement(objCliente);
				crear.getTxtNombre().setText("");  
				crear.getTxtCedula().setText("");
				crear.getTxtDireccion().setText("");
				crear.getTxtTelefono().setText("");
				crear.getTxtCorreo().setText("");
				configuracion.agregarCliente(objCliente);
			}else {
				JOptionPane.showMessageDialog(null, "Campo vacio");
			}
		}else if(evento.equalsIgnoreCase("Eliminar")) {
			Cliente objCliente = new Cliente();
			objCliente.setCedula(actualizar.getTxtCedula().getText());
			objCliente.setNombre_completo(actualizar.getTxtNombre().getText());
			objCliente.setDireccion(actualizar.getTxtDireccion().getText());
			objCliente.setTelefono(Integer.parseInt(actualizar.getTxtTelefono().getText()));
			objCliente.setCorreo_electronico(actualizar.getTxtCorreo().getText());
			int a = JOptionPane.showConfirmDialog(null, "Segur@?");
			if(a==0) {
				configuracion.eliminarCliente(objCliente);
				new Principal();
				frame.dispose();
			}
		}else if(evento.equalsIgnoreCase("Actualizar")) {
			new ActualizarCliente(configuracion,this.getCliente());
			frame.dispose();
		}else {
			System.out.println("Close");
			new Principal();
			frame.dispose();
		}
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
