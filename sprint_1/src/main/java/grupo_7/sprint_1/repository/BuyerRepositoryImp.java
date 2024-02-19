package grupo_7.sprint_1.repository;

import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BuyerRepositoryImp implements IBuyerRepository {

    private List<Buyer> buyerList = new ArrayList<>();


    @Override
    public Buyer findBuyerById(Integer id) {
        return buyerList.stream()
                .filter(buyer -> buyer.getUserId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateBuyer(Buyer buyer) {
        buyerList.remove(buyer);
        buyerList.add(buyer);
    }
}