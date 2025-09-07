import utils.DBUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

public class DemoFinal {

    public static void main(String[] args) {
        EntityManager em = DBUtils.getEntityManager();
        DBUtils.comenzarTransaccion(em);

        try {
            // --- CREAR PRODUCTO ---
            Producto desodorante = new Producto();
            desodorante.setNombre("Desodorante");
            desodorante.setDescripcion("Desodorante dove");

            // Insert
            em.persist(desodorante);

            // --- ACTUALIZAR PRODUCTO ---
            desodorante.setDescripcion("Desodorante hipoalergénico ");

            System.out.println("ID DESODORANTE: " + desodorante.getId_producto());

            // --- CONSULTAR PRODUCTO ---
            List<Producto> productos = em
                    .createQuery("select p from Producto p where p.nombre = ?1", Producto.class)
                    .setParameter(1, "Desodorante")
                    .getResultList();

            System.out.println("Productos encontrados: " + productos);

            // --- ELIMINAR PRODUCTO ---
            //for (Producto p : productos) {
              //  em.remove(p);
            //}

            
            Busqueda busqueda = new Busqueda();
            busqueda.setFechaCreada(new Date());
            busqueda.setTiempoDisponible(8);
            busqueda.setEstadoActual(EstadoBusqueda.ACTIVA);
            busqueda.setProducto(desodorante);

            em.persist(busqueda);
            System.out.println("ID BUSQUEDA: " + desodorante.getId_producto());

            DBUtils.commit(em);

        } catch (Exception e) {
            DBUtils.rollback(em);
            e.printStackTrace();
        }
    }

}

