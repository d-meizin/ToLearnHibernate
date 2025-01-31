package meizin.ltd.NewTable;

/* import jakarta.persistence.EntityManager;
//import meizin.ltd.ToLearnHibernate.Product;

public class ProductServiceNew {
	
	public ProductNew getEmployeeById(Short employeeId) {
        EntityManager em = HibernateUtilNew.getEntityManagerFactory().createEntityManager();
        ProductNew product = null;
        try {
            product = em.find(ProductNew.class, employeeId);
        } finally {
            em.close();
        }
        return product;
    }

    public void saveOrUpdateProduct(ProductNew product) {
        EntityManager em = HibernateUtilNew.getEntityManagerFactory().createEntityManager();
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
*/