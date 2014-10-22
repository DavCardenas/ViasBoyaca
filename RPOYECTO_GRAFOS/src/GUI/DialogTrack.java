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

import logic.Track;

public class DialogTrack extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pnlTop;
	private JPanel pnlBoth;
	private JLabel lbTrack;
	private JComboBox<Integer> cbxTracks;
	private DefaultComboBoxModel<Integer> modelTracks;
	private JButton btnAccept;
	private JButton btnBack;
	private JLabel lnLength;
	private JLabel lbTime;
	private JLabel lbStatus;
	private JLabel lbSpeed;
	private JTextField txtLength;
	private JTextField txtTime;
	private JTextField txtSpeed;
	private JTextField txtStatus;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	public static final String BTN_ACCEPT = "ACEPTAR_VIA";
	public static final String BTN_BACK = "VOLVER_VIA";
	
	
	public DialogTrack(WindowsPrincipal principal, Events events) {
		
		setTitle("Información de la Ciudad");
		setSize(300, 430);
		setResizable(false);
	    setLayout(new GridLayout(2, 1));
	    setLocationRelativeTo(null);
	    
	    
	    pnlTop = new JPanel();
	    gridbag = new GridBagLayout();
	    pnlTop.setLayout(gridbag);
		
	    lbTrack = new JLabel("Via No.");
	    gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlTop.add(lbTrack, gbc);
		
	    modelTracks = new DefaultComboBoxModel<>();
		cbxTracks = new JComboBox<>(modelTracks);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlTop.add(cbxTracks, gbc);
	    
	    btnAccept = new JButton("Aceptar");
	    btnAccept.setFocusable(false);
		btnAccept.setActionCommand(BTN_ACCEPT);
		btnAccept.addActionListener(events);
	    gbc = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 5, 5, 45), 0, 0);
	    pnlTop.add(btnAccept, gbc);
	    
	    pnlBoth = new JPanel();
	    gridbag = new GridBagLayout();
	    pnlBoth.setLayout(gridbag);
		
	    lnLength = new JLabel("Longitud: (Km)");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0);
		pnlBoth.add(lnLength, gbc);
		
		lbSpeed = new JLabel("Velocidad: (Km/h)");
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlBoth.add(lbSpeed, gbc);
		
		lbTime = new JLabel("Tiempo: (h)");
		gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlBoth.add(lbTime, gbc);
		
		lbStatus = new JLabel("Estado");
		gbc = new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlBoth.add(lbStatus, gbc);
		
		txtLength = new JTextField(12);
		txtLength.setEditable(false);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0);
		pnlBoth.add(txtLength, gbc);
		
		txtSpeed = new JTextField(12);
		txtSpeed.setEditable(false);
		gbc = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlBoth.add(txtSpeed, gbc);
		
		txtTime = new JTextField(12);
		txtTime.setEditable(false);
		gbc = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlBoth.add(txtTime, gbc);
		
		txtStatus = new JTextField(12);
		txtStatus.setEditable(false);
		gbc = new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		pnlBoth.add(txtStatus, gbc);
		
		btnBack = new JButton("Volver");
		btnBack.setFocusable(false);
		btnBack.setActionCommand(BTN_BACK);
		btnBack.addActionListener(events);
		gbc = new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 100), 13, 0);
		pnlBoth.add(btnBack, gbc);
	    
	    add(pnlTop);
	    add(pnlBoth);
		
	}
	
	/**
	 * Actualiza el comobox de vias a partir de un arraylist
	 * @param tracks
	 */
	public void updateTracks(ArrayList<Track> tracks) {
		modelTracks.removeAllElements();
		for (Track track : tracks) {
			modelTracks.addElement(track.getId());
		}
	}
	
	/**
	 * llena los campos de texto a partir de un arraylist
	 * y la posicion seleccionada del combobox
	 * @param Vias
	 */
	public void fillFieldsTrack(ArrayList<Track> Vias){
		Track aux = Vias.get(cbxTracks.getSelectedIndex());
		txtLength.setText(aux.getLength()+"");
		txtTime.setText(aux.getTime()+"");
		txtSpeed.setText(aux.getSpeed()+"");
		txtStatus.setText(aux.getStatus());
	}
	
	/**
	 * limpia los campos de texto
	 */
	public void cleanFieldsTrack(){
		txtLength.setText("");
		txtTime.setText("");
		txtSpeed.setText("");
		txtStatus.setText("");
	}
}
