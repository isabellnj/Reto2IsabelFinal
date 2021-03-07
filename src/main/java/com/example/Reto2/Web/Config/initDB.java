package com.example.Reto2.Web.Config;

import com.example.Reto2.Repositories.Entities.Order;
import com.example.Reto2.Repositories.Entities.OrderProduct;
import com.example.Reto2.Repositories.Entities.Product;
import com.example.Reto2.Repositories.Entities.Order.estados;
import com.example.Reto2.Repositories.Interfaces.OrderProductRepository;
import com.example.Reto2.Repositories.Interfaces.OrderRepository;
import com.example.Reto2.Repositories.Interfaces.ProductRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class initDB {
    @Bean
    CommandLineRunner initDatabase(ProductRepository repository, OrderRepository repository2, OrderProductRepository repository3) {
        return args -> {
            repository2.save( new Order("20/11/2020", "isabel", estados.CANCELADO));
            repository2.save( new Order("20/11/2020", "pilar", estados.CANCELADO));
            repository2.save( new Order("20/11/2020", "nuria", estados.CANCELADO));
            repository2.save( new Order("20/11/2020", "marina", estados.CANCELADO));
            repository.save( new Product("helado", 2, "helado.jpg"));
            repository.save( new Product("avena", 3, "avena.jpg" ));
            repository.save( new Product("yogur de avena", 4, "avena.jpg"));
            repository.save( new Product("yogur de helado", 5, "helado.jpg"));
            repository.save( new Product("helado de avena", 5, "helado.jpg"));
            repository3.save( new OrderProduct(1L, 5L, 4));
            repository3.save( new OrderProduct(2L, 6L, 40) ); 
            repository3.save( new OrderProduct(1L, 6L, 400) ); 
            repository3.save( new OrderProduct(2L, 5L, 444) ); 
        };
    }
}
