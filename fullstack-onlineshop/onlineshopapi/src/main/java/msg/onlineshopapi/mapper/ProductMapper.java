package msg.onlineshopapi.mapper;

import msg.onlineshopapi.domain.Product;
import msg.onlineshopapi.domain.Supplier;
import msg.onlineshopapi.dto.ProductCreateDTO;
import msg.onlineshopapi.dto.ProductDTO;
import msg.onlineshopapi.dto.ProductUpdateDTO;

public class ProductMapper {

    private ProductMapper() {
        // Utility class - prevent instantiation
    }

    public static Product toEntity(ProductCreateDTO dto, Supplier supplier) {
        return Product.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .imageUrl(dto.getImageUrl())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .supplier(supplier)
                .build();
    }

    public static Product updateEntity(Product product, ProductUpdateDTO dto, Supplier supplier) {
        if (dto.getName() != null) {
            product.setName(dto.getName());
        }
        if (dto.getCategory() != null) {
            product.setCategory(dto.getCategory());
        }
        if (dto.getImageUrl() != null) {
            product.setImageUrl(dto.getImageUrl());
        }
        if (dto.getPrice() != null) {
            product.setPrice(dto.getPrice());
        }
        if (dto.getDescription() != null) {
            product.setDescription(dto.getDescription());
        }
        if (supplier != null) {
            product.setSupplier(supplier);
        }
        return product;
    }

    public static ProductDTO toDTO(Product entity) {
        return ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .category(entity.getCategory())
                .imageUrl(entity.getImageUrl())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .supplier(SupplierMapper.toDTO(entity.getSupplier()))
                .build();
    }
}
