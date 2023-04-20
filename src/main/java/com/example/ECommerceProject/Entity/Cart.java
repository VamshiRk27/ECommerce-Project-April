package com.example.ECommerceProject.Entity;

import com.example.ECommerceProject.Enum.CardType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
// @Data contains @ToString , @ReqArgsConstructor , @Getter , @Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    Integer totalCost;
    Integer noOfItems;

    @OneToOne
    @JoinColumn
    Customer customer;

    @OneToMany(mappedBy="cart",cascade=CascadeType.ALL)
    List<Item> items=new ArrayList<>();
}
