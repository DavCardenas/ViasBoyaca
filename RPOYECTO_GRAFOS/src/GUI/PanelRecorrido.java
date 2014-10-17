package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelRecorrido extends JPanel{
	

	public PanelRecorrido(VentanaPrincipal ven) {
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33),200));
		setBackground(Color.black);
	}
}
