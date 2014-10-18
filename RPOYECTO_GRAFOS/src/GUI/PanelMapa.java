package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logic.Ciudad;
import logic.Via;
import logic.ViasBoyaca;

public class PanelMapa extends JPanel implements MouseListener {

	public final static int ANCHO = 900;
	public final static int ALTO = 450;

	private JLabel mapa;
	private JButton btnZoom1;
	private JButton btnZoom2;
	private JScrollPane scrollPane;
	private ViasBoyaca viasBoyaca;
	private PanelAcciones panelAcciones;
	private boolean encontrar;
	private Ciudad[] ciudades;
	private int contador;
	private int id;
	private Ciudad Caux;
	
	public PanelMapa(VentanaPrincipal ven, ViasBoyaca vias, PanelAcciones ppAcciones) {
		setBackground(Color.blue);
		// this.setPreferredSize(new Dimension(ANCHO, ALTO));
		setSize(ANCHO, ALTO);
		setLayout(null);

		viasBoyaca = vias;
		ciudades = new Ciudad[2];
		contador = 0;
		id = 0;

		btnZoom1 = new JButton("Zoom (+)");
		btnZoom1.setBounds(120, 350, 90, 25);
		add(btnZoom1);

		btnZoom2 = new JButton("Zoom (-)");
		btnZoom2.setBounds(120, 320, 90, 25);
		add(btnZoom2);

		addMouseListener(this);
		encontrar = false;
		panelAcciones = ppAcciones;

	}

	public void crearCiudad(MouseEvent e) {
		Ciudad aux = new Ciudad();
		aux.setPosX(e.getX() - 3);
		aux.setPosY(e.getY() - 3);
		aux.setNombre(panelAcciones.getPanelCrearCiudad().getNombre());
		panelAcciones.getPanelCrearCiudad().setNombre("");
		viasBoyaca.getCiudades().add(aux);
		repaint();
	}
	
	public void crearVia() {
		if (ciudades[0]!=null&&ciudades[1]!=null) {
			id = + 1;
			Via via = new Via();
			panelAcciones.getPanelCrearVia().enviarDatos(via);
			via.setCiudadInicial(ciudades[0]);
			via.setCiudadFinal(ciudades[1]);
			via.setId(id);
			viasBoyaca.getVias().add(via);
		
		}else {
			JOptionPane.showMessageDialog(this, "No se puede crear la via");
		}
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		//g.drawImage(new ImageIcon(getClass().getResource("/img/mapa.png")).getImage(), 0, 0, null);
		g.drawImage(new ImageIcon(getClass().getResource("/img/mapa2.png")).getImage(), 300, 0, null);
		this.setOpaque(false);
		if (!viasBoyaca.getCiudades().isEmpty()) {
			ArrayList<Ciudad> aux = viasBoyaca.getCiudades();
			for (Ciudad ciudad : aux) {
				g.fillOval(ciudad.getPosX(), ciudad.getPosY(), 6, 6);
			}
		}
		if (!viasBoyaca.getVias().isEmpty()) {
			ArrayList<Via> auxV = viasBoyaca.getVias();
			for (Via via : auxV) {
				g.drawLine(via.getCiudadInicial().getPosX(), via.getCiudadInicial().getPosY(), via.getCiudadFinal().getPosX(), via.getCiudadFinal().getPosY());
			}
		}
		super.paint(g);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (panelAcciones.getPresionado()[0]) {
			if (panelAcciones.validarNombre()) {
				this.crearCiudad(arg0);
			} else {
				JOptionPane.showMessageDialog(this, "No ha llenado el formulario");
			}
		}
		if (panelAcciones.getPresionado()[1]) {
			contador+=1;
			if (!viasBoyaca.getCiudades().isEmpty()) {
				if (contador == 1) {
					if (buscarCiudad(arg0.getX(), arg0.getY()) != null) {
						ciudades[0] = buscarCiudad(arg0.getX(), arg0.getY());
					}
				}else if (contador == 2) {
					if (buscarCiudad(arg0.getX(), arg0.getY()) != null) {
						ciudades[1] = buscarCiudad(arg0.getX(), arg0.getY());
					}
				}
				encontrar = false;
			}
		}
		if (contador == 2) {
			contador = 0;
		}
	}
	
	public void limpiarCiudades() {
		ciudades[0] = null;
		ciudades[1] = null;
	}

	public Ciudad calcularColision(int posX, int posY, Ciudad ciudad, int i) {
		if (posX >= ciudad.getPosX() && posX <= ciudad.getPosX() + 6) {
			if (posY >= ciudad.getPosY() && posY <= ciudad.getPosY() + 6) {
				encontrar = true;
				return viasBoyaca.getCiudades().get(i);
			}
		}
		return null;
	}

	public Ciudad buscarCiudad(int posX, int posY) {
		ArrayList<Ciudad> aux = viasBoyaca.getCiudades();
		for (int i = 0; (i < aux.size()) && !encontrar; i++) {
			Caux = calcularColision(posX, posY, aux.get(i), i);
		}
		return Caux;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
