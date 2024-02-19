package grupo_7.sprint_1.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Product {
    Integer productId;
    String name;
    String type;
    String brand;
    String color;
    String notes;
}
