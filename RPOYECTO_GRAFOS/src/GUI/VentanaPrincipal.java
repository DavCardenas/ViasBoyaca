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
	private JButton btnCrearCiudad;
	private JMenuBar menuBar;
	private JMenu menuArchivo;
	private JMenuItem itemSalir;
	private PanelAcciones panelAcciones;

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
		//mapa.setPreferredSize(new Dimension(mapa.ANCHO, mapa.ALTO));
		
		// T O L B A R
		toolBar = new JToolBar(("Menu de registro"));
		toolBar.setOrientation(JToolBar.HORIZONTAL);

		// Botones tolbarr

		btnCrearCiudad = new JButton("asd");
		//btnCrearCiudad.setIcon(new ImageIcon(getClass().getResource(
			//	"/Img/AddSong.png")));
		btnCrearCiudad.setFocusable(false);
		//btnCrearCiudad.addActionListener(eventos);
		//btnCrearCiudad.setActionCommand(COMANDO_BOTON_AGREGAR_CANCION);
		btnCrearCiudad.setToolTipText("Agregar Ciudad");

		// M E N U    B A R 
		menuBar = new JMenuBar();

		// MENU ARCHIVO
		menuArchivo = new JMenu("Archivo");

		//Salir
		itemSalir = new JMenuItem("Salir");
		//itemSalir.addActionListener(eventos);
		//itemSalir.setActionCommand(COMANDO_SALIR)
		
		menuArchivo.add(itemSalir);

		menuBar.add(menuArchivo);
		toolBar.add(btnCrearCiudad);
		toolBar.addSeparator();

		
		setJMenuBar(menuBar);
		
		
		add(toolBar, BorderLayout.NORTH);
		add(mapa, BorderLayout.CENTER);
		add(panelAcciones, BorderLayout.SOUTH);
	}
}
