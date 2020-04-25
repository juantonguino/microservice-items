/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeandapps.microservice.items.service;

import com.codeandapps.microservice.items.domain.Item;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IItemService {
    
    public List<Item> findAll();
    
    public Item findById(Long id, int cuantity);
}
