package grupo_7.sprint_1.utils;

import grupo_7.sprint_1.entity.Buyer;

import java.util.ArrayList;
import java.util.List;

public class MockBuilder {
    public static Buyer buildMockBuyer() {
        return new Buyer(
                11,
                "Buyer_11",
                List.of()
        );
    }
}
