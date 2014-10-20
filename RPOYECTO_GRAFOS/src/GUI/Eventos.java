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
			principal.limpiarCamposCiudadInfo();
			principal.actualizarCiudadInfo();
			principal.showInfoCity();
			break;
		case DialogCiudad.BTN_ACEPTAR:
			principal.llenarCamposCiudadInfo();		
		break;
		case DialogCiudad.BTN_VOLVER:
			principal.cerrarInfoCiudad();
			principal.limpiarCamposCiudadInfo();
		break;
		case VentanaPrincipal.BTN_INFOROAD:
			principal.actualizarViaInfo();
			principal.showInfoRoad();
		break;
		case DialogVia.BTN_ACEPTAR:
			principal.llenarCamposViaInfo();
		break;
		case DialogVia.BTN_VOLVER:
			principal.cerrarInfoVia();;
			principal.limpiarCamposViaInfo();
		break;
		default:
			break;
		}
	}

}
