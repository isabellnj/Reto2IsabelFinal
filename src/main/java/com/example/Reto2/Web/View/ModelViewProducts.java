package com.example.Reto2.Web.View;

import java.util.ArrayList;

import com.example.Reto2.Repositories.Entities.OrderProductFull;
import com.example.Reto2.Repositories.Entities.ProductCantidad;
import com.example.Reto2.Services.ProductService;
import com.example.Reto2.Web.Api.OrdersController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelViewProducts {

    private final ProductService productService;

    ModelViewProducts(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/productoshtml")
    public ModelAndView products() {
        ModelAndView modelo = new ModelAndView("listProducts");
        OrderProductFull order = OrdersController.orderById(1L);
        ArrayList<Long> ids = new ArrayList<Long>();

        for (final ProductCantidad producto : order.getProducts()) {
            ids.add(producto.getProduct().getId());

        }

        modelo.addObject("products", productService.getAll());
        modelo.addObject("order", order);
        modelo.addObject("ids", ids);
        return modelo;
    }

}
