package com.example.Reto2.Repositories.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "OrderProduct") // sobre base de datos
@Entity(name = "OrderProduct") // sobre memoria
public class OrderProduct {
    public Long orderId;
    public Long productId;
    private int quantity;
    private @Id @GeneratedValue Long id;



    
    public OrderProduct() {
	}

    public OrderProduct(Long orderId, Long productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    

    
}
