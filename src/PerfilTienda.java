import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PerfilTienda extends JFrame implements ActionListener{

	private Tienda t;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl12;
	private JLabel lbl22;
	private JLabel lbl32;
	private JLabel lbl42;
	private JLabel lbl52;
	private JLabel lbl62;
	private JLabel lbl72;
	private JLabel lbl82;
	private JLabel lbl92;
	private JButton btnEditar;
	private JButton btnCancelar;
	private Configuracion c;
	
	public PerfilTienda(Configuracion configuracion,Tienda tienda) {
		t=tienda;
		c=configuracion;
		setLayout(new GridLayout(10, 2));

		this.lbl1 = new JLabel(t.getNombre());
		this.lbl2 = new JLabel(t.getTipoComercio());
		this.lbl3 = new JLabel(t.getNIT()+"");
		this.lbl4 = new JLabel(t.getCiudad());
		this.lbl5 = new JLabel(t.getValorIVA()+"");
		this.lbl6 = new JLabel(t.getTasaInteres()+"");
		this.lbl7 = new JLabel(t.getBanco());
		this.lbl8 = new JLabel(t.getNumCuenta()+"");
		this.lbl9 = new JLabel(t.getGerente());
		this.lbl12 = new JLabel("Nombre de la tienda:");
		this.lbl22 = new JLabel("Tipo de comercio que realiza la tienda:");
		this.lbl32 = new JLabel("NIT de la tienda:");
		this.lbl42 = new JLabel("Ciudad en que está la tienda:*");
		this.lbl52 = new JLabel("Valor de IVA:*");
		this.lbl62 = new JLabel("Tasa de interés:*");
		this.lbl72 = new JLabel("Nombre del Banco donde se tiene la cuenta:");
		this.lbl82 = new JLabel("Número de cuenta corriente del banco:");
		this.lbl92 = new JLabel("Nombre del gerente de la tienda:");
		this.lbl92 = new JLabel("Nombre del gerente de la tienda:");
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setActionCommand("Editar");
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("cancelar");

		add(lbl12);
		add(lbl1);
		add(lbl22);
		add(lbl2);
		add(lbl32);
		add(lbl3);
		add(lbl42);
		add(lbl4);
		add(lbl52);
		add(lbl5);
		add(lbl62);
		add(lbl6);
		add(lbl72);
		add(lbl7);
		add(lbl82);
		add(lbl8);
		add(lbl92);
		add(lbl9);
		add(btnEditar);
		add(btnCancelar);

		setTitle("Editar");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(600, 600));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equalsIgnoreCase("Editar")) {
			System.out.println("Editar");
			new EditarPerfilTienda(c,t);
			this.dispose();
		}else{
			System.out.println("cancelar");
			new Principal();
			this.dispose();
		}
	}
}
