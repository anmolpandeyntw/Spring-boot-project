package com.Firstspring.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name="Product",
        description = "It hold product  information.  "
)
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
private Long categoryId ;// yeha C capital tha mai small kiya hu

}
