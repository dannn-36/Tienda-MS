

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActualizarProducto extends JFrame implements ActionListener{

	private JTextField txtCodigo; 
	private JTextField txtNombre;
	private JTextField txtNit;
	private JTextField txtPrecioCompra;
	private JTextField txtPrecioventa;
	private JLabel lblInfo;
	private JLabel lblInfo2;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;	
	private JButton btnGuardar;
	private JLabel btnCancelar;
	private Producto producto;
	private Configuracion configuracion;
	
	public ActualizarProducto(Configuracion c,Producto pProducto) {
		configuracion =c;
		producto = pProducto;
		setLayout(new GridLayout(7, 2));
		
		this.txtCodigo = new JTextField();
		txtCodigo.setText(producto.getCodigo_producto()+"");
		this.txtNombre = new JTextField();
		txtNombre.setText(producto.getNombre_producto());
		this.txtNit = new JTextField();
		txtNit.setText(producto.getNIT_proveedor_producto()+"");
		this.txtPrecioCompra = new JTextField();
		txtPrecioCompra.setText(producto.getPrecio_compra_prosducto()+"");
		this.txtPrecioventa =  new JTextField();
		txtPrecioventa.setText(producto.getPrecio_venta_producto()+"");
		this.lbl1 = new JLabel("|  Codigo:*");
		this.lbl2 = new JLabel("|  Nombre Completo:*");
		this.lbl3 = new JLabel("|  NIT proveedor:*");
		this.lbl4 = new JLabel("|  Precio de compra:*");
		this.lbl5 = new JLabel("|  Precio de venta:*");		
		lblInfo =new JLabel("* Campos obligatorios");
		lblInfo2 =new JLabel("");
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
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
		add(txtPrecioventa);		
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
		if (txtCodigo.getText().equals("")) {
			rts = false;
		} else if (txtNombre.getText().equals("")) {
			rts = false;
		} else if (txtNit.getText().equals("")) {
			rts = false;
		} else if (txtPrecioCompra.getText().equals("")) {
			rts = false;
		} else if (txtPrecioventa.getText().equals("")) {
			rts = false;
		} 
		return rts;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actualizado");
		if(validar()) {
			Producto objCliente = new Producto();
			objCliente.setCodigo_producto(Integer.parseInt(this.getTxtCodigo().getText()));
			objCliente.setNombre_producto(getTxtNombre().getText());
			objCliente.setNIT_proveedor_producto(Integer.parseInt(this.getTxtNit().getText()));
			objCliente.setPrecio_compra_producto(Integer.parseInt(this.getTxtPrecioCompra().getText()));
			objCliente.setPrecio_venta_producto(Integer.parseInt(this.getTxtPrecioventa().getText()));
			configuracion.actualizarProducto(objCliente);
			new Principal();
			this.dispose();
		}
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
	public JTextField getTxtPrecioventa() {
		return txtPrecioventa;
	}
	public void setTxtPrecioventa(JTextField txtPrecioventa) {
		this.txtPrecioventa = txtPrecioventa;
	}
}
