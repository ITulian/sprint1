package grupo_7.sprint_1.controller;

import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.dtos.SellerFollowersListDto;
import grupo_7.sprint_1.service.ISellerService;
import grupo_7.sprint_1.service.SellerServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SellerController {
    ISellerService sellerService;

    public SellerController(SellerServiceImp sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/products/post/{sellerId}")
    public ResponseEntity<?> postPost(@PathVariable(name = "seller_id") Integer sellerId,
                                      @RequestBody PostPostDto newPost) {
        return new ResponseEntity<>(sellerService.postPost(sellerId, newPost), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<SellerFollowersListDto> getFollowersList (@PathVariable Integer userId, boolean orderAsc){

        return ResponseEntity.ok(sellerService.getListOrderedAlphabetically(userId, orderAsc));
    }
}
