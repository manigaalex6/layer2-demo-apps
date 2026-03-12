package msg.onlineshopapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierCreateDTO {
    
    @NotBlank(message = "Supplier name is required")
    private String name;
    
    private String brandDescription;
}
