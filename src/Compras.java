import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Compras extends JFrame implements ActionListener{

	private Configuracion configuracion;
	private Proveedor proveedorm;
	private JButton cancelar;
	private JButton adicionar;
	private JButton totalizar;
	private PanelLista<Producto> panelL;
	private ArrayList<Producto> arrayP;
	private ArrayList<Producto> array;
	private ArrayList<Integer> cantidad;
	
	public Compras(Configuracion pConfiguracion,Proveedor proveedor) {
		JPanel p=new JPanel();
		configuracion=pConfiguracion;
		setSize(200, 360);
		arrayP = new ArrayList<>();
		array = new ArrayList<>();
		this.setTitle(proveedor.getNombre_proveedor());
		cantidad = new ArrayList<>();
		proveedorm = proveedor;
		
		p.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		adicionar = new JButton("Adicionar");
		adicionar.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		p.add(adicionar, c);

		totalizar = new JButton("Totalizar");
		totalizar.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		p.add(totalizar, c);
		
		panelL = new PanelLista<>("Compras");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 200;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		p.add(panelL, c);
		
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(10,0,0,0);
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 2;
		p.add(cancelar, c);

		add(p);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	public boolean buscarProducto(String cedula) {
		boolean rts = false;
		ArrayList<String> arr = configuracion.getP().leer("productos");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
			String[] split = arr.get(i).split(";");
			if(split[0].equals(cedula)&&split[2].equals(proveedorm.getNIT()+"")) {
				rts=true;
			}
		}
		return rts;
	}
	public Producto leerProducto(String codigo) {
		Producto p = new Producto();
		ArrayList<String> arr = configuracion.getP().leer("productos");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
			String[] split = arr.get(i).split(";");
			if(split[0].equals(codigo)) {
				p.setCodigo_producto(Integer.parseInt(split[0]));
				p.setNombre_producto(split[1]);
				p.setNIT_proveedor_producto(Integer.parseInt(split[2]));
				p.setPrecio_compra_producto(Integer.parseInt(split[3]));
				p.setPrecio_venta_producto(Integer.parseInt(split[4]));
			}
		}
		return p;
	}
	
	public void totalizar() {
		int iva = (configuracion.getTienda().getValorIVA());
		int totaliza =0,totaiva=0;
		ArrayList<String> ivas = new ArrayList<>();
		for (int i = 0; i < arrayP.size(); i++) {
			int total = (arrayP.get(i).getPrecio_venta_producto()*iva)/100;
			ivas.add(total+"");
			totaiva+=total;
			totaliza+=total+arrayP.get(i).getPrecio_venta_producto();
		}
		JOptionPane.showMessageDialog(null, totaiva);
		int b = JOptionPane.showConfirmDialog(null, "Confirmar compra");
		if(b==0) {
			String[] txt = configuracion.leerCompra().get(configuracion.leerCompra().size()-1).split(";");
			int cons = Integer.parseInt(txt[0]);
			Cheque ch = new Cheque((cons+1)+"", proveedorm.getNombre_proveedor(), 
					totaliza, configuracion.getTienda().getBanco(), configuracion.getTienda().getNumCuenta()+"");
			JOptionPane.showMessageDialog(null, ch.toString());
			configuracion.agregarCompra(new Compra(cons+1, proveedorm.getNIT(), totaliza, configuracion.getTienda().getValorIVA(), totaliza));
			for (int i = 0; i < array.size(); i++) {
				Detalle_compra dv = new Detalle_compra(array.get(i).getCodigo_producto(), cantidad.get(i), cantidad.get(i)*array.get(i).getPrecio_compra_prosducto(), cons+1);
				configuracion.agregarCompras(dv);
			}
			configuracion.agregarCheque(ch);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String evento= e.getActionCommand();
		if(evento.equalsIgnoreCase("Totalizar")) {
			totalizar();
			new Principal();
			this.dispose();
		}else if(evento.equalsIgnoreCase("Adicionar")) {
			String codigo = JOptionPane.showInputDialog(null, "Digite el codigo del producto:");
			if(buscarProducto(codigo)) {
				String canti = JOptionPane.showInputDialog(null, "Digite la cantidad:");
				Producto p = leerProducto(codigo);
				panelL.getModeloLista().addElement(p.getNombre_producto()+" -- "+canti);
				for (int i = 0; i < Integer.parseInt(canti); i++) {
					arrayP.add(p);
				}
				array.add(p);
				cantidad.add(Integer.parseInt(canti));
			}else {
				JOptionPane.showMessageDialog(null, "Producto no encontrado");
			}
		}else {
			new Principal();
			this.dispose();
		}
	}
}
