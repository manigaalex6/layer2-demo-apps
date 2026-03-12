package msg.onlineshopapi.dto;

import jakarta.validation.constraints.Positive;
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
public class ProductUpdateDTO {
    
    private String name;
    private Category category;
    private String imageUrl;
    
    @Positive(message = "Price must be positive")
    private BigDecimal price;
    
    private String description;
    private UUID supplierId;
}
