package com.bt_akademi.user_management.model.service;

import java.util.List;

public interface EntityService<E, I>
{
    List<E> getAll();

    E save(E entity);

    void deleteById(I id);
}

