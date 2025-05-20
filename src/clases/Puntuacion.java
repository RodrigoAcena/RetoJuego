package clases;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;

public class Puntuacion implements Serializable {
	private static final long serialVersionUID = 707446558496930666L;
	private File archivo;
	private FileWriter fw;
	private PrintWriter escritor;
	public Puntuacion(String ruta) throws IOException {
		archivo = new File(ruta);
		fw = new FileWriter(archivo);
		escritor = new PrintWriter(fw);
	}
	public void insertarRecord() {
		
	}
	public void leerRecord() {
		
	}

}
