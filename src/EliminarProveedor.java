import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class EliminarProveedor extends JPanel{

	private JLabel txtNIT; 
	private JLabel txtNombre;
	private JLabel txtDireccion;
	private JLabel txtTelefono;
	private JLabel txtCorreo;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;	
	private JButton btnAceptar;
	private JButton btnCancelar;
	private Proveedor Proveedor;
	
	public EliminarProveedor(Proveedor pProveedor,Proveedores Proveedors) {
		Proveedor = pProveedor;
		setLayout(new GridLayout(6, 2));
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder("Proveedor");
		setBorder(title1);
		
		this.txtNIT = new JLabel("");
		txtNIT.setText(Proveedor.getNIT()+"");		
		this.txtNombre = new JLabel("");
		txtNombre.setText(Proveedor.getNombre_proveedor());
		this.txtDireccion = new JLabel("");
		txtDireccion.setText(Proveedor.getDireccion());
		this.txtTelefono = new JLabel("");
		txtTelefono.setText(Proveedor.getTelefono()+"");
		this.txtCorreo =  new JLabel("");
		txtCorreo.setText(Proveedor.getCiudad());		
		this.lbl1 = new JLabel("NIT del Proveedor:");
		this.lbl2 = new JLabel("Nombre proveedor:");
		this.lbl3 = new JLabel("Dirección del Proveedor:");
		this.lbl4 = new JLabel("Teléfono del Proveedor:");
		this.lbl5 = new JLabel("Ciudad del Proveedor:");		
		btnAceptar = new JButton("Eliminar");
		btnAceptar.addActionListener(Proveedors);
		btnCancelar = new JButton("Actualizar");
		btnCancelar.addActionListener(Proveedors);

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
		add(btnAceptar);
		add(btnCancelar);

		setSize(new Dimension(600, 500));
		setVisible(true);
	}
	public JLabel getTxtNIT() {
		return txtNIT;
	}
	public void setTxtNIT(JLabel txtNIT) {
		this.txtNIT = txtNIT;
	}
	public JLabel getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JLabel txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JLabel getTxtDireccion() {
		return txtDireccion;
	}
	public void setTxtDireccion(JLabel txtDireccion) {
		this.txtDireccion = txtDireccion;
	}
	public JLabel getTxtTelefono() {
		return txtTelefono;
	}
	public void setTxtTelefono(JLabel txtTelefono) {
		this.txtTelefono = txtTelefono;
	}
	public JLabel getTxtCorreo() {
		return txtCorreo;
	}
	public void setTxtCorreo(JLabel txtCorreo) {
		this.txtCorreo = txtCorreo;
	}
	public Proveedor getProveedor() {
		return Proveedor;
	}
	public void setProveedor(Proveedor Proveedor) {
		this.Proveedor = Proveedor;
	}
	
}
