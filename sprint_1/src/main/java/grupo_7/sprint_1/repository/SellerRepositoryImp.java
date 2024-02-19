package grupo_7.sprint_1.repository;

import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class SellerRepositoryImp implements ISellerRepository {

    Mapper mapper;
    private List<Seller> sellers = new ArrayList<>();

    public SellerRepositoryImp(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Post postPost(Integer sellerId, PostPostDto newPost) {
        Post post = Mapper.convertPostDtoToPost(newPost);

        Seller s = new Seller();
        for (Seller se : sellers) {
            if (Objects.equals(se.getUserId(), sellerId)) {
                se.getPosts().add(post);
            }
        }

        return post;
    }

    public Seller findById(Integer userId) {
        return sellers.stream()
                .filter(seller -> seller.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Seller not found with ID: " + userId));
    }
    public int cantidadDeSeguidores(int userId) {
        for (Seller seller : sellers) {
            if (seller.getUserId() == userId) {
                return seller.getFollowers().size();
            }
        }
        return 0;
    }

}

