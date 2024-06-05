package org.example.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Cart {
    private Long cartId;
    private Long id;
    private int qty;
    private double productTot;
    private Long userId;

    private String productName;
    private String productImgURL;
}
