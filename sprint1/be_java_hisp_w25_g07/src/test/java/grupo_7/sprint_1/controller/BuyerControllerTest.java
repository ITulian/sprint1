package grupo_7.sprint_1.controller;

import grupo_7.sprint_1.dtos.MessageDto;
import grupo_7.sprint_1.service.BuyerServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BuyerControllerTest {

    @Mock
    BuyerServiceImp service;
    @InjectMocks
    BuyerController controller;

    @Test
    public void unfollowSellerTestOk() {
        // arrange
        int idUser = 11;
        int idUserUnfollow = 1;
        MessageDto devolucion = new MessageDto("Se eliminó de seguidores correctamente");
        when(service.unfollowSeller(anyInt(), anyInt())).thenReturn(devolucion);

        // act
        var obtained = controller.unfollowSeller(idUser, idUserUnfollow);

        // assert
        verify(service, atLeastOnce()).unfollowSeller(idUser, idUserUnfollow);
        Assertions.assertEquals(devolucion, obtained.getBody());
    }




}
