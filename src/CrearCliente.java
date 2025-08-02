import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class CrearCliente extends JPanel{
	
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
	private Configuracion configuracion;
	
	public CrearCliente(Configuracion c,Clientes clientes) {
		configuracion =c;
		setLayout(new GridLayout(7, 2));
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder("Cliente");
		setBorder(title1);
		
		this.txtCedula = new JTextField();
		this.txtNombre = new JTextField();
		this.txtDireccion = new JTextField();
		this.txtTelefono = new JTextField();
		this.txtCorreo =  new JTextField();
		this.lbl1 = new JLabel("|  Cédula del Cliente:*");
		this.lbl2 = new JLabel("|  Nombre Completo del Cliente:*");
		this.lbl3 = new JLabel("|  Dirección del Cliente:*");
		this.lbl4 = new JLabel("|  Teléfono del Cliente:*");
		this.lbl5 = new JLabel("|  Correo Electrónico del Cliente:*");		
		lblInfo =new JLabel("* Campos obligatorios");
		lblInfo2 =new JLabel("");
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(clientes);
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
