
/**
 * Clase ReservaLibro para reservar un libro
 * @author alba_
 */
public class ReservaLibro {
    private Libro libro;
    private String fechaReserva;
    private String fechaFin;

    public ReservaLibro(Libro libro, String fechaReserva, String fechaFin) {
        this.libro = libro;
        this.fechaReserva = fechaReserva;
        this.fechaFin = fechaFin;
    }

    public ReservaLibro() {
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Reserva del Libro: título = " + libro + ", fecha de Reserva = " + fechaReserva + ", fecha de Finalización = " + fechaFin;
    }
    
    
    
}
