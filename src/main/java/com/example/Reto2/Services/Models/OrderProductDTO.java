package com.example.Reto2.Services.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
public class OrderProductDTO {
  
    public Long orderId;
    public Long productId;
    private int quantity;
    private Long id;



    
    public OrderProductDTO() {
	}

    public OrderProductDTO(Long orderId, Long productId, int quantity) {
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
