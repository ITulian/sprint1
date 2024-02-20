package grupo_7.sprint_1.controller;

import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.dtos.SellerDTO;
import grupo_7.sprint_1.dtos.SellerFollowersListDto;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.service.ISellerService;
import grupo_7.sprint_1.service.SellerServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    ISellerService sellerService;

    public SellerController(SellerServiceImp sellerService) {
        this.sellerService = sellerService;
    }

    //TODO: anda (gracias dios)
    @PostMapping("/products/post")
    public ResponseEntity<?> postPost(@RequestBody PostPostDto newPost) {
        return new ResponseEntity<>(sellerService.postPost(newPost.userId(), newPost), HttpStatus.OK);
    }

    //TODO: ANDA XD
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<SellerFollowersListDto> getFollowersList(@PathVariable Integer userId, boolean orderAsc) {

        return ResponseEntity.ok(sellerService.getListOrderedAlphabetically(userId, orderAsc));
    }

    @GetMapping("/users/allsellers")
    public ResponseEntity<?> getAllSellers() {
        return ResponseEntity.ok(sellerService.getAllSellers());
    }

    //TODO: ANDA
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<SellerDTO> getFollowersCount(@PathVariable int userId) {
        try {
            SellerDTO sellerDTO = sellerService.cantidadSeguidores(userId);
            return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<List<PostDto>> getRecentPostsFromFollowedSellers(@PathVariable Integer userId) {
        List<PostDto> posts = sellerService.getRecentPostsFromFollowedSellers(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
