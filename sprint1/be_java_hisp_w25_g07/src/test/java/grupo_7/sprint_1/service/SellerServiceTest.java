package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.SellerDTO;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.exception.BadRequestException;
import grupo_7.sprint_1.repository.BuyerRepositoryImp;
import grupo_7.sprint_1.repository.IBuyerRepository;
import grupo_7.sprint_1.repository.ISellerRepository;
import grupo_7.sprint_1.repository.SellerRepositoryImp;
import grupo_7.sprint_1.utils.MockBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SellerServiceTest {

    @InjectMocks
    private SellerServiceImp sellerServiceImp;

    @Mock
    private BuyerRepositoryImp buyerRepository;

    @Mock
    private SellerRepositoryImp sellerRepository;

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Éxito")
    public void verifyDateFilterExistsCorrect() {
        Integer buyerId = 11;
        String order = "date_asc";
        List<Seller> lista = MockBuilder.mockSellers();
        Buyer buyer = MockBuilder.mockBuyerForSeller();

        when(buyerRepository.findBuyerById(buyerId)).thenReturn(buyer);
        when(sellerRepository.getAllSellers()).thenReturn(lista);

        List<PostDto> post = sellerServiceImp.getRecentPostsFromFollowedSellers(buyerId, order);
        assertEquals(post.size(), 3);
    }

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Excepción")
    public void verifyDateFilterExistsException() {
        Integer buyerId = 1;
        String order = "";
        when(buyerRepository.findBuyerById(buyerId)).thenReturn(new Buyer());
        assertThrows(BadRequestException.class, () -> sellerServiceImp.getRecentPostsFromFollowedSellers(buyerId, order));
    }

    @Test
    @DisplayName("T-0007: Verificar que la cantidad de seguidores de un determinado usuario sea correcta (US-0002) - Éxito")
    public void cantidadSeguidoresTest() {
        int userId = 1;
        SellerDTO expected = new SellerDTO();
        expected.setFollowerCount(10);

        when(sellerServiceImp.cantidadSeguidores(userId)).thenReturn(expected);

        SellerDTO actual = sellerServiceImp.cantidadSeguidores(userId);

        Assert.assertEquals(expected.getFollowerCount(), actual.getFollowerCount());
    }

    @Test
    @DisplayName("T-0006: Verificar que el tipo de ordenamiento por fecha ascendente sea correcto (US-0008)")
    public void verifyDateAscFilterIsCorrect() {
        Integer buyerId = 1;
        String order = "date_asc";
        List<Seller> sellers = MockBuilder.mockSellers();
        Buyer buyer = MockBuilder.mockBuyerForSeller();

        when(buyerRepository.findBuyerById(buyerId)).thenReturn(buyer);
        when(sellerRepository.getAllSellers()).thenReturn(sellers);

        List<PostDto> posts = sellerServiceImp.getRecentPostsFromFollowedSellers(buyerId, order);

        LocalDate lastDate = null;
        for(PostDto post : posts) {
            if(lastDate != null) {
                assertTrue(post.getDate().isAfter(lastDate));
            }
            lastDate = post.getDate();
        }
    }

    @Test
    @DisplayName("T-0006: Verificar que el tipo de ordenamiento por fecha descendente sea correcto (US-0008)")
    public void verifyDateDescFilterIsCorrect() {
        Integer buyerId = 1;
        String order = "date_desc";
        List<Seller> sellers = MockBuilder.mockSellers();
        Buyer buyer = MockBuilder.mockBuyerForSeller();

        when(buyerRepository.findBuyerById(buyerId)).thenReturn(buyer);
        when(sellerRepository.getAllSellers()).thenReturn(sellers);

        List<PostDto> posts = sellerServiceImp.getRecentPostsFromFollowedSellers(buyerId, order);

        LocalDate lastDate = null;
        for(PostDto post : posts) {
            if(lastDate != null) {
                assertTrue(post.getDate().isBefore(lastDate));
            }
            lastDate = post.getDate();
        }
    }
}
