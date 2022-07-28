package Açoes;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa p1 = new Pessoa();
		p1.setNome("picasso");
		p1.setEmail("picasso@gmail.com");
		Endereco e1 = new Endereco();
		e1.setEstado("DF");
		e1.setRua("quadra 01 conjunto t");
		e1.setNumero("08");
		p1.setEndereco(e1);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("acredito");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e1);
        em.persist(p1);
        em.getTransaction().commit();
        em.close();
        emf.close();

	}

}
