import javax.persistence.*;


@Entity
@Table(name = "postulante")
public class Postulante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postulante")
    private Integer id_postulante;

    @Column(name = "genero", length = 20)
    private String genero;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "usuario", unique = true, nullable = false, length = 50)
    private String usuario_;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // --- GETTERS & SETTERS ---
    public Integer getId_postulante() {
        return id_postulante;
    }

    public void setId_postulante(Integer id_postulante) {
        this.id_postulante = id_postulante;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getUsuario_() {
        return usuario_;
    }

    public void setUsuario_(String usuario_) {
        this.usuario_ = usuario_;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
