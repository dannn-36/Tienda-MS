

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActualizarCliente extends JFrame implements ActionListener{

	private JTextField txtCedula; 
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
	private Cliente cliente;
	private Configuracion configuracion;
	
	public ActualizarCliente(Configuracion c,Cliente pCliente) {
		configuracion =c;
		cliente = pCliente;
		setLayout(new GridLayout(7, 2));
		
		this.txtCedula = new JTextField();
		txtCedula.setText(cliente.getCedula());
		this.txtNombre = new JTextField();
		txtNombre.setText(cliente.getNombre_completo());
		this.txtDireccion = new JTextField();
		txtDireccion.setText(cliente.getDireccion());
		this.txtTelefono = new JTextField();
		txtTelefono.setText(cliente.getTelefono()+"");
		this.txtCorreo =  new JTextField();
		txtCorreo.setText(cliente.getCorreo_electronico());
		this.lbl1 = new JLabel("|  Cédula del Cliente:*");
		this.lbl2 = new JLabel("|  Nombre Completo del Cliente:*");
		this.lbl3 = new JLabel("|  Dirección del Cliente:*");
		this.lbl4 = new JLabel("|  Teléfono del Cliente:*");
		this.lbl5 = new JLabel("|  Correo Electrónico del Cliente:*");		
		lblInfo =new JLabel("* Campos obligatorios");
		lblInfo2 =new JLabel("");
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("Guardar");
		btnCancelar = new JLabel("");

		add(lbl1);
		add(txtCedula);
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
		if (txtCedula.getText().equals("")) {
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
			Cliente objCliente = new Cliente();
			objCliente.setCedula(this.getTxtCedula().getText());
			objCliente.setNombre_completo(getTxtNombre().getText());
			objCliente.setDireccion(this.getTxtDireccion().getText());
			objCliente.setTelefono(Integer.parseInt(this.getTxtTelefono().getText()));
			objCliente.setCorreo_electronico(this.getTxtCorreo().getText());
			configuracion.actualizarCliente(objCliente);
			new Principal();
			this.dispose();
		}
	}
	public JTextField getTxtCedula() {
		return txtCedula;
	}
	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
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
