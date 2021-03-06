package com.example.Reto2.Repositories.Entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "Product") // sobre base de datos
@Entity(name = "Product") // sobre memoria
public class Product{

    public Product(){}

    private static int count=0;
    private @Id @GeneratedValue Long id;
    private String Name; 
    private int Precio; 
    private String Image;

    public Product(final String _name, final int _precio, final String _image){
        this.Name = _name;
        this.Precio = _precio;
        this.Image = _image;
    }

    public Product(final Long _id, final String _name, final int _precio, final String _image){
        this.id = _id;
        this.Name = _name;
        this.Precio = _precio;
        this.Image = _image;
    }

    public Product (Product product){
      
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


    

    
}
