package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table
public class CakesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String price;
    private String imgURL;

    // Define the ManyToOne relationship with CategoryEntity
    @ManyToOne(fetch = FetchType.EAGER) // Use FetchType.LAZY for better performance
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnore // Ignore this property when serializing to JSON
    private CategoryEntity category;
}
