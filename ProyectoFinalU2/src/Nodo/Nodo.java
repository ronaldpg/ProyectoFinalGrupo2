package Nodo;
import ClassToI.*;

public class Nodo {
	private Libro libro;
	private Nodo hijoIzquierdo;
	private Nodo hijoDerecho;

	public Nodo(Libro libro) {
		this.libro = libro;
		this.hijoIzquierdo = null;
		this.hijoDerecho = null;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Nodo getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	public void setHijoIzquierdo(Nodo nodo) {
		hijoIzquierdo = nodo;
	}

	public Nodo getHijoDerecho() {
		return hijoDerecho;
	}

	public void setHijoDerecho(Nodo nodo) {
		hijoDerecho = nodo;
	}

	public boolean esHoja() {
		return hijoIzquierdo == null && hijoDerecho == null;
	}

}
