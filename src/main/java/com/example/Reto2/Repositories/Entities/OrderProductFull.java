package com.example.Reto2.Repositories.Entities;

import java.util.ArrayList;
import java.util.HashMap;

//import com.example.RetoIsabelMS.MODEL.Order.estados;

public class OrderProductFull {

    //la clase OrderProductFull: esta clase lo que hace es sacar el order con los productos, a su vez he creaado otra clase ProductCantidad
    //la cual solo tiene el objeto producto y la cantidad, asi en esta clase lo saco todo de vez.

    private Order order;
    private ArrayList<ProductCantidad> products;

    public OrderProductFull() {
    }

    public OrderProductFull(Order order, ArrayList<ProductCantidad> products) {
        this.order = order;
        this.products = products;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ArrayList<ProductCantidad> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductCantidad> products) {
        this.products = products;
    }

}
