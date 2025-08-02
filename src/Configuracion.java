import java.util.ArrayList;

public class Configuracion {

	private Tienda tienda;
	private Propiedades p;
	
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Proveedor> listaProveedores;
	private ArrayList<Producto> listaProductos;
	private ArrayList<String> listas;
	
	public Configuracion() {
		p = new Propiedades();
		p.setPropiedades("tienda");
		ArrayList<String> arr=p.leer("tienda");
		tienda = new Tienda(arr.get(0), arr.get(1),Integer.parseInt(arr.get(2)), arr.get(3), Integer.parseInt(arr.get(4))
				, Integer.parseInt(arr.get(5)), arr.get(6), Integer.parseInt(arr.get(7)), arr.get(8));
		listaClientes = new ArrayList<>();
		listaProductos = new ArrayList<>();
		listaProveedores = new ArrayList<>();
		listas = new ArrayList<>();
	}
	
	public ArrayList<String> getListas() {
		return listas;
	}

	public void setListas(ArrayList<String> listas) {
		this.listas = listas;
	}

	public void leerClientes() {
		p.setPropiedades("clientes");
		ArrayList<String> arrs = p.leer("clientes");
		for (int i = 0; i < arrs.size(); i++) {
			String[] split = arrs.get(i).split(";");
			listaClientes.add(new Cliente(split[0],split[1], split[2],Integer.parseInt(split[3]), split[4]));
		}
	}
	public void agregarCliente(Cliente cliente) {
		ArrayList<String> arrs = p.leer("clientes");
		arrs.add(cliente.getCedula()+";"+cliente.getNombre_completo()+";"+cliente.getDireccion()+";"+cliente.getTelefono()+";"+cliente.getCorreo_electronico());
		p.Escribir(arrs, "clientes");
	}
	public void actualizarCliente(Cliente cliente) {
		ArrayList<String> arrs = p.leer("clientes");
		for (int i = 0; i < arrs.size(); i++) {
			String[] split = arrs.get(i).split(";");
			if(split[0].equals(cliente.getCedula())) {
				arrs.set(i, cliente.getCedula()+";"+cliente.getNombre_completo()+";"+cliente.getDireccion()+";"+cliente.getTelefono()+";"+cliente.getCorreo_electronico());
			}
		}
		p.Escribir(arrs, "clientes");
	}
	public void eliminarCliente(Cliente cliente) {
		ArrayList<String> arrs = p.leer("clientes");
		for (int i = 0; i < arrs.size(); i++) {
			String[] split = arrs.get(i).split(";");
			if(split[0].equals(cliente.getCedula())) {
				arrs.remove(i);
			}
		}
		p.Escribir(arrs, "clientes");
	}
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	public void leerProveedor() {
		p.setPropiedades("proveedores");
		ArrayList<String> arrs = p.leer("proveedores");
		for (int i = 0; i < arrs.size(); i++) {
			String[] split = arrs.get(i).split(";");
			listaProveedores.add(new Proveedor(Integer.parseInt(split[0]),split[1], split[2],Integer.parseInt(split[3]), split[4]));
		}
	}
	public void agregarProveedor(Proveedor proveedor) {
		ArrayList<String> arrs = p.leer("proveedores");
		arrs.add(proveedor.getNIT()+";"+proveedor.getNombre_proveedor()+";"+proveedor.getDireccion()+";"+proveedor.getTelefono()+";"+proveedor.getCiudad());
		p.Escribir(arrs, "proveedores");
	}
	public void actualizarProveedor(Proveedor proveedor) {
		ArrayList<String> arrs = p.leer("proveedores");
		for (int i = 0; i < arrs.size(); i++) {
			String[] split = arrs.get(i).split(";");
			if(split[0].equals(proveedor.getNIT()+"")) {
				arrs.set(i, proveedor.getNIT()+";"+proveedor.getNombre_proveedor()+";"+proveedor.getDireccion()+";"+proveedor.getTelefono()+";"+proveedor.getCiudad());
			}
		}
		p.Escribir(arrs, "proveedores");
	}
	public void eliminarProveedor(Proveedor proveedor) {
		ArrayList<String> arrs = p.leer("proveedores");
		for (int i = 0; i < arrs.size(); i++) {
			String[] split = arrs.get(i).split(";");
			if(split[0].equals(proveedor.getNIT()+"")) {
				arrs.remove(i);
			}
		}
		p.Escribir(arrs, "proveedores");
	}
	
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public void leerProducto() {
		p.setPropiedades("productos");
		ArrayList<String> arrs = p.leer("productos");
		for (int i = 0; i < arrs.size(); i++) {
			String[] split = arrs.get(i).split(";");
			listaProductos.add(new Producto(Integer.parseInt(split[0]),split[1], Integer.parseInt(split[2]),Integer.parseInt(split[3]), Integer.parseInt(split[4])));
		}
	}
	public void agregarProducto(Producto producto) {
		ArrayList<String> arrs = p.leer("productos");
		arrs.add(producto.getCodigo_producto()+";"+producto.getNombre_producto()+";"+producto.getNIT_proveedor_producto()+";"+producto.getPrecio_compra_prosducto()+";"+producto.getPrecio_venta_producto());
		p.Escribir(arrs, "productos");
	}
	public void actualizarProducto(Producto producto) {
		ArrayList<String> arrs = p.leer("productos");
		for (int i = 0; i < arrs.size(); i++) {
			String[] split = arrs.get(i).split(";");
			if(split[0].equals(producto.getCodigo_producto()+"")) {
				arrs.set(i, producto.getCodigo_producto()+";"+producto.getNombre_producto()+";"+producto.getNIT_proveedor_producto()+";"+producto.getPrecio_compra_prosducto()+";"+producto.getPrecio_venta_producto());
			}
		}
		p.Escribir(arrs, "productos");
	}
	public void eliminarProducto(Producto producto) {
		ArrayList<String> arrs = p.leer("productos");
		for (int i = 0; i < arrs.size(); i++) {
			String[] split = arrs.get(i).split(";");
			if(split[0].equals(producto.getCodigo_producto()+"")) {
				arrs.remove(i);
			}
		}
		p.Escribir(arrs, "productos");
	}
	
