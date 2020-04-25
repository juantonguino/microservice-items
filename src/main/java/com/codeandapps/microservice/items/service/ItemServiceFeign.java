/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeandapps.microservice.items.service;

import com.codeandapps.microservice.items.configuration.feignclients.IProductClientFeign;
import com.codeandapps.microservice.items.domain.Item;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author diego
 */
@Service("itemServiceFeign")
public class ItemServiceFeign implements IItemService{

    @Autowired
    @Qualifier("productFeingClient")
    private IProductClientFeign clientFeign;
    
    @Override
    public List<Item> findAll() {
        return clientFeign.getAll().stream().map(p-> new Item(1, p)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, int cuantity) {
        return new Item(0,clientFeign.getById(id));
    }
    
}
