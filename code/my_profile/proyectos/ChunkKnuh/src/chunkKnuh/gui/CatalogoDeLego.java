package chunkKnuh.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import chunkKnuh.dominio.Lego;

public class CatalogoDeLego extends JDialog implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;

	private JMenu operaciones;
	private JMenuItem nuevo;
	private JMenuItem modificar;
	private JMenuItem guardar;
	private JMenuItem eliminar;
	private JMenuItem cancelar;
	private JMenuBar barraOperaciones;

	private JButton nuevoBot�n;
	private JButton modificarBot�n;
	private JButton guardarBot�n;
	private JButton eliminarBot�n;
	private JButton cancelarBot�n;

	private JComboBox<Lego> lego;
	private JSpinner piezas;
	private JSpinner precio;
	private JTextField nombre;
	private JTextField c�digo;
	private JTextField a�oPublicaci�n;
	private JComboBox<String> edadM�nima;
	private JComboBox<String> tema;

	private JCheckBox impresionesPegatina;
	private JCheckBox impresionesPl�stico;
	private JCheckBox impresionesImpresionLaser;

	private JScrollPane desplazamiento;

	private JButton agregarColor;
	private JButton quitarColor;
	private JList<String> coloresEnLista;
	private JComboBox<String> colores;

	private JLabel imagen;
	private JButton imagenBot�n;

	public CatalogoDeLego(JFrame principal) {
		super(principal, "Cat�logo de lego", true);
		this.setIconImage(principal.getIconImage());

		operaciones = new JMenu("Operaciones");
		operaciones.setIcon(new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/operaciones.png")));
		operaciones.setMnemonic(KeyEvent.VK_O);

		// Nuevo
		Action operacionNuevo = new AbstractAction("Nuevo",
				new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/nuevo.png"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				operaci�nNuevo();
			}
		};
		operacionNuevo.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_N);
		operacionNuevo.putValue(Action.SHORT_DESCRIPTION, "Crea un nuevo archivo para el cat�logo de lego");
		operacionNuevo.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		nuevo = new JMenuItem(operacionNuevo);

		// Modificar
		Action operacionModificar = new AbstractAction("Modificar",
				new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/modificar.png"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				operaci�nModificar();
			}
		};
		operacionModificar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_M);
		operacionModificar.putValue(Action.SHORT_DESCRIPTION, "Modifica un archivo del cat�logo de lego");
		operacionModificar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		modificar = new JMenuItem(operacionModificar);

		// Guardar
		Action operacionGuardar = new AbstractAction("Guardar",
				new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/guardar.png"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				operacionGuardar();
			}
		};
		operacionGuardar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_G);
		operacionGuardar.putValue(Action.SHORT_DESCRIPTION, "Guarda un archivo Para cat�logo de lego");
		operacionGuardar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		guardar = new JMenuItem(operacionGuardar);

		// Eliminar
		Action operacionEliminar = new AbstractAction("Eliminar",
				new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/eliminar.png"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				operacionEliminar();
			}
		};
		operacionEliminar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
		operacionEliminar.putValue(Action.SHORT_DESCRIPTION, "Elimina un archivo del cat�logo de lego");
		eliminar = new JMenuItem(operacionEliminar);

		// Cancelar
		Action operacionCancelar = new AbstractAction("Cancelar",
				new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/cancelar.png"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				operacionCancelar();
			}
		};
		operacionCancelar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
		operacionCancelar.putValue(Action.SHORT_DESCRIPTION, "Cancela un archivo del cat�logo de lego");
		cancelar = new JMenuItem(operacionCancelar);

		operaciones.add(nuevo);
		operaciones.add(modificar);
		operaciones.add(guardar);
		operaciones.add(eliminar);
		operaciones.add(cancelar);

		barraOperaciones = new JMenuBar();
		barraOperaciones.add(operaciones);
		barraOperaciones.setBackground(Color.ORANGE);
		this.setJMenuBar(barraOperaciones);

		/// Creaci�n de paneles
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		JPanel panelAyuda = new JPanel();

		// Este
		JPanel panelBorderEste = new JPanel();
		panelBorderEste.setLayout(new GridLayout(5, 1, 0, 50));
		// Botones
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		nuevoBot�n = new JButton(operacionNuevo);
		nuevoBot�n.getActionMap().put("accionNuevo", operacionNuevo);
		nuevoBot�n.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) operacionNuevo.getValue(Action.ACCELERATOR_KEY), "accionNuevo");

		panel.add(nuevoBot�n);
		panelBorderEste.add(panel);

		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		modificarBot�n = new JButton(operacionModificar);
		modificarBot�n.getActionMap().put("accionModificar", operacionModificar);
		modificarBot�n.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) operacionModificar.getValue(Action.ACCELERATOR_KEY), "accionModificar");

		panel.add(modificarBot�n);
		panelBorderEste.add(panel);

		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		guardarBot�n = new JButton(operacionGuardar);
		guardarBot�n.getActionMap().put("accionGuardar", operacionGuardar);
		guardarBot�n.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) operacionGuardar.getValue(Action.ACCELERATOR_KEY), "accionGuardar");

		panel.add(guardarBot�n);
		panelBorderEste.add(panel);

		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		eliminarBot�n = new JButton(operacionEliminar);

		panel.add(eliminarBot�n);
		panelBorderEste.add(panel);

		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		cancelarBot�n = new JButton(operacionCancelar);

		panel.add(cancelarBot�n);
		panelBorderEste.add(panel);

		this.add(panelBorderEste, BorderLayout.EAST);

		// Norte
		JPanel panelBorderNorte = new JPanel();
		panelBorderNorte.setPreferredSize(new Dimension(-1, 60));
		// Entidad de lego
		panel = new JPanel();
		JLabel legoEtiqueta = new JLabel("Legos");
		legoEtiqueta.setDisplayedMnemonic(KeyEvent.VK_L);
		panel.add(legoEtiqueta);

		lego = new JComboBox<Lego>();
		lego.setPreferredSize(new Dimension(320, 20));
		legoEtiqueta.setLabelFor(lego);
		lego.addItemListener(this);
		lego.setToolTipText("lista de Legos");
		panel.add(lego);
		panelBorderNorte.add(panel);
		this.add(panelBorderNorte, BorderLayout.NORTH);

		// Oeste
		JPanel panelBorderOeste = new JPanel();
		panelBorderOeste.setLayout(new GridLayout(8, 2, 0, 0));

		// N�mero Piezas etiqueta
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel piezasEtiqueta = new JLabel("1� N�mero de piezas");
		piezasEtiqueta.setDisplayedMnemonic(KeyEvent.VK_1);
		panel.add(piezasEtiqueta);
		panelBorderOeste.add(panel);

		// Precio etiqueta
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel precioEtiqueta = new JLabel("2� Precio");
		precioEtiqueta.setDisplayedMnemonic(KeyEvent.VK_2);
		panel.add(precioEtiqueta);
		panelBorderOeste.add(panel);

		// N�mero Piezas
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		piezas = new JSpinner();
		piezas.setPreferredSize(new Dimension(150, 20));
		piezasEtiqueta.setLabelFor(piezas);
		piezas.setToolTipText("Numero total de piezas en el Lego.");
		panel.add(piezas);
		panelBorderOeste.add(panel);

		// Precio
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		precio = new JSpinner();
		precio.setPreferredSize(new Dimension(150, 20));
		precioEtiqueta.setLabelFor(precio);
		precio.setToolTipText("precio del Lego que va de 240.99 a 14213.96 .");
		panel.add(precio);
		panelBorderOeste.add(panel);

		// Nombre etiqueta
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel nombreEtiqueta = new JLabel("3� Nombre");
		nombreEtiqueta.setDisplayedMnemonic(KeyEvent.VK_3);
		panel.add(nombreEtiqueta);
		panelBorderOeste.add(panel);

		// C�digo etiqueta
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel c�digoEtiqueta = new JLabel("4� C�digo");
		c�digoEtiqueta.setDisplayedMnemonic(KeyEvent.VK_4);
		panel.add(c�digoEtiqueta);
		panelBorderOeste.add(panel);

		// Nombre
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		nombre = new JTextField();
		nombre.setPreferredSize(new Dimension(150, 20));
		nombreEtiqueta.setLabelFor(nombre);
		nombre.setToolTipText("nombre completo del Lego");
		panel.add(nombre);
		panelBorderOeste.add(panel);

		// C�digo
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		c�digo = new JTextField();
		c�digo.setPreferredSize(new Dimension(150, 20));
		c�digoEtiqueta.setLabelFor(c�digo);
		c�digo.setToolTipText("una combinacion de 5 digitos numericos(0-9)");
		panel.add(c�digo);
		panelBorderOeste.add(panel);

		// A�o de publicaci�n etiqueta
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel a�oPublicaci�nEtiqueta = new JLabel("5� A�o de publicaci�n");
		a�oPublicaci�nEtiqueta.setDisplayedMnemonic(KeyEvent.VK_5);
		panel.add(a�oPublicaci�nEtiqueta);
		panelBorderOeste.add(panel);

		// Edad m�nima etiqueta
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel edadM�nimaEtiqueta = new JLabel("6� Edad m�nima");
		edadM�nimaEtiqueta.setDisplayedMnemonic(KeyEvent.VK_6);
		panel.add(edadM�nimaEtiqueta);
		panelBorderOeste.add(panel);

		// A�o de publicaci�n
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		a�oPublicaci�n = new JTextField();
		a�oPublicaci�n.setPreferredSize(new Dimension(80, 20));
		a�oPublicaci�nEtiqueta.setLabelFor(a�oPublicaci�n);
		a�oPublicaci�n.setToolTipText("fecha que se publico el Lego");
		panel.add(a�oPublicaci�n);
		panelBorderOeste.add(panel);

		// Edad m�nima
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		edadM�nima = new JComboBox<>();
		edadM�nima.setEditable(false);
		edadM�nima.addItem("1.5+");
		edadM�nima.addItem("4+");
		edadM�nima.addItem("6+");
		edadM�nima.addItem("9+");
		edadM�nima.addItem("13+");
		edadM�nima.addItem("18+");
		edadM�nima.setPreferredSize(new Dimension(80, 20));
		edadM�nimaEtiqueta.setLabelFor(edadM�nima);
		edadM�nima.setToolTipText("rango de edad minimo para el LEgo");
		panel.add(edadM�nima);
		panelBorderOeste.add(panel);

		// Tema etiqueta
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel temaEtiqueta = new JLabel("7� Tema");
		temaEtiqueta.setDisplayedMnemonic(KeyEvent.VK_7);
		panel.add(temaEtiqueta);
		panelBorderOeste.add(panel);

		// Impresiones etiqueta
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel impresionesEtiqueta = new JLabel("8� Impresiones");
		impresionesEtiqueta.setDisplayedMnemonic(KeyEvent.VK_8);
		panel.add(impresionesEtiqueta);
		panelBorderOeste.add(panel);

		// Tema
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		tema = new JComboBox<>();
		tema.setEditable(true);
		tema.addItem("Arquitectura");
		tema.addItem("City+");
		tema.addItem("Dreams");
		tema.addItem("Disney");
		tema.addItem("Harry Potter");
		tema.addItem("Ninjago");
		tema.setPreferredSize(new Dimension(150, 20));
		temaEtiqueta.setLabelFor(tema);
		tema.setToolTipText("escoger el tema que representa el lego, se puede ingresar nuevos temas");
		panel.add(tema);
		panelBorderOeste.add(panel);

		// Impresiones
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		impresionesPegatina = new JCheckBox("Pegatinas");
		impresionesPl�stico = new JCheckBox("Pl�stico");
		impresionesImpresionLaser = new JCheckBox("Impresi�n l�ser");
		impresionesEtiqueta.setLabelFor(impresionesPegatina);
		impresionesEtiqueta.setLabelFor(impresionesPl�stico);
		impresionesEtiqueta.setLabelFor(impresionesImpresionLaser);
		impresionesPegatina.setToolTipText("papel sticker que se pega a la hora de ensamblarlo, duracion minima");
		impresionesImpresionLaser.setToolTipText("la imagen esta sobre una cara,duraccion media");
		impresionesPl�stico.setToolTipText("la imagen ya esta ingresada en el bloque,duraccion maxima");
		panel.add(impresionesPegatina);
		panel.add(impresionesImpresionLaser);
		panel.add(impresionesPl�stico);
		panelBorderOeste.add(panel);

		this.add(panelBorderOeste, BorderLayout.WEST);

		// Centro
		JPanel panelBorderCentro = new JPanel();
		panelBorderCentro.setLayout(new GridLayout(4, 1, 10, 10));

		// Colores etiqueta
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel coloresEtiqueta = new JLabel("9� Colores");
		coloresEtiqueta.setDisplayedMnemonic(KeyEvent.VK_9);
		panel.add(coloresEtiqueta);
		panelBorderCentro.add(panel);

		panelAyuda = new JPanel();
		panelAyuda.setLayout(new GridLayout(2, 2, 0, 0));

		// Colores
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.TRAILING));
		colores = new JComboBox<>();
		colores.setPreferredSize(new Dimension(130, 20));
		colores.setEditable(true);
		colores.setToolTipText("Selecciona un color o escribe uno nuevo.");
		coloresEtiqueta.setLabelFor(colores);
		panel.add(colores);
		panelAyuda.add(panel);

		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		agregarColor = new JButton("Agregar");
		coloresEtiqueta.setLabelFor(agregarColor);
		agregarColor.addActionListener(this);
		agregarColor.setIcon(new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/agregar.png")));
		agregarColor.setMnemonic(KeyEvent.VK_A);
		agregarColor.setToolTipText("agregar color a lista de colores.");
		panel.add(agregarColor);
		panelAyuda.add(panel);

		coloresEnLista = new JList<>();
		desplazamiento = new JScrollPane(coloresEnLista);
		coloresEnLista.setToolTipText("lista de colores escogidos");
		coloresEtiqueta.setLabelFor(coloresEnLista);
		panelAyuda.add(desplazamiento);
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		quitarColor = new JButton("Quitar");
		coloresEtiqueta.setLabelFor(quitarColor);
		quitarColor.addActionListener(this);
		quitarColor.setIcon(new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/quitar.png")));
		quitarColor.setMnemonic(KeyEvent.VK_Q);
		quitarColor.setToolTipText("quitar color a lista de colores");
		panel.add(quitarColor);
		panelAyuda.add(panel);

		panelBorderCentro.add(panelAyuda);

		// Imagen etiqueta
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel imagenEtiqueta = new JLabel("10� Imagen");
		panel.add(imagenEtiqueta);
		panelBorderCentro.add(panel);

		// imagen
		panelAyuda = new JPanel();
		panelAyuda.setLayout(new GridLayout(2, 1, 10, 10));

		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		imagen = new JLabel();
		imagenEtiqueta.setLabelFor(imagen);
		panel.add(imagen);
		panelAyuda.add(panel);
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		imagenBot�n = new JButton("Escoger imagen");
		imagenEtiqueta.setLabelFor(imagenBot�n);
		imagenBot�n.addActionListener(this);
		imagenBot�n.setIcon(new ImageIcon(getClass().getResource("/ChunkKnuh/imagenes/escoger.png")));
		imagenBot�n.setMnemonic(KeyEvent.VK_S);
		imagenBot�n.setToolTipText("selecciona una imagen del ordenador.");
		panel.add(imagenBot�n);
		panelAyuda.add(panel);
		panelBorderCentro.add(panelAyuda);

		this.add(panelBorderCentro, BorderLayout.CENTER);

		// Ventana
		this.setSize(new Dimension(1000, 600));
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(principal);

		inicializar();
		establecerFoco();

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(imagenBot�n)) {
			escogerImagen();
		} else if (e.getSource().equals(agregarColor)) {
			agregarColor();
		} else if (e.getSource().equals(quitarColor)) {
			quitarColor();
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(lego)) {
			//Obtener el objeto de la entidad que 
			//est� seleccionado y mostrar� en los componentes gr�ficos los valores almacenados
			Lego guardadoLego = (Lego) lego.getSelectedItem();

			String guardadoNombre = guardadoLego.getNombre();
			String guardadocodigo = guardadoLego.getC�digo();
			float guardadoPrecio = guardadoLego.getPrecio();
			int guardadoPiezas = guardadoLego.getPiezas();
			String guardadoEdadMinima = guardadoLego.getEdadM�nima();

			nombre.setText(guardadoNombre);
			c�digo.setText(guardadocodigo);
			precio.setValue(guardadoPrecio);
			piezas.setValue(guardadoPiezas);
			edadM�nima.setSelectedItem(guardadoEdadMinima);

		}
	}

	// cancelara un archivo en uso
	private void operacionCancelar() {
		limpiarCampos();
		habilitarCampos(false);

		nuevoBot�n.setEnabled(true);
		nuevo.setEnabled(true);

		guardarBot�n.setEnabled(false);
		guardar.setEnabled(false);

		cancelarBot�n.setEnabled(false);
		cancelar.setEnabled(false);

		verificarLista();
	}

	// eliminara un archivo guardado.
	private void operacionEliminar() {
		JOptionPane.showMessageDialog(this, "Eliminar");
	}

	// guardara un archivo.
	private void operacionGuardar() {
		String nuevoNombre = nombre.getText();
		String nuevocodigo = c�digo.getText();
		String nuevoPrecio = String.valueOf(precio.getValue());// en caso spinner
		String nuevasPiezas = String.valueOf(piezas.getValue());
		String nuevaEdadMinima = (String) edadM�nima.getSelectedItem();

		Lego nuevoLego = new Lego();
		nuevoLego.setNombre(nuevoNombre);
		nuevoLego.setC�digo(nuevocodigo);
		nuevoLego.setPrecio(nuevoPrecio);
		nuevoLego.setPiezas(nuevasPiezas);
		nuevoLego.setEdadM�nima(nuevaEdadMinima);

		lego.addItem(nuevoLego);

		JOptionPane.showMessageDialog(this, "Legos guardado exitosamente.", "�xito", JOptionPane.INFORMATION_MESSAGE);
		operacionCancelar();
	}

	// crea un nuevo archivo.
	private void operaci�nNuevo() {
		habilitarCampos(true);
		limpiarCampos();
		// botones y men�s
		modificarBot�n.setEnabled(false);
		modificar.setEnabled(false);

		eliminarBot�n.setEnabled(false);
		eliminar.setEnabled(false);

		guardarBot�n.setEnabled(true);
		guardar.setEnabled(true);

		cancelarBot�n.setEnabled(true);
		cancelar.setEnabled(true);

		lego.setEnabled(false);

		nuevoBot�n.setEnabled(false);
		nuevo.setEnabled(false);
	}

	// modifica un archivo guardado.
	private void operaci�nModificar() {
		JOptionPane.showMessageDialog(this, "Modificar");
	}

	// Quitara un color
	private void quitarColor() {
		JOptionPane.showMessageDialog(this, "Quitar color");
	}

	// Agregara un color.
	private void agregarColor() {
		JOptionPane.showMessageDialog(this, "Agregar color");
	}

	// Escoge una imagen.
	private void escogerImagen() {
		JOptionPane.showMessageDialog(this, "Escoger imagen");
	}

	// limpiar� el contenido de los campos de texto del di�logo
	private void limpiarCampos() {
		nombre.setText("");
		c�digo.setText("");
		precio.setValue(0);
		piezas.setValue(0);
		a�oPublicaci�n.setText("");
		edadM�nima.setSelectedIndex(0);
	}

	// habilitar� o deshabilitar� la escritura de los campos de texto y habilitar� o
	// deshabilitar� al resto de los
	// componentes gr�ficos del �rea de trabajo,
	private void habilitarCampos(boolean escritura) {
		// JSpinner
		piezas.setEnabled(escritura);
		precio.setEnabled(escritura);
		// JTextField
		nombre.setEnabled(escritura);
		c�digo.setEnabled(escritura);
		a�oPublicaci�n.setEnabled(escritura);
		// JComboBox<String>
		edadM�nima.setEnabled(escritura);
		tema.setEnabled(escritura);
		colores.setEnabled(escritura);
		// JCheckBox
		impresionesPegatina.setEnabled(escritura);
		impresionesPl�stico.setEnabled(escritura);
		impresionesImpresionLaser.setEnabled(escritura);
		// JButton
		agregarColor.setEnabled(escritura);
		quitarColor.setEnabled(escritura);
		imagenBot�n.setEnabled(escritura);
		// JList<String>
		coloresEnLista.setEnabled(escritura);
	}

	// verificar� si la lista desplegable principal tiene elementos. Si los tiene,
	// habilitar� a los botones y men�s �Modificar� y
	// �Eliminar�,
	private void verificarLista() {
		if (lego.getItemCount() > 0) {
			// lista principal
			lego.setEnabled(true);
			// botones
			modificarBot�n.setEnabled(true);
			modificar.setEnabled(true);
			eliminarBot�n.setEnabled(true);
			eliminar.setEnabled(true);
		} else {
			// lista principal
			lego.setEnabled(false);
			// botones
			modificarBot�n.setEnabled(false);
			modificar.setEnabled(false);
			eliminarBot�n.setEnabled(false);
			eliminar.setEnabled(false);
		}
	}

	// Inicia el di�logo
	private void inicializar() {
		// elementos gr�ficos 
		habilitarCampos(false);

		// botones y men�s
		nuevoBot�n.setEnabled(true);
		nuevo.setEnabled(true);

		guardarBot�n.setEnabled(false);
		guardar.setEnabled(false);

		cancelarBot�n.setEnabled(false);
		cancelar.setEnabled(false);
		// lista
		verificarLista();
	}

	// Establece el orden de enfoque entre los componentes de la interfaz.
	private void establecerFoco() {
		Vector<Component> componentes = new Vector<>();
		componentes.add(nuevoBot�n);
		componentes.add(modificarBot�n);
		componentes.add(guardarBot�n);
		componentes.add(eliminarBot�n);
		componentes.add(cancelarBot�n);
		componentes.add(lego);
		componentes.add(piezas);
		componentes.add(precio);
		componentes.add(nombre);
		componentes.add(c�digo);
		componentes.add(a�oPublicaci�n);
		componentes.add(edadM�nima);
		componentes.add(tema);
		componentes.add(impresionesPegatina);
		componentes.add(impresionesPl�stico);
		componentes.add(impresionesImpresionLaser);
		componentes.add(colores);
		componentes.add(agregarColor);
		componentes.add(quitarColor);
		componentes.add(imagenBot�n);
		chunkKnuh.utilerias.MiFocusTraversalPolicy politicaFoco = new chunkKnuh.utilerias.MiFocusTraversalPolicy(componentes);
		this.setFocusTraversalPolicy(politicaFoco);
	}
}