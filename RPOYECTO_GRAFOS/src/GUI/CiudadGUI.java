package GUI;

import java.awt.Color;

import javax.swing.JButton;

import logic.Ciudad;

public class CiudadGUI extends JButton{
	
	private Ciudad ciudadL;
	private int posX;
	private int posY;
	
	public CiudadGUI(Ciudad pCiudadL) {
		this.ciudadL = pCiudadL;
		setSize(30, 30);
		posX = pCiudadL.getPosX();
		posY = pCiudadL.getPosY();
	}
	
	
}
