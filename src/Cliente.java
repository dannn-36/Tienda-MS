

public class Cliente {

	private String cedula; 
	private String nombre_completo; 
	private String direccion; 
	private int telefono; 
	private String correo_electronico; 


	public Cliente ()  {

	}

	public Cliente (String cedula, String nombre_completo, String direccion, int telefono, String correo_electronico) {

		this.cedula = cedula; 
		this.nombre_completo = nombre_completo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo_electronico = correo_electronico;

	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
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

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre_completo=" + nombre_completo + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", correo_electronico=" + correo_electronico + "]";
	}
	
}
