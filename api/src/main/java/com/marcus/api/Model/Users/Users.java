package com.marcus.api.Model.Users;

import java.math.BigDecimal;

import com.marcus.api.DTO.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String firstName;

    private String lastName;
    	
    @Column(unique=true) 
    private String document;
     
    @Column(unique=true)
    private String email;

    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public Users(UserDTO dto){
        this.firstName = dto.firstName();
        this.lastName = dto.lastName();
        this.document = dto.document();
        this.email = dto.email();
        this.password = dto.password();
        this.balance = dto.balance();
    }
}
