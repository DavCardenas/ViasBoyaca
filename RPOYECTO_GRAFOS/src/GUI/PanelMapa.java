package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logic.Ciudad;
import logic.Estado;
import logic.Via;
import logic.ViasBoyaca;

public class PanelMapa extends JPanel implements MouseListener {

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
	private JScrollPane panelScroll;
	private JPanel panelContenedorMapa;
	private float xScaleFactor;
	private float yScaleFactor;
	private BufferedImage img;
	private Ciudad Caux;

	public PanelMapa(VentanaPrincipal ven, ViasBoyaca vias, PanelAcciones ppAcciones) {
		// this.setPreferredSize(new Dimension(ANCHO, ALTO));
		setSize(ven.getWidth(), (int)(ven.getHeight()-(ven.getHeight()*0.40)));
		setLayout(null);

		xScaleFactor = 1;
		yScaleFactor = 1;

		img = toBufferedImage(createImage("/img/mapa2.png").getImage());

		panelContenedorMapa = new JPanel();
		panelContenedorMapa.setOpaque(false);

		mapa = new JLabel(new ImageIcon(img));

		panelContenedorMapa.add(mapa);
		//panelContenedorMapa.addMouseListener(this);

		panelScroll = new JScrollPane(panelContenedorMapa);
		panelScroll.addMouseListener(this);
		panelScroll.setOpaque(false);
		panelScroll.getViewport().setOpaque(false);
		panelScroll.getViewport().setBackground (new Color (0.0f,0.0f,0.0f,0.0f));
		panelScroll.setBounds(0, 0, getWidth(), getHeight());
		//panelScroll.getViewport().setBackground (Color.black);

		viasBoyaca = vias;
		ciudades = new Ciudad[2];
		contador = 0;
		id = 0;

		btnZoom1 = new JButton("Zoom (+)");
		btnZoom1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				increaseZoom();
				actualizarDatos(viasBoyaca.getCiudades(),xScaleFactor,yScaleFactor);
				actualizar();
			}
		});
		btnZoom1.setBounds(120, 350, 90, 25);
		add(btnZoom1);

		btnZoom2 = new JButton("Zoom (-)");
		btnZoom2.setBounds(120, 320, 90, 25);
		btnZoom2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				decreaseZoom();
				actualizarDatos(viasBoyaca.getCiudades(),xScaleFactor,yScaleFactor);
				actualizar();
			}
		});
		add(btnZoom2);

		add(panelScroll);

		addMouseListener(this);
		encontrar = false;
		panelAcciones = ppAcciones;

	}
	
	public void actualizarDatos(ArrayList<Ciudad> ciudades, float escalaX , float escalaY) {
		for (Ciudad ciudad : ciudades) {
			ciudad.cacularEscala(escalaX, escalaY);
			ciudad.cacularEscalaTamanio(escalaX, escalaY);
			System.out.println("Valores X: " + ciudad.getPosX() + " Y: " + ciudad.getPosY());
			System.out.println("Escala X: "+ciudad.getScaleX()+ " Y: " + ciudad.getScaleY());
		}
		repaint();
	}

	public void actualizar() {
		panelContenedorMapa.remove(mapa);
		int newW = (int) (img.getWidth() * xScaleFactor);
		int newH = (int) (img.getHeight() * yScaleFactor);
		//scaleX = x * xScaleFactor;
		//scaleY = y * yScaleFactor;
		//ancho = mAncho * xScaleFactor;
		//alto = mAlto * yScaleFactor;
		mapa = new JLabel(new ImageIcon(img.getScaledInstance(newW, newH, 10)));
		panelContenedorMapa.add(mapa);
		panelContenedorMapa.updateUI();
		mapa.updateUI();
	}

	public void increaseZoom() {
		xScaleFactor += 0.1;
		yScaleFactor += 0.1;
		repaint();
	}

	public void decreaseZoom() {
		xScaleFactor -= 0.1;
		yScaleFactor -= 0.1;
		repaint();
	}

	public void crearCiudad(MouseEvent e) {
		Ciudad aux = new Ciudad();
		aux.setPosX(e.getX() - 3);
		aux.setPosY(e.getY() - 3);
		aux.setScaleX(e.getX() - 3);
		aux.setScaleY(e.getY() - 3);
		aux.setNombre(panelAcciones.getPanelCrearCiudad().getNombre());
		panelAcciones.getPanelCrearCiudad().setNombre("");
		viasBoyaca.getCiudades().add(aux);
		panelAcciones.ActualizarCiudadesRecorrido();
		repaint();
	}

	public void crearVia() {
		if (ciudades[0]!=null&&ciudades[1]!=null && panelAcciones.getPanelCrearVia().verificarDatos()) {
			id += 1;
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
		super.paint(g);
		//g.drawImage(new ImageIcon(getClass().getResource("/img/mapa.png")).getImage(), 0, 0, null);
		//g.drawImage(new ImageIcon(getClass().getResource("/img/mapa2.png")).getImage(), 300, 0, null);
		g.setFont(new Font("Arial", Font.BOLD, 11));
		//this.setOpaque(false);
		if (!viasBoyaca.getCiudades().isEmpty()) {
			ArrayList<Ciudad> aux = viasBoyaca.getCiudades();
			for (Ciudad ciudad : aux) {
				g.setColor(ciudad.getColor());
				g.fillOval((int)ciudad.getScaleX(), (int)ciudad.getScaleY(), (int)ciudad.getAncho(), (int)ciudad.getAlto());
			}
		}
		if (!viasBoyaca.getVias().isEmpty()) {
			ArrayList<Via> auxV = viasBoyaca.getVias();
			g.setColor(Color.black);
			for (Via via : auxV) {
				g.drawString(via.getId()+"", via.calcularPosText().x, via.calcularPosText().y);
				g.drawLine(via.getCiudadInicial().getPosX(), via.getCiudadInicial().getPosY(), via.getCiudadFinal().getPosX(), via.getCiudadFinal().getPosY());
			}
		}
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
						buscarCiudad(arg0.getX(), arg0.getY()).setColor(Color.RED);
						repaint();
						ciudades[0] = buscarCiudad(arg0.getX(), arg0.getY());
					}
				}else if (contador == 2) {
					if (buscarCiudad(arg0.getX(), arg0.getY()) != null) {
						buscarCiudad(arg0.getX(), arg0.getY()).setColor(Color.BLUE);
						repaint();
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
		if (ciudades[0] != null && ciudades[1] != null) {
			ciudades[0].setColor(Color.BLACK);
			ciudades[1].setColor(Color.BLACK);
		}
		ciudades[0] = null;
		ciudades[1] = null;
		repaint();
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

	public static BufferedImage toBufferedImage(Image image) {
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}

		image = new ImageIcon(image).getImage();

		boolean hasAlpha = hasAlpha(image);

		BufferedImage bimage = null;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {

			int transparency = Transparency.OPAQUE;
			if (hasAlpha) {
				transparency = Transparency.BITMASK;
			}

			GraphicsDevice gs = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gs.getDefaultConfiguration();
			bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);
		} catch (HeadlessException e) {
			// The system does not have a screen
		}

		if (bimage == null) {
			int type = BufferedImage.TYPE_INT_RGB;
			if (hasAlpha) {
				type = BufferedImage.TYPE_INT_ARGB;
			}
			bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
		}

		Graphics g = bimage.createGraphics();

		g.drawImage(image, 0, 0, null);
		g.dispose();

		return bimage;
	}

	public static boolean hasAlpha(Image image) {

		if (image instanceof BufferedImage) {
			BufferedImage bimage = (BufferedImage) image;
			return bimage.getColorModel().hasAlpha();
		}

		PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
		try {
			pg.grabPixels();
		} catch (InterruptedException e) {
		}

		ColorModel cm = pg.getColorModel();
		return cm.hasAlpha();
	}

	private ImageIcon createImage(String path) {
		URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
