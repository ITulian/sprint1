package grupo_7.sprint_1.controller;

import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.service.BuyerServiceImp;
import grupo_7.sprint_1.service.IBuyerService;
import grupo_7.sprint_1.service.ISellerService;
import grupo_7.sprint_1.service.SellerServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BuyerController {

    IBuyerService buyerService;

    public BuyerController(BuyerServiceImp buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping("/users/{userid}/followed/list")
    public ResponseEntity<?> getfollowedlist(@PathVariable Integer userid, @RequestParam String order) {
        return new ResponseEntity<>(buyerService.getBuyerfollow(userid,order), HttpStatus.OK);
    }
}
