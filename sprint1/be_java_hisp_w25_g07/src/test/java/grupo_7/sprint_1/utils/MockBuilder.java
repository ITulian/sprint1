package grupo_7.sprint_1.utils;

import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Product;
import grupo_7.sprint_1.entity.Seller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockBuilder {
    public static Buyer buildMockBuyer() {
        return new Buyer(
                1,
                "Buyer_1",
                List.of()
        );
    }

    public static List<Seller> mockSellers() {
        List<Seller> sellers = new ArrayList<>();
        Seller seller = new Seller();
        seller.setUserId(1);
        seller.setFollowers(List.of(new Buyer()));
        seller.setPosts(List.of(new Post(new Product(), 1, 100.0, LocalDate.now().minusDays(2)),
                new Post(new Product(), 2, 200.0, LocalDate.now().minusDays(3)),
                new Post(new Product(), 3, 300.0, LocalDate.now().minusDays(4))));
        sellers.add(seller);
        return sellers;
    }

    public static Buyer mockBuyerForSeller(){
        Seller seller = new Seller();
        seller.setUserId(1);
        return new Buyer(1,"Buyer_1",List.of(seller));
    }
}
