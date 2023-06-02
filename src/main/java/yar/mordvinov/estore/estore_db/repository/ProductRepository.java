package yar.mordvinov.estore.estore_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yar.mordvinov.estore.estore_db.entities.Product;
import yar.mordvinov.estore.estore_db.entities.enums.ProductType;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductsByProductType(ProductType type);
}
