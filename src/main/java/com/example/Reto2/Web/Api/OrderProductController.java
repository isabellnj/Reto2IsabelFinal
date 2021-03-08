package com.example.Reto2.Web.Api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.Reto2.Services.OrderProductService;
import com.example.Reto2.Services.Models.OrderProductDTO;
@RequestMapping("orderProduct/v1")
@RestController
public class OrderProductController {

    private OrderProductService orderProductService;

    OrderProductController(OrderProductService orderProductService) {

        this.orderProductService = orderProductService;
    }

    @GetMapping
    public List<OrderProductDTO> Get() {

        return orderProductService.getAll();
    }


}
