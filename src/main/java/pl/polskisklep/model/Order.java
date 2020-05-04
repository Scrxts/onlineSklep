package pl.polskisklep.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;
    @ManyToMany
    private List<Product> products;
    @Column(name = "details", length = 512)
    private String orderDetails;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    Order() {
    }

    public Order(String orderDetails) { this.orderDetails = orderDetails;
    }

    public List<Product> getProducts() { return products;
    }

    public void setProducts(List<Product> products) { this.products = products;
    }

    public String getOrderDetails() { return orderDetails; }

    public void setOrderDetails(String orderDetails) { this.orderDetails = orderDetails;
    }

    public User getUser() { return user;
    }

    public void setUser(User user) { this.user = user;
    }
}