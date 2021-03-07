package com.example.Reto2.Web.Api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.Reto2.Services.ProductService;
import com.example.Reto2.Services.Models.ProductDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductDTO> Get() {

        return productService.getAll();
    }

    @GetMapping("/productsid/{id}")
    public List<ProductDTO> Get(@PathVariable("id") final Long id) {

        return productService.getByProductid(id);
    }

}
