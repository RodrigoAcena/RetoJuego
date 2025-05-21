package clases;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Puntuacion implements Serializable {
	private static final long serialVersionUID = 707446558496930666L;
	private File archivo;

	public Puntuacion(String ruta){
		archivo = new File(ruta);
	}

	public void insertarRecord(String nombre, int rondas) {
		PrintWriter escritor = null;
		try {
			FileWriter fw = new FileWriter(archivo);
			escritor = new PrintWriter(fw);
			if (!recordSuperado(rondas)) {
				escritor.println(nombre +" "+ rondas);
			}
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			escritor.close();
		}
	}

	public void leerRecord() {
		Scanner entrada = null;
		try {
			entrada = new Scanner(archivo);
			while (entrada.hasNextLine()) {
				String linea = entrada.nextLine();
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			try {
				archivo.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (entrada != null) {
				entrada.close();
			}
		}
	}

	public boolean recordSuperado(int rondas) {
		Scanner entrada = null;
		try {
			entrada = new Scanner(archivo);
			while (entrada.hasNextLine()) {
				try {
					if (rondas > entrada.nextInt()) {
						return true;
					} else {
						return false;
					}
				} catch (InputMismatchException e) {
					continue;
				} finally {
					entrada.nextLine();
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
