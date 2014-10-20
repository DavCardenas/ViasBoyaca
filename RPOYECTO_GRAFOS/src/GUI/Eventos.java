package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventos implements ActionListener {

	private VentanaPrincipal principal;

	
	public Eventos(VentanaPrincipal Vprincipal) {
		this.principal = Vprincipal;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
		
		case VentanaPrincipal.COMANDO_ABOUT:
			principal.showAbout();
			break;
		case VentanaPrincipal.BTN_INFOCITY:
			principal.actualizarCiudadInfo();
			principal.showInfoCity();
			break;

		default:
			break;
		}
	}

}
