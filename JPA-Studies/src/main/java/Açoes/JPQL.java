package Açoes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
public class JPQL {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    private static EntityManager em = emf.createEntityManager();
	public static void main(String[] args) {
		
		
		String jpql = "select c from Pessoa c where c.nome= 'picasso'";
		TypedQuery<Pessoa> typedQuery = em.createQuery(jpql, Pessoa.class);
				
		List<Pessoa> listapessoa = typedQuery.getResultList();
		for(Pessoa pessoa: listapessoa) {
			System.out.println(pessoa);
		}
		
		emf.close();
		em.close();

	}

}
