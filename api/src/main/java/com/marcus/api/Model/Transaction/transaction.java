package com.marcus.api.Model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.marcus.api.Model.Users.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity(name="Transaction")
@Table(name="Transaction")
@Data
@Getter
@Setter
@EqualsAndHashCode(of="id")
@AllArgsConstructor
public class Transaction {
    
    public Transaction() {
    }

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

    public void setTimestamp(LocalDateTime now) {
    }
    
}
