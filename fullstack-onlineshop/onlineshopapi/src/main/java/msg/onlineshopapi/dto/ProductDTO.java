package msg.onlineshopapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import msg.onlineshopapi.domain.enums.Category;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    
    private UUID id;
    private String name;
    private Category category;
    private String imageUrl;
    private BigDecimal price;
    private String description;
    private SupplierDTO supplier;
}
