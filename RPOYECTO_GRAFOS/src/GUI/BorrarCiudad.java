package GUI;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;


import logic.Ciudad;
import logic.ViasBoyaca;

public class BorrarCiudad extends JDialog {

	private JComboBox cbxCiudades;
	private DefaultComboBoxModel modelCiudades;
	
	public BorrarCiudad() {
		
		setTitle("Borrar Ciudad");
		setSize(100, 100);
		modelCiudades = new DefaultComboBoxModel<>();
		cbxCiudades = new JComboBox<>(modelCiudades);
		
		
	}
	public void actualizarCiudades(ArrayList<Ciudad> Ciudades) {
		modelCiudades.removeAllElements();
		for (Ciudad ciudad : Ciudades) {
			modelCiudades.addElement(ciudad.getNombre());
		}
	}
}
