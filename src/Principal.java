
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton buscar;
	private JButton crear;
	private JButton productos;
	private JButton proveedores;
	private JButton ventas;
	private JButton compras;
	private JButton consultasYreportes;
	private Configuracion configuracion;
	
	public Principal() {
		configuracion = new Configuracion();
		this.setTitle(configuracion.getTienda().getNombre());
		setSize(500, 500);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(7, 1));

		buscar = new JButton("Gestor Clientes");
		buscar.addActionListener(this);
		buscar.setActionCommand("Gestor Clientes");
		crear = new JButton("Perfil Tienda");
		crear.addActionListener(this);
		crear.setActionCommand("Perfil Tienda");
		productos = new JButton("Gestor Productos");
		productos.addActionListener(this);
		productos.setActionCommand("Gestor Productos");
		proveedores = new JButton("Gestor Proveedores");
		proveedores.addActionListener(this);
		proveedores.setActionCommand("Gestor Proveedores");
		ventas = new JButton("Gestor Ventas");
		ventas.addActionListener(this);
		ventas.setActionCommand("Gestor Ventas");
		compras = new JButton("Gestor Compras");
		compras.addActionListener(this);
		compras.setActionCommand("Gestor Compras");
		consultasYreportes = new JButton("Consultas y Reportes");
		consultasYreportes.addActionListener(this);
		consultasYreportes.setActionCommand("Consultas y Reportes");
		
		p.add(buscar);
		p.add(crear);
		p.add(productos);
		p.add(proveedores);
		p.add(ventas);
		p.add(compras);
		p.add(consultasYreportes);
		
		add(p);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int n = 0;
		if(e.getActionCommand().equalsIgnoreCase("Gestor Clientes")) {
			new Clientes(configuracion);
		}else if(e.getActionCommand().equalsIgnoreCase("Perfil Tienda")){
			new PerfilTienda(configuracion,configuracion.getTienda());
		}else if(e.getActionCommand().equalsIgnoreCase("Gestor Productos")){
			new Productos(configuracion);
		}else if(e.getActionCommand().equalsIgnoreCase("Gestor Proveedores")){
			new Proveedores(configuracion);
		}else if(e.getActionCommand().equalsIgnoreCase("Gestor Ventas")){
			String cedula = JOptionPane.showInputDialog(null, "Digite su cedula:");
			if(!cedula.equals("")) {
				if(buscarCliente(cedula)) {
					System.out.println("Ingreso Cliente");
					ArrayList<String> arr = configuracion.getP().leer("clientes");
					for (int i = 0; i < arr.size(); i++) {
						System.out.println(arr.get(i));
						String[] split = arr.get(i).split(";");
						if(split[0].equals(cedula)) {
							new Ventas(configuracion,new Cliente(split[0],split[1], split[2],Integer.parseInt(split[3]), split[4]));
						}
					}
				}else {
					n=1;
					JOptionPane.showMessageDialog(null, "Usuaio invalido");
				}
			}else {
				n=1;
			}
		}else if(e.getActionCommand().equalsIgnoreCase("Gestor Compras")){
			String cedula = JOptionPane.showInputDialog(null, "Digite el NIT del proveedor:");
			if(!cedula.equals("")) {
				if(buscarCliente(cedula)) {
					System.out.println("Ingreso Proveedor");
					ArrayList<String> arr = configuracion.getP().leer("proveedores");
					for (int i = 0; i < arr.size(); i++) {
						System.out.println(arr.get(i));
						String[] split = arr.get(i).split(";");
						if(split[0].equals(cedula)) {
							new Compras(configuracion, new Proveedor(Integer.parseInt(split[0]),split[1], split[2],Integer.parseInt(split[3]), split[4]));
						}
					}
				}else {
					n=1;
					JOptionPane.showMessageDialog(null, "Proveedor invalido");
				}
			}else {
				n=1;
			}
		}else if(e.getActionCommand().equalsIgnoreCase("Consultas y Reportes")){
			String caso = JOptionPane.showInputDialog(null, "1. listado de clientes"+"\n"
					+"2 Total de ventas por cliente"+"\n"
					+"3 detalle de ventas por cliente" +"\n"
					+"4 total de compras por proveedor"+"\n"
					+"5 detalle de cheques expedidos");
			if(caso.equals("1")) {
				new ConsultaReportes<Cliente>(configuracion, "clientes");
			}else if(caso.equals("2")){
				new ConsultaReportes<String>(configuracion, "ventas");
			}else if(caso.equals("3")) {
				new ConsultaReportes<String>(configuracion, "detalle_ventas");
			}else if(caso.equals("4")) {
				new ConsultaReportes<String>(configuracion, "compras");
			}else if(caso.equals("5")) {
				new ConsultaReportes<String>(configuracion, "cheques");
			}else {
				n=1;
				JOptionPane.showConfirmDialog(null, "Error al digitar la opción");
			}
		}else {
			System.out.println("Ups");
		}
		if(n==0) {
			this.dispose();
		}
	}
	public boolean buscarCliente(String cedula) {
		boolean rts = false;
		ArrayList<String> arr = configuracion.getP().leer("clientes");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
			String[] split = arr.get(i).split(";");
			if(split[0].equals(cedula)) {
				rts=true;
			}
		}
		return rts;
	}
	public boolean buscarProveedor(String nit) {
		boolean rts = false;
		ArrayList<String> arr = configuracion.getP().leer("proveedores");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
			String[] split = arr.get(i).split(";");
			if(split[0].equals(nit)) {
				rts=true;
			}
		}
		return rts;
	}
}
