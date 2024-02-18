package grupo_7.sprint_1.controller;

import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.service.BuyerServiceImp;
import grupo_7.sprint_1.service.IBuyerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerController {

    IBuyerService buyerService;

    public BuyerController(BuyerServiceImp buyerService) {
        this.buyerService = buyerService;
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> postPost(@RequestBody PostPostDto newPost) {
        return new ResponseEntity<>(buyerService.postPost(newPost), HttpStatus.OK);
    }
}
