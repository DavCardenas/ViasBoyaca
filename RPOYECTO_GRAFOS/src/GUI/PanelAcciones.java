package GUI;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PanelAcciones extends JPanel implements ActionListener{

	private PanelCrearCiudad panelCrearCiudad;
	private PanelCrearVia panelCrearVia;
	private PanelBorrar panelBorrar;
	private PanelCrear panelCrear;
	private PanelRecorrido panelRecorrido;
	private JPanel panelDerecha;
	private PanelMapa panelMapa;
	private boolean presionado;
	
	public PanelAcciones(VentanaPrincipal ven) {
		setPreferredSize(new Dimension((ven.getWidth()),200));
		setLayout(new GridLayout(1, 3));
		
		panelCrear = new PanelCrear(ven, this);
		panelCrear.setBounds(0, 0, panelCrear.getWidth(), panelCrear.getHeight());
		panelCrearCiudad = new PanelCrearCiudad(ven);
		panelCrearCiudad.setVisible(false);
		panelCrearCiudad.setBounds(0, 0, panelCrearCiudad.getWidth(), panelCrearCiudad.getHeight());
		panelCrearVia = new PanelCrearVia(ven);
		panelCrearVia.setVisible(false);
		panelCrearVia.setBounds(0, 0, panelCrearVia.getWidth(), panelCrearVia.getHeight());
		
		panelDerecha = new JPanel();
		panelDerecha.setPreferredSize(this.getPreferredSize());
		panelDerecha.add(panelCrear);
		panelDerecha.add(panelCrearCiudad);
		panelDerecha.add(panelCrearVia);
		
		panelBorrar = new PanelBorrar(ven);
		
		panelRecorrido = new PanelRecorrido(ven);
		
		presionado = false;
		
		add(panelDerecha);
		add(panelRecorrido);
		add(panelBorrar);
	}
	
	
	
	public PanelMapa getPanelMapa() {
		return panelMapa;
	}



	public void setPanelMapa(PanelMapa panelMapa) {
		this.panelMapa = panelMapa;
	}



	public boolean validarNombre() {
		return panelCrearCiudad.validarNombre();
	}
	
	

	public PanelCrearCiudad getPanelCrearCiudad() {
		return panelCrearCiudad;
	}



	public void setPanelCrearCiudad(PanelCrearCiudad panelCrearCiudad) {
		this.panelCrearCiudad = panelCrearCiudad;
	}



	public PanelCrearVia getPanelCrearVia() {
		return panelCrearVia;
	}

	public void setPanelCrearVia(PanelCrearVia panelCrearVia) {
		this.panelCrearVia = panelCrearVia;
	}

	public boolean isPresionado() {
		return presionado;
	}


	public void setPresionado(boolean presionado) {
		this.presionado = presionado;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
		case PanelCrear.BTN_CREAR_CIUDAD:
			panelCrear.setVisible(false);
			panelCrearVia.setVisible(false);
			panelCrearCiudad.setVisible(true);
			panelMapa.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			presionado = true;
			break;
		case PanelCrear.BTN_CREAR_VIA:
			panelCrear.setVisible(false);
			panelCrearCiudad.setVisible(false);
			panelCrearVia.setVisible(true);
			panelMapa.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			break;
		default:
			break;
		}
	}
}