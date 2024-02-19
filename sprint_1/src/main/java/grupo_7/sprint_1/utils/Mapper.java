package grupo_7.sprint_1.utils;

import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.dtos.ProductDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Product;
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
                product.getProductName(),
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
                buyer.getSellerList()
        );
    }
}

