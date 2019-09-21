package facades;

import entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class CustomerFacade {

    private static CustomerFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private CustomerFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CustomerFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
//    //TODO Remove/Change this before use
//    public long getCustomerCount(){
//        EntityManager em = emf.createEntityManager();
//        try{
//            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
//            return renameMeCount;
//        }finally{  
//            em.close();
//        }
//    }

    
//    // Create a Customer
//    public Customer addCustomer(Customer customer){
//        try {
//            EntityManager em = emf.createEntityManager();
//                em.getTransaction().begin();
//                em.persist(customer);
//                em.getTransaction().commit();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } return customer;
//    }
    
    public List<Customer> getCustomerById(String name) {
        EntityManager em = emf.createEntityManager();
            TypedQuery<Customer> tq = em.createNamedQuery("Customer.getByName", Customer.class);
            tq.setParameter("name", "%" + name + "%");
            return tq.getResultList();
            
    }
    
    // Get all Customers
    public List<Customer> getAllCustomers(){
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Customer.getAll").getResultList();
    }
    
    public void 
    
    
}
