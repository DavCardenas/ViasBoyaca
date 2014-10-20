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

import logic.Estado;
import logic.Via;

public class DialogVia extends JDialog{
	
	private JPanel pnlSuperior;
	private JPanel pnlInferior;
	private JLabel lbVia;
	private JComboBox cbxVias;
	private DefaultComboBoxModel modelVias;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JLabel lbLongitud;
	private JLabel lbTiempo;
	private JLabel lbEstado;
	private JLabel lbVelocidad;
	private JTextField txtLongitud;
	private JTextField txtTiempo;
	private JTextField txtVelocidad;
	private JTextField txtEstado;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	public static final String BTN_ACEPTAR = "ACEPTAR_VIA";
	public static final String BTN_VOLVER = "VOLVER_VIA";
	
	
	public DialogVia(VentanaPrincipal principal, Eventos eventos) {
		
		setTitle("Información de la Ciudad");
		setSize(300, 430);
		setResizable(false);
	    setLayout(new GridLayout(2, 1));
	    setLocationRelativeTo(null);
	    
	    
	    pnlSuperior = new JPanel();
	    gridbag = new GridBagLayout();
	    pnlSuperior.setLayout(gridbag);
		
	    lbVia = new JLabel("Via No.");
	    gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlSuperior.add(lbVia, gbc);
		
	    modelVias = new DefaultComboBoxModel<>();
		cbxVias = new JComboBox<>(modelVias);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlSuperior.add(cbxVias, gbc);
	    
	    btnAceptar = new JButton("Aceptar");
	    btnAceptar.setFocusable(false);
		btnAceptar.setActionCommand(BTN_ACEPTAR);
		btnAceptar.addActionListener(eventos);
	    gbc = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 5, 5, 45), 0, 0);
	    pnlSuperior.add(btnAceptar, gbc);
	    
	    pnlInferior = new JPanel();
	    gridbag = new GridBagLayout();
	    pnlInferior.setLayout(gridbag);
		
	    lbLongitud = new JLabel("Longitud: (Km)");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0);
		pnlInferior.add(lbLongitud, gbc);
		
		lbVelocidad = new JLabel("Velocidad: (Km/h)");
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlInferior.add(lbVelocidad, gbc);
		
		lbTiempo = new JLabel("Tiempo: (h)");
		gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlInferior.add(lbTiempo, gbc);
		
		lbEstado = new JLabel("Estado");
		gbc = new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlInferior.add(lbEstado, gbc);
		
		txtLongitud = new JTextField(12);
		txtLongitud.setEditable(false);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0);
		pnlInferior.add(txtLongitud, gbc);
		
		txtVelocidad = new JTextField(12);
		txtVelocidad.setEditable(false);
		gbc = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlInferior.add(txtVelocidad, gbc);
		
		txtTiempo = new JTextField(12);
		txtTiempo.setEditable(false);
		gbc = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlInferior.add(txtTiempo, gbc);
		
		txtEstado = new JTextField(12);
		txtEstado.setEditable(false);
		gbc = new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlInferior.add(txtEstado, gbc);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFocusable(false);
		btnVolver.setActionCommand(BTN_VOLVER);
		btnVolver.addActionListener(eventos);
		gbc = new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 100), 13, 0);
		pnlInferior.add(btnVolver, gbc);
	    
	    add(pnlSuperior);
	    add(pnlInferior);
		
	}
	public void actualizarVias(ArrayList<Via> Vias) {
		modelVias.removeAllElements();
		for (Via via : Vias) {
			modelVias.addElement(via.getId());
		}
	}
	public void llenarCamposVia(ArrayList<Via> Vias){
		Via aux = Vias.get(cbxVias.getSelectedIndex());
		txtLongitud.setText(aux.getLongitud()+"");
		txtTiempo.setText(aux.getTiempo()+"");
		txtVelocidad.setText(aux.getVelocidad()+"");
		txtEstado.setText(aux.getEstado());
	}
	public void limpiarCamposVia(){
		txtLongitud.setText("");
		txtTiempo.setText("");
		txtVelocidad.setText("");
		txtEstado.setText("");
	}
}
