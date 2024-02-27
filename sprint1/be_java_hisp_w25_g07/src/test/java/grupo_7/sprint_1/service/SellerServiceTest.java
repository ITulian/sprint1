package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.SellerDTO;
import grupo_7.sprint_1.exception.BadRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SellerServiceTest {

    @Mock
    SellerServiceImp sellerServiceImp;

    /*@Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Excepción")
    void verifyDateFilterExists() throws NotFoundException {
        Integer buyerId = 1;
        String invalidOrder = "date_wrong";

        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            sellerServiceImp.getRecentPostsFromFollowedSellers(buyerId, invalidOrder);
        }, "Debe lanzar una excepción cuando se proporciona un tipo de ordenamiento inválido.");

        assertEquals("El orden ingresado no es válido.", exception.getMessage());
    }*/

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Éxito")
    public void verifyDateFilterExistsCorrect() {
        Integer buyerId = 1;
        String order = "name_asc";

        try {
            sellerServiceImp.getRecentPostsFromFollowedSellers(buyerId, order);
        } catch (BadRequestException e) {
            Assert.assertEquals("Este test no debería lanzar una excepción", e.getMessage());
        }
    }

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Excepción")
    public void verifyDateFilterExistsException() {
        Integer buyerId = 1;
        String order = "";

        try {
            sellerServiceImp.getRecentPostsFromFollowedSellers(buyerId, order);
        } catch (BadRequestException e) {
            Assert.assertEquals("El orden ingresado no es válido.", e.getMessage());
        }
    }
    @Test
    @DisplayName("T-0007: Verificar que la cantidad de seguidores de un determinado usuario sea correcta.(US-0002)")
    public void cantidadSeguidoresTest() {
        int id = 1;
        SellerDTO expected = new SellerDTO();
        expected.setFollowerCount(10);

        when(sellerServiceImp.cantidadSeguidores(id)).thenReturn(expected);

        SellerDTO actual = sellerServiceImp.cantidadSeguidores(id);

        Assert.assertEquals(expected.getFollowerCount(), actual.getFollowerCount());
    }
}
