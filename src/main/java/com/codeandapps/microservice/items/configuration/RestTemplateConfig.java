/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeandapps.microservice.items.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author diego
 */
@Configuration
public class RestTemplateConfig {
    
    @Bean("clientRestTemplate")
    @LoadBalanced
    public RestTemplate registerRestTemplate(){
        return new RestTemplate();
    }
}
