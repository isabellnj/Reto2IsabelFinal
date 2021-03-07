package com.example.Reto2.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.Reto2.Repositories.Entities.OrderProduct;
import com.example.Reto2.Repositories.Interfaces.OrderProductRepository;
import com.example.Reto2.Services.Models.OrderProductDTO;

import org.modelmapper.ModelMapper;


public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private ModelMapper modelMapper;
    public List<OrderProductDTO> getAll() {
        return orderProductRepository.findAll().stream().map(x -> modelMapper.map(x, OrderProductDTO.class))
                .collect(Collectors.toList());
    }

    public List<OrderProductDTO> findByOrderId(Long id) {
        return orderProductRepository.findByOrderId(id).stream().map(x -> modelMapper.map(x, OrderProductDTO.class))
                .collect(Collectors.toList());
    }


    
    public OrderProductDTO add(OrderProductDTO orderProduct) {

      
        // List<OrderProduct> orders = orderProductRepository.findByOrderIdProductId(orderProduct.orderId, null).stream().map(x -> modelMapper.map(x, OrderProductDTO.class)).collect(Collectors.toList());
        OrderProduct entityToInsert = modelMapper.map(orderProduct, OrderProduct.class);
        OrderProduct result = orderProductRepository.save(entityToInsert);
        return modelMapper.map(result, OrderProductDTO.class);
        }
        
    



    public void deleteByOrderProduct(Long orderId, Long productId) {
        List<OrderProduct> entityToDelete = orderProductRepository.findByOrderIdProductId(orderId, productId);
        if (!entityToDelete.isEmpty()) {
            orderProductRepository.delete(entityToDelete.get(0));
        }

       

    }

    
    ///-	En caso de que se proporcione un ID que no exista o haya algún error, 
    //la petición debería devolver un error HTTP que identifique adecuadamente este error.
 
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "id no existe")
    public static class ElementNotFound extends RuntimeException{
 
    }

   
}
