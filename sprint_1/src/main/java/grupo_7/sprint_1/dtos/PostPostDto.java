package grupo_7.sprint_1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record PostPostDto(
        @JsonProperty("user_id") Integer userId,
        @JsonProperty("date") LocalDate date,
        @JsonProperty("product") ProductDto product,
        @JsonProperty("category") Integer category,
        @JsonProperty("price") Double price

) {
    /*
    "user_id": 123,
    "date": "29-04-2021",
    "product": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50
    */
}
