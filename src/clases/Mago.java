package clases;

public class Mago extends Personaje{
	private final static int FUERZA_MAGICA = 20;
	private final static int FUERZA_SIN_MAGIA = 5;
	private final static int DEFENSA = 5;
	private final static int MAGIA = 10;
	
	private int magia;

	public Mago(int vida, String nombre) {
		super(vida, FUERZA_MAGICA, DEFENSA, nombre);
		magia = MAGIA;
	}

	@Override
	public int atacar(Personaje otro) {
		magia--;
		if(magia <= 0) {
			this.ataque = FUERZA_SIN_MAGIA;
		}
		return super.atacar(otro);
	}

	@Override
	public void curar() {
		magia--;
		if(magia > 0) {
			if((vida + ataque) > vidaInicial) {
				setVida(vidaInicial);
			} else {
				setVida(vida + ataque);
			}
		} else {
			setVida(vida);
		}
	}

	@Override
	public void resetear() {
		magia = MAGIA;
		super.resetear();
	}

	@Override
	public String toString() {
		return super.toString() + "; Magia: " + magia + "/" + MAGIA;
	}
	
}
