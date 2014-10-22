package GUI;

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

import logic.City;

public class DialogCity extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pnlTop;
	private JPanel pnlBoth;
	private JLabel lbName;
	private JLabel lbPoints;
	private JLabel lbCity;
	private JComboBox<String> cbxCities;
	private DefaultComboBoxModel<String> modelCities;
	private JTextField txtName;
	private JTextField txtPoints;
	private JButton btnAccept;
	private JButton btnBack;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	
	public static final String BTN_ACCEPT = "ACEPTAR_CIUDAD";
	public static final String BTN_BACK = "VOLVER_CIUDAD";
	
	public DialogCity(WindowsPrincipal principal, Events events) {
		
		setTitle("Información de la Ciudad");
		setSize(300, 250);
		setResizable(false);
	    setLayout(new GridLayout(2, 1));
	    setLocationRelativeTo(null);
	    
	    
	    pnlTop = new JPanel();
	    gridbag = new GridBagLayout();
	    pnlTop.setLayout(gridbag);
		
	    lbCity = new JLabel("Ciudad");
	    gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlTop.add(lbCity, gbc);
		
	    modelCities = new DefaultComboBoxModel<>();
		cbxCities = new JComboBox<>(modelCities);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlTop.add(cbxCities, gbc);
	    
	    btnAccept = new JButton("Aceptar");
	    btnAccept.setFocusable(false);
		btnAccept.setActionCommand(BTN_ACCEPT);
		btnAccept.addActionListener(events);
	    gbc = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 45), 0, 0);
	    pnlTop.add(btnAccept, gbc);
	    
	    pnlBoth = new JPanel();

	    
	    gridbag = new GridBagLayout();
	    pnlBoth.setLayout(gridbag);
		
		lbName = new JLabel("Nombre");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlBoth.add(lbName, gbc);
		
		txtName = new JTextField(12);
		txtName.setEditable(false);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 200, 0);
		pnlBoth.add(txtName, gbc);
		
		lbPoints = new JLabel("Ubicación");
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlBoth.add(lbPoints, gbc);
		
		txtPoints = new JTextField(12);
		txtPoints.setEditable(false);
		gbc = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 200, 0);
		pnlBoth.add(txtPoints, gbc);
		
		btnBack = new JButton("Volver");
		btnBack.setFocusable(false);
		btnBack.setActionCommand(BTN_BACK);
		btnBack.addActionListener(events);
		gbc = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 50), 13, 0);
		pnlBoth.add(btnBack, gbc);
	    
	    add(pnlTop);
	    add(pnlBoth);
	}
	
	/**
	 * Actualiza el combobox de ciudades a partir de un arraylist
	 * @param Ciudades
	 */
	public void updateCities(ArrayList<City> Ciudades) {
		modelCities.removeAllElements();
		for (City ciudad : Ciudades) {
			modelCities.addElement(ciudad.getName());
		}
	}
	
	/**
	 * llena los campos de texto a partir de una arraylist
	 * y el combobox de ciudades
	 * @param Ciudades
	 */
	public void fillFieldsCity(ArrayList<City> Ciudades){
		City aux = Ciudades.get(cbxCities.getSelectedIndex());
		txtName.setText(aux.getName());
		txtPoints.setText("Coordenadas: "+aux.getPointX()+", "+aux.getPointY());
	}
	
	/**
	 * limpia los campos 
	 */
	public void cleanFieldsCity(){
		txtName.setText("");
		txtPoints.setText("");
	}
}
