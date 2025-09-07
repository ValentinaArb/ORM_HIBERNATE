package utils;
import javax.persistence.EntityManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Probando PU: ORM_Hibernate_Prueba");
        EntityManager em = null;
        try {
            em = DBUtils.getEntityManager(); // o DBUtils si tu clase se llama así

            // 1) Lectura simple: si esto anda, la conexión está OK
            Object dbName = em.createNativeQuery("SELECT DATABASE()").getSingleResult();
            Object version = em.createNativeQuery("SELECT VERSION()").getSingleResult();
            System.out.printf("Conectado a BD '%s' - MySQL %s%n", dbName, version);

            // 2) Escritura simple: probar transacción y permisos de escritura
            DBUtils.comenzarTransaccion(em);
            em.createNativeQuery(
                    "CREATE TABLE IF NOT EXISTS _probe (" +
                            "  id INT PRIMARY KEY AUTO_INCREMENT," +
                            "  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                            ")").executeUpdate();
            DBUtils.commit(em);
            System.out.println("Escritura OK (tabla _probe creada/verificada).");

            // 3) Inserción de prueba
            DBUtils.comenzarTransaccion(em);
            em.createNativeQuery("INSERT INTO _probe() VALUES ()").executeUpdate();
            DBUtils.commit(em);
            System.out.println("Insert OK en _probe.");

            // 4) Conteo rápido
            Object count = em.createNativeQuery("SELECT COUNT(*) FROM _probe").getSingleResult();
            System.out.println("Filas en _probe: " + count);

            System.out.println("✅ Conexión y operaciones básicas OK.");
        } catch (Exception e) {
            try { if (em != null) DBUtils.rollback(em); } catch (Exception ignore) {}
            System.err.println("❌ Falló la conexión o la consulta. Detalle:");
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
            // Sugerido: agregá en BDUtils un método closeFactory() para cerrar la EMF al salir.
            // BDUtils.closeFactory();
        }
    }
    }
