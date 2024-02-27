package grupo_7.sprint_1.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SellerRepositoryTest {
    @Mock
    SellerRepositoryImp sellerRepository;

    @Test
    @DisplayName("T-0007: Verificar que la cantidad de seguidores de un determinado usuario sea correcta.(US-0002)")
    public void cantidadDeSeguidoresTest() {
        int userId = 1;
        int expected = 10;

        when(sellerRepository.cantidadDeSeguidores(userId)).thenReturn(expected);

        int actual = sellerRepository.cantidadDeSeguidores(userId);

        assertEquals(expected, actual);
    }
}
