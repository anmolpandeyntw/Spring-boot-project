package com.Firstspring.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
private Long categoryId ;// yeha C capital tha mai small kiya hu

}
