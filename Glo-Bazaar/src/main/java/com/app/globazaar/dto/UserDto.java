package com.app.globazaar.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto {
    private Long id;
    @NotEmpty
    @Size(min = 5,message = "Username should have minimum 6 characters")
    private String username;
    @Email(message = "Please provide a valid email")
    private String email;
    @NotEmpty
    @Size(min = 6,message = "Password should have minimum 6 characters")
    private String password;
    private List<ProductDto> products;
}