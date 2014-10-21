package logic;

import java.awt.Color;

public class Ciudad {
	
	private String nombre;
	private int posX;
	private int posY;
	private float scaleX;
	private float scaleY;
	private Color color;
	
	public Ciudad() {
		color = Color.BLACK;
		nombre = null;
		posX = 0;
		posY = 0;
		scaleX = posX;
		scaleY = posY;
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	public void cacularEscala(float escala) {
		scaleX = scaleX * escala;
		scaleY = scaleY * escala;
	}
}
