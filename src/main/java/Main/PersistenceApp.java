package Main;

import org.example.*;
import org.hibernate.envers.internal.tools.ArgumentsTools;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceApp {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceAppPU");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Persistir una nueva entidad Cliente
            entityManager.getTransaction().begin();

            Factura factura1 = new Factura();

            factura1.setNumero(12);
            factura1.setFecha("10/04/2023");

            Domicilio dom = new Domicilio("San Martin", 2344);
            Cliente cliente = new Cliente(234234, "munoz", "Pablo");
            dom.setCliente(cliente);

            factura1.setCliente(cliente);

            Categoria perecederos = new Categoria("perecederos");
            Categoria lacteos = new Categoria("lacteos");
            Categoria limpieza =new Categoria("limpieza");

            Articulo art1 = new Articulo(200, "yogurt ser sabor frutila", 20);
            Articulo art2 = new Articulo(300, "detergente", 80);

            art1.getCategorias().add(perecederos);
            art1.getCategorias().add(lacteos);
            lacteos.getArticulos().add(art1);
            perecederos.getArticulos().add(art1);

            art2.getCategorias().add(limpieza);
            limpieza.getArticulos().add(art2);

            DetalleFactura det1 = new DetalleFactura();

            det1.setArticulo(art1);
            det1.setCantidad(2);
            det1.setSubtotal(40);

            art1.getDetalle().add(det1);
            factura1.getDetalles().add(det1);
            det1.setFactura(factura1);

            DetalleFactura det2 = new DetalleFactura();

            det2.setArticulo(art2);
            det2.setCantidad(1);
            det2.setSubtotal(80);

            art2.getDetalle().add(det2);
            factura1.getDetalles().add(det2);
            det2.setFactura(factura1);

            factura1.setTotal(120);

            entityManager.persist(factura1);
            //entityManager.persist(cliente);


            entityManager.flush();
            entityManager.getTransaction().commit();

        }catch (Exception e){

            entityManager.getTransaction().rollback();
        }

        //Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
