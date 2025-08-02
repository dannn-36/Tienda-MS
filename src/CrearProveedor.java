import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class CrearProveedor extends JPanel{
	
	private JTextField txtNit; 
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCiudad;
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
	
	public CrearProveedor(Configuracion c,Proveedores proveedor) {
		configuracion =c;
		setLayout(new GridLayout(7, 2));
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder("Proveedor");
		setBorder(title1);
		
		this.txtNit = new JTextField();
		this.txtNombre = new JTextField();
		this.txtDireccion = new JTextField();
		this.txtTelefono = new JTextField();
		this.txtCiudad =  new JTextField();
		this.lbl1 = new JLabel("|  NIT:*");
		this.lbl2 = new JLabel("|  Nombre Completo:*");
		this.lbl3 = new JLabel("|  Dirección:*");
		this.lbl4 = new JLabel("|  Teléfono:*");
		this.lbl5 = new JLabel("|  Ciudad:*");		
		lblInfo =new JLabel("* Campos obligatorios");
		lblInfo2 =new JLabel("");
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(proveedor);
		btnGuardar.setActionCommand("Guardar");
		btnCancelar = new JLabel("");

		add(lbl1);
		add(txtNit);
		add(lbl2);
		add(txtNombre);
		add(lbl3);
		add(txtDireccion);
		add(lbl4);
		add(txtTelefono);
		add(lbl5);
		add(txtCiudad);		
		add(lblInfo);
		add(lblInfo2);
		add(btnCancelar);
		add(btnGuardar);

		setSize(new Dimension(600, 500));
		setVisible(true);
	}
	public boolean validar() {
		boolean rts = true;
		if (txtNit.getText().equals("")) {
			rts = false;
		} else if (txtNombre.getText().equals("")) {
			rts = false;
		} else if (txtDireccion.getText().equals("")) {
			rts = false;
		} else if (txtTelefono.getText().equals("")) {
			rts = false;
		} else if (txtCiudad.getText().equals("")) {
			rts = false;
		} 
		return rts;
	}
	public JTextField getTxtCedula() {
		return txtNit;
	}
	public void setTxtCedula(JTextField txtCedula) {
		this.txtNit = txtCedula;
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
		return txtCiudad;
	}
	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCiudad = txtCorreo;
	}
}
