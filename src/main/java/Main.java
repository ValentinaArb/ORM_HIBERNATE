import utils.DBUtils;
import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {

        EntityManager em = DBUtils.getEntityManager();
        DBUtils.comenzarTransaccion(em);

        em.persist(new Producto());

        DBUtils.commit(em);
    }
}