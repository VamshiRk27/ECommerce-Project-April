package com.example.ECommerceProject.Entity;

import com.example.ECommerceProject.Enum.ProductCategory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
// @Data contains @ToString , @ReqArgsConstructor , @Getter , @Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String name;
    int price;
    int quantity;

    @Enumerated(EnumType.STRING)
    ProductCategory category;

    @ManyToOne
    @JoinColumn
    Seller seller;
}
