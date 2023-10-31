package com.marcus.api.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcus.api.Model.Users.UserType;
import com.marcus.api.Model.Users.Users;
import com.marcus.api.Repository.UsersRepository;

@Service
public class UserService {
    
    @Autowired
    private UsersRepository repository;

    public void validateTransaction(Users sender, BigDecimal amount) throws Exception{
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usúario do tipo lojista não pode realizar uma transação");
        }   

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("O valor da transação é menor do que o saldo disponível em conta");
        }
    }

    public Users findUserById(Long Id) throws Exception{
        return this.repository.findById(Id).orElseThrow(() -> new Exception("Usuário não encontrado"));

    }

    public void saveUser(Users user){
        repository.save(user);
    }
}
