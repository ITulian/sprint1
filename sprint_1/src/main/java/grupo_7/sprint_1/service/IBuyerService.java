package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;

public interface IBuyerService {
    PostDto postPost(PostPostDto newPost);
}
