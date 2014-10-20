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

import logic.Ciudad;
import logic.ViasBoyaca;

public class VentanaPrincipal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ViasBoyaca boyaca;
	private PanelMapa mapa;
	private JToolBar toolBar;
	private JButton btnAbrir;
	private JButton btnGuardar;
	private JButton btnMostrarInfoCiudad;
	private JButton btnMostrarInfoVia;
	private JMenuBar menuBar;
	private JMenu menuArchivo;
	private JMenuItem itemAbrir;
	private JMenuItem itemGuardar;
	private JMenuItem itemSalir;
	private JMenu menuAyuda;
	private JMenuItem itemAbout;
	private PanelAcciones panelAcciones;
	private DialogAbout about;
	
	public static final String BTN_ABRIR = "ABRIR_ARCHIVO";
	public static final String BTN_GUARDAR = "GUARDAR_ARCHIVO";
	public static final String BTN_INFOCITY = "CIUDAD";
	public static final String BTN_INFOROAD = "VIA";
	public static final String COMANDO_ABRIR = "ABRIR_MENU";
	public static final String COMANDO_GUARDAR = "GUARDAR_MENU";
	public static final String COMANDO_SALIR = "SALIR";
	public static final String COMANDO_ABOUT = "ABOUT";
	
	

	public VentanaPrincipal() {
		
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
		
		boyaca = new ViasBoyaca();
		
		panelAcciones = new PanelAcciones(this);
		mapa = new PanelMapa(this,boyaca,panelAcciones);
		panelAcciones.setPanelMapa(mapa);
		about = new DialogAbout(panelAcciones, this);
		
		//mapa.setPreferredSize(new Dimension(mapa.ANCHO, mapa.ALTO));
		
		// T O L B A R
		toolBar = new JToolBar(("Menu de registro"));
		toolBar.setOrientation(JToolBar.HORIZONTAL);

		// Botones tolbarr

		btnAbrir = new JButton();
		btnAbrir.setIcon(new ImageIcon(getClass().getResource(
				"/img/openFile.png")));
		btnAbrir.setFocusable(false);
		btnAbrir.addActionListener(panelAcciones);
		btnAbrir.setActionCommand(BTN_ABRIR);
		btnAbrir.setToolTipText("Abrir Archivo");
		
		btnGuardar = new JButton();
		btnGuardar.setIcon(new ImageIcon(getClass().getResource(
				"/img/saveFile.png")));
		btnGuardar.setFocusable(false);
		btnGuardar.addActionListener(panelAcciones);
		btnGuardar.setActionCommand(BTN_GUARDAR);
		btnGuardar.setToolTipText("Guardar Archivo");
		
		btnMostrarInfoCiudad = new JButton();
		btnMostrarInfoCiudad.setIcon(new ImageIcon(getClass().getResource(
				"/img/city.png")));
		btnMostrarInfoCiudad.setFocusable(false);
		btnMostrarInfoCiudad.addActionListener(panelAcciones);
		btnMostrarInfoCiudad.setActionCommand(BTN_INFOCITY);
		btnMostrarInfoCiudad.setToolTipText("Muestra la información de una ciudad");
		
		btnMostrarInfoVia = new JButton();
		btnMostrarInfoVia.setIcon(new ImageIcon(getClass().getResource(
				"/img/road.png")));
		btnMostrarInfoVia.setFocusable(false);
		btnMostrarInfoVia.addActionListener(panelAcciones);
		btnMostrarInfoVia.setActionCommand(BTN_INFOROAD);
		btnMostrarInfoVia.setToolTipText("Muestra la información de una vía");

		// M E N U    B A R 
		menuBar = new JMenuBar();

		// MENU ARCHIVO
		menuArchivo = new JMenu("Archivo");
		
		//Abrir
		itemAbrir = new JMenuItem("Abrir");
		itemAbrir.addActionListener(panelAcciones);
		itemAbrir.setActionCommand(COMANDO_ABRIR);
		
		//Guardar
		itemGuardar= new JMenuItem("Guardar");
		itemGuardar.addActionListener(panelAcciones);
		itemGuardar.setActionCommand(COMANDO_GUARDAR);
		//Salir
		itemSalir = new JMenuItem("Salir");
		itemSalir.addActionListener(panelAcciones);
		itemSalir.setActionCommand(COMANDO_SALIR);
		
		
		//MENU AYUDA
		menuAyuda = new JMenu("Ayuda");
		
		//About
		itemAbout = new JMenuItem("Acerca de");
		itemAbout.addActionListener(panelAcciones);
		itemAbout.setActionCommand(COMANDO_ABOUT);
		
		menuArchivo.add(itemAbrir);
		menuArchivo.add(itemGuardar);
		menuArchivo.add(itemSalir);
		
		menuAyuda.add(itemAbout);
		
		menuBar.add(menuArchivo);
		menuBar.add(menuAyuda);
		toolBar.add(btnAbrir);
		toolBar.addSeparator();
		toolBar.add(btnGuardar);
		toolBar.addSeparator();
		toolBar.add(btnMostrarInfoCiudad);
		toolBar.addSeparator();
		toolBar.add(btnMostrarInfoVia);
		toolBar.addSeparator();

		
		setJMenuBar(menuBar);
		
		
		add(toolBar, BorderLayout.NORTH);
		add(mapa, BorderLayout.CENTER);
		add(panelAcciones, BorderLayout.SOUTH);
	}
	public void ShowAbout(){
		about.setVisible(true);
	}
	public ViasBoyaca getBoyaca() {
		return boyaca;
	}
	public void setBoyaca(ViasBoyaca boyaca) {
		this.boyaca = boyaca;
	}
	
	
}
