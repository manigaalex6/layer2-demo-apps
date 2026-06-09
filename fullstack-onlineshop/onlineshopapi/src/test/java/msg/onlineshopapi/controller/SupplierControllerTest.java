package msg.onlineshopapi.controller;

import msg.onlineshopapi.config.TestSecurityConfig;
import msg.onlineshopapi.dto.SupplierDto;
import msg.onlineshopapi.dto.mapper.SupplierMapper;
import msg.onlineshopapi.model.Supplier;
import msg.onlineshopapi.security.JwtService;
import msg.onlineshopapi.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SupplierController.class)
@Import(TestSecurityConfig.class)
class SupplierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SupplierService supplierService;

    @MockitoBean
    private SupplierMapper supplierMapper;

    @MockitoBean
    private JwtService jwtService;

    @MockitoBean
    private UserDetailsService userDetailsService;

    private final UUID supplierId = UUID.randomUUID();

    @Test
    @WithMockUser(roles = "CUSTOMER")
    void getAll_returnsSuppliers() throws Exception {
        Supplier supplier = Supplier.builder().id(supplierId).name("TechVision Electronics").build();
        SupplierDto dto = SupplierDto.builder()
                .id(supplierId).name("TechVision Electronics")
                .contactEmail("sales@techvision.com").phone("+40-21-555-0101").build();

        when(supplierService.findAll()).thenReturn(List.of(supplier));
        when(supplierMapper.toDto(supplier)).thenReturn(dto);

        mockMvc.perform(get("/products/suppliers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(supplierId.toString()))
                .andExpect(jsonPath("$[0].name").value("TechVision Electronics"))
                .andExpect(jsonPath("$[0].contactEmail").value("sales@techvision.com"));
    }

    @Test
    @WithMockUser(roles = "CUSTOMER")
    void getById_returnsSupplier_whenFound() throws Exception {
        Supplier supplier = Supplier.builder().id(supplierId).name("TechVision Electronics").build();
        SupplierDto dto = SupplierDto.builder()
                .id(supplierId).name("TechVision Electronics")
                .contactEmail("sales@techvision.com").phone("+40-21-555-0101").build();

        when(supplierService.findById(supplierId)).thenReturn(Optional.of(supplier));
        when(supplierMapper.toDto(supplier)).thenReturn(dto);

        mockMvc.perform(get("/products/suppliers/{id}", supplierId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(supplierId.toString()))
                .andExpect(jsonPath("$.name").value("TechVision Electronics"));
    }

    @Test
    @WithMockUser(roles = "CUSTOMER")
    void getById_returns404_whenNotFound() throws Exception {
        when(supplierService.findById(supplierId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/products/suppliers/{id}", supplierId))
                .andExpect(status().isNotFound());
    }
}
