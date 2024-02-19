package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.repository.IBuyerRepository;
import grupo_7.sprint_1.repository.ISellerRepository;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImp implements ISellerService {
    ISellerRepository sellerRepository;

    public SellerServiceImp(ISellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public PostDto postPost(int sellerId, PostPostDto newPost) {
        isPostValid(newPost);
        Post post = sellerRepository.postPost(sellerId, newPost);
        return Mapper.convertPostToPostDto(post);
    }

    private void isPostValid(PostPostDto newPost) {
    }
}
