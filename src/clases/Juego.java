package clases;

import java.util.ArrayList;

public class Juego {

	private static String[] nombresEnemigos = {"Cato", "Adrius", "Vulgor", "Cassius", "Bjorn"};
	private ArrayList<Enemigo> enemigos;
	private Personaje jugador;
	private int nRondas;
	private int ronda;
	
	public Juego() {
		enemigos = new ArrayList<Enemigo>(nombresEnemigos.length);
	}
	
	public static String[] getNombresEnemigos() {
		return nombresEnemigos;
	}
	public static void setNombresEnemigos(String[] nombresEnemigos) {
		Juego.nombresEnemigos = nombresEnemigos;
	}
	public Personaje getJugador() {
		return jugador;
	}
	public void setJugador(Personaje jugador) {
		this.jugador = jugador;
	}
	public int getnRondas() {
		return nRondas;
	}
	public void setnRondas(int nRondas) {
		this.nRondas = nRondas;
	}
	public int getRonda() {
		return ronda;
	}
	public void setRonda(int ronda) {
		this.ronda = ronda;
	}
	
	public static String ranNombre() {
		return nombresEnemigos[(int)(Math.random() * nombresEnemigos.length)];
	}
	
	public void iniciarJuego() {
		if(enemigos.isEmpty()) {
			setRonda(0);
			for(int i = 0; i < nRondas; i++) {
				Enemigo e = new Enemigo();
				e.iniciarEnemigo(ranNombre());
				enemigos.add(e);
			}
		} else {
			enemigos.clear();
			setRonda(0);
			for(int i = 0; i < nRondas; i++) {
				Enemigo e = new Enemigo();
				e.iniciarEnemigo(ranNombre());
				enemigos.add(e);
			}
		}
	}
	
	public Enemigo getSiguiente() {
		return enemigos.get(0);
	}
	
	public boolean terminarRonda() {
		if(enemigos.get(0).vida <= 0) {
			enemigos.remove(0);
			ronda++;
			return true;
		}
		return false;
	}
	
	public void nuevoMago(String nombre) {
		jugador = new Mago((int)(Math.random() * (150 - 50 + 1) + 50), nombre);
	}
	
	public void nuevoGuerrero(String nombre) {
		jugador = new Guerrero((int)(Math.random() * (200 - 100 + 1) + 100), nombre);
	}
	
	public boolean finalizarJuego() {
		if(enemigos.isEmpty()) {
			System.out.println("HAS GANADO");
			return true;
		} else if(ronda >= nRondas) {
			System.out.println("HAS GANADO");
			return true;
		} else if(jugador.getVida() <= 0) {
			System.out.println(jugador.getNombre() + " ha muerto...");
			return true;
		}
		return false;
	}
}
