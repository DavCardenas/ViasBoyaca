package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PaneCreateCity extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lbName;
	private JTextField txtName;
	private JButton btnAccept;
	private JButton btnBack;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	private String name;
	
	public final static String BTN_BACK = "RETURN_CC";
	public final static String BTN_ACCEPT = "ACEPT_CC";
	
	public PaneCreateCity(WindowsPrincipal ven,PaneActions pPActions) {
		
		name = "";
		
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33),200));
		gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		lbName = new JLabel("Nombre");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbName, gbc);
		
		txtName = new JTextField(12);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(txtName, gbc);
		
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * valida que el campo de texto no este vacio
	 * @return
	 */
	public boolean validateName() {
		if (!name.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * asigna a la variable nombre el texto que 
	 * este en txtName y luego limpia txtName
	 */
	public void data(){
		name = txtName.getText();
		txtName.setText("");
	}
	
}
