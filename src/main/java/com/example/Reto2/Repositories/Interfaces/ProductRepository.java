package com.example.Reto2.Repositories.Interfaces;

import java.util.Collection;
import java.util.List;

import com.example.Reto2.Repositories.Entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// import Lab42Trim.isabel.Repositories.Entities.Movie;


public interface ProductRepository extends JpaRepository<Product, Long> {


}
