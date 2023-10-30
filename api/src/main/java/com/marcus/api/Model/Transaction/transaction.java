package com.marcus.api.Model.Transaction;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import com.marcus.api.Model.Users.Users;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity(name="Transaction")
@Table(name="Transacition")
@Data
@Getter
@Setter
@EqualsAndHashCode(of="id")
@AllArgsConstructor
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private Users sender;

    @ManyToOne
    @JoinColumn(name="receiver_id")
    private Users receiver;
    
}
