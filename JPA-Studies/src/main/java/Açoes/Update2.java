package Açoes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
public class Update2 {


	    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
	    private static EntityManager em = emf.createEntityManager();
		public static void main(String[] args) {
			em.getTransaction().begin();
		
			em.createQuery("update Pessoa c set nome = 'picasso' where c.nome= 'gabriel'")
			.executeUpdate();
			em.getTransaction().commit();
			emf.close();
			em.close();

		}

	}