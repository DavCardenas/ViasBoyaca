package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.Ciudad;

public class DialogCiudad extends JDialog {

	private JPanel pnlSuperior;
	private JPanel pnlInferior;
	private JLabel lbNombre;
	private JLabel lbCoordenadas;
	private JLabel lbCiudad;
	private JComboBox cbxCiudades;
	private DefaultComboBoxModel modelCiudades;
	private JTextField txtNombre;
	private JTextField txtCoordenadas;
	private JButton btnAceptar;
	private JButton btnVolver;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	
	public static final String BTN_ACEPTAR = "ACEPTAR_CIUDAD";
	public static final String BTN_VOLVER = "VOLVER_CIUDAD";
	
	public DialogCiudad(VentanaPrincipal principal, Eventos eventos) {
		
		setTitle("Información de la Ciudad");
		setSize(300, 250);
		setResizable(false);
	    setLayout(new GridLayout(2, 1));
	    setLocationRelativeTo(null);
	    
	    
	    pnlSuperior = new JPanel();
	    gridbag = new GridBagLayout();
	    pnlSuperior.setLayout(gridbag);
		
	    lbCiudad = new JLabel("Ciudad");
	    gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlSuperior.add(lbCiudad, gbc);
		
	    modelCiudades = new DefaultComboBoxModel<>();
		cbxCiudades = new JComboBox<>(modelCiudades);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlSuperior.add(cbxCiudades, gbc);
	    
	    btnAceptar = new JButton("Aceptar");
	    btnAceptar.setFocusable(false);
		btnAceptar.setActionCommand(BTN_ACEPTAR);
		btnAceptar.addActionListener(eventos);
	    gbc = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 45), 0, 0);
	    pnlSuperior.add(btnAceptar, gbc);
	    
	    pnlInferior = new JPanel();

	    
	    gridbag = new GridBagLayout();
	    pnlInferior.setLayout(gridbag);
		
		lbNombre = new JLabel("Nombre");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlInferior.add(lbNombre, gbc);
		
		txtNombre = new JTextField(12);
		txtNombre.setEditable(false);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 200, 0);
		pnlInferior.add(txtNombre, gbc);
		
		lbCoordenadas = new JLabel("Ubicación");
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlInferior.add(lbCoordenadas, gbc);
		
		txtCoordenadas = new JTextField(12);
		txtCoordenadas.setEditable(false);
		gbc = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 200, 0);
		pnlInferior.add(txtCoordenadas, gbc);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFocusable(false);
		btnVolver.setActionCommand(BTN_VOLVER);
		btnVolver.addActionListener(eventos);
		gbc = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 50), 13, 0);
		pnlInferior.add(btnVolver, gbc);
	    
	    add(pnlSuperior);
	    add(pnlInferior);
	}
	public void actualizarCiudades(ArrayList<Ciudad> Ciudades) {
		modelCiudades.removeAllElements();
		for (Ciudad ciudad : Ciudades) {
			modelCiudades.addElement(ciudad.getNombre());
		}
	}
	public void llenarCamposCiudad(ArrayList<Ciudad> Ciudades){
		Ciudad aux = Ciudades.get(cbxCiudades.getSelectedIndex());
		txtNombre.setText(aux.getNombre());
		txtCoordenadas.setText("Coordenadas: "+aux.getPosX()+", "+aux.getPosY());
	}
	public void limpiarCamposCiudad(){
		txtNombre.setText("");
		txtCoordenadas.setText("");
	}
}
