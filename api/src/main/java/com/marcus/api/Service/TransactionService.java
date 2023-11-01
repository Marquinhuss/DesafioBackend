package com.marcus.api.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.marcus.api.DTO.TransactionDTO;
import com.marcus.api.Model.Transaction.Transaction;
import com.marcus.api.Model.Users.Users;
import com.marcus.api.Repository.TransactionRepository;
import com.marcus.api.TransactionExternHandler.TransactionHandler;

@Service
public class TransactionService {
    @Autowired
    private UserService service;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private TransactionHandler transactionHandler;

    @Autowired
    private RestTemplate restTemplate;

    public void transferToAcount(TransactionDTO transactionDTO) throws Exception{
        Users sender = this.service.findUserById(transactionDTO.senderId());
        Users receiver = this.service.findUserById(transactionDTO.receiverId());

        service.validateTransaction(sender, transactionDTO.value());

        if(this.authorizeTransaction()){
            Transaction transaction = new Transaction();
            transaction.setAmount(transactionDTO.value());
            transaction.setSender(sender);
            transaction.setReceiver(receiver);
            transaction.setTimestamp(LocalDateTime.now());

            sender.setBalance(sender.getBalance().subtract(transactionDTO.value()));
            receiver.setBalance(receiver.getBalance().add(transactionDTO.value()));

            this.repository.save(transaction);
            this.service.saveUser(sender);
            this.service.saveUser(receiver);

        }else{
            throw new Exception("Transação não autorizada");
        }
    }

    public boolean authorizeTransaction(){
        boolean status = transactionHandler.randomValidation();
        return status;
    }
}
