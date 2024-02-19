package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Buyer;

public interface IBuyerService {
    PostDto postPost(PostPostDto newPost);

    BuyerDto getBuyerfollow(int buyer);
}
