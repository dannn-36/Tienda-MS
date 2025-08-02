
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

public class Propiedades {

	private Properties prop = new Properties();
	private String archivoprop = "./data/config.properties";
	
	public void setPropiedades(String archivo) {
		try {
			prop.setProperty("nombreArchivo", "./data/"+archivo+".txt");
			prop.setProperty("archivoProp", "./data/archivo.properties");
			prop.setProperty("nombreCodigo", "Propiedades.Java");
			prop.store(new FileOutputStream(archivoprop), null);
		} catch (IOException e) {
			
		}
	}
	public void getPropiedades() {
		try {
			prop.load(new FileInputStream(archivoprop));
			prop.list(System.out);
			System.out.println(prop.getProperty("nombreArchivo"));
			System.out.println(prop.getProperty("archivoProp"));
			System.out.println(prop.getProperty("nombreCodigo"));
		} catch (Exception e) {
		}
	}
	public ArrayList<String> leer(String archivo) {
		File f = new File("./data/"+archivo+".txt");
		ArrayList<String> arr = new ArrayList<>();
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea!=null) {
				arr.add(linea);
				System.out.println(linea);
				linea=br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			
		}
		return arr;
	}
	public void Escribir(ArrayList<String> arr,String archivo) {
		File f = new File("./data/"+archivo+".txt");
		try {
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			for (int i = 0; i < arr.size(); i++) {
				pw.println(arr.get(i));
			}
			pw.close();
			fw.close();
		} catch (IOException e) {
			
		}
	}
}