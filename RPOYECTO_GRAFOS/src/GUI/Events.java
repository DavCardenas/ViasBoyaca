package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Events implements ActionListener {

	private WindowsPrincipal principal;

	
	public Events(WindowsPrincipal Vprincipal) {
		this.principal = Vprincipal;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comand = e.getActionCommand();
		switch (comand) {
		
		case WindowsPrincipal.COMAND_ABOUT:
			principal.showAbout();
			break;
		case WindowsPrincipal.BTN_INFOCITY:
			principal.cleanFieldsCity();
			principal.updateCityInfo();
			principal.showInfoCity();
			break;
		case DialogCity.BTN_ACCEPT:
			principal.fillFieldsCity();		
		break;
		case DialogCity.BTN_BACK:
			principal.closeInfoCity();
			principal.cleanFieldsCity();
		break;
		case WindowsPrincipal.BTN_INFOTRACK:
			principal.updateTracksInfo();
			principal.showInfoTrack();
		break;
		case DialogTrack.BTN_ACCEPT:
			principal.fillFieldsTrack();
		break;
		case DialogTrack.BTN_BACK:
			principal.closeInfoTrack();
			principal.cleanFieldsTrack();
		break;
		default:
			break;
		}
	}

}
