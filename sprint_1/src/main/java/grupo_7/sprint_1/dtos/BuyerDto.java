package grupo_7.sprint_1.dtos;

import grupo_7.sprint_1.entity.Seller;

import java.util.List;


public record BuyerDto(
        int userId,
        String userName,
        List<Seller> sellerList
) {
}
