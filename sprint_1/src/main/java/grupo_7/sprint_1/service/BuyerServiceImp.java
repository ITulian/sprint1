package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.repository.IBuyerRepository;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyerServiceImp implements IBuyerService {
    IBuyerRepository buyerRepository;


    @Override
    public PostDto postPost(PostPostDto newPost) {
        isPostValid(newPost);
        Post post = buyerRepository.postPost(newPost);
        return Mapper.convertPostToPostDto(post);
    }

    @Override
    public BuyerDto getBuyerfollow(int id) {
        Buyer buyer = buyerRepository.getFollowlist(id);

        return Mapper.convertBuyertoBuyerDto(buyer);
    }

    private void isPostValid(PostPostDto newPost) {
    }
}
