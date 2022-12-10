package com.bt_akademi.user_management.model.service;

import com.bt_akademi.user_management.channel.repository.ProductCallable;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;

// ****14 -> ProductServiceCallable
public abstract class AbstractProductService implements EntityService<JsonElement, Integer>
{
    @Autowired
    protected ProductCallable productCallable;
}
