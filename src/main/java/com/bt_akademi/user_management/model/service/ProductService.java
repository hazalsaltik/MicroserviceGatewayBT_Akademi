package com.bt_akademi.user_management.model.service;

import com.bt_akademi.user_management.channel.utility.RetrofitUtil;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Service;

import java.util.List;

// ****18 -> TransactionCallable
@Service
public class ProductService extends AbstractProductService
{
    @Override
    public List<JsonElement> getAll()
    {
        return RetrofitUtil.callGenericBlock( productCallable.getAll() );
    }

    @Override
    public void deleteById(Integer productID)
    {
        RetrofitUtil.callGenericBlock( productCallable.deleteByID(productID) );
    }

    // ****16 -> RetrofitUtil
    @Override
    public JsonElement save(JsonElement product)
    {
        return RetrofitUtil.callGenericBlock( productCallable.save(product) );
    }

}
