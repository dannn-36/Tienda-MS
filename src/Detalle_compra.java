

public class Detalle_compra {

	private int codigo_producto; 
	private int cantidad_compra;
	private int valor_total;
	private int codigo_compra;


	public Detalle_compra () {

	}

	public Detalle_compra (int codigo_producto, int cantidad_compra, int valor_total, int codigo_compra) {
		
		this.codigo_producto = codigo_producto;
		this.cantidad_compra = cantidad_compra;
		this.valor_total = valor_total;
		this.codigo_compra = codigo_compra;

	}

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public int getCantidad_compra() {
		return cantidad_compra;
	}

	public void setCantidad_compra(int cantidad_compra) {
		this.cantidad_compra = cantidad_compra;
	}

	public int getValor_total() {
		return valor_total;
	}

	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}

	public int getCodigo_compra() {
		return codigo_compra;
	}

	public void setCodigo_compra(int codigo_compra) {
		this.codigo_compra = codigo_compra;
	}
	
}
