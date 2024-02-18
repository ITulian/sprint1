package grupo_7.sprint_1.repository;

import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Post;

public interface IBuyerRepository {

    Post postPost(PostPostDto newPost);
}
