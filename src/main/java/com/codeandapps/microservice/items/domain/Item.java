/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeandapps.microservice.items.domain;

/**
 *
 * @author diego
 */
public class Item {
    
    public int cuatity;
    
    public Product product;

    public Item() {
    }
    
    public Item(int cuatity, Product product) {
        this.cuatity = cuatity;
        this.product = product;
    }

    public int getCuatity() {
        return cuatity;
    }

    public void setCuatity(int cuatity) {
        this.cuatity = cuatity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public double getTotal(){
        return this.cuatity*product.getPrecio();
    }
    
}
