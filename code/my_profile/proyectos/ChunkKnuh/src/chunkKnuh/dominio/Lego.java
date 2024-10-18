package chunkKnuh.dominio;

import java.util.ArrayList;
import java.util.Date;

// paradigmas de programaci�n I
// Reto 3- Cat�logo de lego
// Alumno=Mane Isabela Velasco Naranjo
// grupo 412
// 20/06/2024

public class Lego {
	// Variables miembro.
	// 1. N�mero libre.
	private int piezas;
	// 2. N�mero con rango.
	private float precio;

	// 3. Texto en formato libre.
	private String nombre;

	// 4. Texto con formato predefinido.
	private String c�digo;

	// 5. Fecha, que ser� un objeto de tipo Date (java.util).
	private Date a�oPublicaci�n;

	// 6. Dato obtenido de opciones mutuamente excluyentes fijas.
	// Opciones fijas: 1.5+ ,4+ ,6+ ,9+ ,13+ ,18+ .
	private String edadM�nima;

	// 7. Dato obtenido de opciones mutuamente excluyentes din�micas.
	private String tema;

	// 8. Dato multivalorado de opciones no excluyentes fijas.
	// Opciones multivaloradas fijas: pegatina, pl�stico, impresi�n.
	private ArrayList<String> impresiones;

	// 9. Dato multivalorado de opciones no excluyentes din�micas.
	private ArrayList<String> colores;

	// 10. Imagen, que ser� un String para la ruta de la imagen.
	private String imagen;

	// M�todos get
	public int getPiezas() {
		return piezas;
	}

	public float getPrecio() {
		return precio;
	}

	public String getNombre() {
		return nombre;
	}

	public String getC�digo() {
		return c�digo;
	}

	public Date getA�oPublicaci�n() {
		return a�oPublicaci�n;
	}

	public String getEdadM�nima() {
		return edadM�nima;
	}

	public String getTema() {
		return tema;
	}

	public ArrayList<String> getImpresiones() {
		return impresiones;
	}

	public ArrayList<String> getColores() {
		return colores;
	}

	public String getImagen() {
		return imagen;
	}

	// M�todos set.

	public void setPiezas(String piezas) {
		setPiezas(Integer.parseInt(piezas.trim()));
	}

	public void setPiezas(int piezas) {
		if (piezas > 0) {
			this.piezas = piezas;
		} else {
			this.piezas = 0;
		}
	}

	public void setPrecio(String precio) {
		setPrecio(Float.parseFloat(precio.trim()));
	}

	public void setPrecio(float precio) {
		if (precio > 240.99 && precio < 14213.96) {
			this.precio = precio;
		} else {
			this.precio = 0;
		}
	}

	public void setNombre(String nombre) {
		nombre = nombre.trim();
		if (nombre.isEmpty()) {
			throw new IllegalArgumentException();
		} else {
			this.nombre = nombre;
		}
	}

	public void setC�digo(String c�digo) {
		c�digo = c�digo.trim();
		if (c�digo.matches("[0-9]{5}")) {
			this.c�digo = c�digo;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void setA�oPublicaci�n(Date a�oPublicaci�n) {
		this.a�oPublicaci�n = a�oPublicaci�n;
	}

	public void setEdadM�nima(String edadM�nima) {
		this.edadM�nima = edadM�nima;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public void setImpresiones(ArrayList<String> impresiones) {
		this.impresiones = impresiones;
	}

	public void setColores(ArrayList<String> colores) {
		this.colores = colores;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	// Constructor sin par�metros que establezca todos los valores por defecto.
	public Lego() {
		// 1.int.
		this.piezas = 0;

		// 2.int.
		this.precio = 0;

		// 3.String.
		this.nombre = "";

		// 4.String.
		this.c�digo = "";

		// 5.Date.
		this.a�oPublicaci�n = null;

		// 6.String.
		this.edadM�nima = "";

		// 7.String.
		this.tema = "";

		// 8.list String.
		this.impresiones = null;

		// 9.list String.
		this.colores = null;

		// 10.String.
		this.imagen = "";
	}

	// La representaci�n en cadena de la entidad.
	@Override
	public String toString() {
		return piezas + "- " + precio + "- " +nombre+"-"+ c�digo+"-"+edadM�nima;
	}

}
