package programa;

import java.io.IOException;
import java.util.Scanner;

import clases.*;

public class Programa {

	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(System.in);
		Juego juego = new Juego();
		Puntuacion puntos = new Puntuacion("ficheros/mejorPuntuacion.txt");
		String nombre;
		int clase;
		int rondas;
		int elegir;
		
		puntos.leerRecord();
		System.out.print("¡Bienvenido al juego!\n"
				+ "Introduce el nombre del personaje: ");
		nombre = entrada.nextLine();
		do {
			System.out.println("Elige tu clase:\n"
					+ "1. Mago\n"
					+ "2. Guerrero");
			System.out.print("Clase: ");
			clase = entrada.nextInt();
			entrada.nextLine();
			if(!(clase == 1 || clase == 2)) {
				System.err.println("ERROR: Clase no valida");
			}
		} while(!(clase == 1 || clase == 2));
		
		System.out.print("¿Cuantas rondas quieres jugar? ");
		rondas = entrada.nextInt();
		entrada.nextLine();
		juego.setnRondas(rondas);
		juego.iniciarJuego();
		
		switch(clase) {
		case 1:
			juego.nuevoMago(nombre);
			do {
				do {
					System.out.println("Ronda: " + (juego.getRonda() + 1) + "/" + juego.getnRondas());
					System.out.println(juego.getSiguiente());
					System.out.println("Tu: "+juego.getJugador());
					System.out.println("Acciones:\n"
							+ "\t1. Atacar\n"
							+ "\t2. Curar");
					System.out.print("Elige: ");
					elegir = entrada.nextInt();
					entrada.nextLine();
					
					switch(elegir) {
					case 1:
						System.out.println(nombre + " ataca a " + juego.getSiguiente().getNombre());
						juego.getJugador().atacar(juego.getSiguiente());
						break;
					case 2:
						System.out.println(nombre + " se cura");
						juego.getJugador().curar();
						break;
					default:
						System.out.println("Opcion incorrecta");
					}
					System.out.println(juego.getSiguiente().getNombre() + " ataca a " + nombre);
					juego.getSiguiente().atacar(juego.getJugador());
				} while(juego.terminarRonda() != true);
			} while(juego.finalizarJuego() != true);
			break;
		case 2:
			juego.nuevoGuerrero(nombre);
			do {
				do {
					System.out.println("Ronda: " + (juego.getRonda() + 1) + "/" + juego.getnRondas());
					System.out.println(juego.getSiguiente());
					System.out.println("Tu: "+juego.getJugador());
					System.out.println("Acciones:\n"
							+ "\t1. Atacar\n"
							+ "\t2. Curar");
					System.out.print("Elige: ");
					elegir = entrada.nextInt();
					entrada.nextLine();
					
					switch(elegir) {
					case 1:
						System.out.println(nombre + " ataca a " + juego.getSiguiente().getNombre());
						juego.getJugador().atacar(juego.getSiguiente());
						break;
					case 2:
						if(juego.getJugador().getVida() == juego.getJugador().getVidaInicial()) {
							System.out.println();
						} else {
							System.out.println(nombre + " se cura");
							juego.getJugador().curar();
						}
						break;
					default:
						System.out.println("Opcion incorrecta");
					}
					System.out.println(juego.getSiguiente().getNombre() + " ataca a " + nombre);
					juego.getSiguiente().atacar(juego.getJugador());
				} while(juego.terminarRonda() != true);
				if(puntos.recordSuperado(nombre, rondas) == true) {
					System.out.println("¡Nuevo Record!");
					puntos.insertarRecord(nombre, rondas);
				}
			} while(juego.finalizarJuego() != true);
			break;
		}
		entrada.close();
	}

}
