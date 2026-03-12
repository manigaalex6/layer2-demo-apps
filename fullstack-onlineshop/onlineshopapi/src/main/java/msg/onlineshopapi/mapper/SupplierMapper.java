package msg.onlineshopapi.mapper;

import msg.onlineshopapi.domain.Supplier;
import msg.onlineshopapi.dto.SupplierCreateDTO;
import msg.onlineshopapi.dto.SupplierDTO;

public class SupplierMapper {

    private SupplierMapper() {
        // Utility class - prevent instantiation
    }

    public static Supplier toEntity(SupplierCreateDTO dto) {
        return Supplier.builder()
                .name(dto.getName())
                .brandDescription(dto.getBrandDescription())
                .build();
    }

    public static SupplierDTO toDTO(Supplier entity) {
        if (entity == null) {
            return null;
        }
        
        return SupplierDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .brandDescription(entity.getBrandDescription())
                .build();
    }
}
