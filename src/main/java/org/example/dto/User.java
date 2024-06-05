package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {
//    private String firstName;
//    private String lastName;
//    private Long id;
    private Long userId;
    private String userName;
    private String address;
    private String email;
    private String contact;
    private String password;
    private String verify;
}
