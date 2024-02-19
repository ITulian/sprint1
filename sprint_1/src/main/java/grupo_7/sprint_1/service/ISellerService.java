package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.dtos.SellerFollowersListDto;

public interface ISellerService {
    PostDto postPost(Integer sellerId, PostPostDto newPost);
    SellerFollowersListDto getListOrderedAlphabetically(Integer userId, boolean orderAsc);
}
