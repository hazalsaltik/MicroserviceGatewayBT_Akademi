package com.bt_akademi.user_management.controller;

import com.bt_akademi.user_management.model.service.AbstractProductService;
import org.hibernate.query.internal.AbstractProducedQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping
@RestController("gateway/product")

public class ProductController
{

    private AbstractProductService productService;

}
