package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.Status;
import logic.Track;
import logic.Validator;

public class PaneCreateTrack extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lbLength;
	private JLabel lbTime;
	private JLabel lbStatus;
	private JLabel lbSpeed;
	private String length;
	private String time;
	private String speed;
	private String status;
	private JTextField txtLength;
	private JTextField txtTime;
	private JTextField txtSpeed;
	private JComboBox<Status> cbxStatus;
	private JButton btnAccept;
	private JButton btnBack;
	private GridBagLayout gridbag;
	private GridBagConstraints gbc;
	
	
	public final static String BTN_BACK = "RETURN_CT";
	public final static String BTN_CREATE_TRACK = "ACEPT_CT";
	
	public PaneCreateTrack(WindowsPrincipal ven,PaneActions pPActions) {
		
		
		time = "";
		length = "";
		speed = "";
		status = "";
		
		setPreferredSize(new Dimension((int)(ven.getWidth()*0.33), 200));
		gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		lbLength = new JLabel("Longitud: (Km)");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbLength, gbc);
		
		lbSpeed = new JLabel("Velocidad: (Km/h)");
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbSpeed, gbc);
		
		lbTime = new JLabel("Tiempo: (h)");
		gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbTime, gbc);
		
		lbStatus = new JLabel("Estado");
		gbc = new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbStatus, gbc);
		
		txtLength = new JTextField(12);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(txtLength, gbc);
		
		txtSpeed = new JTextField(12);
		gbc = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(txtSpeed, gbc);
		
		txtTime = new JTextField(12);
		gbc = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(txtTime, gbc);
		
		cbxStatus = new JComboBox<Status>(Status.values());
		gbc = new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cbxStatus, gbc);
		
		btnAccept = new JButton("Aceptar");
		btnAccept.setActionCommand(BTN_CREATE_TRACK);
		btnAccept.addActionListener(pPActions);
		gbc = new GridBagConstraints(0, 4, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnAccept, gbc);
		
		btnBack = new JButton("Volver");
		btnBack.addActionListener(pPActions);
		btnBack.setActionCommand(BTN_BACK);
		gbc = new GridBagConstraints(1, 4, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnBack, gbc);
	}
	
	
	/**
	 * verifica que los campos de texto no esten vacios
	 * si estan vacios retorna false si no retorna true
	 * @return
	 */
	public boolean verifyData() {
		if (!txtLength.getText().isEmpty()) {
			if (!txtTime.getText().isEmpty()) {
				if (!txtSpeed.getText().isEmpty()) {
					return true;
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "LLene todo los campos");
		}
		return false;
	}
	
	/**
	 * limpia los campos de texto
	 */
	public void cleanFields() {
		txtLength.setText("");
		txtTime.setText("");
		txtSpeed.setText("");
		cbxStatus.setSelectedIndex(0);
	}
	
	/**
	 * Asigna los datos a unas variables globales, para que estás sean usadas al momento de crear via
	 */
	public void Data(){
		length =(txtLength.getText());
		time = (txtTime.getText());
		speed =(txtSpeed.getText());
		status = (cbxStatus.getSelectedItem().toString());
	}


	public String getLength() {
		return length;
	}


	public void setLength(String length) {
		this.length = length;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getSpeed() {
		return speed;
	}


	public void setSpeed(String speed) {
		this.speed = speed;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
}
