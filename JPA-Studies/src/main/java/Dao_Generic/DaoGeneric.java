package Dao_Generic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public interface DaoGeneric {
public static <T> void persist(T entidade) {
	EntityManager em = JPAUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	em.persist(entidade);
	et.commit();
	em.close();
}
public static <T, F> void Delete(T clazz, F Id) {
	EntityManager em = JPAUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	Object t=null;
	try {
		t = em.find(clazz.getClass(), Id);
		em.remove(t);
	}
	finally {
		em.close();
		et.commit();
	}
}
public static <T, F> T SearchToId(T clazz, F Id) {
	EntityManager em = JPAUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	Object t=null;
	try {
		 t = (T) em.find(clazz.getClass(), Id);
		
	}
	finally {
		em.close();
		et.commit();
	}
	return (T) t;
}
public static <T> ArrayList<T> ListAll(T clazz) {
	EntityManager em = JPAUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	String nome=clazz.getClass().getName();
	nome += " a";
	String jpql = "select a from ";
	jpql += nome;
	ArrayList<T> retorno = (ArrayList<T>) em.createQuery(jpql).getResultList();
	et.commit();
	em.close();
	return retorno;
}
public static<T, Y, U, Z> ArrayList<T> ListToEspecificAtribute(T clazz, U atributo, Z operadorlogico, Y valor) {
	EntityManager em = JPAUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	String tabela = clazz.getClass().getName();
	try {
	String jpql="select a from "+tabela+" a where "+ atributo.toString() + " " +operadorlogico.toString()+" "+valor.toString();
	ArrayList<T> retorno = (ArrayList<T>) em.createQuery(jpql).getResultList();
	et.commit();
	em.close();
	return retorno;
	}
	catch(javax.persistence.PersistenceException e) {
		String jpql="select a from "+tabela+" a where "+ atributo.toString() + " " +operadorlogico.toString()+" '"+valor.toString() + "'";
		ArrayList<T> retorno = (ArrayList<T>) em.createQuery(jpql).getResultList();
		et.commit();
		em.close();
		return retorno;
	}
	
}
public static <T,L, Y, P, O, H, A> void UpdateEspecificAtributeToEspecificAtributeList(T Clazz, L AtributoBuscador, H OperadorLogico1, Y ValorBuscador, P AtributoModificador, A OperadorLogico2, O ValorModificador) {
	String tabela = Clazz.getClass().getName();
	try {
	EntityManager em = JPAUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	String jpql="update "+tabela+" set "+AtributoModificador+" "+OperadorLogico2+" "+ValorModificador+" where "+AtributoBuscador+" "+OperadorLogico1+" "+ValorBuscador;
	em.createQuery(jpql)
	.executeUpdate();
	et.commit();
	em.close();
	}
	catch(javax.persistence.PersistenceException e) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
		String jpql="update "+tabela+" set "+AtributoModificador+" "+OperadorLogico2+" '"+ValorModificador+"' where "+AtributoBuscador+" "+OperadorLogico1+" "+ValorBuscador;
		em.createQuery(jpql)
		.executeUpdate();
		et.commit();
		em.close();
		}
		catch(javax.persistence.PersistenceException f) {
			try {
				EntityManager em = JPAUtil.getEntityManager();
				EntityTransaction et = em.getTransaction();
				et.begin();
				String jpql="update "+tabela+" set "+AtributoModificador+" "+OperadorLogico2+" '"+ValorModificador+"' where "+AtributoBuscador+" "+OperadorLogico1+" '"+ValorBuscador+"'";
				em.createQuery(jpql)
				.executeUpdate();
				et.commit();
				em.close();
			}
			catch(javax.persistence.PersistenceException g) {
				EntityManager em = JPAUtil.getEntityManager();
				EntityTransaction et = em.getTransaction();
				et.begin();
				String jpql="update "+tabela+" set "+AtributoModificador+" "+OperadorLogico2+" "+ValorModificador+" where "+AtributoBuscador+" "+OperadorLogico1+" '"+ValorBuscador+"'";
				em.createQuery(jpql)
				.executeUpdate();
				et.commit();
				em.close();
			}
		}
	}
} 
}
