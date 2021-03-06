package com.example.Reto2.Services.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.Reto2.Repositories.Entities.Product;


public class ProductDTO {
    
    public ProductDTO(){}

    private static int count=0;
    private @Id @GeneratedValue Long id;
    private String Name; 
    private int Precio; 
    private String Image;

    public ProductDTO(final String _name, final int _precio, final String _image){
       
       
        this.Name = _name;
        this.Precio = _precio;
        this.Image = _image;
    }
    public ProductDTO (ProductDTO product){
      
        this.Name = product.Name;
        this.Precio = product.Precio;
        this.Image = product.Image;
    }


  
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product [Image=" + Image + ", Name=" + Name + ", Precio=" + Precio + ", id=" + id + "]";
    }

    public Product toProduct() {
        return new Product(
            this.id,
            this.Name,
            this.Precio,
            this.Image
        );
    }


    
  




    
}
