

public class Detalle_venta {

	private int codigo_producto; 
	private int cantidad; 
	private int valor_unitario;
	private int valor_total; 
	private int codigo_venta; 

	public Detalle_venta () {

	}

	@Override
	public String toString() {
		return "Detalle_venta [codigo_producto=" + codigo_producto + ", cantidad=" + cantidad + ", valor_unitario="
				+ valor_unitario + ", valor_total=" + valor_total + ", codigo_venta=" + codigo_venta + "]";
	}

	public Detalle_venta (int codigo_producto, int cantidad, int valor_unitario, int valor_total, int codigo_venta ) {
		
		this.codigo_producto =  codigo_producto;
		this.cantidad = cantidad; 
		this.valor_unitario = valor_unitario;
		this.valor_total = valor_total; 
		this.codigo_venta = codigo_venta;

	}

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(int valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public int getValor_total() {
		return valor_total;
	}

	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}

	public int getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	
	
	
}
