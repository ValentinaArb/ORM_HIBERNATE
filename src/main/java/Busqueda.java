import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "busqueda")
public class Busqueda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_busqueda;

    @Temporal(TemporalType.DATE)
    private Date fechaCreada;

    @Column(name = "adicional")
    private String adicional;

    @Column(name = "tiempoDisponible")
    private Integer tiempoDisponible;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_actual")
    private EstadoBusqueda estadoActual;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    public Integer getId_busqueda() {
        return id_busqueda;
    }

    public void setId_busqueda(Integer id_busqueda) {
        this.id_busqueda = id_busqueda;
    }

    public Date getFechaCreada() {
        return fechaCreada;
    }

    public void setFechaCreada(Date fechaCreada) {
        this.fechaCreada = fechaCreada;
    }

    public String getAdicional() {
        return adicional;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }

    public Integer getTiempoDisponible() {
        return tiempoDisponible;
    }

    public void setTiempoDisponible(Integer tiempoDisponible) {
        this.tiempoDisponible = tiempoDisponible;
    }

    public EstadoBusqueda getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoBusqueda estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}