package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelCrear extends JPanel{

	private JButton btnCrearCiudad;
	private JButton btnCrearVia;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	public final static String BTN_CREAR_CIUDAD = "CREARCIUDAD";
	public final static String BTN_CREAR_VIA = "CREARVIA";
	
	public PanelCrear(VentanaPrincipal ven, PanelAcciones panelAcciones) {
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33), 200));
		
		gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		btnCrearCiudad = new JButton("Crear Ciudad");
		btnCrearCiudad.setActionCommand(BTN_CREAR_CIUDAD);
		btnCrearCiudad.addActionListener(panelAcciones);
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnCrearCiudad, gbc);
		
		btnCrearVia = new JButton("Crear Via");
		btnCrearVia.setActionCommand(BTN_CREAR_VIA);
		btnCrearVia.addActionListener(panelAcciones);
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		
		add(btnCrearVia, gbc);
	}
	
	
}
