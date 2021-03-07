 package com.example.Reto2.Repositories.Interfaces;

import java.util.Collection;
import java.util.List;

import com.example.Reto2.Repositories.Entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface OrderRepository extends JpaRepository<Order, Long> {

    // @Query(value = "SELECT p " + " FROM Movie p " + " WHERE p.title LIKE %:title% AND p.year = :year")
    // List<Movie> findMovieByTitle(

    //         @Param("title") String tittle, @Param("year") int year);

    @Query(value = "SELECT o " + " FROM Orderr o " + " WHERE o.id= :id")
    List<Order> findOrderById(@Param("id") Long id);  
}
