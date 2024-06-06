package org.example.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Common {
    private Long id;
    private String name;
    @Size(max = 65535)
    private String description;
    private String price;
    private String imgURL;

    private Long categoryId;
}
