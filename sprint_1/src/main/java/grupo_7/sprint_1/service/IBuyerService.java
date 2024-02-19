package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.MessageDto;
import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Buyer;

public interface IBuyerService {
    BuyerDto getBuyerfollow(Integer buyer,String order);
    MessageDto unfollowSeller(int idUser, int userIdToUnfollow);
    BuyerDto getById(int id);
}
