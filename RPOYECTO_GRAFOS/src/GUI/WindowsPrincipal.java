package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import logic.City;
import logic.TrackBoyaca;

public class WindowsPrincipal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TrackBoyaca boyaca;
	private PaneMap map;
	private JToolBar toolBar;
	private JButton btnOpen;
	private JButton btnSave;
	private JButton btnShowInfoCity;
	private JButton btnShowInfoTrack;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem itemOpen;
	private JMenuItem itemSave;
	private JMenuItem itemExit;
	private JMenu menuHelp;
	private JMenuItem itemAbout;
	private PaneActions panelActions;
	private Events events;
	private DialogAbout about;
	private DialogCity city;
	private DialogTrack track;
	
	public static final String BTN_OPEN = "ABRIR_ARCHIVO";
	public static final String BTN_SAVE = "GUARDAR_ARCHIVO";
	public static final String BTN_INFOCITY = "CIUDAD";
	public static final String BTN_INFOTRACK = "VIA";
	public static final String COMAND_OPEN = "ABRIR_MENU";
	public static final String COMAND_SAVE = "GUARDAR_MENU";
	public static final String COMAND_EXIT = "SALIR";
	public static final String COMAND_ABOUT = "ABOUT";
	
	

	public WindowsPrincipal() {
		
		try {
			UIManager
			.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setSize(1000,700);
		setBackground(Color.white);
		setTitle("Vías Boyacá");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		boyaca = new TrackBoyaca();
		
		panelActions = new PaneActions(this);
		events = new Events(this);
		map = new PaneMap(this,boyaca,panelActions);
		panelActions.setPaneMap(map);
		about = new DialogAbout(events, this);
		city = new DialogCity(this, events);
		track = new DialogTrack(this, events);
		
		
		
		//mapa.setPreferredSize(new Dimension(mapa.ANCHO, mapa.ALTO));
		
		// T O L B A R
		toolBar = new JToolBar(("Menu de registro"));
		toolBar.setOrientation(JToolBar.HORIZONTAL);

		// Botones tolbarr

		btnOpen = new JButton();
		btnOpen.setIcon(new ImageIcon(getClass().getResource(
				"/img/openFile.png")));
		btnOpen.setFocusable(false);
		btnOpen.addActionListener(events);
		btnOpen.setActionCommand(BTN_OPEN);
		btnOpen.setToolTipText("Abrir Archivo");
		
		btnSave = new JButton();
		btnSave.setIcon(new ImageIcon(getClass().getResource(
				"/img/saveFile.png")));
		btnSave.setFocusable(false);
		btnSave.addActionListener(events);
		btnSave.setActionCommand(BTN_SAVE);
		btnSave.setToolTipText("Guardar Archivo");
		
		btnShowInfoCity = new JButton();
		btnShowInfoCity.setIcon(new ImageIcon(getClass().getResource(
				"/img/city.png")));
		btnShowInfoCity.setFocusable(false);
		btnShowInfoCity.addActionListener(events);
		btnShowInfoCity.setActionCommand(BTN_INFOCITY);
		btnShowInfoCity.setToolTipText("Muestra la información de una ciudad");
		
		btnShowInfoTrack = new JButton();
		btnShowInfoTrack.setIcon(new ImageIcon(getClass().getResource(
				"/img/road.png")));
		btnShowInfoTrack.setFocusable(false);
		btnShowInfoTrack.addActionListener(events);
		btnShowInfoTrack.setActionCommand(BTN_INFOTRACK);
		btnShowInfoTrack.setToolTipText("Muestra la información de una vía");

		// M E N U    B A R 
		menuBar = new JMenuBar();

		// MENU ARCHIVO
		menuFile = new JMenu("Archivo");
		
		//Abrir
		itemOpen = new JMenuItem("Abrir");
		itemOpen.addActionListener(events);
		itemOpen.setActionCommand(COMAND_OPEN);
		
		//Guardar
		itemSave= new JMenuItem("Guardar");
		itemSave.addActionListener(events);
		itemSave.setActionCommand(COMAND_SAVE);
		//Salir
		itemExit = new JMenuItem("Salir");
		itemExit.addActionListener(events);
		itemExit.setActionCommand(COMAND_EXIT);
		
		
		//MENU AYUDA
		menuHelp = new JMenu("Ayuda");
		
		//About
		itemAbout = new JMenuItem("Acerca de");
		itemAbout.addActionListener(events);
		itemAbout.setActionCommand(COMAND_ABOUT);
		
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.add(itemExit);
		
		menuHelp.add(itemAbout);
		
		menuBar.add(menuFile);
		menuBar.add(menuHelp);
		toolBar.add(btnOpen);
		toolBar.addSeparator();
		toolBar.add(btnSave);
		toolBar.addSeparator();
		toolBar.add(btnShowInfoCity);
		toolBar.addSeparator();
		toolBar.add(btnShowInfoTrack);
		toolBar.addSeparator();

		
		setJMenuBar(menuBar);
		
		
		add(toolBar, BorderLayout.NORTH);
		add(map, BorderLayout.CENTER);
		add(panelActions, BorderLayout.SOUTH);
	}
	public void showAbout(){
		about.setVisible(true);
	}
	public void showInfoCity(){
		city.setVisible(true);
	}
	public TrackBoyaca getBoyaca() {
		return boyaca;
	}
	public void setBoyaca(TrackBoyaca boyaca) {
		this.boyaca = boyaca;
	}
	public void updateCityInfo(){
		city.updateCities(boyaca.getCities());
	}
	public void fillFieldsCity(){
		city.fillFieldsCity(boyaca.getCities());
	}
	public void cleanFieldsCity(){
		city.cleanFieldsCity();
	}
	public void closeInfoCity(){
		city.setVisible(false);
	}
	public void showInfoTrack(){
		track.setVisible(true);
	}
	public void updateTracksInfo(){
		track.updateTracks(boyaca.getTrack());
	}
	public void fillFieldsTrack(){
		track.fillFieldsTrack(boyaca.getTrack());
	}
	public void cleanFieldsTrack(){
		track.cleanFieldsTrack();
	}
	public void closeInfoTrack(){
		track.setVisible(false);
	}
}
