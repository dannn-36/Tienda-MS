

public class Cheque {

	private String consecutivo_cheque;
	private String nombre_proveedor; 
	private int valor_total_compra_IVA;
	private String banco;
	private String Num_cuenta;

	public Cheque() {
	}

	public Cheque(String consecutivo_cheque, String nombre_proveedor, int valor_total_compra_IVA, String banco,
			String num_cuenta) {
		super();
		this.consecutivo_cheque = consecutivo_cheque;
		this.nombre_proveedor = nombre_proveedor;
		this.valor_total_compra_IVA = valor_total_compra_IVA;
		this.banco = banco;
		Num_cuenta = num_cuenta;
	}

	public String getConsecutivo_cheque() {
		return consecutivo_cheque;
	}

	public void setConsecutivo_cheque(String consecutivo_cheque) {
		this.consecutivo_cheque = consecutivo_cheque;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public int getValor_total_compra_IVA() {
		return valor_total_compra_IVA;
	}

	public void setValor_total_compra_IVA(int valor_total_compra_IVA) {
		this.valor_total_compra_IVA = valor_total_compra_IVA;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getNum_cuenta() {
		return Num_cuenta;
	}

	public void setNum_cuenta(String num_cuenta) {
		Num_cuenta = num_cuenta;
	}

	@Override
	public String toString() {
		return "Cheque [consecutivo_cheque=" + consecutivo_cheque + ", nombre_proveedor=" + nombre_proveedor
				+ ", valor_total_compra_IVA=" + valor_total_compra_IVA + ", banco=" + banco + ", Num_cuenta="
				+ Num_cuenta + "]";
	}
	
}
