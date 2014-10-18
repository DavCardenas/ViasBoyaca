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

import logic.Estado;
import logic.Via;

public class PanelCrearVia extends JPanel{

	private JLabel lbLongitud;
	private JLabel lbTiempo;
	private JLabel lbSentido;
	private JLabel lbVelocidad;
	private JTextField txtLongitud;
	private JTextField txtTiempo;
	private JTextField txtVelocidad;
	private JComboBox<Estado> cbxEstado;
	private JButton btnAceptar;
	private JButton btnVolver;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	public final static String BTN_VOLVER = "BTN_VOLVER_VIA";
	public final static String BTN_CREAR_VIA = "BTN_CREAR_VIA";
	
	public PanelCrearVia(VentanaPrincipal ven,PanelAcciones ppAcciones) {
		
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
		
		cbxEstado = new JComboBox<Estado>(Estado.values());
		gbc = new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cbxEstado, gbc);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setActionCommand(BTN_CREAR_VIA);
		btnAceptar.addActionListener(ppAcciones);
		gbc = new GridBagConstraints(0, 4, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnAceptar, gbc);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(ppAcciones);
		btnVolver.setActionCommand(BTN_VOLVER);
		gbc = new GridBagConstraints(1, 4, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnVolver, gbc);
	}
	
	public boolean verificarDatos() {
		if (!txtLongitud.getText().isEmpty()) {
			if (!txtTiempo.getText().isEmpty()) {
				if (!txtVelocidad.getText().isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void enviarDatos(Via via) {
		if (verificarDatos()) {
			via.setLongitud(Integer.parseInt(txtLongitud.getText()));
			via.setTiempo(Integer.parseInt(txtLongitud.getText()));
			via.setEstado((String)cbxEstado.getSelectedItem());
			via.getVelocidad()[0]=Integer.parseInt(txtLongitud.getText());
		}
	}
}
