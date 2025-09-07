import javax.persistence.*;

@Entity
public class DetalleBusquedaPorRequisito {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_detalleBusqueda", nullable = false)
    private DetalleBusqueda detalleBusqueda;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_requisito", nullable = false)
    private Requisito requisito;

    public DetalleBusqueda getId_detalleBusqueda() {
        return detalleBusqueda;
    }

    public Requisito getId_requisito() {
        return requisito;
    }

    public void setId_requisito(Integer id_requisito) {
        this.requisito = requisito;
    }

    public void setdetalleBusqueda(DetalleBusqueda detalleBusqueda) {
        this.detalleBusqueda = detalleBusqueda;
    }


}
