package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logic.City;
import logic.Track;
import logic.TrackBoyaca;

public class PaneContentMap extends JPanel implements MouseListener{
	
	private JLabel map;
	private JScrollPane paneScroll;
	private float xScaleFactor;
	private float yScaleFactor;
	private BufferedImage img;
	private TrackBoyaca tracksBoyaca;
	
	public PaneContentMap(TrackBoyaca track, WindowsPrincipal ven, PaneMap mapa) {
		
		setSize(ven.getWidth(), (int)((ven.getHeight() - (ven.getHeight() * 0.40))));
		
		xScaleFactor = 1;
		yScaleFactor = 1;
		
		img = toBufferedImage(createImage("/img/mapaBo.png").getImage());
		map = new JLabel(new ImageIcon(img));
	
		tracksBoyaca = track;
		
		add(map);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("Arial", Font.BOLD, 11));
		if (!tracksBoyaca.getCities().isEmpty()) {
			ArrayList<City> auxCity = tracksBoyaca.getCities();
			for (City city : auxCity) {
				g.setColor(city.getColor());
				g.fillOval((int)city.getScaleX(), (int)city.getScaleY(), (int)city.getWidth(),
						(int)city.getHeight());
			}
		}
		if (!tracksBoyaca.getTrack().isEmpty()) {
			ArrayList<Track> auxTrack = tracksBoyaca.getTrack();
			g.setColor(Color.black);
			for (Track track : auxTrack) {
				g.setColor(track.getColor());
				g.drawString(track.getId() + "", track.calculatePosText().x, track.calculatePosText().y);
				g.drawLine((int) track.getCityInitial().getScaleX(),(int) track.getCityInitial().getScaleY(),(int) track.getCityEnd()
						.getScaleX(),(int) track.getCityEnd().getScaleY());
			}
		}
	}
	
	/**
	 * actualiza la posicion y el tamaño de una lista de ciudades
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
		this.remove(map);
		int newW = (int) (img.getWidth() * xScaleFactor);
		int newH = (int) (img.getHeight() * yScaleFactor);
		map = new JLabel(new ImageIcon(img.getScaledInstance(newW, newH, 10)));
		this.add(map);
		this.updateUI();
		map.updateUI();
		repaint();
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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

	public float getxScaleFactor() {
		return xScaleFactor;
	}

	public void setxScaleFactor(float xScaleFactor) {
		this.xScaleFactor = xScaleFactor;
	}

	public float getyScaleFactor() {
		return yScaleFactor;
	}

	public void setyScaleFactor(float yScaleFactor) {
		this.yScaleFactor = yScaleFactor;
	}

	

}
