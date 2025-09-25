

package com.Firstspring.product.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.ast.tree.cte.CteColumn;

@Entity
@Getter @Setter


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    @ManyToOne
    @JoinColumn(name="category_id" , nullable = false)
private Category category;



}
