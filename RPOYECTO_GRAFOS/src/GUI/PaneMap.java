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

import logic.City;
import logic.Track;
import logic.TrackBoyaca;

public class PaneMap extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel map;
	private JButton btnZoom1;
	private JButton btnZoom2;
	private TrackBoyaca tracksBoyaca;
	private PaneActions paneActions;
	private boolean find;
	private City[] cities;
	private int cont;
	private int id;
	private JScrollPane paneScroll;
	private JPanel paneContentMap;
	private float xScaleFactor;
	private float yScaleFactor;
	private BufferedImage img;
	private City Caux;

	public PaneMap(WindowsPrincipal ven, TrackBoyaca track, PaneActions pPActions) {
		setSize(ven.getWidth(), (int) (ven.getHeight() - (ven.getHeight() * 0.40)));
		setLayout(null);

		xScaleFactor = 1;
		yScaleFactor = 1;

		img = toBufferedImage(createImage("/img/mapa2.png").getImage());

		paneContentMap = new JPanel();
		paneContentMap.setOpaque(false);

		map = new JLabel(new ImageIcon(img));

		paneContentMap.add(map);

		paneScroll = new JScrollPane(paneContentMap);
		paneScroll.addMouseListener(this);
		paneScroll.setOpaque(false);
		paneScroll.getViewport().setOpaque(false);
		paneScroll.getViewport().setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		paneScroll.setBounds(0, 0, getWidth(), getHeight());

		tracksBoyaca = track;
		cities = new City[2];
		cont = 0;
		id = 0;

		btnZoom1 = new JButton("Zoom (+)");
		btnZoom1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				increaseZoom();
				updateData(tracksBoyaca.getCities(), xScaleFactor, yScaleFactor);
				update();
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
				updateData(tracksBoyaca.getCities(), xScaleFactor, yScaleFactor);
				update();
			}
		});
		add(btnZoom2);

		add(paneScroll);

		addMouseListener(this);
		find = false;
		paneActions = pPActions;

	}

	/**
	 * actualiza la posicion y el tamanio de una lista de ciudades
	 * @param cities
	 * @param scaleX
	 * @param scaleY
	 */
	public void updateData(ArrayList<City> cities, float scaleX, float scaleY) {
		for (City city : cities) {
			city.calculateScale(scaleX, scaleY);
			city.calculateSacaleSize(scaleX, scaleY);
		}
		repaint();
	}

	/**
	 * actualiza los componentes graficos para mostrar el zoom
	 */
	public void update() {
		paneContentMap.remove(map);
		int newW = (int) (img.getWidth() * xScaleFactor);
		int newH = (int) (img.getHeight() * yScaleFactor);
		map = new JLabel(new ImageIcon(img.getScaledInstance(newW, newH, 10)));
		paneContentMap.add(map);
		paneContentMap.updateUI();
		map.updateUI();
	}

	/**
	 * incrementa el factor de escala
	 */
	public void increaseZoom() {
		xScaleFactor += 0.1;
		yScaleFactor += 0.1;
		repaint();
	}

	/**
	 * decrementa el factor de escala
	 */
	public void decreaseZoom() {
		xScaleFactor -= 0.1;
		yScaleFactor -= 0.1;
		repaint();
	}

	/**
	 * crea una ciudad y la agrega a una lista de ciudades enviandole
	 * a la ciudad parametros de escala y puntos de ubicacion
	 * @param e
	 */
	public void createCity(MouseEvent e) {
		City aux = new City();
		aux.setPointX(e.getX() - 3);
		aux.setPointY(e.getY() - 3);
		aux.setScaleX(e.getX() - 3);
		aux.setScaleY(e.getY() - 3);
		aux.setName(paneActions.getPaneCreateCity().getName());
		paneActions.getPaneCreateCity().setName("");
		tracksBoyaca.getCities().add(aux);
		paneActions.updateCityRoute();
		repaint();
	}

	/**
	 * crea una via a partir de la seleccion de dos ciudades y asigna un id, finalmemte
	 * agrega la via a una lista de vias
	 */
	public void createTrack() {
		if (cities[0] != null && cities[1] != null && paneActions.getPaneCreateTrack().verifyData()) {
			id += 1;
			Track via = new Track();
			paneActions.getPaneCreateTrack().sendData(via);
			via.setCityInitial(cities[0]);
			via.setCityEnd(cities[1]);
			via.setId(id);
			tracksBoyaca.getTrack().add(via);

		} else {
			JOptionPane.showMessageDialog(this, "No se puede crear la via");
		}
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("Arial", Font.BOLD, 11));
		if (!tracksBoyaca.getCities().isEmpty()) {
			ArrayList<City> auxCity = tracksBoyaca.getCities();
			for (City city : auxCity) {
				g.setColor(city.getColor());
				g.fillOval((int) city.getScaleX(), (int) city.getScaleY(), (int) city.getWidth(),
						(int) city.getHeight());
			}
		}
		if (!tracksBoyaca.getTrack().isEmpty()) {
			ArrayList<Track> auxTrack = tracksBoyaca.getTrack();
			g.setColor(Color.black);
			for (Track track : auxTrack) {
				g.drawString(track.getId() + "", track.calculatePosText().x, track.calculatePosText().y);
				g.drawLine(track.getCityInitial().getPointX(), track.getCityInitial().getPointY(), track.getCityEnd()
						.getPointX(), track.getCityEnd().getPointY());
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (paneActions.getPress()[0]) {
			if (paneActions.validateName()) {
				this.createCity(arg0);
			} else {
				JOptionPane.showMessageDialog(this, "No ha llenado el formulario");
			}
		}
		if (paneActions.getPress()[1]) {
			cont += 1;
			if (!tracksBoyaca.getCities().isEmpty()) {
				if (cont == 1) {
					if (searchCity(arg0.getX(), arg0.getY()) != null) {
						searchCity(arg0.getX(), arg0.getY()).setColor(Color.RED);
						repaint();
						cities[0] = searchCity(arg0.getX(), arg0.getY());
					}
				} else if (cont == 2) {
					if (searchCity(arg0.getX(), arg0.getY()) != null) {
						searchCity(arg0.getX(), arg0.getY()).setColor(Color.BLUE);
						repaint();
						cities[1] = searchCity(arg0.getX(), arg0.getY());
					}
				}
				find = false;
			}
		}
		if (cont == 2) {
			cont = 0;
		}
	}

	/**
	 * limpia el vector de ciudades y re asigna el color
	 * de las ciudades seleccionadas
	 */
	public void cleanCities() {
		if (cities[0] != null && cities[1] != null) {
			cities[0].setColor(Color.BLACK);
			cities[1].setColor(Color.BLACK);
		}
		cities[0] = null;
		cities[1] = null;
		repaint();
	}

	/**
	 * calcula la colision del mouse y una lista de ciudades para 
	 * encontrar la ciudad seleccionada
	 * @param posX
	 * @param posY
	 * @param ciudad
	 * @param i
	 * @return
	 */
	public City calculateColision(int posX, int posY, City ciudad, int i) {
		if (posX >= ciudad.getPointX() && posX <= ciudad.getPointX() + 6) {
			if (posY >= ciudad.getPointY() && posY <= ciudad.getPointY() + 6) {
				find = true;
				return tracksBoyaca.getCities().get(i);
			}
		}
		return null;
	}

	public City searchCity(int posX, int posY) {
		ArrayList<City> aux = tracksBoyaca.getCities();
		for (int i = 0; (i < aux.size()) && !find; i++) {
			Caux = calculateColision(posX, posY, aux.get(i), i);
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

	/**
	 * comvierte una imagen a bufferedImage
	 * @param image
	 * @return
	 */
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

	/**
	 * crea una imagen a prtir de una ruta especificada
	 * @param path
	 * @return
	 */
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
