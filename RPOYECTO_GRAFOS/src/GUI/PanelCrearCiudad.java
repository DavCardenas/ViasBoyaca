package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCrearCiudad extends JPanel{

	private JLabel lbNombre;
	private JTextField txtNombre;
	private JButton btnAceptar;
	private JButton btnVolver;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	private String nombre;
	
	public final static String BTN_VOLVER = "VOLVER";
	public final static String BTN_ACEPTAR = "ACEPTARCC";
	
	public PanelCrearCiudad(VentanaPrincipal ven,PanelAcciones ppAcciones) {
		
		nombre = "";
		
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33),200));
		gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		lbNombre = new JLabel("Nombre");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbNombre, gbc);
		
		txtNombre = new JTextField(12);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(txtNombre, gbc);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setActionCommand(BTN_ACEPTAR);
		btnAceptar.addActionListener(ppAcciones);
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnAceptar, gbc);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand(BTN_VOLVER);
		btnVolver.addActionListener(ppAcciones);
		gbc = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnVolver, gbc);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean validarNombre() {
		if (!nombre.isEmpty()) {
			return true;
		}
		return false;
	}
	public void datos(){
		nombre = txtNombre.getText();
		txtNombre.setText("");
	}
	
}
