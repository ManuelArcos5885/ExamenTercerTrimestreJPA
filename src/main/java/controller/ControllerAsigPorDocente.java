package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignaturaspordocente;
import model.Docente;

public class ControllerAsigPorDocente {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProfesoryMateria");
	
	
	
	
	public static List<Asignaturaspordocente> findLikeidDocente(Docente d){
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM asignaturaspordocente where idDocente = ?", Asignaturaspordocente.class);
		q.setParameter(1, d.getId());
		
		List<Asignaturaspordocente> l = (List<Asignaturaspordocente>) q.getResultList();
		
	
		
		em.close();
		return l;
		
	}
	
	/**
	 * 
	 * 
	 */
	public static void persist(Asignaturaspordocente a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 */
	public static void remove(Asignaturaspordocente a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Asignaturaspordocente actual = null;
		em.getTransaction().begin();
		if (!em.contains(a)) {
			actual = em.merge(a);
		}
		em.remove(actual);
		em.getTransaction().commit();
		em.close();
	}
	
}
