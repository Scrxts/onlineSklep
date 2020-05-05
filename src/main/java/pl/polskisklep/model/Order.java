package pl.polskisklep.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;
    @Column(name = "details", length = 512)
    private String orderDetails;
    @ManyToMany
    @JoinTable(name = "order_products",
            joinColumns = {@JoinColumn(name="order_id", referencedColumnName="id_order")},
            inverseJoinColumns = {@JoinColumn(name="product_id", referencedColumnName="id_product")}
    )
    private List<Product> products;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order() {
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