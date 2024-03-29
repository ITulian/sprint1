package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.GenericResponseDTO;
import grupo_7.sprint_1.dtos.MessageDto;

public interface IBuyerService {
    BuyerDto getBuyerfollow(Integer buyer, String order);

    GenericResponseDTO followSeller(Integer buyerId, Integer sellerId);

    MessageDto unfollowSeller(int idUser, int userIdToUnfollow);
}
