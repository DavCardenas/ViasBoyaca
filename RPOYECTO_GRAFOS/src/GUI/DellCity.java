package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;


import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.City;

public class DellCity extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> cbxCity;
	private DefaultComboBoxModel<String> modelCity;
	private JLabel lbName;
	private JButton btnAccept;
	private JButton btnBack;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	public final static String BTN_BACK = "VOLVER_BORRARC";
	public final static String BTN_ACCEPT = "ACEPTAR_BORRARC";
	
	public DellCity(WindowsPrincipal ven, PaneActions pPActions) {
		
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33),200));
		gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		lbName = new JLabel("Ciudad");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbName, gbc);
		
		modelCity = new DefaultComboBoxModel<>();
		cbxCity = new JComboBox<>(modelCity);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cbxCity, gbc);
		
		btnAccept = new JButton("Aceptar");
		btnAccept.setActionCommand(BTN_ACCEPT);
		btnAccept.addActionListener(pPActions);
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnAccept, gbc);
		
		btnBack = new JButton("Volver");
		btnBack.setActionCommand(BTN_BACK);
		btnBack.addActionListener(pPActions);
		gbc = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnBack, gbc);
	}
	
	/**
	 * actualiza el combobox a partir del arraylist que le ingresan
	 * @param Cities
	 */
	public void updateCities(ArrayList<City> Cities) {
		modelCity.removeAllElements();
		for (City city : Cities) {
			modelCity.addElement(city.getName());
		}
	}
	
	/**
	 * elminia una ciudad del arraylist que le ingresan
	 * con al posicion seleccionada en el combobox
	 * @param Cities
	 * @return
	 */
	public ArrayList<City> dellCity(ArrayList<City> Cities){
		if (!Cities.isEmpty()) {
			Cities.remove(cbxCity.getSelectedIndex());
		}
		return Cities;
		
	}
}
