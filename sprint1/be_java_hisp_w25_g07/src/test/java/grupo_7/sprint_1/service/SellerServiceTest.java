package grupo_7.sprint_1.service;

import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.exception.BadRequestException;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.repository.IBuyerRepository;
import grupo_7.sprint_1.repository.ISellerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SellerServiceTest {

    @Mock
    ISellerRepository sellerRepository;
    @Mock
    IBuyerRepository buyerRepository;

    @InjectMocks
    SellerServiceImp sellerServiceImp;

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009)")
    void verifyDateFilterExists() throws NotFoundException {
        assertThrows(NotFoundException.class, () -> {
            sellerServiceImp.getRecentPostsFromFollowedSellers(1, "date_wrong");
        }, "Debe lanzar una excepción cuando se proporciona un tipo de ordenamiento inválido.");
    }
}
