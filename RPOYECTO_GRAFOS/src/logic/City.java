package logic;

import java.awt.Color;

public class City {
	
	private String name;
	private int pointX;
	private int pointY;
	private float scaleX;
	private float scaleY;
	private float width;
	private float height;
	private Color color;
	
	public final static int TAMANIO = 6;
	
	public City() {
		color = Color.BLACK;
		name = null;
		pointX = 0;
		pointY = 0;
		scaleX = 0;
		scaleY = 0;
		width = TAMANIO;
		height = TAMANIO;
	}
	public City(String pName, int pX, int pY) {
		this.name = pName;
		this.pointX = pX;
		this.pointY = pY;
	}
	public String getName() {
		return name;
	}
	public void setName(String pName) {
		this.name = pName;
	}
	public int getPointX() {
		return pointX;
	}
	public void setPointX(int pointX) {
		this.pointX = pointX;
	}
	public int getPointY() {
		return pointY;
	}
	public void setPointY(int pointY) {
		this.pointY = pointY;
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
	
	public float getWidth() {
		return width;
	}
	public void setWidth(float pWdith) {
		this.width = pWdith;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float pHeight) {
		this.height = pHeight;
	}
	
	/**
	 * Calcula la nueva posicion a partir de la escala de zoom
	 * @param pScaleX
	 * @param pScaleY
	 */
	public void calculateScale(float pScaleX,float pScaleY) {
		scaleX = pointX * pScaleX;
		scaleY = pointY * pScaleY;
	}
	
	/**
	 * Calcula el nuevo tamaño a partir de la escala del zoom
	 * @param pScaleX
	 * @param pScaleY
	 */
	public void calculateSacaleSize(float pScaleX,float pScaleY) {
		width = TAMANIO * pScaleX;
		height = TAMANIO * pScaleY;
	}
}
