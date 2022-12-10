package com.bt_akademi.user_management.model.service;

import com.bt_akademi.user_management.channel.utility.RetrofitUtil;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Service;

import java.util.List;

// ****21 -> TransactionController
@Service
public class TransactionService extends AbstractTransactionService
{
    @Override
    public List<JsonElement> findAllByUserID(Integer userID)
    {
        return RetrofitUtil.callGenericBlock( transactionCallable.getAllTransactionsOfUser(userID) );

    }

    @Override
    public List<JsonElement> getAll()
    {
        return RetrofitUtil.callGenericBlock( transactionCallable.getAll() );
    }

    @Override
    public void deleteById(Integer transactionID)
    {
        RetrofitUtil.callGenericBlock( transactionCallable.deleteByID(transactionID) );
    }

    @Override
    public JsonElement save(JsonElement transaction)
    {
        return RetrofitUtil.callGenericBlock( transactionCallable.save(transaction) );
    }
}
