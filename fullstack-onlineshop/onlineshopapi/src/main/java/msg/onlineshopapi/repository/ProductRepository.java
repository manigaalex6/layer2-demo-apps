package msg.onlineshopapi.repository;

import msg.onlineshopapi.domain.Product;
import msg.onlineshopapi.domain.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    
    List<Product> findByCategory(Category category);
    
    List<Product> findBySupplierId(UUID supplierId);
}
