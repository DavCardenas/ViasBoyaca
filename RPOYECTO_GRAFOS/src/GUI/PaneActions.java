package GUI;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.TrackBoyaca;

public class PaneActions extends JPanel implements ActionListener{

	private PaneCreateCity paneCreateCity;
	private PaneCreateTrack paneCreateTrack;
	private PaneDell paneDell;
	private PaneCreate paneCreate;
	private PanelRoute panelRoute;
	private JPanel paneRight;
	private JPanel paneLeft;
	private PaneMap paneMap;
	private boolean[] press;
	private DellCity dellCity;
	private DellTrack dellTrack;
	private WindowsPrincipal principal;
	
	public PaneActions(WindowsPrincipal ven) {
		this.principal = ven;
		setPreferredSize(new Dimension((ven.getWidth()),200));
		setLayout(new GridLayout(1, 3));
		
		paneCreate = new PaneCreate(ven, this);
		paneCreate.setBounds(0, 0, paneCreate.getWidth(), paneCreate.getHeight());
		paneCreateCity = new PaneCreateCity(ven,this);
		paneCreateCity.setVisible(false);
		paneCreateCity.setBounds(0, 0, paneCreateCity.getWidth(), paneCreateCity.getHeight());
		paneCreateTrack = new PaneCreateTrack(ven, this);
		paneCreateTrack.setVisible(false);
		paneCreateTrack.setBounds(0, 0, paneCreateTrack.getWidth(), paneCreateTrack.getHeight());
		
		paneRight = new JPanel();
		paneRight.setPreferredSize(this.getPreferredSize());
		paneRight.add(paneCreate);
		paneRight.add(paneCreateCity);
		paneRight.add(paneCreateTrack);
		
		paneDell = new PaneDell(ven, this);
		paneDell.setBounds(0, 0, paneDell.getWidth(), paneDell.getHeight());
		
		dellCity = new DellCity(ven, this);
		dellCity.setVisible(false);
		dellCity.setBounds(0, 0, dellCity.getWidth(), dellCity.getHeight());
		
		dellTrack = new DellTrack(ven, this);
		dellTrack.setVisible(false);
		dellTrack.setBounds(0, 0, dellTrack.getWidth(), dellTrack.getHeight());
		
		panelRoute = new PanelRoute(ven,this);
		
		paneLeft = new JPanel();
		paneLeft.setPreferredSize(this.getPreferredSize());
		paneLeft.add(paneDell);
		paneLeft.add(dellCity);
		paneLeft.add(dellTrack);
		
		press = new boolean[2];
		
		add(paneRight);
		add(panelRoute);
		add(paneLeft);
	}
	
	public PaneMap getPaneMap() {
		return paneMap;
	}

	public void setPaneMap(PaneMap pPMap) {
		this.paneMap = pPMap;
	}

	public boolean validateName() {
		return paneCreateCity.validateName();
	}

	public PaneCreateCity getPaneCreateCity() {
		return paneCreateCity;
	}

	public void setPaneCreateCity(PaneCreateCity panelCrearCiudad) {
		this.paneCreateCity = panelCrearCiudad;
	}

	public PaneCreateTrack getPaneCreateTrack() {
		return paneCreateTrack;
	}

	public void setPaneCreateTrack(PaneCreateTrack panelCrearVia) {
		this.paneCreateTrack = panelCrearVia;
	}

	public boolean[] getPress() {
		return press;
	}

	public void setPress(boolean[] presionado) {
		this.press = presionado;
	}
	public void updateCityRoute(){
		panelRoute.updateCities(principal.getBoyaca().getCities());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String comand = e.getActionCommand();
		switch (comand) {
		case PaneCreate.BTN_CREATE_CITY:
			paneCreate.setVisible(false);
			paneCreateTrack.setVisible(false);
			paneCreateCity.setVisible(true);
			paneMap.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			press[0] = true; 
			JOptionPane.showMessageDialog(paneMap, " Para crear una ciudad "
					+ "o municipio \n primero tendra que "
					+ "llenar el formulario \n y luego dar "
					+ "clic en el boton aceptar \n finalmente "
					+ "tendra que posicionar el mouse\n en el lugar "
					+ "deseado y dar clic.","Crear Ciudad", JOptionPane.INFORMATION_MESSAGE);
			break;
		case PaneCreate.BTN_CREATE_TRACK:
			paneCreate.setVisible(false);
			paneCreateCity.setVisible(false);
			paneCreateTrack.setVisible(true);
			paneMap.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			press[1] = true;
			JOptionPane.showMessageDialog(paneMap, "Para crear una via "
					+ "primero tendra que seleccionar 2 ciudades \n"
					+ "y llenar el formulario luego dar clic en el boton aceptar \n"
					+ "y finalmente se creara la via.", "Crear Via", JOptionPane.INFORMATION_MESSAGE);
			break;
		case PaneCreateCity.BTN_ACCEPT:
			paneCreateCity.data();
		break;
		case PaneCreateCity.BTN_BACK:
			paneCreate.setVisible(true);
			paneMap.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			press[0] = false;
			break;
		case PaneCreateTrack.BTN_BACK:
			paneCreate.setVisible(true);
			paneMap.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			press[1] = false;
			break;
		case PaneDell.BTN_DELL_CITY:
			dellCity.updateCities(principal.getBoyaca().getCities());
			paneDell.setVisible(false);
			dellCity.setVisible(true);
			break;
		case PaneCreateTrack.BTN_CREATE_TRACK:
			paneMap.createTrack();
			paneMap.cleanCities();
			paneCreateTrack.cleanFields();
			break;
		case DellCity.BTN_BACK:
			dellCity.setVisible(false);
			paneDell.setVisible(true);
			break;
		case DellCity.BTN_ACCEPT:
			dellCity.dellCity(principal.getBoyaca().getCities());
			dellCity.updateCities(principal.getBoyaca().getCities());
			panelRoute.updateCities(principal.getBoyaca().getCities());
			paneMap.repaint();
			break;
		case PaneDell.BTN_DELL_TRACK:
			dellTrack.updateTracks(principal.getBoyaca().getTrack());
			paneDell.setVisible(false);
			dellTrack.setVisible(true);
		break;
		case DellTrack.BTN_BACK:
			dellTrack.setVisible(false);
			paneDell.setVisible(true);
		break;
		case DellTrack.BTN_ACCEPT:
			dellTrack.dellTrack(principal.getBoyaca().getTrack());
			dellTrack.updateTracks(principal.getBoyaca().getTrack());
			paneMap.repaint();
		break;
		case PanelRoute.BTN_ACCEPT:
				principal.getBoyaca().calculateRouteLength(panelRoute.cityInitial(), panelRoute.cityEnd());
			break;
		default:
			break;
		}
	}
}
