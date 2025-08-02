

public class Tienda {

	private String nombre;
	private String tipoComercio;
	private int NIT;
	private String ciudad;
	private int valorIVA;
	private int tasaInteres;
	private String banco;
	private int numCuenta;
	private String gerente;
	
	public Tienda() {
		
	}
	
	public Tienda(String nombre, String tipoComercio, int nIT, String ciudad, int valorIVA, int tasaInteres,
			String banco, int numCuenta, String gerente) {
		super();
		this.nombre = nombre;
		this.tipoComercio = tipoComercio;
		NIT = nIT;
		this.ciudad = ciudad;
		this.valorIVA = valorIVA;
		this.tasaInteres = tasaInteres;
		this.banco = banco;
		this.numCuenta = numCuenta;
		this.gerente = gerente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoComercio() {
		return tipoComercio;
	}
	public void setTipoComercio(String tipoComercio) {
		this.tipoComercio = tipoComercio;
	}
	public int getNIT() {
		return NIT;
	}
	public void setNIT(int nIT) {
		NIT = nIT;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getValorIVA() {
		return valorIVA;
	}
	public void setValorIVA(int valorIVA) {
		this.valorIVA = valorIVA;
	}
	public int getTasaInteres() {
		return tasaInteres;
	}
	public void setTasaInteres(int tasaInteres) {
		this.tasaInteres = tasaInteres;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public int getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}
	public String getGerente() {
		return gerente;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
}
