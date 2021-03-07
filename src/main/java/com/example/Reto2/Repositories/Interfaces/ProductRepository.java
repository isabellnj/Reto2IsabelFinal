package com.example.Reto2.Repositories.Interfaces;

import java.util.Collection;
import java.util.List;

import com.example.Reto2.Repositories.Entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// import Lab42Trim.isabel.Repositories.Entities.Movie;


public interface ProductRepository extends JpaRepository<Product, Long> {

    // @Query(value = "SELECT p " + " FROM Movie p " + " WHERE p.title LIKE %:title% AND p.year = :year")
    // List<Movie> findMovieByTitle(

    //         @Param("title") String tittle, @Param("year") int year);

    // @Query(value =  "SELECT p " + " FROM Product p INNER JOIN OrderProduct op on op.productId=p.id " + " WHERE op.orderId= :id")
    // List<Product> findByProductId(

    //         @Param("id") Long id);


            // @Query(value =  "SELECT NEW package Reto2IsabelMs.Reto2IsabelMs.Respositories.Entities.Product(p.Name)" + " FROM Product p  " + " WHERE p.id= :id")
            // List<Product> findd(
        
            //         @Param("id") Long id);
        

}
