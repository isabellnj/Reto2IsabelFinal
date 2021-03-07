package com.example.Reto2.Web.Api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle.Control;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import javax.servlet.http.HttpServletResponse;

import com.example.Reto2.Repositories.Entities.OrderProductFull;
import com.example.Reto2.Repositories.Entities.Product;
import com.example.Reto2.Repositories.Entities.ProductCantidad;
import com.example.Reto2.Repositories.Entities.ProductEdit;
import com.example.Reto2.Services.OrderProductService;
import com.example.Reto2.Services.OrderService;
import com.example.Reto2.Services.ProductService;
import com.example.Reto2.Services.Models.OrderDTO;
import com.example.Reto2.Services.Models.OrderProductDTO;
import com.example.Reto2.Services.Models.ProductDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders/v1")

public class OrdersController {

    private static OrderService orderService;
    private static OrderProductService orderProductService;
    private static ProductService productService;

    OrdersController(OrderService orderService, OrderProductService orderProductService,
            ProductService productService) {

        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.productService = productService;
    }

    // saca la lista de todos
    @GetMapping("/order")
    public List<OrderDTO> Get() {

        return orderService.getAll();
    }

    // saca order por id, lo que he ido haciendo es varias consultas por id y ir
    // creando clases de lo que necesitaba sacar, ya que
    // lo intente por inner join y no me salia.
    @GetMapping("/{id}")
    public static OrderProductFull orderById(@PathVariable("id") final Long id) {
        List<OrderDTO> orders = orderService.findById(id);
        OrderDTO orderDto = null;

        if (!orders.isEmpty()) {
            orderDto = orders.get(0);
        } 

        List<OrderProductDTO> orderProductsDTO = orderProductService.findByOrderId(id);

        ArrayList<ProductCantidad> products = new ArrayList<ProductCantidad>();
        for (OrderProductDTO orderProductDTO : orderProductsDTO) {
            ProductDTO productDTO = productService.getByProductid(orderProductDTO.getProductId()).get(0);
            ProductCantidad productCantidad = new ProductCantidad(productDTO.toProduct(),
                    orderProductDTO.getQuantity());
            products.add(productCantidad);
        }

        return new OrderProductFull(orderDto.toOrder(), products);
    }

    // - Permite editar un pedido añadiendo o eliminando productos en ese pedido, si la cantidad es 0 hago otra consulta y
    //borro el producto del pedido
    @PutMapping("/{id}")
    public void Update(@RequestBody ProductEdit product, @PathVariable("id") Long id) {
        List<OrderDTO> orders = orderService.findById(id);
        if (!orders.isEmpty()){
       
            orderProductService.deleteByOrderProduct(id, product.getId());
            if (product.getCantidad() > 0) {
                orderProductService.add(new OrderProductDTO(id, product.getId(), product.getCantidad()));
            }

        }else{
            throw new ElementNotFound();
        }
        
     

    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "id no existe")
    public static class ElementNotFound extends RuntimeException{
 
    }
   

}
