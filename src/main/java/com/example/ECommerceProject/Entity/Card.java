package com.example.ECommerceProject.Entity;

import com.example.ECommerceProject.Enum.CardType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
// @Data contains @ToString , @ReqArgsConstructor , @Getter , @Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@Table(name="card")
public class Card {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @Column(unique=true,nullable=false)
    String cardNo;
    int cvv;
    Date expiryDate;

    @Enumerated(EnumType.STRING)
    CardType cardType;

    @ManyToOne
    @JoinColumn
    Customer customer;
}
