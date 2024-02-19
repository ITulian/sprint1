package grupo_7.sprint_1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BuyerRepositoryImp implements IBuyerRepository {

    private List<Buyer> buyerList = new ArrayList<>();

   /* public BuyerRepositoryImp(Mapper mapper) throws IOException {
        this.mapper = mapper;
        this.buyerList = loadBuyers();
    }*/

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

    // busco la lista de los seguidos del comrpador por ID
    @Override
    public Buyer getById(int id) {
        Buyer buyer = buyerList.stream()
                .filter(buyerFilter -> buyerFilter.getUserId() == id)
                .findFirst()
                .orElse(null);

        if(buyer == null) {
            throw new NotFoundException("No se encuentra el id del comprador");
        }
        return buyer;
        // buyerDto.setSellerList(buyer.getSellerList());


        //return buyerDto;
    }

    private List<Buyer> loadBuyers() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Buyer> mappedBuyers;

        file = ResourceUtils.getFile("classpath:buyers.json");
        mappedBuyers = objectMapper.readValue(file, new TypeReference<List<Buyer>>() {
        });

        return mappedBuyers;
    }

}
