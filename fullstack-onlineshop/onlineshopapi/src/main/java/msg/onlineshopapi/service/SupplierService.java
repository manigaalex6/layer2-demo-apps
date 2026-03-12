package msg.onlineshopapi.service;

import lombok.RequiredArgsConstructor;
import msg.onlineshopapi.domain.Supplier;
import msg.onlineshopapi.dto.SupplierCreateDTO;
import msg.onlineshopapi.dto.SupplierDTO;
import msg.onlineshopapi.exception.SupplierNotFoundException;
import msg.onlineshopapi.mapper.SupplierMapper;
import msg.onlineshopapi.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Transactional
    public SupplierDTO createSupplier(SupplierCreateDTO dto) {
        Supplier supplier = SupplierMapper.toEntity(dto);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return SupplierMapper.toDTO(savedSupplier);
    }

    @Transactional(readOnly = true)
    public SupplierDTO getSupplierById(UUID id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new SupplierNotFoundException(id));
        return SupplierMapper.toDTO(supplier);
    }

    @Transactional(readOnly = true)
    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream()
                .map(SupplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteSupplier(UUID id) {
        if (!supplierRepository.existsById(id)) {
            throw new SupplierNotFoundException(id);
        }
        supplierRepository.deleteById(id);
    }
}
