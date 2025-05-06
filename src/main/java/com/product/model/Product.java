package com.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "product_table")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long productId;
    @Column(name = "p_name")
    private String productName;
    @Column(name = "p_price")
    private Double productPrice;
    @Column(name = "p_quantity")
    private Integer productQuantity;
}
