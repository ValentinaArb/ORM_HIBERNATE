import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "postulacion")
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postulacion")
    private Integer id_postulacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoPostulacion estado;

    @Column(name = "fecha_iniciada", nullable = false)
    private LocalDate fechaIniciada;

    @Column(name = "cv")
    private String cv;

    @Column(name = "reel")
    private String reel;

    @Column(name = "fotos")
    private String fotos;

    // 🔹 Relación con postulante
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante", nullable = false)
    private Postulante postulante;

    // 🔹 Relación con búsqueda
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_busqueda", nullable = false)
    private Busqueda busqueda;

    // --- GETTERS & SETTERS ---
    public Integer getId_postulacion() {
        return id_postulacion;
    }

    public void setId_postulacion(Integer id_postulacion) {
        this.id_postulacion = id_postulacion;
    }

    public EstadoPostulacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoPostulacion estado) {
        this.estado = estado;
    }

    public LocalDate getFechaIniciada() {
        return fechaIniciada;
    }

    public void setFechaIniciada(LocalDate fechaIniciada) {
        this.fechaIniciada = fechaIniciada;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getReel() {
        return reel;
    }

    public void setReel(String reel) {
        this.reel = reel;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public Busqueda getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(Busqueda busqueda) {
        this.busqueda = busqueda;
    }
}
