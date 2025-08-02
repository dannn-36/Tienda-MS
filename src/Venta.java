

public class Venta {

	private int codigo_venta; 
	private String Cedula_cliente;
	private int valor_total_venta; 
	private int valor_total_IVA;


	public Venta () {

	}


	public Venta (int codigo_venta, String cedula_cliente, int valor_total_venta, 
			int valor_IVA, int valor_total_IVA) {
		
		this.codigo_venta = codigo_venta;
		this.Cedula_cliente = cedula_cliente;
		this.valor_total_venta = valor_total_venta;
		this.valor_total_IVA = valor_total_IVA;

	}


	public int getCodigo_venta() {
		return codigo_venta;
	}


	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}


	public String getCedula_cliente() {
		return Cedula_cliente;
	}


	public void setCedula_cliente(String cedula_cliente) {
		Cedula_cliente = cedula_cliente;
	}


	public int getValor_total_venta() {
		return valor_total_venta;
	}


	public void setValor_total_venta(int valor_total_venta) {
		this.valor_total_venta = valor_total_venta;
	}
	
	public int getValor_total_IVA() {
		return valor_total_IVA;
	}


	public void setValor_total_IVA(int valor_total_IVA) {
		this.valor_total_IVA = valor_total_IVA;
	}


	@Override
	public String toString() {
		return "Venta [codigo_venta=" + codigo_venta + ", Cedula_cliente=" + Cedula_cliente + ", valor_total_venta="
				+ valor_total_venta + ", valor_total_IVA=" + valor_total_IVA + "]";
	}
	
	
	

}
