package grupo_7.sprint_1.service;

import grupo_7.sprint_1.controller.BuyerController;
import grupo_7.sprint_1.exception.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BuyerServiceTest {

    @Mock
    BuyerServiceImp service;
    @InjectMocks
    BuyerController controller;

    @Test
    public void getFollowedListOrderExistenceOKTest() {
        int id = 1;
        String order = "name_asc";

        try {
            service.getBuyerfollow(id, order);
        } catch (BadRequestException e) {
            Assert.assertEquals("No deberia tirar excepcion", e.getMessage());
        }
    }

    @Test
    public void getFollowedListOrderExistenceBadTest() {
        int id = 1;
        String order = "";
        try {
            service.getBuyerfollow(id, order);
        } catch (BadRequestException e) {
            Assert.assertEquals("No se ha ingresado una opción de ordenamiento válida", e.getMessage());
        }
    }
}
