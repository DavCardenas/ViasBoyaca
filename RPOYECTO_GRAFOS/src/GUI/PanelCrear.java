package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelCrear extends JPanel{

	private JButton btnCrearCiudad;
	private JButton btnCrearVia;
	private boolean presionado;
	
	public final static String BTN_CREAR_CIUDAD = "CREARCIUDAD";
	public final static String BTN_CREAR_VIA = "CREARVIA";
	
	public PanelCrear(VentanaPrincipal ven, PanelAcciones panelAcciones) {
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33), 200));
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		
		btnCrearCiudad = new JButton("Crear Ciudad");
		btnCrearCiudad.setActionCommand(BTN_CREAR_CIUDAD);
		btnCrearCiudad.addActionListener(panelAcciones);
		btnCrearVia = new JButton("Crear Via");
		btnCrearVia.setActionCommand(BTN_CREAR_VIA);
		btnCrearVia.addActionListener(panelAcciones);
		
		presionado = false;
		
		add(btnCrearCiudad);
		add(btnCrearVia);
	}
	
	
}
