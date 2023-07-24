package ClassToI;

public class Libro implements  Comparable<Libro>{

	String nombreAutor;
	public String nombreLibro;
	String fechaP;
	String generoLibro;
	int numeroPaginas;

	public Libro(String nombreAutor, String nombreLibro, String fechaP, String generoLibro, int numeroPaginas) {
		this.nombreAutor = nombreAutor;
		this.nombreLibro = nombreLibro;
		this.fechaP = fechaP;
		this.generoLibro = generoLibro;
		this.numeroPaginas = numeroPaginas;
	}
	public Libro() {
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public String getNombreLibro() {
		return nombreLibro;
	}
	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}
	public String getFechaP() {
		return fechaP;
	}
	public void setFechaP(String fechaP) {
		this.fechaP = fechaP;
	}
	public String getGeneroLibro() {
		return generoLibro;
	}
	public void setGeneroLibro(String generoLibro) {
		this.generoLibro = generoLibro;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	@Override
	public int compareTo(Libro otroLibro) {
		return this.nombreLibro.compareToIgnoreCase(otroLibro.getNombreLibro());
	}
}