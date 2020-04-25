/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeandapps.microservice.items.configuration.feignclients;

import com.codeandapps.microservice.items.domain.Product;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author diego
 */
@FeignClient(name="microservice-products", qualifier = "productFeingClient")
public interface IProductClientFeign {
    
    @GetMapping("product/")
    public List<Product> getAll();
    
    @GetMapping(path = {"product/{id}"})
    public Product getById(@PathVariable Long id);
}
