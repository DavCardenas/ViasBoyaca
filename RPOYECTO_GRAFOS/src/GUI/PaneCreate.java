package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PaneCreate extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnCreateCity;
	private JButton btnCreateTrack;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	public final static String BTN_CREATE_CITY = "CREATE_CITY";
	public final static String BTN_CREATE_TRACK = "CREATE_TRAK";
	
	public PaneCreate(WindowsPrincipal ven, PaneActions pPActions) {
		
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33), 200));
		
		gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		btnCreateCity = new JButton("Crear Ciudad");
		btnCreateCity.setActionCommand(BTN_CREATE_CITY);
		btnCreateCity.addActionListener(pPActions);
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnCreateCity, gbc);
		
		btnCreateTrack = new JButton("Crear Via");
		btnCreateTrack.setActionCommand(BTN_CREATE_TRACK);
		btnCreateTrack.addActionListener(pPActions);
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		
		add(btnCreateTrack, gbc);
	}
	
	
}
