/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Henrik
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Order.deleteAllRows", query = "DELETE from Students"),
    @NamedQuery(name = "Order.getAll", query = "SELECT o from Order o"),
    @NamedQuery(name = "Order.getByName", query = "SELECT o from Order o"),
    @NamedQuery(name = "Order.getByColor", query = "SELECT o from Order o")
})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String orderID;

    public Order(Integer id, String orderID) {
        this.id = id;
        this.orderID = orderID;
    }

    public Order(){}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    
    
}
