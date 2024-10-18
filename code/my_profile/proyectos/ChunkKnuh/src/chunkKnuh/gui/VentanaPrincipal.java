package chunkKnuh.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

//paradigmas de programaci�n I
//Reto 3- Cat�logo de lego
//Alumno=Mane Isabela Velasco Naranjo
//grupo 412
//20/06/2024

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	// Men� Archivo
	private JMenu archivo;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem salir;
	// Men� Operaciones
	private JMenu operaciones;
	private JMenuItem cat�logo;
	private JMenuItem consultar;
	// Men� Ayuda
	private JMenu ayuda;
	private JMenuItem acercaDe;

	private JMenuBar barraMenu;

	public VentanaPrincipal() {
		// Configuraci�n de pantalla
		super("ChunkKnuh");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ChunkKnuh/imagenes/logo.png")));

		EventosDeLego eventosDeLego = new EventosDeLego();
		// Men� Archivo
		archivo = new JMenu("Archivo");
		archivo.setIcon(new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/archivo.png")));
		archivo.setMnemonic(KeyEvent.VK_A);
		archivo.setToolTipText("Men� de archivo de ChunkKnuh.");

		abrir = new JMenuItem("Abrir");
		abrir.setIcon(new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/abrir.png")));
		abrir.setMnemonic(KeyEvent.VK_R);
		// Acelerador
		abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK));
		abrir.setToolTipText("Abrir archivos de ChunkKnuh.");
		abrir.addActionListener(eventosDeLego);

		guardar = new JMenuItem("Guardar");
		guardar.setIcon(new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/guardar.png")));
		guardar.setMnemonic(KeyEvent.VK_G);
		guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.ALT_DOWN_MASK));
		guardar.setToolTipText("Guardar archivos de ChunkKnuh.");
		guardar.addActionListener(eventosDeLego);

		salir = new JMenuItem("Salir");
		salir.setIcon(new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/salir.png")));
		salir.setMnemonic(KeyEvent.VK_S);
		salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
		salir.setToolTipText("Cerrar ChunkKnuh.");
		salir.addActionListener(eventosDeLego);

		// Men� de archivo
		archivo.add(abrir);
		archivo.add(guardar);
		archivo.addSeparator();
		archivo.add(salir);

		// Operaciones
		operaciones = new JMenu("Operaciones");
		operaciones.setIcon(new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/operaciones.png")));
		operaciones.setMnemonic(KeyEvent.VK_O);
		operaciones.setToolTipText("Men� de operaciones de ChunkKnuh.");

		// Consultar
		consultar = new JMenuItem("Consultar");
		consultar.setIcon(new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/consultar.png")));
		consultar.setMnemonic(KeyEvent.VK_U);
		consultar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_DOWN_MASK));
		consultar.setToolTipText("Consultar los archivo de ChunkKnuh.");
		consultar.addActionListener(eventosDeLego);

		// Cat�logo
		cat�logo = new JMenuItem("Cat�logo");
		cat�logo.setIcon(new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/catalogo.png")));
		cat�logo.setMnemonic(KeyEvent.VK_C);
		cat�logo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		cat�logo.addActionListener(eventosDeLego);
		cat�logo.setToolTipText("Ventana del cat�logo de ChunkKnuh.");

		// Men� de operaciones
		operaciones.add(cat�logo);
		operaciones.addSeparator();
		operaciones.add(consultar);

		// Ayuda
		ayuda = new JMenu("Ayuda");
		ayuda.setIcon(new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/ayuda.png")));
		ayuda.setMnemonic(KeyEvent.VK_Y);
		ayuda.setToolTipText("Ayuda con ChunkKnuh.");

		acercaDe = new JMenuItem("Acerca de...");
		acercaDe.setIcon(new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/acercaDe.png")));
		acercaDe.setMnemonic(KeyEvent.VK_E);
		acercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_DOWN_MASK));
		acercaDe.setToolTipText("Muestra los cr�ditos de ChunkKnuh.");
		acercaDe.addActionListener(eventosDeLego);

		// Men� de ayuda
		ayuda.add(acercaDe);

		// Barra de men�
		barraMenu = new JMenuBar();
		barraMenu.add(archivo);
		barraMenu.add(operaciones);
		barraMenu.add(ayuda);
		barraMenu.setBackground(Color.ORANGE);
		this.setJMenuBar(barraMenu);
		this.getContentPane().setLayout(new FlowLayout());

		// Ventana
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		this.setResizable(false);

		this.getContentPane().setLayout(new FlowLayout());
		JLabel fondo = new JLabel();

		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/fondo.jpg"));
		Image imagenEscalada = imagenFondo.getImage().getScaledInstance(
				Toolkit.getDefaultToolkit().getScreenSize().width - 100,
				Toolkit.getDefaultToolkit().getScreenSize().height - 100, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(imagenEscalada));
		this.getContentPane().add(fondo);
		getContentPane().setBackground(Color.WHITE);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// Implementar el evento WindowListener en la ventana principal utilizando una
		// clase an�nima
		addWindowListener(new WindowAdapter() {
			@Override
			// Solo implementar el m�todo windowClosing
			public void windowClosing(WindowEvent e) {
				men�Salir();
			}
		});

		setVisible(true);

	}

	// Implementar el evento ActionListener utilizando una clase interna.
	// clase privada
	private class EventosDeLego implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(salir)) {
				men�Salir();
			} else if (e.getSource().equals(acercaDe)) {
				men�AcercaDe();
			} else if (e.getSource().equals(cat�logo)) {
				mostrarDialogo();
			} else if (e.getSource().equals(consultar)) {
				men�Consultar();
			} else if (e.getSource().equals(guardar)) {
				men�Guardar();
			} else if (e.getSource().equals(abrir)) {
				men�Abrir();
			}
		}
	}

	// Muestra un di�logo con el cat�logo de Lego.
	private void mostrarDialogo() {
		new CatalogoDeLego(this);
	}

	// Muestra un cuadro de di�logo "Acerca de", con informaci�n del programa.
	private void men�AcercaDe() {
		JOptionPane.showMessageDialog(this,
				"ChunkKnuh" + "\n\n" + "Realizado por:" + "\nMane Isabela Velasco Naranjo" + "\n\n"
						+ "Derechos reservados UMAR " + '\u00A9' + " 2024",
				"Acerca de ChunkKnuh", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon(getClass().getResource("/legos/imagenes/logo.png")));
	}

	// Cierra la aplicaci�n
	private void men�Salir() {

		System.exit(0);

	}

	// Muestra un cuadro de di�logo indicando que no hay elementos para consultar.
	private void men�Consultar() {
		JOptionPane.showMessageDialog(this, "No hay elementos para consultar", "Consultar",
				JOptionPane.WARNING_MESSAGE);
	}

	// Muestra un cuadro de di�logo indicando que no hay elementos para guardar.
	private void men�Guardar() {
		JOptionPane.showMessageDialog(this, "No hay elementos para guardar", "Guardar", JOptionPane.WARNING_MESSAGE);
	}

	// Muestra un cuadro de di�logo indicando que no hay elementos para abrir.
	private void men�Abrir() {
		JOptionPane.showMessageDialog(this, "No hay elementos para abrir", "Abrir", JOptionPane.WARNING_MESSAGE);
	}

}