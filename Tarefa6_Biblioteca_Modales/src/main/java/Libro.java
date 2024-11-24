/**
 * Clase libro
 * @author alba_
 */
public class Libro {
    private String libro;
    private String autor;
    private String editorial;
    private String tipo;
    private int valoracion;

    public Libro(String libro, String autor, String editorial, String tipo, int valoracion) {
        this.libro = libro;
        this.autor = autor;
        this.editorial = editorial;
        this.tipo = tipo;
        this.valoracion = valoracion;
    }

    public Libro() {
    }

    public Libro(String libro) {
        this.libro = libro;
    }
    
    

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "Libro: Título =" + libro + ", autor=" + autor + ", editorial=" + editorial + ", tipo=" + tipo + ", valoracion=" + valoracion;
    }
    
    
    
}
