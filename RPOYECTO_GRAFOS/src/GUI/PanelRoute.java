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
import logic.Route;

public class PanelRoute extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultComboBoxModel<String> modelCityI;
	private DefaultComboBoxModel<String> modelCityF;
	private JLabel cityInitial;
	private JLabel cityEnd;
	private JLabel filter;
	private JButton btnAccept;
	private JComboBox<String> cbxCityInitial;
	private JComboBox<String> cbxCityEnd;
	private JComboBox<Route> cbxRoute;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	public static final String BTN_ACCEPT ="ACEPTAR_RECORRIDO";
	
	public PanelRoute(WindowsPrincipal ven, PaneActions pPActions) {
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33),200));
		gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		cityInitial = new JLabel("Ciudad Inicial");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cityInitial, gbc);
		
		cityEnd = new JLabel("Ciudad Final");
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cityEnd, gbc);
		
		filter= new JLabel("Filtrar por");
		gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(filter, gbc);
		
		modelCityI = new DefaultComboBoxModel<String>();
		cbxCityInitial = new JComboBox<String>(modelCityI);
		gbc = new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cbxCityInitial, gbc);
		
		modelCityF = new DefaultComboBoxModel<String>();
		cbxCityEnd = new JComboBox<String>(modelCityF);
		gbc = new GridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cbxCityEnd, gbc);
		
		cbxRoute = new JComboBox<Route>(Route.values());
		gbc = new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cbxRoute, gbc);
		
		btnAccept = new JButton("Aceptar");
		btnAccept.setFocusable(false);
		btnAccept.setActionCommand(BTN_ACCEPT);
		btnAccept.addActionListener(pPActions);
		
		gbc = new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnAccept, gbc);
	}
	
	/**
	 * actualiza los combobox a partir de una arraylist
	 * @param cities
	 */
	public void updateCities(ArrayList<City> cities) {
		modelCityI.removeAllElements();
		modelCityF.removeAllElements();
		for (City city : cities) {
			modelCityI.addElement(city.getName());
			modelCityF.addElement(city.getName());
		}
	}
	
	public int cityInitial() {
		return cbxCityInitial.getSelectedIndex();
	}
	
	public int cityEnd() {
		return cbxCityEnd.getSelectedIndex();
	}
}
