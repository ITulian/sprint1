package grupo_7.sprint_1.utils;

import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.dtos.ProductDto;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Product;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    public PostDto convertPostToPostDto(Post post) {
        return new PostDto(
                convertProductToProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.getDate()
        );
    }

    private ProductDto convertProductToProductDto(Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }

    public Post convertPostDtoToPost(PostPostDto newPost) {
        return new Post(
                convertProductDtoToProduct(newPost.product()),
                newPost.category(),
                newPost.price(),
                newPost.date()
        );
    }

    private Product convertProductDtoToProduct(ProductDto product) {
        return new Product(
                product.productId(),
                product.productName(),
                product.type(),
                product.brand(),
                product.color(),
                product.notes()
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

}

