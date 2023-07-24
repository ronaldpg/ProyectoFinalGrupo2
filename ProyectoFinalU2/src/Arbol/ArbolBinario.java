package Arbol;
import Nodo.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import ClassToI.*;
public class ArbolBinario {

	private Nodo raiz;

	//Constructores
	public ArbolBinario() {
		raiz = null;
	}
	public ArbolBinario(Nodo nodo) {
		raiz = nodo;
	}	
	public ArbolBinario(Nodo raiz, Nodo ramaIzquierda, Nodo ramaDerecha) {
		this.raiz = raiz;
		this.raiz.setHijoIzquierdo(ramaIzquierda);
		this.raiz.setHijoDerecho(ramaDerecha);
	}
	//Metodo para saber si esta vacio
	public boolean estaVacio() {
		return raiz == null;
	}
	//Metodo para obtener la raiz
	public Nodo obtenerRaiz() {
		return raiz;
	}
	//Metodo para obtener la rama Izquierda
	public Nodo obtenerRamaIzquierda() {
		if (raiz != null) {
			return raiz.getHijoIzquierdo();
		}
		return null;
	}
	//Metodo para Obetener la rama Derecha
	public Nodo obtenerRamaDerecha() {
		if (raiz != null) {
			return raiz.getHijoDerecho();
		}
		return null;
	}
	//MetodoInsertarNodo
	private Nodo insertarNodo(Nodo nodo, Libro libro) {
		if (nodo == null) {
			return new Nodo(libro);
		}

		if (libro.compareTo(nodo.getLibro()) < 0) {
			nodo.setHijoIzquierdo(insertarNodo(nodo.getHijoIzquierdo(), libro));
		} else if (libro.compareTo(nodo.getLibro()) > 0) {
			nodo.setHijoDerecho(insertarNodo(nodo.getHijoDerecho(), libro));
		}

		return nodo;
	}
	//Metodo BuscarNodo
	private boolean buscarNodo(Nodo nodo, Libro libro) {
		if (nodo == null) {
			JOptionPane.showMessageDialog(null, "No fue encontrado el libro");
			return false;
		}

		if (libro.compareTo(nodo.getLibro()) == 0) {
			JOptionPane.showMessageDialog(null, "El libro fue encontrado");
			return true;
		} else if (libro.compareTo(nodo.getLibro()) < 0) {
			return buscarNodo(nodo.getHijoIzquierdo(), libro);
		} else {
			return buscarNodo(nodo.getHijoDerecho(), libro);
		}
	}
	//Metodo EliminarNodo
	private Nodo eliminarNodo(Nodo nodo, String titulo) {
        if (nodo == null) {
            return null;
        }

        if (titulo.compareToIgnoreCase(nodo.getLibro().getNombreLibro()) < 0) {
            nodo.setHijoIzquierdo(eliminarNodo(nodo.getHijoIzquierdo(), titulo));
        } else if (titulo.compareToIgnoreCase(nodo.getLibro().getNombreLibro()) > 0) {
            nodo.setHijoDerecho(eliminarNodo(nodo.getHijoDerecho(), titulo));
        } else {
            if (nodo.esHoja()) {
                return null;
            } else if (nodo.getHijoIzquierdo() == null) {
                return nodo.getHijoDerecho();
            } else if (nodo.getHijoDerecho() == null) {
                return nodo.getHijoIzquierdo();
            } else {
                Nodo sucesor = obtenerSucesor(nodo.getHijoDerecho());
                nodo.setLibro(sucesor.getLibro());
                nodo.setHijoDerecho(eliminarNodo(nodo.getHijoDerecho(), sucesor.getLibro().getNombreLibro()));
            }
        }

        return nodo;
    }

	//Metodos para insertar los nodos en el jTable
	public List<Libro> obtenerListaDeLibros() {
		List<Libro> listaLibros = new ArrayList<>();
		obtenerListaDeLibros(raiz, listaLibros);
		return listaLibros;
	}

	private void obtenerListaDeLibros(Nodo nodo, List<Libro> listaLibros) {
		if (nodo != null) {
			obtenerListaDeLibros(nodo.getHijoIzquierdo(), listaLibros);
			listaLibros.add((Libro) nodo.getLibro());
			obtenerListaDeLibros(nodo.getHijoDerecho(), listaLibros);
		}
	}

