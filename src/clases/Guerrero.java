package clases;

public class Guerrero extends Personaje implements Jugable {
	private final static int FUERZA = 15;
	private final static int DEFENSA = 10;
	private final static int POCIONES = 2;
	
	private int pociones;

	public Guerrero(int vida, String nombre) {
		super(vida, FUERZA, DEFENSA, nombre);
		pociones = POCIONES;
	}
	

	@Override
	public void curar() {
		if(pociones > 0 && vida < vidaInicial) {
			setVida(vidaInicial);
			pociones--;
		} else if(pociones <= 0) {
			System.out.println("No tienes pociones");
		}
	}

	@Override
	public void resetear() {
		pociones = POCIONES;
		super.resetear();
	}

	@Override
	public String toString() {
		return super.toString() + "; Pociones: " + pociones + "/" + POCIONES;
	}
	
}
