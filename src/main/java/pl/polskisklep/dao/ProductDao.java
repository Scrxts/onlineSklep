package pl.polskisklep.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polskisklep.model.Product;


@Repository
@Transactional
public class ProductDao extends GenericDao<Product, Long> {
}
