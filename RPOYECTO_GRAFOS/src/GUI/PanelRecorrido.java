package GUI;

import java.awt.Color;
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

import logic.Ciudad;
import logic.Estado;
import logic.Recorrido;

public class PanelRecorrido extends JPanel{
	
	private DefaultComboBoxModel modelCiudadI;
	private DefaultComboBoxModel modelCiudadF;
	private JLabel CiudadInicial;
	private JLabel CiudadFinal;
	private JLabel Filtrar;
	private JButton btnAceptar;
	private JComboBox cbxCiudadInicial;
	private JComboBox cbxCiudadFinal;
	private JComboBox<Recorrido> cbxRecorrido;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	public static final String BTN_ACEPTAR ="ACEPTAR_RECORRIDO";
	
	public PanelRecorrido(VentanaPrincipal ven, PanelAcciones ppAcciones) {
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33),200));
		gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		CiudadInicial = new JLabel("Ciudad Inicial");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(CiudadInicial, gbc);
		
		CiudadFinal = new JLabel("Ciudad Final");
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(CiudadFinal, gbc);
		
		Filtrar= new JLabel("Filtrar por");
		gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(Filtrar, gbc);
		
		modelCiudadI = new DefaultComboBoxModel();
		cbxCiudadInicial = new JComboBox(modelCiudadI);
		gbc = new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cbxCiudadInicial, gbc);
		
		modelCiudadF = new DefaultComboBoxModel();
		cbxCiudadFinal = new JComboBox(modelCiudadF);
		gbc = new GridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cbxCiudadFinal, gbc);
		
		cbxRecorrido = new JComboBox<Recorrido>(Recorrido.values());
		gbc = new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cbxRecorrido, gbc);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFocusable(false);
		btnAceptar.setActionCommand(BTN_ACEPTAR);
		btnAceptar.addActionListener(ppAcciones);
		
		gbc = new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnAceptar, gbc);
	}
	public void actualizarCiudades(ArrayList<Ciudad> Ciudades) {
		modelCiudadI.removeAllElements();
		modelCiudadF.removeAllElements();
		for (Ciudad ciudad : Ciudades) {
			modelCiudadI.addElement(ciudad.getNombre());
			modelCiudadF.addElement(ciudad.getNombre());
		}
	}
}
