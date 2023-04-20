package com.example.ECommerceProject.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
// @Data contains @ToString , @ReqArgsConstructor , @Getter , @Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String name;
    String emailId;
    Integer age;
    String mobNo;
    String address;

    @OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
    List<Card> cards=new ArrayList<>();

    @OneToOne(mappedBy="customer",cascade=CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
    List<Orders> ordersList=new ArrayList<>();
}
