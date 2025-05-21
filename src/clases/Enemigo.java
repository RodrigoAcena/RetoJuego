package clases;

public class Enemigo extends Personaje {

	public Enemigo() {
	}
	
	public void iniciarEnemigo(String nombre) {
		setNombre(nombre);
		vida = (int) (Math.random() * (100 - 20 + 1)) + 20;
		vidaInicial = vida;
		ataque = (int) (Math.random() * (20 - 2 + 1)) + 2;
		defensa = (int) (Math.random() * (5 - 1 + 1)) + 1;
	}

	@Override
	public void curar() {
		
	}
	
}
