package grupo_7.sprint_1.repository;

import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SellerRepositoryImp implements ISellerRepository {

    Mapper mapper;
    private List<Seller> sellers = new ArrayList<>();

    public SellerRepositoryImp(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Post postPost(Integer sellerId, PostPostDto newPost) {
        Post post = mapper.convertPostDtoToPost(newPost);

        Seller s = new Seller();
        for (Seller se : sellers) {
            if (se.getUserId() == sellerId) {
                se.getPostList().add(post);
            }
        }

        return post;
    }
}
