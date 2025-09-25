package com.Firstspring.product.dto;

import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor


// ^^^^^^^^^^^ This is essential!
public class CategoryDTO {


    private long id;
    private String name;
    private List<ProductDTO>products;

}
