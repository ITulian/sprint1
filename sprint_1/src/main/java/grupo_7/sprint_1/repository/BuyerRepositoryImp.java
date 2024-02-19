package grupo_7.sprint_1.repository;

import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BuyerRepositoryImp implements IBuyerRepository {

    Mapper mapper;
    private List<Post> postsList = new ArrayList<>();
    private List<Buyer> buyerList = new ArrayList<>();

    public BuyerRepositoryImp(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Post postPost(PostPostDto newPost) {
        Post post = mapper.convertPostDtoToPost(newPost);

        postsList.add(post);
        return post;
    }

    @Override
    public Buyer getFollowlist(int id) {
        return buyerList.get(id);
    }
}
