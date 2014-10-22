package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PaneDell extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnDellCity;
	private JButton btnDellTrack;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	
	public static final String BTN_DELL_CITY = "BORRARC";
	public static final String BTN_DELL_TRACK = "BORRARV";
	
	
	
	public PaneDell(WindowsPrincipal ven, PaneActions pPActions) {
	
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33), 200));
		
		gridbag = new GridBagLayout();
		
		setLayout(gridbag);
		
		btnDellCity = new JButton("Borrar Ciudad");
		btnDellCity.setActionCommand(BTN_DELL_CITY);
		btnDellCity.addActionListener(pPActions);
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnDellCity, gbc);
		
		btnDellTrack = new JButton("Borrar Via");
		btnDellTrack.setActionCommand(BTN_DELL_TRACK);
		btnDellTrack.addActionListener(pPActions);
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnDellTrack, gbc);
	}
}
