package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
    @NamedQuery(name = "customer.deleteAllRows", query = "DELETE from customer"),
    @NamedQuery(name = "customer.getAll", query = "SELECT from customer"),
    @NamedQuery(name = "customer.getByName", query = "SELECT from customer"),
    @NamedQuery(name = "customer.getByEmail", query = "SELECT from customer")
})

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Name;
    private String Email;

    public Customer(int id, String Name, String Email) {
        this.id = id;
        this.Name = Name;
        this.Email = Email;
    }
    
    public Customer() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
}
