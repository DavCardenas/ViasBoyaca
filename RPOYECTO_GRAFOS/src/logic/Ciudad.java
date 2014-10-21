package logic;

import java.awt.Color;

public class Ciudad {
	
	private String nombre;
	private int posX;
	private int posY;
	private float scaleX;
	private float scaleY;
	private float ancho;
	private float alto;
	private Color color;
	
	public Ciudad() {
		color = Color.BLACK;
		nombre = null;
		posX = 0;
		posY = 0;
		scaleX = 0;
		scaleY = 0;
		ancho = 6;
		alto = 6;
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
	public float getScaleX() {
		return scaleX;
	}
	public void setScaleX(float scaleX) {
		this.scaleX = scaleX;
	}
	public float getScaleY() {
		return scaleY;
	}
	public void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}
	
	public float getAncho() {
		return ancho;
	}
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	public float getAlto() {
		return alto;
	}
	public void setAlto(float alto) {
		this.alto = alto;
	}
	public void cacularEscala(float escalaX,float escalaY) {
		scaleX = posX * escalaX;
		scaleY = posY * escalaY;
	}
	public void cacularEscalaTamanio(float escalaX,float escalaY) {
		ancho = 6 * escalaX;
		alto = 6 * escalaY;
	}
}
