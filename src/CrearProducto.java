import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class CrearProducto extends JPanel{
	
	private JTextField txtCodigo; 
	private JTextField txtNombre;
	private JTextField txtNit;
	private JTextField txtPrecioCompra;
	private JTextField txtPrecioVenta;
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
	
	public CrearProducto(Configuracion c,Productos provductos) {
		configuracion =c;
		setLayout(new GridLayout(7, 2));
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder("Producto");
		setBorder(title1);
		
		this.txtCodigo = new JTextField();
		this.txtNombre = new JTextField();
		this.txtNit = new JTextField();
		this.txtPrecioCompra = new JTextField();
		this.txtPrecioVenta =  new JTextField();
		this.lbl1 = new JLabel("|  Codigo:*");
		this.lbl2 = new JLabel("|  Nombre Completo:*");
		this.lbl3 = new JLabel("|  NIT proveedor:*");
		this.lbl4 = new JLabel("|  Precio de compra:*");
		this.lbl5 = new JLabel("|  Precio de venta:*");
		lblInfo =new JLabel("* Campos obligatorios");
		lblInfo2 =new JLabel("");
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(provductos);
		btnGuardar.setActionCommand("Guardar");
		btnCancelar = new JLabel("");

		add(lbl1);
		add(txtCodigo);
		add(lbl2);
		add(txtNombre);
		add(lbl3);
		add(txtNit);
		add(lbl4);
		add(txtPrecioCompra);
		add(lbl5);
		add(txtPrecioVenta);		
		add(lblInfo);
		add(lblInfo2);
		add(btnCancelar);
		add(btnGuardar);

		setSize(new Dimension(600, 500));
		setVisible(true);
	}
	public boolean validar() {
		boolean rts = true;
		if (txtCodigo.getText().equals("")) {
			rts = false;
		} else if (txtNombre.getText().equals("")) {
			rts = false;
		} else if (txtNit.getText().equals("")) {
			rts = false;
		} else if (txtPrecioCompra.getText().equals("")) {
			rts = false;
		} else if (txtPrecioVenta.getText().equals("")) {
			rts = false;
		} 
		return rts;
	}
	public JTextField getTxtCodigo() {
		return txtCodigo;
	}
	public void setTxtCodigo(JTextField txtCodigo) {
		this.txtCodigo = txtCodigo;
	}
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JTextField getTxtNit() {
		return txtNit;
	}
	public void setTxtNit(JTextField txtNit) {
		this.txtNit = txtNit;
	}
	public JTextField getTxtPrecioCompra() {
		return txtPrecioCompra;
	}
	public void setTxtPrecioCompra(JTextField txtPrecioCompra) {
		this.txtPrecioCompra = txtPrecioCompra;
	}
	public JTextField getTxtPrecioVenta() {
		return txtPrecioVenta;
	}
	public void setTxtPrecioVenta(JTextField txtPrecioVenta) {
		this.txtPrecioVenta = txtPrecioVenta;
	}
}
