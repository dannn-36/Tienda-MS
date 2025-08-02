import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class EliminarProducto extends JPanel{

	private JLabel txtCodigo; 
	private JLabel txtNombre;
	private JLabel txtNit;
	private JLabel txtPrecioCompra;
	private JLabel txtPrecioVenta;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;	
	private JButton btnAceptar;
	private JButton btnCancelar;
	private Producto Producto;
	
	public EliminarProducto(Producto pProducto,Productos productos) {
		Producto = pProducto;
		setLayout(new GridLayout(6, 2));
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder("Producto");
		setBorder(title1);
		
		this.txtCodigo = new JLabel("");
		txtCodigo.setText(Producto.getCodigo_producto()+"");		
		this.txtNombre = new JLabel("");
		txtNombre.setText(Producto.getNombre_producto());
		this.txtNit = new JLabel("");
		txtNit.setText(Producto.getNIT_proveedor_producto()+"");
		this.txtPrecioCompra = new JLabel("");
		txtPrecioCompra.setText(Producto.getPrecio_compra_prosducto()+"");
		this.txtPrecioVenta =  new JLabel("");
		txtPrecioVenta.setText(Producto.getPrecio_venta_producto()+"");
		this.lbl1 = new JLabel("|  Codigo:");
		this.lbl2 = new JLabel("|  Nombre Completo:");
		this.lbl3 = new JLabel("|  NIT proveedor:");
		this.lbl4 = new JLabel("|  Precio de compra:");
		this.lbl5 = new JLabel("|  Precio de venta:");
		btnAceptar = new JButton("Eliminar");
		btnAceptar.addActionListener(productos);
		btnCancelar = new JButton("Actualizar");
		btnCancelar.addActionListener(productos);

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
		add(btnAceptar);
		add(btnCancelar);

		setSize(new Dimension(600, 500));
		setVisible(true);
	}

	public JLabel getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(JLabel txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public JLabel getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JLabel txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JLabel getTxtNit() {
		return txtNit;
	}

	public void setTxtNit(JLabel txtNit) {
		this.txtNit = txtNit;
	}

	public JLabel getTxtPrecioCompra() {
		return txtPrecioCompra;
	}

	public void setTxtPrecioCompra(JLabel txtPrecioCompra) {
		this.txtPrecioCompra = txtPrecioCompra;
	}

	public JLabel getTxtPrecioVenta() {
		return txtPrecioVenta;
	}

	public void setTxtPrecioVenta(JLabel txtPrecioVenta) {
		this.txtPrecioVenta = txtPrecioVenta;
	}

	public JLabel getLbl1() {
		return lbl1;
	}

	public void setLbl1(JLabel lbl1) {
		this.lbl1 = lbl1;
	}

	public JLabel getLbl2() {
		return lbl2;
	}

	public void setLbl2(JLabel lbl2) {
		this.lbl2 = lbl2;
	}

	public JLabel getLbl3() {
		return lbl3;
	}

	public void setLbl3(JLabel lbl3) {
		this.lbl3 = lbl3;
	}

	public JLabel getLbl4() {
		return lbl4;
	}

	public void setLbl4(JLabel lbl4) {
		this.lbl4 = lbl4;
	}

	public JLabel getLbl5() {
		return lbl5;
	}

	public void setLbl5(JLabel lbl5) {
		this.lbl5 = lbl5;
	}

	public Producto getProducto() {
		return Producto;
	}

	public void setProducto(Producto producto) {
		Producto = producto;
	}
	
}
