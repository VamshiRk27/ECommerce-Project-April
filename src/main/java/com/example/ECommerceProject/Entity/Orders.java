package com.example.ECommerceProject.Entity;

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
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String orderId;
    int totalOrderValue;
    Date orderedDate;
    String cardUsed;

    @ManyToOne
    @JoinColumn
    Customer customer;
    @OneToMany(mappedBy="orders",cascade=CascadeType.ALL)
    List<Item> items=new ArrayList<>();
}
