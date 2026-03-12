package msg.onlineshopapi.service;

import lombok.RequiredArgsConstructor;
import msg.onlineshopapi.domain.Product;
import msg.onlineshopapi.domain.Supplier;
import msg.onlineshopapi.domain.enums.Category;
import msg.onlineshopapi.dto.ProductCreateDTO;
import msg.onlineshopapi.dto.ProductDTO;
import msg.onlineshopapi.dto.ProductUpdateDTO;
import msg.onlineshopapi.exception.ProductNotFoundException;
import msg.onlineshopapi.exception.SupplierNotFoundException;
import msg.onlineshopapi.mapper.ProductMapper;
import msg.onlineshopapi.repository.ProductRepository;
import msg.onlineshopapi.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    @Transactional
    public ProductDTO createProduct(ProductCreateDTO dto) {
        Supplier supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new SupplierNotFoundException(dto.getSupplierId()));

        Product product = ProductMapper.toEntity(dto, supplier);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toDTO(savedProduct);
    }

    @Transactional
    public ProductDTO updateProduct(UUID id, ProductUpdateDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        Supplier supplier = null;
        if (dto.getSupplierId() != null) {
            supplier = supplierRepository.findById(dto.getSupplierId())
                    .orElseThrow(() -> new SupplierNotFoundException(dto.getSupplierId()));
        }

        Product updatedProduct = ProductMapper.updateEntity(product, dto, supplier);
        Product savedProduct = productRepository.save(updatedProduct);
        return ProductMapper.toDTO(savedProduct);
    }

    @Transactional(readOnly = true)
    public ProductDTO getProductById(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return ProductMapper.toDTO(product);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category).stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteProduct(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}
