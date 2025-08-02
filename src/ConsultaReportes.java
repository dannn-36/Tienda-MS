import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

public class ConsultaReportes <E>extends JFrame implements ActionListener{

	private Configuracion configuracion;
	private JButton regresar;
	private JLabel lbl2;
	private PanelLista<E> panelL;
	
	public ConsultaReportes(Configuracion pConfiguracion,String lista) {
		JPanel p=new JPanel();
		configuracion=pConfiguracion;
		setSize(500, 350);
		
		p.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		lbl2 = new JLabel("");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 200;
		c.gridx = 1;
		c.gridy = 0;
		p.add(lbl2, c);
		
		if(lista.equals("clientes")) {
			configuracion.leerClientes();
			panelL = new PanelLista<E>((ArrayList<E>) configuracion.getListaClientes(), lista);
		}else if(lista.equals("cheques")) {
			panelL = new PanelLista<E>((ArrayList<E>) configuracion.leerCheques(), lista);
		}else if(lista.equals("ventas")) {
			panelL = new PanelLista<E>((ArrayList<E>) configuracion.leerVentaPorCliente(), lista);
		}else if(lista.equals("detalle_ventas")) {
			panelL = new PanelLista<E>((ArrayList<E>) configuracion.leerVentas(), lista);
		}else {
			panelL = new PanelLista<E>((ArrayList<E>) configuracion.leerCompraPorProveedor(), lista);
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 200;
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 0;
		p.add(panelL, c);
		
		regresar = new JButton("Cancelar");
		regresar.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(10,0,0,0);
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 1;
		p.add(regresar, c);

		add(p);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Principal();
		this.dispose();
	}
}
