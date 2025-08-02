import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditarPerfilTienda extends JFrame implements ActionListener{

	private JTextField txtNombre;
	private JTextField txtTipoComercio;
	private JTextField txtNit;
	private JTextField txtCiudad;
	private JTextField txtValorIVA;
	private JTextField txtInteres;
	private JTextField txtNomBanco;
	private JTextField txtNumCuenta;
	private JTextField txtGerente;
	private JLabel lblInfo;
	private JLabel lblInfo2;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private Tienda t;
	private Configuracion c;
	
	public EditarPerfilTienda(Configuracion configuracion,Tienda tienda) {
		t = tienda;
		c= configuracion;
		setLayout(new GridLayout(11, 2));

		this.txtNombre = new JTextField();
		txtNombre.setText(tienda.getNombre());
		this.txtTipoComercio = new JTextField();
		txtTipoComercio.setText(tienda.getTipoComercio());
		this.txtNit = new JTextField();
		txtNit.setText(tienda.getNIT()+"");
		this.txtCiudad = new JTextField();
		txtCiudad.setText(tienda.getCiudad());
		this.txtValorIVA = new JTextField();
		txtValorIVA.setText(tienda.getValorIVA()+"");
		this.txtInteres = new JTextField();
		txtInteres.setText(tienda.getTasaInteres()+"");
		this.txtNomBanco = new JTextField();
		txtNomBanco.setText(tienda.getBanco());
		this.txtNumCuenta = new JTextField();
		txtNumCuenta.setText(tienda.getNumCuenta()+"");
		this.txtGerente = new JTextField();
		txtGerente.setText(tienda.getGerente());
		this.lbl1 = new JLabel("|  Nombre de la tienda:*");
		this.lbl2 = new JLabel("|  Tipo de comercio que realiza la tienda:*");
		this.lbl3 = new JLabel("|  NIT de la tienda:*");
		this.lbl4 = new JLabel("|  Ciudad en que está la tienda:*");
		this.lbl5 = new JLabel("|  Valor de IVA:*");
		this.lbl6 = new JLabel("|  Tasa de interés:*");
		this.lbl7 = new JLabel("|  Nombre del Banco donde se tiene la cuenta:*");
		this.lbl8 = new JLabel("|  Número de cuenta corriente del banco:*");
		this.lbl9 = new JLabel("|  Nombre del gerente de la tienda:*");
		lblInfo =new JLabel("* Campos obligatorios");
		lblInfo2 =new JLabel("");
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setActionCommand("Aceptar");
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("cancelar");

		add(lbl1);
		add(txtNombre);
		add(lbl2);
		add(txtTipoComercio);
		add(lbl3);
		add(txtNit);
		add(lbl4);
		add(txtCiudad);
		add(lbl5);
		add(txtValorIVA);
		add(lbl6);
		add(txtInteres);
		add(lbl7);
		add(txtNomBanco);
		add(lbl8);
		add(txtNumCuenta);
		add(lbl9);
		add(txtGerente);
		add(lblInfo);
		add(lblInfo2);
		add(btnAceptar);
		add(btnCancelar);

		setTitle("Editar");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(600, 600));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	public boolean validar() {
		boolean rts = true;
		if (txtNombre.getText().equals("")) {
			rts = false;
		} else if (txtTipoComercio.getText().equals("")) {
			rts = false;
		} else if (txtNit.getText().equals("")) {
			rts = false;
		} else if (txtCiudad.getText().equals("")) {
			rts = false;
		} else if (txtValorIVA.getText().equals("")) {
			rts = false;
		} else if (txtInteres.getText().equals("")) {
			rts = false;
		} else if (txtNomBanco.getText().equals("")) {
			rts = false;
		} else if (txtNumCuenta.getText().equals("")) {
			rts = false;
		} else if (txtGerente.getText().equals("")) {
			rts = false;
		}
		return rts;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if(evento.equalsIgnoreCase("Aceptar")) {
			System.out.println("Aceptar");
			if(validar()) {
				ArrayList<String> arr = new ArrayList<>();
				arr.add(txtNombre.getText());
				arr.add(txtTipoComercio.getText());
				arr.add(txtNit.getText());
				arr.add(txtCiudad.getText());
				arr.add(txtValorIVA.getText());
				arr.add(txtInteres.getText());
				arr.add(txtNomBanco.getText());
				arr.add(txtNumCuenta.getText());
				arr.add(txtGerente.getText());
				c.getP().Escribir(arr, "tienda");
				new Principal();
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Campo vacio" );
			}
		}else {
			System.out.println("Cancelar");
			new PerfilTienda(c,t);
			this.dispose();
		}
	}
}
