

public class Proveedor {


	private int NIT; 
	private String nombre_proveedor;
	private String direccion; 
	private int telefono; 
	private String ciudad; 


	public Proveedor () {

	}

	public Proveedor (int NIT, String nombre_proveedor, String direccion, int telefono, String ciudad) {
		
		this.NIT = NIT; 
		this.nombre_proveedor = nombre_proveedor;
		this.direccion = direccion;
		this.ciudad = ciudad;

	}

	public int getNIT() {
		return NIT;
	}

	public void setNIT(int nIT) {
		NIT = nIT;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Proveedor [NIT=" + NIT + ", nombre_proveedor=" + nombre_proveedor + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", ciudad=" + ciudad + "]";
	}
	
	
}