	//Metodo Para obtenerSucesor
	private Nodo obtenerSucesor(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.getHijoIzquierdo() != null) {
            actual = actual.getHijoIzquierdo();
        }
        return actual;
    }
	//Metodo para obtener el maxio nodo
	private Nodo obtenerMaximo(Nodo nodo) {
		if (nodo == null) {
			return null;
		}

		Nodo maximo = nodo;
		Nodo maximoIzquierda = obtenerMaximo(nodo.getHijoIzquierdo());
		Nodo maximoDerecha = obtenerMaximo(nodo.getHijoDerecho());

		if (maximoIzquierda != null && maximoIzquierda.getLibro().compareTo(maximo.getLibro()) > 0) {
			maximo = maximoIzquierda;
		}
		if (maximoDerecha != null && maximoDerecha.getLibro().compareTo(maximo.getLibro()) > 0) {
			maximo = maximoDerecha;
		}

		return maximo;
	}

	//Metodo para sumar todas las paginas de los libros
	private int sumarPaginas(Nodo nodo) {
		if (nodo == null) {
			return 0;
		}

		Libro libro = (Libro) nodo.getLibro();
		int paginasIzquierda = sumarPaginas(nodo.getHijoIzquierdo());
		int paginasDerecha = sumarPaginas(nodo.getHijoDerecho());

		return paginasIzquierda + paginasDerecha + libro.getNumeroPaginas();
	}
	//Metodo para saber cuantos libros existe en el arbol
	private int contarLibros(Nodo nodo) {
		if (nodo == null) {
			return 0;
		}

		int cantidadIzquierda = contarLibros(nodo.getHijoIzquierdo());
		int cantidadDerecha = contarLibros(nodo.getHijoDerecho());

		return cantidadIzquierda + cantidadDerecha + 1;
	}
	//Metodo para saber si el nodo pertenece al arbol
	private boolean pertenece(Nodo nodoActual, Nodo nodoBuscado) {
		if (nodoActual == null) {
			return false;
		}

		if (nodoActual == nodoBuscado) {
			return true;
		}

		return pertenece(nodoActual.getHijoIzquierdo(), nodoBuscado) || pertenece(nodoActual.getHijoDerecho(), nodoBuscado);
	}

	//Metodo InOrden
	private void InOrden(Nodo nodo) {
		if (nodo != null) {
			InOrden(nodo.getHijoIzquierdo());
			JOptionPane.showMessageDialog(null,"Título: " + nodo.getLibro().getNombreLibro() + ", Autor: " + nodo.getLibro().getNombreAutor());
			InOrden(nodo.getHijoDerecho());
		}
	}
	//Metodo PreOrden
	private void PreOrden(Nodo nodo) {
		if(nodo != null) {
			JOptionPane.showMessageDialog(null,"Título: " + nodo.getLibro().getNombreLibro() + ", Autor: " + nodo.getLibro().getNombreAutor());
			PreOrden(nodo.getHijoIzquierdo());
			PreOrden(nodo.getHijoDerecho());
		}
	}

	//Metodo postOrden
	private void PostOrden(Nodo nodo) {
		PostOrden(nodo.getHijoIzquierdo());
		PostOrden(nodo.getHijoDerecho());
		JOptionPane.showMessageDialog(null,"Título: " + nodo.getLibro().getNombreLibro() + ", Autor: " + nodo.getLibro().getNombreAutor());
	}


	//Impresion de los ordenamientos y utilizacion de los metodos
	public void ImprimirPostOrden() {
		PostOrden(raiz);
	}

	public void ImprimirPreOrden() {
		PreOrden(raiz);
	}

	public void imprimirInOrden() {
		InOrden(raiz);
	}

	public void eliminar(String titulo) {
		raiz = eliminarNodo(raiz, titulo);
	}

	public boolean buscar(Libro libro) {
		return buscarNodo(raiz, libro);
	}

	public void insertar(Libro libro) {
		raiz = insertarNodo(raiz, libro);
	}

	public Nodo obtenerMaximo() {
		return obtenerMaximo(raiz);
	}

	public int sumarPaginas() {
		return sumarPaginas(raiz);
	}

	public int contarLibros() {
		return contarLibros(raiz);
	}

	public boolean pertenece(Nodo nodoBuscado) {
		return pertenece(raiz, nodoBuscado);
	}
}
