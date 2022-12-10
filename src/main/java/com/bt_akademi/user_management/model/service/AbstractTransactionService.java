package com.bt_akademi.user_management.model.service;

import com.bt_akademi.user_management.channel.repository.ProductCallable;
import com.bt_akademi.user_management.channel.repository.TransactionCallable;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// ****20 -> TransactionService
public abstract class AbstractTransactionService implements EntityService<JsonElement, Integer>
{
    @Autowired
    protected TransactionCallable transactionCallable;

    public abstract List<JsonElement> findAllByUserID(Integer userID);
}
