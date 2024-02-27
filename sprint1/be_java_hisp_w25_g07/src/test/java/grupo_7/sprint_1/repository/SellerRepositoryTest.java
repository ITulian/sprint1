package grupo_7.sprint_1.repository;

import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.exception.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SellerRepositoryTest {
    @Mock
    SellerRepositoryImp sellerRepository;

    @Test
    @DisplayName("T-0007: Verificar que la cantidad de seguidores de un determinado usuario sea correcta (US-0002) - Éxito")
    public void cantidadDeSeguidoresTest() {
        int userId = 1;
        int expected = 10;

        when(sellerRepository.cantidadDeSeguidores(userId)).thenReturn(expected);
        int actual = sellerRepository.cantidadDeSeguidores(userId);
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("T-0001: Verificar que el usuario a seguir exista (US-0001) - Éxito")
    public void findByIdTest() {
        int userId = 1;
        Seller expected = new Seller();
        expected.setUserId(userId);

        when(sellerRepository.findById(userId)).thenReturn(Optional.of(expected));
        Optional<Seller> actual = sellerRepository.findById(userId);
        assertEquals(expected, actual.get());
    }
    @Test
    @DisplayName("T-0001: Verificar que el usuario a seguir exista (US-0001) - Excepción")
    public void findByIdTest_UserDoesNotExist() {
        int nonExistentUserId = 2;

        when(sellerRepository.findById(nonExistentUserId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> sellerRepository.findById(nonExistentUserId).orElseThrow(() -> new NotFoundException("User not found")));
    }


}
