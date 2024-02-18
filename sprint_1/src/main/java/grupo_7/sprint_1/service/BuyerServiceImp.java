package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.repository.IBuyerRepository;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyerServiceImp implements IBuyerService {
    IBuyerRepository buyerRepository;
    Mapper mapper;

    public BuyerServiceImp(IBuyerRepository buyerRepository, Mapper mapper) {
        this.buyerRepository = buyerRepository;
        this.mapper = mapper;
    }

    @Override
    public PostDto postPost(PostPostDto newPost) {
        isPostValid(newPost);
        Post post = buyerRepository.postPost(newPost);
        return mapper.convertPostToPostDto(post);
    }

    private void isPostValid(PostPostDto newPost) {
    }
}
