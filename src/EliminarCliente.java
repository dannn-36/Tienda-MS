import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class EliminarCliente extends JPanel{

	private JLabel txtCedula; 
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
	private Cliente cliente;
	
	public EliminarCliente(Cliente pCliente,Clientes clientes) {
		cliente = pCliente;
		setLayout(new GridLayout(6, 2));
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder("Cliente");
		setBorder(title1);
		
		this.txtCedula = new JLabel("");
		txtCedula.setText(cliente.getCedula());		
		this.txtNombre = new JLabel("");
		txtNombre.setText(cliente.getNombre_completo());
		this.txtDireccion = new JLabel("");
		txtDireccion.setText(cliente.getDireccion());
		this.txtTelefono = new JLabel("");
		txtTelefono.setText(cliente.getTelefono()+"");
		this.txtCorreo =  new JLabel("");
		txtCorreo.setText(cliente.getCorreo_electronico());		
		this.lbl1 = new JLabel("Cédula del Cliente:");
		this.lbl2 = new JLabel("Nombre Completo del Cliente:");
		this.lbl3 = new JLabel("Dirección del Cliente:");
		this.lbl4 = new JLabel("Teléfono del Cliente:");
		this.lbl5 = new JLabel("Correo Electrónico del Cliente:");		
		btnAceptar = new JButton("Eliminar");
		btnAceptar.addActionListener(clientes);
		btnCancelar = new JButton("Actualizar");
		btnCancelar.addActionListener(clientes);

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
		add(btnAceptar);
		add(btnCancelar);

		setSize(new Dimension(600, 500));
		setVisible(true);
	}
	public JLabel getTxtCedula() {
		return txtCedula;
	}
	public void setTxtCedula(JLabel txtCedula) {
		this.txtCedula = txtCedula;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
