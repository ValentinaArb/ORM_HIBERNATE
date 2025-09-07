import javax.persistence.*;

@Entity
public class DetalleBusqueda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalleBusqueda;

    @Column(name = "generoPostulante")
    private String generoPostulante;

    @Column(name = "edadMinima")
    private Integer edadMinima;

    @Column(name = "edadMaxima")
    private Integer edadMaxima;

    @Column(name = "generoObra")
    private String generoObra;


    @Column(name = "tipoRemuneracion")
    private String tipoRemuneracion;

    @Column(name = "localidad")
    private String localidad;

    public Integer getId_detalleBusqueda() {
        return id_detalleBusqueda;
    }

    public void setId_detalleBusqueda(Integer id_detalleBusqueda) {
        this.id_detalleBusqueda = id_detalleBusqueda;
    }

    public String getGeneroPostulante() {
        return generoPostulante;
    }

    public void setGeneroPostulante(String generoPostulante) {
        this.generoPostulante = generoPostulante;
    }

}
