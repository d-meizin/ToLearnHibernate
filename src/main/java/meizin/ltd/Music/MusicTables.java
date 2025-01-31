package meizin.ltd.Music;

import meizin.ltd.MusicArtist;
import meizin.ltd.MusicBand;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MusicTables {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("northwind-persistence-unit");
		EntityManager entityManager = factory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		MusicArtist musicArtist = null;
		MusicBand musicBand = null;
		
		try {
			transaction.begin();
			
			transaction.commit();
		} 
		catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(entityManager != null) {
				entityManager.close();
				factory.close();
			}
		}
	}
	

}
