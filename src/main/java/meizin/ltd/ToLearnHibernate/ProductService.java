package meizin.ltd.ToLearnHibernate;

import jakarta.persistence.EntityManager;

public class ProductService {

    public Product getProductById(Short productId) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        Product product = null;
        try {
            product = em.find(Product.class, productId);
        } finally {
            em.close();
        }
        return product;
    }

    public void saveOrUpdateProduct(Product product) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(product); // Обновление или создание записи
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
