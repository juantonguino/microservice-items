/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeandapps.microservice.items.service;

import com.codeandapps.microservice.items.domain.Item;
import com.codeandapps.microservice.items.domain.Product;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author diego
 */
@Service("itemServiceRestTemplate")
public class ItemServiceRestTemplate implements IItemService{

    @Autowired
    @Qualifier("clientRestTemplate")
    private RestTemplate clientetRestTemplate;
    
    @Override
    public List<Item> findAll() {
        Product[] response = clientetRestTemplate.getForObject("http://microservice-products/product/", Product[].class);
        List<Product> listProducts = Arrays.asList(response);
        List<Item> retorno = listProducts.stream().map(p->new Item(1,p)).collect(Collectors.toList());
        return retorno;
    }

    @Override
    public Item findById(Long id, int cuantity) {
        Map<String,String> parameter= new HashMap<String,String>();
        parameter.put("id",id.toString() );
        Product response = clientetRestTemplate.getForObject("http://microservice-products/product/{id}", Product.class, parameter);
        if(response==null){
           return null;
        }
        else {
            return new Item(1, response);
        }
    }
    
}
