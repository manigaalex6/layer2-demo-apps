package msg.onlineshopapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class ProductCreateDTO {
    
    @NotBlank(message = "Product name is required")
    private String name;
    
    @NotNull(message = "Category is required")
    private Category category;
    
    private String imageUrl;
    
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;
    
    private String description;
    
    @NotNull(message = "Supplier ID is required")
    private UUID supplierId;
}
