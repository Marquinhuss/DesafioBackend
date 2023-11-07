package com.marcus.api.DTO;

import java.math.BigDecimal;

import org.hibernate.usertype.UserType;

public record UserDTO(String firstName, String lastName, String document, String email, String password, BigDecimal balance, UserType userType) {
    
}
