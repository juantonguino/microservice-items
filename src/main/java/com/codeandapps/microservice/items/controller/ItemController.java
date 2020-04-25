/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeandapps.microservice.items.controller;

import com.codeandapps.microservice.items.domain.Item;
import com.codeandapps.microservice.items.domain.Product;
import com.codeandapps.microservice.items.service.IItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 *
 * @author diego
 */
@RestController
@RequestMapping("item")
public class ItemController {
    
    @Autowired
    @Qualifier("itemServiceRestTemplate")
    private  IItemService itemServiceRestTemplate;
    
    @Autowired
    @Qualifier("itemServiceFeign")
    private  IItemService itemServiceFeign;
    
    @GetMapping(path = {"resttemplate","resttemplate/"})
    public List<Item> getAll(){
        return itemServiceRestTemplate.findAll();
    }
    
    @GetMapping("resttemplate/{id}")
    public Item getById(@PathVariable Long id){
        return itemServiceRestTemplate.findById(id, 1);
    }
    
    @GetMapping(path = {"feign","feign/"})
    public List<Item> getAllFeign(){
        return itemServiceFeign.findAll();
    }
    
    //@HystrixCommand( fallbackMethod = "fallGetByIdFeign")
    @GetMapping("feign/{id}")
    public Item getByIdFeign(@PathVariable Long id){
        return itemServiceFeign.findById(id, 1);
    }
    
    public Item fallGetByIdFeign(Long id){
        return new Item(0,new Product());
    }
}
