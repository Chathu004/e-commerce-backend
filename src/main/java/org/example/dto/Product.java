package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Product {
    private Long id;
    private String name;
    private String description;
    private String price;
    private String imgURL;

    private Long categoryId;
}
