package GUI;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.ViasBoyaca;

public class PanelAcciones extends JPanel implements ActionListener{

	private PanelCrearCiudad panelCrearCiudad;
	private PanelCrearVia panelCrearVia;
	private PanelBorrar panelBorrar;
	private PanelCrear panelCrear;
	private PanelRecorrido panelRecorrido;
	private JPanel panelDerecha;
	private JPanel panelIzquierda;
	private PanelMapa panelMapa;
	private boolean[] presionado;
	private BorrarCiudad borrarCiudad;
	private BorrarVia borrarVia;
	private VentanaPrincipal principal;
	
	public PanelAcciones(VentanaPrincipal ven) {
		this.principal = ven;
		setPreferredSize(new Dimension((ven.getWidth()),200));
		setLayout(new GridLayout(1, 3));
		
		panelCrear = new PanelCrear(ven, this);
		panelCrear.setBounds(0, 0, panelCrear.getWidth(), panelCrear.getHeight());
		panelCrearCiudad = new PanelCrearCiudad(ven,this);
		panelCrearCiudad.setVisible(false);
		panelCrearCiudad.setBounds(0, 0, panelCrearCiudad.getWidth(), panelCrearCiudad.getHeight());
		panelCrearVia = new PanelCrearVia(ven, this);
		panelCrearVia.setVisible(false);
		panelCrearVia.setBounds(0, 0, panelCrearVia.getWidth(), panelCrearVia.getHeight());
		
		panelDerecha = new JPanel();
		panelDerecha.setPreferredSize(this.getPreferredSize());
		panelDerecha.add(panelCrear);
		panelDerecha.add(panelCrearCiudad);
		panelDerecha.add(panelCrearVia);
		
		panelBorrar = new PanelBorrar(ven, this);
		panelBorrar.setBounds(0, 0, panelBorrar.getWidth(), panelBorrar.getHeight());
		
		borrarCiudad = new BorrarCiudad(ven, this);
		borrarCiudad.setVisible(false);
		borrarCiudad.setBounds(0, 0, borrarCiudad.getWidth(), borrarCiudad.getHeight());
		
		borrarVia = new BorrarVia(ven, this);
		borrarVia.setVisible(false);
		borrarCiudad.setBounds(0, 0, borrarCiudad.getWidth(), borrarCiudad.getHeight());
		
		panelRecorrido = new PanelRecorrido(ven,this);
		
		panelIzquierda = new JPanel();
		panelIzquierda.setPreferredSize(this.getPreferredSize());
		panelIzquierda.add(panelBorrar);
		panelIzquierda.add(borrarCiudad);
		panelIzquierda.add(borrarVia);
		
		presionado = new boolean[2];
		
		add(panelDerecha);
		add(panelRecorrido);
		add(panelIzquierda);
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

	public boolean[] getPresionado() {
		return presionado;
	}

	public void setPresionado(boolean[] presionado) {
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
			presionado[0] = true; 
			JOptionPane.showMessageDialog(panelMapa, " Para crear una ciudad "
					+ "o municipio \n primero tendra que "
					+ "llenar el formulario \n y luego dar "
					+ "clic en el boton aceptar \n finalmente "
					+ "tendra que posicionar el mouse\n en el lugar "
					+ "deseado y dar clic.","Crear Ciudad", JOptionPane.INFORMATION_MESSAGE);
			panelRecorrido.actualizarCiudades(principal.getBoyaca().getCiudades());
			panelRecorrido.repaint();      
			break;
		case PanelCrear.BTN_CREAR_VIA:
			panelCrear.setVisible(false);
			panelCrearCiudad.setVisible(false);
			panelCrearVia.setVisible(true);
			panelMapa.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			presionado[1] = true;
			JOptionPane.showMessageDialog(panelMapa, "Para crear una via "
					+ "primero tendra que seleccionar 2 ciudades \n"
					+ "y llenar el formulario luego dar clic en el boton aceptar \n"
					+ "y finalmente se creara la via.", "Crear Via", JOptionPane.INFORMATION_MESSAGE);
			break;
		case PanelCrearCiudad.BTN_VOLVER:
			panelCrear.setVisible(true);
			panelMapa.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			presionado[0] = false;
			break;
		case PanelCrearVia.BTN_VOLVER:
			panelCrear.setVisible(true);
			panelMapa.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			presionado[1] = false;
			break;
		case VentanaPrincipal.COMANDO_ABOUT:
			principal.ShowAbout();
			break;
		case PanelBorrar.BTN_BORRAR_CIUDAD:
			borrarCiudad.actualizarCiudades(principal.getBoyaca().getCiudades());
			panelBorrar.setVisible(false);
			borrarCiudad.setVisible(true);
			break;
		case PanelCrearVia.BTN_CREAR_VIA:
			panelMapa.crearVia();
			panelMapa.limpiarCiudades();
			panelCrearVia.limpiarCampos();
			break;
		case BorrarCiudad.BTN_VOLVER:
			borrarCiudad.setVisible(false);
			panelBorrar.setVisible(true);
			break;
		case BorrarCiudad.BTN_ACEPTAR:
			borrarCiudad.eliminarCiudad(principal.getBoyaca().getCiudades());
			borrarCiudad.actualizarCiudades(principal.getBoyaca().getCiudades());
			panelMapa.repaint();
			break;
		case PanelBorrar.BTN_BORRAR_VIA:
			borrarVia.actualizarVias(principal.getBoyaca().getVias());
			panelBorrar.setVisible(false);
			borrarVia.setVisible(true);
		break;
		case BorrarVia.BTN_VOLVER:
			borrarVia.setVisible(false);
			panelBorrar.setVisible(true);
		break;
		case BorrarVia.BTN_ACEPTAR:
			borrarVia.eliminarVia(principal.getBoyaca().getVias());
			borrarVia.actualizarVias(principal.getBoyaca().getVias());
			panelMapa.repaint();
		break;
		default:
			break;
		}
	}
}
