

public class Producto {

	private int codigo_producto; 
	private String nombre_producto; 
	private int NIT_proveedor_producto;
	private int precio_compra_producto;
	private int precio_venta_producto;


	public Producto () {

	}


	public Producto (int codigo_producto, String nombre_producto, int NIT_proveedor, int precio_compra, int precio_venta) {
		
		this.codigo_producto = codigo_producto;
		this.nombre_producto = nombre_producto;
		this.NIT_proveedor_producto = NIT_proveedor;
		this.precio_compra_producto = precio_compra;
		this.precio_venta_producto = precio_venta;

	}


	public int getCodigo_producto() {
		return codigo_producto;
	}


	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}


	public String getNombre_producto() {
		return nombre_producto;
	}


	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}


	public int getNIT_proveedor_producto() {
		return NIT_proveedor_producto;
	}


	public void setNIT_proveedor_producto(int nIT_proveedor_producto) {
		NIT_proveedor_producto = nIT_proveedor_producto;
	}


	public int getPrecio_compra_prosducto() {
		return precio_compra_producto;
	}


	public void setPrecio_compra_producto(int precio_compra_producto) {
		this.precio_compra_producto = precio_compra_producto;
	}


	public int getPrecio_venta_producto() {
		return precio_venta_producto;
	}


	public void setPrecio_venta_producto(int precio_venta_producto) {
		this.precio_venta_producto = precio_venta_producto;
	}


	@Override
	public String toString() {
		return "Producto [codigo_producto=" + codigo_producto + ", nombre_producto=" + nombre_producto
				+ ", NIT_proveedor_producto=" + NIT_proveedor_producto + ", precio_compra_producto="
				+ precio_compra_producto + ", precio_venta_producto=" + precio_venta_producto + "]";
	}
	
}
