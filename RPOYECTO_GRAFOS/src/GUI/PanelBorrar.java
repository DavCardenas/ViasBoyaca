package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutFocusTraversalPolicy;

public class PanelBorrar extends JPanel{

	private JButton btnBorrarCiudad;
	private JButton btnBorrarVia;
	
	public PanelBorrar(VentanaPrincipal ven) {
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33), 200));
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		
		btnBorrarCiudad = new JButton("Borrar Ciudad");
		btnBorrarVia = new JButton("Borrar Via");
		
		add(btnBorrarCiudad);
		add(btnBorrarVia);
		
	}
}
