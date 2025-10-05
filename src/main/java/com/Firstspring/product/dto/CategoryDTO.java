package com.Firstspring.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Schema(
        name="Category",
        description = "It hold category information along with there product  "
)
@Data
@AllArgsConstructor
@NoArgsConstructor


// ^^^^^^^^^^^ This is essential!
public class CategoryDTO {


    private long id;
    private String name;
    private List<ProductDTO>products;

}
