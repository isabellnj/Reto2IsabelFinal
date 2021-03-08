package com.example.Reto2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.Reto2.Repositories.Entities.Product;
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

    // public List<ProductDTO> getByProductid(Long ids) {
    //     return productRepository.findById(ids).stream().map(x -> modelMapper.map(x, ProductDTO.class))
    //             .collect(Collectors.toList());
    // }


    public List<ProductDTO> findById(Long id) {
        return EntitiesToDTO(productRepository.findById(id));
    }

    public List<ProductDTO> EntitiesToDTO(Optional<Product> optional) {
        List<ProductDTO> product = optional.stream().map(x -> modelMapper.map(x, ProductDTO.class))
                .collect(Collectors.toList());
        if (!product.isEmpty()) {
            return product;
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
