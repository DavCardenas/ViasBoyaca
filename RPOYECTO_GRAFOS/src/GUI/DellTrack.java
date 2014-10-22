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

import logic.Track;

public class DellTrack extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<Integer> cbxTrack;
	private DefaultComboBoxModel<Integer> modelTrack;
	private JLabel lbName;
	private JButton btnAccept;
	private JButton btnBack;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	public final static String BTN_BACK = "VOLVER_BORRARV";
	public final static String BTN_ACCEPT = "ACEPTAR_BORRARV";
	
	public DellTrack(WindowsPrincipal ven, PaneActions pPActions) {
		
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33),200));
		gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		lbName = new JLabel("Via");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbName, gbc);
		
		modelTrack = new DefaultComboBoxModel<>();
		cbxTrack = new JComboBox<>(modelTrack);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cbxTrack, gbc);
		
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
	 * actualiza el combobox a partir de un arraylist de vias
	 * @param Tracks
	 */
	public void updateTracks(ArrayList<Track> Tracks) {
		modelTrack.removeAllElements();
		for (Track track : Tracks) {
			modelTrack.addElement(track.getId());
		}
	}
	
	/**
	 * elimina una via a partir de un arraylist
	 * en la posicion del combobox
	 * @param Tracks
	 * @return
	 */
	public ArrayList<Track> dellTrack(ArrayList<Track> Tracks){
		if (!Tracks.isEmpty()) {
			Tracks.remove(cbxTrack.getSelectedIndex());
		}
		return Tracks;
		
	}
}
