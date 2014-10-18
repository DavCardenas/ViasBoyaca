package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.Ciudad;
import logic.ViasBoyaca;

public class BorrarCiudad extends JPanel{

	private JComboBox cbxCiudades;
	private DefaultComboBoxModel modelCiudades;
	private JLabel lbNombre;
	private JTextField txtNombre;
	private JButton btnAceptar;
	private JButton btnVolver;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	private ViasBoyaca boyaca;
	
	public final static String BTN_VOLVER = "VOLVER_BORRARC";
	public final static String BTN_ACEPTAR = "ACEPTAR_BORRARC";
	
	public BorrarCiudad(VentanaPrincipal ven, PanelAcciones ppAcciones) {
		
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33),200));
		gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		boyaca = new ViasBoyaca();
		
		lbNombre = new JLabel("Ciudad");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbNombre, gbc);
		
		modelCiudades = new DefaultComboBoxModel<>();
		cbxCiudades = new JComboBox<>(modelCiudades);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cbxCiudades, gbc);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(ppAcciones);
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnAceptar, gbc);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand(BTN_VOLVER);
		btnVolver.addActionListener(ppAcciones);
		gbc = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnVolver, gbc);
	}
	
	public void actualizarCiudades(ArrayList<Ciudad> ciudades) {
		modelCiudades.removeAllElements();
		for (Ciudad ciudad : ciudades) {
			modelCiudades.addElement(ciudad.getNombre());
		}
	}
	
}
