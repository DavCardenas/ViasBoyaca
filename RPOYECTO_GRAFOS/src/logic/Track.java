package logic;

import java.awt.Color;
import java.awt.Point;

public class Track {

	private int Length;
	private String status;
	private int time;
	private int speed;
	private City cityInitial;
	private City cityEnd;
	private int id;
	private Color color;

	public Track() {
		color = Color.BLACK;
		id = 0;
		Length = 0;
		status = "";
		time = 0;
		speed = 0;
		cityInitial = null;
		cityEnd = null;
	}
	
	public Track(City pCityInitial, City pCityEnd) {
		this.cityInitial = pCityInitial;
		this.cityEnd = pCityEnd;
		color = Color.BLACK;
		id = 0;
		Length = 0;
		status = "";
		time = 0;
		speed = 0;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	public int getLength() {
		return Length;
	}
	public void setLength(int pLength) {
		this.Length = pLength;
	}
	public int getTime() {
		return time;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String pStatus) {
		this.status = pStatus;
	}
	public void setTime(int pTime) {
		this.time = pTime;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int pSpeed) {
		this.speed = pSpeed;
	}
	public City getCityInitial() {
		return cityInitial;
	}
	public void setCityInitial(City pCityInitial) {
		this.cityInitial = pCityInitial;
	}
	public City getCityEnd() {
		return cityEnd;
	}
	public void setCityEnd(City pCityEnd) {
		this.cityEnd = pCityEnd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * metodo que calcula la posicion del texto que se imprime en la via
	 * @return
	 */
	public Point calculatePosText() {
		int pointX;
		int pointY;
		pointX = Math.abs(((cityEnd.getPointX() - cityInitial.getPointX())/2));
		pointY = Math.abs(((cityEnd.getPointY() - cityInitial.getPointY())/2));
		if (cityInitial.getScaleX()<cityEnd.getScaleX()) {
			pointX += cityInitial.getScaleX() + 5;
		}else {
			pointX = (int) (cityInitial.getScaleX()-pointX-5);
		}
		
		if (cityInitial.getScaleY()<cityEnd.getScaleY()) {
			pointY += cityInitial.getScaleY()+5;
		}else {
			pointY= (int) (cityInitial.getScaleY()-pointY-5);
		}
		return new Point(pointX, pointY);
	}
}
