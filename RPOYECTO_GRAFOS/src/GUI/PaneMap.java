package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JButton;
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
	
	private JButton btnZoom1;
	private JButton btnZoom2;
	private TrackBoyaca tracksBoyaca;
	private PaneActions paneActions;
	private boolean find;
	private City[] cities;
	private int cont;
	private int idTrack;
	private int idCity;
	private JScrollPane paneScroll;
	private City Caux;
	private PaneContentMap contentMap;

	public PaneMap(WindowsPrincipal ven, TrackBoyaca track, PaneActions pPActions) {
		setSize(ven.getWidth(), (int) (ven.getHeight() - (ven.getHeight() * 0.40)));
		setLayout(null);

		contentMap = new PaneContentMap(track, ven, this);
		
		paneScroll = new JScrollPane(contentMap);
		paneScroll.addMouseListener(this);
		paneScroll.setFocusable(false);
		paneScroll.setBorder(null);
		paneScroll.setOpaque(false);
		paneScroll.getViewport().setOpaque(false);
		paneScroll.getViewport().setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		paneScroll.setBounds(0, 0, getWidth(), getHeight());
		paneScroll.addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				repaint();
			}
		});
		paneScroll.getHorizontalScrollBar().addMouseListener(this);
		paneScroll.getVerticalScrollBar().addMouseListener(this);
		
		tracksBoyaca = track;
		cities = new City[2];
		cont = 0;
		idTrack = 0;
		idCity = 0;

		btnZoom1 = new JButton("Zoom (+)");
		btnZoom1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				contentMap.increaseZoom();
				contentMap.updateData(tracksBoyaca.getCities(), contentMap.getxScaleFactor(), contentMap.getyScaleFactor());
				contentMap.update();
				repaint();
			}
		});
		btnZoom1.setBounds(120, 350, 90, 25);
		add(btnZoom1);

		btnZoom2 = new JButton("Zoom (-)");
		btnZoom2.setBounds(120, 320, 90, 25);
		btnZoom2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				contentMap.decreaseZoom();
				contentMap.updateData(tracksBoyaca.getCities(), contentMap.getxScaleFactor(), contentMap.getyScaleFactor());
				contentMap.update();
				repaint();
			}
		});
		add(btnZoom2);

		find = false;
		paneActions = pPActions;
		add(paneScroll);

	}
	
	/**
	 * crea una ciudad y la agrega a una lista de ciudades enviandole
	 * a la ciudad parametros de escala y puntos de ubicacion
	 * @param e
	 */
	public void createCity(MouseEvent e) {
		City aux = tracksBoyaca.addCityint(e.getX()-3, e.getY()-3, paneActions.getPaneCreateCity().getName(), idCity);
		aux.setScaleX(aux.getPointX());
		aux.setScaleY(aux.getPointY());
		paneActions.getPaneCreateCity().setName("");
		tracksBoyaca.getCities().add(aux);
		paneActions.updateCityRoute();
		repaint();
		idCity += 1;
	}

	/**
	 * crea una via a partir de la seleccion de dos ciudades y asigna un id, finalmemte
	 * agrega la via a una lista de vias
	 */
	public void createTrack() {
		if (cities[0] != null && cities[1] != null && paneActions.getPaneCreateTrack().verifyData()) {
			Track via = tracksBoyaca.addTrack(cities[0], cities[1]);
			paneActions.getPaneCreateTrack().sendData(via);
			via.setId(idTrack);
			tracksBoyaca.getTrack().add(via);
			idTrack += 1;
		} else {
			JOptionPane.showMessageDialog(this, "No se puede crear la via");
		}
		repaint();
	}
	
	public void changeColorTrack(String ids) {
		ArrayList<Track> auxTrack = tracksBoyaca.getTrack();
		String cadena = ids.replace(" ", "");
		for (int i = 0; i < cadena.length()-1; i++) {
			for (Track track : auxTrack) {
				if (track.getCityInitial().getId() == Character.digit(cadena.charAt(i),10) && track.getCityEnd().getId() == Character.digit(cadena.charAt(i+1),10)) {
						track.setColor(Color.RED);
				}
				if (track.getCityInitial().getId() == Character.digit(cadena.charAt(i+1),10) && track.getCityEnd().getId() == Character.digit(cadena.charAt(i),10)) {
					track.setColor(Color.RED);
				}
			}
		}
		repaint();
	}
	
	/**
	 * cambia el color de todas las vias
	 */
	public void cleanTrack() {
		ArrayList<Track> aux = tracksBoyaca.getTrack();
		for (Track track : aux) {
			track.setColor(Color.BLACK);
		}
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (paneActions.getPress()[0]) {
			if (paneActions.validateName()) {
				this.createCity(arg0);
				validate();
			} else {
				JOptionPane.showMessageDialog(this, "No ha llenado el formulario");
			}
		}
		if (paneActions.getPress()[1]) {
			City aux;
			cont += 1;
			if (!tracksBoyaca.getCities().isEmpty()) {
				if (cont == 1) {
					aux = searchCity(arg0.getX(), arg0.getY());
					if (aux != null) {
						aux.setColor(Color.RED);
						cities[0] = aux;
						aux = null;
						repaint();
					}
				} else if (cont == 2) {
					aux = searchCity(arg0.getX(), arg0.getY());
					if ( aux != null) {
						aux.setColor(Color.BLUE);
						cities[1] = aux;
						aux = null;
						repaint();
					}
				}
				find = false;
			}
			aux = null;
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
		if (cities[0] != null) {
			cities[0].setColor(Color.BLACK);
		}
		if (cities[1] != null) {
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
		if (posX >= ciudad.getScaleX() && posX <= (ciudad.getScaleX()+ciudad.getWidth())) {
			if (posY >= ciudad.getScaleY() && posY <= (ciudad.getScaleY()+ciudad.getHeight())) {
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
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		repaint();
	}

	public City[] getCities() {
		return cities;
	}

	public void setCities(City[] cities) {
		this.cities = cities;
	}
	
	
}
