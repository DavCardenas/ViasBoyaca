package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutFocusTraversalPolicy;

public class PanelBorrar extends JPanel{

	private JButton btnBorrarCiudad;
	private JButton btnBorrarVia;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	
	public PanelBorrar(VentanaPrincipal ven) {
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33), 200));
		
		gridbag = new GridBagLayout();
		
		setLayout(gridbag);
		
		btnBorrarCiudad = new JButton("Borrar Ciudad");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnBorrarCiudad, gbc);
		
		btnBorrarVia = new JButton("Borrar Via");
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnBorrarVia, gbc);
		
	}
}
