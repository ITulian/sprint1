package grupo_7.sprint_1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class SellerRepositoryImp implements ISellerRepository {

    Mapper mapper;
    private List<Seller> sellers = new ArrayList<>();

    public SellerRepositoryImp(Mapper mapper) throws IOException {
        this.mapper = mapper;
        this.sellers = loadSellers();
    }

    @Override
    public Post postPost(Integer sellerId, PostPostDto newPost) {
        Post post = Mapper.convertPostDtoToPost(newPost);

        Optional<Seller> foundSeller = findById(sellerId);
        foundSeller.get().getPosts().add(post);

        return post;
    }

    public Optional<Seller> findById(Integer userId) {
        return sellers.stream()
                .filter(seller -> seller.getUserId().equals(userId))
                .findFirst();
    }

    public int cantidadDeSeguidores(int userId) {
        return sellers.stream()
                .filter(seller -> seller.getUserId() == userId)
                .findFirst()
                .map(seller -> seller.getFollowers().size())
                .orElse(0);
    }

    private List<Seller> loadSellers() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Seller> mappedSellers;

        file = ResourceUtils.getFile("classpath:sellers.json");
        mappedSellers = objectMapper.readValue(file, new TypeReference<List<Seller>>() {
        });

        return mappedSellers;
    }

}

