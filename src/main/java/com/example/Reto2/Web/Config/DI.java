package com.example.Reto2.Web.Config;

import com.example.Reto2.Services.OrderProductService;
import com.example.Reto2.Services.OrderService;
import com.example.Reto2.Services.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class DI {
    @Bean
    ProductService createMovieService() {
        return new ProductService();
    }

    @Bean
    OrderService creatService() {
        return new OrderService();
    }
   

    @Bean
    OrderProductService creatOrder() {
        return new OrderProductService();
    }
   

    @Bean
    ModelMapper createModelMapper() {

        return new ModelMapper();
    }

    

}
