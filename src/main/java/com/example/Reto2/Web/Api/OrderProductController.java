package com.example.Reto2.Web.Api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.Reto2.Services.OrderProductService;

@RestController
public class OrderProductController {

    private OrderProductService orderProductService;

    OrderProductController(OrderProductService orderProductService) {

        this.orderProductService = orderProductService;
    }

}
