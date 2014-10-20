package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventos implements ActionListener {

	private VentanaPrincipal principal;
	private DialogCiudad ciudad;
	
	public Eventos(VentanaPrincipal Vprincipal) {
		this.principal = Vprincipal;
		
		
		ciudad = new DialogCiudad(principal, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
		
		case VentanaPrincipal.COMANDO_ABOUT:
			principal.showAbout();
			break;
		case VentanaPrincipal.BTN_INFOCITY:
			ciudad.actualizarCiudades(principal.getBoyaca().getCiudades());
			principal.showInfoCity();
			break;

		default:
			break;
		}
	}

}
