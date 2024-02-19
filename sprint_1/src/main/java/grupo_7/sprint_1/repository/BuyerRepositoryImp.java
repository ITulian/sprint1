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
    Mapper mapper;
    private List<Buyer> buyerList = new ArrayList<>();

    public BuyerRepositoryImp(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Buyer getFollowlist(Integer id) {
        return buyerList.get(id);
    }
}
