

public class Compra {

	private int codigo_compra;
	private int NIT_proveedor;
	private int valor_total;
	private int valor_IVA;
	private int valor_total_IVA;

	public Compra () {

	}


	public Compra(int codigo_compra, int nIT_proveedor, int valor_total, int valor_IVA, int valor_total_IVA) {
		super();
		this.codigo_compra = codigo_compra;
		NIT_proveedor = nIT_proveedor;
		this.valor_total = valor_total;
		this.valor_IVA = valor_IVA;
		this.valor_total_IVA = valor_total_IVA;
	}


	public int getCodigo_compra() {
		return codigo_compra;
	}


	public void setCodigo_compra(int codigo_compra) {
		this.codigo_compra = codigo_compra;
	}


	public int getNIT_proveedor() {
		return NIT_proveedor;
	}


	public void setNIT_proveedor(int nIT_proveedor) {
		NIT_proveedor = nIT_proveedor;
	}


	public int getValor_total() {
		return valor_total;
	}


	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}


	public int getValor_IVA() {
		return valor_IVA;
	}


	public void setValor_IVA(int valor_IVA) {
		this.valor_IVA = valor_IVA;
	}


	public int getValor_total_IVA() {
		return valor_total_IVA;
	}


	public void setValor_total_IVA(int valor_total_IVA) {
		this.valor_total_IVA = valor_total_IVA;
	}


	@Override
	public String toString() {
		return "Compra [codigo_compra=" + codigo_compra + ", NIT_proveedor=" + NIT_proveedor + ", valor_total="
				+ valor_total + ", valor_IVA=" + valor_IVA + ", valor_total_IVA=" + valor_total_IVA + "]";
	}
	
}
