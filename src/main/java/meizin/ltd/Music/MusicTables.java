package meizin.ltd.Music;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MusicTables {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("northwind-persistence-unit");
		EntityManager entityManager = factory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			
			// PERSIST
//		MusicBand musicBand = new MusicBand("Modern Talking", 2);
//		MusicArtist musicArtist1 = new MusicArtist("Dieter", "Bohlen", 50);
//		MusicArtist musicArtist2 = new MusicArtist("Thomas", "Anders", 49);
//
//
//		musicBand.addArtistToBand(musicArtist1);
//		musicBand.addArtistToBand(musicArtist2);
		
//			entityManager.persist(musicBand);
			
//		MusicArtist musicArtist3 = new MusicArtist("Dima", "Plasm", 32);
//		MusicArtist musicArtist4 = new MusicArtist("Vova", "Plasm", 31);
//		MusicBand musicBand = new MusicBand("Plasma", 2);
		
//		musicBand.addArtistToBand(musicArtist3);
//		musicBand.addArtistToBand(musicArtist4);
		
//	    entityManager.persist(musicArtist3);
			
			//FIND
//		MusicBand musicBand = entityManager.find(MusicBand.class, 2);
//		System.out.println(musicBand);
//		System.out.println(musicBand.getArtists());
	
//		MusicArtist musicArtist = entityManager.find(MusicArtist.class, 2);
//		System.out.println(musicArtist);
//		System.out.println(musicArtist.getBand());
//		System.out.println(musicArtist.getBand().getArtists());

		//REMOVE
		MusicArtist musicArtist = entityManager.find(MusicArtist.class, 3);
		entityManager.remove(musicArtist);
		
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
