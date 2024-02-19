package grupo_7.sprint_1.repository;

import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Seller;

public interface ISellerRepository {
    Post postPost(Integer sellerId, PostPostDto newPost);
    Seller findById (Integer userId);
    int cantidadDeSeguidores(int userId);


}
