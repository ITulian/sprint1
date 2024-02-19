package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.User;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.repository.IBuyerRepository;
import grupo_7.sprint_1.repository.ISellerRepository;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service
public class BuyerServiceImp implements IBuyerService {
    IBuyerRepository buyerRepository;

    @Override
    public BuyerDto getBuyerfollow(Integer id,String order) {
        Buyer buyer = buyerRepository.getFollowlist(id);
        if (buyer == null){
            throw new NotFoundException("el id ingresado no corresponde a ningun comprador");
        }
        if (order.equals("name_asc")){
            buyer.setFollowed(buyer.getFollowed().stream().sorted(Comparator.comparing(User::getUserName)).toList());
            return Mapper.convertBuyertoBuyerDto(buyer);
        }
        if(order.equals("name_desc")){
            buyer.setFollowed(buyer.getFollowed().stream().sorted(Comparator.comparing(User::getUserName)).toList().reversed());
            return Mapper.convertBuyertoBuyerDto(buyer);
        }
        return null;
    }
}
