package logic;

public class Ciudad {
	
	private String nombre;
	private int posX;
	private int posY;
	
	public Ciudad() {
		nombre = null;
		posX = 0;
		posY = 0;
	}
	public Ciudad(String pNombre, int pX, int pY) {
		this.nombre = pNombre;
		this.posX = pX;
		this.posY = pY;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	

}
