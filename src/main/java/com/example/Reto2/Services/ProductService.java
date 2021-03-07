package com.example.Reto2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.Reto2.Repositories.Interfaces.ProductRepository;
import com.example.Reto2.Services.Models.ProductDTO;

import org.modelmapper.ModelMapper;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream().map(x -> modelMapper.map(x, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getByProductid(Long ids) {
        return productRepository.findById(ids).stream().map(x -> modelMapper.map(x, ProductDTO.class))
                .collect(Collectors.toList());
    }

}
