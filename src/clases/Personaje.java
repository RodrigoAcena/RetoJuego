package clases;

public abstract class Personaje {

	protected int vida;
	protected int vidaInicial;
	protected int ataque;
	protected int defensa;
	private String nombre;
	public Personaje(int vida, int ataque, int defensa, String nombre) {
		this.vida = vida;
		vidaInicial = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.nombre = nombre;
	}
	public Personaje() {
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getVidaInicial() {
		return vidaInicial;
	}
	public void setVidaInicial(int vidaInicial) {
		this.vidaInicial = vidaInicial;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int atacar(Personaje otro) {
		return otro.vida -= (this.ataque - otro.defensa) < 0 ? 0 : (this.ataque - otro.defensa);
	}
	public void resetear() {
		setVida(vidaInicial);
	}
	public boolean muerto(Personaje p) {
		if(p.vida <= 0) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return nombre + "=> Vida: " + vida+ "/" + vidaInicial;
	}
}
