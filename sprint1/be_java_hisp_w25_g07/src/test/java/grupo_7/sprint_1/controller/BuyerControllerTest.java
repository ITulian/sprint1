package grupo_7.sprint_1.controller;

import grupo_7.sprint_1.service.BuyerServiceImp;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BuyerControllerTest {

    @Mock
    BuyerServiceImp service;
    @InjectMocks
    BuyerController controller;


}
