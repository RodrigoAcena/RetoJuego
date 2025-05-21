package clases;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

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

	public void insertarRecord(String nombre, int rondas) {
		if (recordSuperado(nombre, rondas) == true) {
			escritor.println("Nombre del jugador: " + nombre);
			escritor.println("Rondas jugadas: " + rondas);
		}
	}

	public void leerRecord() throws IOException {
		Scanner entrada = null;
		try {
			entrada = new Scanner(archivo);
			while (entrada.hasNextLine()) {
				String linea = entrada.nextLine();
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			archivo.createNewFile();
		} finally {
			if (entrada != null) {
				entrada.close();
			}
		}
	}

	public boolean recordSuperado(String nombre, int rondas) {
		Scanner entrada = null;
		try {
			entrada = new Scanner(archivo);
			while (entrada.hasNextLine()) {
				if (rondas > entrada.nextInt()) {
					return true;
				} else {
					return false;
				}
			}
		} catch (FileNotFoundException e) {
			return false;
		} finally {
			if (entrada != null) {
				entrada.close();
			}
		}
		return false;
	}

}
