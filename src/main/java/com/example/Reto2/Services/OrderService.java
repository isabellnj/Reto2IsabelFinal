package com.example.Reto2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.Reto2.Repositories.Entities.Order;
import com.example.Reto2.Repositories.Interfaces.OrderRepository;
import com.example.Reto2.Services.Models.OrderDTO;

import org.modelmapper.ModelMapper;

public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(x -> modelMapper.map(x, OrderDTO.class))
                .collect(Collectors.toList());
    }

   
    public List<OrderDTO> findById(Long id) {
        return EntitiesToDTO(orderRepository.findById(id));
    }

    public List<OrderDTO> EntitiesToDTO(Optional<Order> optional) {
        List<OrderDTO> order = optional.stream().map(x -> modelMapper.map(x, OrderDTO.class))
                .collect(Collectors.toList());
        if (!order.isEmpty()) {
            return order;
        } else {
            throw new ElementNotFound();
        }

    }

    /// - En caso de que se proporcione un ID que no exista o haya algún error,
    // la petición debería devolver un error HTTP que identifique adecuadamente este
    /// error.

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "id no existe")
    public static class ElementNotFound extends RuntimeException {

    }

}
