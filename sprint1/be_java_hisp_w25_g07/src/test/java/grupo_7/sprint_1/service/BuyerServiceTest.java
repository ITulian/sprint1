package grupo_7.sprint_1.service;

import grupo_7.sprint_1.controller.BuyerController;
import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.MessageDto;
import grupo_7.sprint_1.dtos.SellerDTO;
import grupo_7.sprint_1.dtos.SellerListDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.exception.BadRequestException;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.repository.BuyerRepositoryImp;
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
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BuyerServiceTest {

    /*@Mock
    BuyerServiceImp service;
    @InjectMocks
    BuyerController controller; */

    @Mock
    BuyerRepositoryImp buyerRepositoryImp;

    @InjectMocks
    BuyerServiceImp buyerServiceImp;

    @Test
    @DisplayName("unfollow test ok")
    public void unfollowSellerTestOk(){
        // arrange
        int idUsuario = 11;
        int idUnfollow = 1;

        Seller seller = new Seller();
        seller.setUserId(1);
        List<Seller> vendedoresSeguidos = new ArrayList<>();
        vendedoresSeguidos.add(seller);

        Buyer buyer = new Buyer();
        //buyer.setUserId(11);
        buyer.setFollowed(vendedoresSeguidos);

        Mockito.when(buyerRepositoryImp.findBuyerById(idUsuario)).thenReturn(buyer);

        MessageDto devolucion = new MessageDto("Se eliminó de seguidores correctamente");

        // act
        var obtained = buyerServiceImp.unfollowSeller(idUsuario, idUnfollow);

        // assert
        Assertions.assertEquals(devolucion, obtained);
    }

    @Test
    @DisplayName("unfollow test bad comprador no existe") // cambiar el repo getById por el otro q es igual.
    public void unfollowSelleNoExistBuyerBadTest() {
        // arrange
        int idUsuario = 111;
        int idUnfollow = 1;

        // act & assert
        Mockito.when(buyerRepositoryImp.findBuyerById(idUsuario)).thenReturn(null);

        Assertions.assertThrows(NotFoundException.class,
                () -> buyerServiceImp.unfollowSeller(idUsuario, idUnfollow));

    }

    @Test
    @DisplayName("unfollow bad test seller no existe")
    public void unfollowSelleNoExistFollowedBadTest () {
        // arrange
        int idUsuario = 11;
        int idUnfollow = 1;

        Buyer buyer = new Buyer();
        buyer.setFollowed(Collections.emptyList());

        // act & assert
        Mockito.when(buyerRepositoryImp.findBuyerById(idUsuario)).thenReturn(buyer);

        Assertions.assertThrows(NotFoundException.class,
                () -> buyerServiceImp.unfollowSeller(idUsuario, idUnfollow));

    }

    @Test
    @DisplayName("T-0003: Verificar que el tipo de ordenamiento alfabético exista (US-0008) - Éxito")
    public void getFollowedListOrderExistenceOKTest() {
//        int id = 1;
//        String order = "name_asc";
//
//        try {
//            buyerServiceImp.getBuyerfollow(id, order);
//        } catch (BadRequestException e) {
//            Assert.assertEquals("No deberia tirar excepcion", e.getMessage());
//        }

        // arrange
        Integer id = 11;
        String order = "name_asc";

        List<Seller> vendedoresSeguidos = new ArrayList<>();
        Seller seller = new Seller();
        seller.setUserId(1);
        seller.setUserName("carlos");
        vendedoresSeguidos.add(seller);

        Seller seller2 = new Seller();
        seller2.setUserId(2);
        seller2.setUserName("zara");
        vendedoresSeguidos.add(seller2);

        Buyer buyer = new Buyer();
        buyer.setUserId(11);
        buyer.setUserName("sergio");
        buyer.setFollowed(vendedoresSeguidos);

        SellerListDto sellerListDto = new SellerListDto(1, "carlos");
        SellerListDto sellerListDto2 = new SellerListDto(2, "zara");
        List<SellerListDto> listSellerDto = new ArrayList<>();
        listSellerDto.add(sellerListDto);
        listSellerDto.add(sellerListDto2);


        BuyerDto buyerDtoDevolucion = new BuyerDto(11, "sergio", listSellerDto);
        when(buyerRepositoryImp.findBuyerById(id)).thenReturn(buyer);

        // act
        var obtained = buyerServiceImp.getBuyerfollow(id, order);

        // assert
        Assertions.assertEquals(buyerDtoDevolucion, obtained);

    }

    @Test
    @DisplayName("T-0003: Verificar que el tipo de ordenamiento alfabético exista (US-0008) - Excepción")
    public void getFollowedListOrderExistenceBadTest() {
        int id = 1;
        String order = "";
        try {
            buyerServiceImp.getBuyerfollow(id, order);
        } catch (BadRequestException e) {
            Assert.assertEquals("No se ha ingresado una opción de ordenamiento válida", e.getMessage());
        }
    }
}
