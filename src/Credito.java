

public class Credito {

	private int codigo_venta;
	private String cedula_cliente;

	public Credito () {

	}


	@Override
	public String toString() {
		return "Credito [codigo_venta=" + codigo_venta + ", cedula_cliente=" + cedula_cliente + "]";
	}


	public Credito (int codigo_venta, String cedula_cliente) {
		
		this.codigo_venta = codigo_venta;
		this.cedula_cliente = cedula_cliente;

	}


	public int getCodigo_venta() {
		return codigo_venta;
	}


	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}


	public String getCedula_cliente() {
		return cedula_cliente;
	}


	public void setCedula_cliente(String cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	
	
}
