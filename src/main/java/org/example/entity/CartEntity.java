package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Cart ID")
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private CommonEntity commonEntity;

    @Column(name = "quantity")
    private int qty;

    @Column(name = "product_total")
    private double productTot;

    @Column(name = "is_complete")
    private boolean isComplete;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_img_url")
    private String productImgURL;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private UserEntity userEntity;
}
