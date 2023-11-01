package com.marcus.api.DTO;

import java.math.BigDecimal;


public record TransactionDTO(BigDecimal value, Long senderId, Long receiverId) {
    
}
