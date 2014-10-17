package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.Sentido;

public class PanelCrearVia extends JPanel{

	private JLabel lbLongitud;
	private JLabel lbTiempo;
	private JLabel lbSentido;
	private JLabel lbVelocidad;
	private JTextField txtLongitud;
	private JTextField txtTiempo;
	private JTextField txtVelocidad;
	private JComboBox<Sentido> cbxSentido;
	private JButton btnAceptar;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	public PanelCrearVia(VentanaPrincipal ven) {
		
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33), 200));
		gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		lbLongitud = new JLabel("Longitud: (Km)");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbLongitud, gbc);
		
		lbVelocidad = new JLabel("Velocidad: (Km/h)");
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbVelocidad, gbc);
		
		lbTiempo = new JLabel("Tiempo: (h)");
		gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbTiempo, gbc);
		
		lbSentido = new JLabel("Sentido");
		gbc = new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbSentido, gbc);
		
		txtLongitud = new JTextField(12);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(txtLongitud, gbc);
		
		txtVelocidad = new JTextField(12);
		gbc = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(txtVelocidad, gbc);
		
		txtTiempo = new JTextField(12);
		gbc = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(txtTiempo, gbc);
		
		cbxSentido = new JComboBox<Sentido>(Sentido.values());
		gbc = new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cbxSentido, gbc);
		
		btnAceptar = new JButton("Aceptar");
		gbc = new GridBagConstraints(0, 4, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnAceptar, gbc);
	}
}
