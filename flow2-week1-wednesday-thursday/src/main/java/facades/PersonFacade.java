package facades;

import DTO.PersonDTO;
import DTO.PersonsDTO;
import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private PersonFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PersonDTO getPerson(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return new PersonDTO(em.find(Person.class, id));

        } finally {
            em.close();
        }
    }

    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();

        try {
            return (List<Person>)em.createQuery("select p from Person p").getResultList();
        } finally {
            em.close();
        }
    }

    public Person addPerson(String firstName, String lastName, String phone) {
        EntityManager em = emf.createEntityManager();
        Person person = new Person(firstName, lastName, phone);
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return person;
    }

    public PersonDTO editPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        Person pNew = em.find(Person.class, p.getId());
        pNew.setFirstName(p.getFirstName());
        pNew.setLastName(p.getLastName());
        pNew.setPhone(p.getPhone());
        try {
            em.getTransaction().begin();
            em.merge(pNew);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return getPerson(p.getId());

    }

    public PersonDTO deletePerson(String firstName, String lastName, String phone) {
        EntityManager em = emf.createEntityManager();
        Person person = new Person(firstName, lastName, phone);
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return new PersonDTO(person);
    }

//TODO Remove/Change this before use
//    public long getRenameMeCount() {
//        EntityManager em = emf.createEntityManager();
//        try {
//            long renameMeCount = (long) em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
//            return renameMeCount;
//        } finally {
//            em.close();
//        }
//
//    }
}
