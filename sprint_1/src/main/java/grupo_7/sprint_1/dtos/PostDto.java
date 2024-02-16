package grupo_7.sprint_1.dtos;

import grupo_7.sprint_1.entity.Product;

import java.time.LocalDate;

public record PostDto(
        Product product,
        int category,
        Double price,
        LocalDate date
) {

}
