package tester;

import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Henrik
 */
public class Tester {
    public static void main(String[] args) {
        
        Customer cust = new Customer("Kurt", "Wonnegut");
        cust.addHobby("Football");
        cust.addHobby("Beer");
        cust.addHobby("Sailing");
        cust.addHobby("Running");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        
        
    }
}
