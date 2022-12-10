package com.bt_akademi.user_management.channel.repository;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

// ****19 -> AbstractTransactionService
public interface TransactionCallable
{
    @GET("api/transaction/{userID}")
    Call<List<JsonElement>> getAllTransactionsOfUser(@Path("userID") Integer userID);

    @GET("api/transaction")
    Call<List<JsonElement>> getAll();

    @DELETE("api/transaction/delete/{transactionID}")
    Call<Void> deleteByID(@Path("transactionID") Integer transactionID);

    @POST("api/transaction")
    Call<JsonElement> save(@Body JsonElement transaction);
}
