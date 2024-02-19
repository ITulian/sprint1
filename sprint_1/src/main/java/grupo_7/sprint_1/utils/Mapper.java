package grupo_7.sprint_1.utils;

import grupo_7.sprint_1.dtos.*;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Product;
import grupo_7.sprint_1.entity.Seller;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    public static PostDto convertPostToPostDto(Post post) {
        return new PostDto(
                convertProductToProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.getDate()
        );
    }

    public static ProductDto convertProductToProductDto(Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }

    public static Post convertPostDtoToPost(PostPostDto newPost) {
        return new Post(
                convertProductDtoToProduct(newPost.product()),
                newPost.category(),
                newPost.price(),
                newPost.date()
        );
    }

    private static Product convertProductDtoToProduct(ProductDto product) {
        return new Product(
                product.productId(),
                product.productName(),
                product.type(),
                product.brand(),
                product.color(),
                product.notes()
        );
    }

    public static BuyerDto convertBuyertoBuyerDto(Buyer buyer) {
        return new BuyerDto(
                buyer.getUserId(),
                buyer.getUserName(),
                buyer.getFollowed()
        );
    }
    public static SellerDTO convertSellerToSllerDTO(Seller seller, int cantidadDeSeguidores) {
        return new SellerDTO(
                seller.getUserId(),
                seller.getUserName(),
                cantidadDeSeguidores
        );
    }
//    public static Link createLink(RequestCreateLinkDTO linkDto, Integer id) {
//        return Link.builder()
//                .linkId(id)
//                .url(linkDto.getUrl())
//                .password(linkDto.getPassword())
//                .build();
//    }
//
//    public static LinkResponseDTO createLinkResponseDTO(Link link) {
//        return LinkResponseDTO.builder()
//                .linkId(link.getLinkId())
//                .url(link.getUrl())
//                .password(link.getPassword())
//                .timesVisited(link.getTimesVisited())
//                .build();
//    }

    public static BuyerDtoRequisito3 convertListToDto (Buyer buyerList){
        return new BuyerDtoRequisito3(buyerList.getUserId(),buyerList.getUserName());
    }
}

