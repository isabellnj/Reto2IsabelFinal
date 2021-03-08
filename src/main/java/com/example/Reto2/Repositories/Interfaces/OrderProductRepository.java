package com.example.Reto2.Repositories.Interfaces;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import com.example.Reto2.Repositories.Entities.OrderProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    // @Query(value = "SELECT p " + " FROM Movie p " + " WHERE p.title LIKE %:title% AND p.year = :year")
    // List<Movie> findMovieByTitle(

    //         @Param("title") String tittle, @Param("year") int year);

    

    @Query(value = "SELECT op " + " FROM OrderProduct op " + " WHERE op.orderId= :id")
    List<OrderProduct> findByOrderId(@Param("id") Long id);

    @Query(value = "SELECT op " + " FROM OrderProduct op " + " WHERE op.orderId= :id AND op.productId= :productId")
    List<OrderProduct> findByOrderIdProductId(@Param("id") Long id, @Param("productId") Long productId);



  

}
