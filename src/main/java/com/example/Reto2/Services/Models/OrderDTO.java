package com.example.Reto2.Services.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.Reto2.Repositories.Entities.Order;


public class OrderDTO {
  
    private Long id;
    private String Date; 
    private String Name; 
    private Order.estados State;
    
    public OrderDTO(final String _date, final String _name, final Order.estados _state){
        super();
      
        this.Date = _date; 
        this.Name = _name; 
        this.State = _state;
    }

 

	

    public OrderDTO (OrderDTO order){       
        this.Date = order.Date;
        this.Name = order.Name; 
        this.State = order.State;
    }
	

    public OrderDTO() {
	}





	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    

    public Order.estados getState() {
        return State;
    }

    public void setState(Order.estados state) {
        State = state;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Order [Date=" + Date + ", Name=" + Name + ", State=" + State + ", id=" + id + "]";
    }

    public Order toOrder() {
        return new Order(
            this.id,
            this.Date,
            this.Name,
            this.State
        );
    }

    
    
    
  
}
