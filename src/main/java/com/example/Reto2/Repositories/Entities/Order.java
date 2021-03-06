package com.example.Reto2.Repositories.Entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "Orderr") // sobre base de datos
@Entity(name = "Orderr") // sobre memoria
public class Order { 


    public enum estados {
        ACEPPTADO,
        CANCELADO,
        ENCURSO,
        ENTREGADO,
        ENVIADO;

      }

    private @Id @GeneratedValue Long id;
    private String Date; 
    private String Name; 
    private estados State;

    
    public Order (final String _date, final String _name, final estados _state){
        this.Date = _date; 
        this.Name = _name; 
        this.State = _state;
    }
	

    public Order (final Long _id, final String _date, final String _name, final estados _state) {    
        super(); 
        this.id = _id;  
        this.Date = _date; 
        this.Name = _name; 
        this.State = _state;
    }
	

    public Order (Order order) {       
        this.Date = order.Date;
        this.Name = order.Name; 
        this.State = order.State;
    }
	

    public Order() {
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

    

    public estados getState() {
        return State;
    }

    public void setState(estados state) {
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

    
    
    



}