	public ArrayList<Proveedor> getListaProveedores() {
		return listaProveedores;
	}
	
	public void setListaProveedores(ArrayList<Proveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}
	
	public void agregarVenta(Venta venta) {
		ArrayList<String> arrs = p.leer("ventas");
		arrs.add(venta.getCodigo_venta()+";"+venta.getCedula_cliente()+";"+venta.getValor_total_venta()+";"+tienda.getValorIVA()+";"+venta.getValor_total_IVA());
		p.Escribir(arrs, "ventas");
	}
	
	public void agregarVentas(Detalle_venta venta) {
		ArrayList<String> arrs = p.leer("detalle_ventas");
		arrs.add(venta.toString());
		p.Escribir(arrs, "detalle_ventas");
	}
	
	public ArrayList<String> leerVenta(){
		return p.leer("ventas");
	}
	public ArrayList<String> leerVentas(){
		return p.leer("detalle_ventas");
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	
	public void agregarCredito(Credito credito) {
		ArrayList<String> arrs = p.leer("creditos");
		arrs.add(credito.toString());
		p.Escribir(arrs, "creditos");
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public Propiedades getP() {
		return p;
	}
	public void setP(Propiedades p) {
		this.p = p;
	}
	
	public void agregarCompra(Compra compra) {
		ArrayList<String> arrs = p.leer("compras");
		arrs.add(compra.getCodigo_compra()+";"+compra.getNIT_proveedor()+";"+compra.getValor_total()+
				";"+compra.getValor_IVA()+";"+compra.getValor_total_IVA());
		p.Escribir(arrs, "compras");
	}
	
	public void agregarCompras(Detalle_compra compra) {
		ArrayList<String> arrs = p.leer("detalle_compras");
		arrs.add(compra.toString());
		p.Escribir(arrs, "detalle_compras");
	}
	
	public ArrayList<String> leerCompra(){
		return p.leer("compras");
	}
	
	public ArrayList<String> leerCheques(){
		return p.leer("cheques");
	}
	
	public void agregarCheque(Cheque cheque) {
		ArrayList<String> arrs = p.leer("cheques");
		arrs.add(cheque.toString());
		p.Escribir(arrs, "cheques");
	}
	
	public ArrayList<String> leerVentaPorCliente(){
		ArrayList<String> rts = new ArrayList<>();
		ArrayList<String> aux = p.leer("ventas");
		ArrayList<String> aux2 = p.leer("clientes");
		for (int i = 0; i < aux.size(); i++) {
			String[] m = aux.get(i).split(";");
			for (int j = 0; j < aux2.size(); j++) {
				String[] m2 = aux2.get(i).split(";");
				if(m[1].equals(m2[0])) {
					rts.add(new Venta(Integer.parseInt(m[0]),m[1],Integer.parseInt(m[2]), Integer.parseInt(m[3]), Integer.parseInt(m[4])).toString());
				}
			}
		}
		return rts;
	}
	public ArrayList<String> leerCompraPorProveedor(){
		ArrayList<String> rts = new ArrayList<>();
		ArrayList<String> aux = p.leer("compras");
		ArrayList<String> aux2 = p.leer("proveedores");
		for (int i = 0; i < aux.size(); i++) {
			String[] m = aux.get(i).split(";");
			for (int j = 0; j < aux2.size(); j++) {
				String[] m2 = aux2.get(i).split(";");
				if(m[0].equals(m2[1])) {
					rts.add(new Compra(Integer.parseInt(m[0]),Integer.parseInt(m[1]),Integer.parseInt(m[2]), Integer.parseInt(m[3]), Integer.parseInt(m[4])).toString());
				}
			}
		}
		return rts;
	}
}
