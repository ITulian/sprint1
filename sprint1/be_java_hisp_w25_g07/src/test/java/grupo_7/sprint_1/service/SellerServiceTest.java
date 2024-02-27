package grupo_7.sprint_1.service;

import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.exception.BadRequestException;
import grupo_7.sprint_1.repository.IBuyerRepository;
import grupo_7.sprint_1.repository.ISellerRepository;
import grupo_7.sprint_1.utils.MockBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SellerServiceTest {

    //--------------------FORMA 1 MOCK + INJECTMOCKS--------------------
    @Mock
    IBuyerRepository buyerRepository;
    @Mock
    ISellerRepository sellerRepository;
    @InjectMocks
    SellerServiceImp sellerServiceImp;

    //--------------------FORMA 2 SOLO MOCK--------------------
    /*@Mock
    SellerServiceImp sellerServiceImp;*/

    //--------------------FORMA 1 MOCK + INJECTMOCKS--------------------
    /*el siguiente test funciona solo porque en el service cambie el orden de las validaciones.
     * en realidad deberia inicializarse la bd correctamente con inject mocks
     * o en su defecto el mockBuyer debería ser suficiente para que NotFoundException ID 11 no sea lanzada.
     * (preguntar si es necesaria esta forma o se puede con la 2)*/
    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Excepción")
    void verifyDateFilterExists() throws BadRequestException {
        String invalidOrder = "date_wrong";

        Buyer mockBuyer = MockBuilder.buildMockBuyer();
        when(buyerRepository.findBuyerById(mockBuyer.getUserId())).thenReturn(mockBuyer);

        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            sellerServiceImp.getRecentPostsFromFollowedSellers(11, invalidOrder);
        }, "Debe lanzar una excepción cuando se proporciona un tipo de ordenamiento inválido.");

        assertEquals("El orden ingresado no es válido.", exception.getMessage());

        /*assertThrows(BadRequestException.class, () -> {
            sellerServiceImp.getRecentPostsFromFollowedSellers(11, invalidOrder);
        }, "Debe lanzar una excepción cuando se proporciona un tipo de ordenamiento inválido.");*/
    }

    //--------------------FORMA 2 SOLO MOCK--------------------
    @Test
    @DisplayName("T-0005-2: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Éxito")
    public void verifyDateFilterExistsCorrect() {
        Integer buyerId = 11;
        String order = "date_asc";

        try {
            sellerServiceImp.getRecentPostsFromFollowedSellers(buyerId, order);
        } catch (BadRequestException e) {
            Assert.assertEquals("Este test no debería lanzar una excepción", e.getMessage());
        }
    }

    @Test
    @DisplayName("T-0005-2: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Excepción")
    public void verifyDateFilterExistsException() {
        Integer buyerId = 11;
        String order = "";

        try {
            sellerServiceImp.getRecentPostsFromFollowedSellers(buyerId, order);
        } catch (BadRequestException e) {
            Assert.assertEquals("El orden ingresado no es válido.", e.getMessage());
        }
    }
}
