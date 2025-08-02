import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class PanelLista <E>extends JPanel{

	private JList<E> jList1;
	private DefaultListModel modeloLista;
	
	public PanelLista(ArrayList<E> lista,String titulo,Clientes c) {
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder(titulo);
		setBorder(title1);
		
		jList1 = new JList<>();
		JScrollPane scroll = new JScrollPane();
		modeloLista = new DefaultListModel();
		setLayout(new GridLayout(1, 1));
		setSize(new Dimension(600, 500));
		
		for (int i = 0; i < lista.size(); i++) {
			modeloLista.addElement(lista.get(i));
		}
		
	    jList1.setModel(modeloLista);
	    jList1.addListSelectionListener(c);
	    scroll.getViewport().setView(jList1);
	    add(scroll);
	}
	public PanelLista(ArrayList<E> lista,String titulo,Proveedores c) {
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder(titulo);
		setBorder(title1);
		
		jList1 = new JList<>();
		JScrollPane scroll = new JScrollPane();
		modeloLista = new DefaultListModel();
		setLayout(new GridLayout(1, 1));
		setSize(new Dimension(600, 500));
		
		for (int i = 0; i < lista.size(); i++) {
			modeloLista.addElement(lista.get(i));
		}
		
	    jList1.setModel(modeloLista);
	    jList1.addListSelectionListener(c);
	    scroll.getViewport().setView(jList1);
	    add(scroll);
	}
	public PanelLista(ArrayList<E> lista,String titulo,Productos c) {
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder(titulo);
		setBorder(title1);
		
		jList1 = new JList<>();
		JScrollPane scroll = new JScrollPane();
		modeloLista = new DefaultListModel();
		setLayout(new GridLayout(1, 1));
		setSize(new Dimension(600, 500));
		
		for (int i = 0; i < lista.size(); i++) {
			modeloLista.addElement(lista.get(i));
		}
		
	    jList1.setModel(modeloLista);
	    jList1.addListSelectionListener(c);
	    scroll.getViewport().setView(jList1);
	    add(scroll);
	}
	public PanelLista(String titulo) {
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder(titulo);
		setBorder(title1);
		
		jList1 = new JList<>();
		JScrollPane scroll = new JScrollPane();
		modeloLista = new DefaultListModel();
		setLayout(new GridLayout(1, 1));
		setSize(new Dimension(600, 500));

	    jList1.setModel(modeloLista);
	    scroll.getViewport().setView(jList1);
	    add(scroll);
	}

	public PanelLista(ArrayList<E> listaClientes, String lista) {
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder(lista);
		setBorder(title1);
		
		jList1 = new JList<>();
		JScrollPane scroll = new JScrollPane();
		modeloLista = new DefaultListModel();
		setLayout(new GridLayout(1, 1));
		setSize(new Dimension(600, 500));
		
		for (int i = 0; i < listaClientes.size(); i++) {
			modeloLista.addElement(listaClientes.get(i));
		}
		
	    jList1.setModel(modeloLista);
	    scroll.getViewport().setView(jList1);
	    add(scroll);
	}
	public JList<E> getjList1() {
		return jList1;
	}

	public void setjList1(JList<E> jList1) {
		this.jList1 = jList1;
	}

	public DefaultListModel getModeloLista() {
		return modeloLista;
	}

	public void setModeloLista(DefaultListModel modeloLista) {
		this.modeloLista = modeloLista;
	}
}
