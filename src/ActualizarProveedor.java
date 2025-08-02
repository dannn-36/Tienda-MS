import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActualizarProveedor extends JFrame implements ActionListener{

	private JTextField txtNIT; 
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JLabel lblInfo;
	private JLabel lblInfo2;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;	
	private JButton btnGuardar;
	private JLabel btnCancelar;
	private Proveedor cliente;
	private Configuracion configuracion;
	
	public ActualizarProveedor(Configuracion c,Proveedor pProveedor) {
		configuracion =c;
		cliente = pProveedor;
		setLayout(new GridLayout(7, 2));
		
		this.txtNIT = new JTextField();
		txtNIT.setText(cliente.getNIT()+"");
		this.txtNombre = new JTextField();
		txtNombre.setText(cliente.getNombre_proveedor());
		this.txtDireccion = new JTextField();
		txtDireccion.setText(cliente.getDireccion());
		this.txtTelefono = new JTextField();
		txtTelefono.setText(cliente.getTelefono()+"");
		this.txtCorreo =  new JTextField();
		txtCorreo.setText(cliente.getCiudad());
		this.lbl1 = new JLabel("|  NIT:*");
		this.lbl2 = new JLabel("|  Nombre Completo:*");
		this.lbl3 = new JLabel("|  Dirección:*");
		this.lbl4 = new JLabel("|  Teléfono:*");
		this.lbl5 = new JLabel("|  Ciudad:*");		
		lblInfo =new JLabel("* Campos obligatorios");
		lblInfo2 =new JLabel("");
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("Guardar");
		btnCancelar = new JLabel("");

		add(lbl1);
		add(txtNIT);
		add(lbl2);
		add(txtNombre);
		add(lbl3);
		add(txtDireccion);
		add(lbl4);
		add(txtTelefono);
		add(lbl5);
		add(txtCorreo);		
		add(lblInfo);
		add(lblInfo2);
		add(btnCancelar);
		add(btnGuardar);

		setSize(new Dimension(600, 500));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	public boolean validar() {
		boolean rts = true;
		if (txtNIT.getText().equals("")) {
			rts = false;
		} else if (txtNombre.getText().equals("")) {
			rts = false;
		} else if (txtDireccion.getText().equals("")) {
			rts = false;
		} else if (txtTelefono.getText().equals("")) {
			rts = false;
		} else if (txtCorreo.getText().equals("")) {
			rts = false;
		} 
		return rts;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actualizado");
		if(validar()) {
			Proveedor objCliente = new Proveedor();
			objCliente.setNIT(Integer.parseInt(this.getTxtNIT().getText()));
			objCliente.setNombre_proveedor(getTxtNombre().getText());
			objCliente.setDireccion(this.getTxtDireccion().getText());
			objCliente.setTelefono(Integer.parseInt(this.getTxtTelefono().getText()));
			objCliente.setCiudad(this.getTxtCorreo().getText());
			configuracion.actualizarProveedor(objCliente);
			new Principal();
			this.dispose();
		}
	}
	public JTextField getTxtNIT() {
		return txtNIT;
	}
	public void setTxtNIT(JTextField txtNIT) {
		this.txtNIT = txtNIT;
	}
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JTextField getTxtDireccion() {
		return txtDireccion;
	}
	public void setTxtDireccion(JTextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}
	public JTextField getTxtTelefono() {
		return txtTelefono;
	}
	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}
	public JTextField getTxtCorreo() {
		return txtCorreo;
	}
	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}
	
}
