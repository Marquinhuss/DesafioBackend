package com.marcus.api.TransactionExternHandler;

import java.util.Random;

public class TransactionHandler {
    
    public boolean randomValidation(){
        Random randomNumber = new Random();
        float value = randomNumber.nextFloat() * 100;

        boolean authorized = true;

        boolean denied = false;

        if(value > 50){
            return authorized;
        }else{
            return denied;
        }
    }
}
