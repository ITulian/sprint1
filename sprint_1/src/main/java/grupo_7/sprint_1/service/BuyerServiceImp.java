package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.repository.IBuyerRepository;
import grupo_7.sprint_1.repository.ISellerRepository;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyerServiceImp implements IBuyerService {
    IBuyerRepository buyerRepository;

    @Override
    public BuyerDto getBuyerfollow(Integer id) {
        Buyer buyer = buyerRepository.getFollowlist(id);
        return Mapper.convertBuyertoBuyerDto(buyer);
    }
}
