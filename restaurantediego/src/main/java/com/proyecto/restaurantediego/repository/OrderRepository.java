package com.proyecto.restaurantediego.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.restaurantediego.entity.Order;
import com.proyecto.restaurantediego.enums.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

    // SOLUCIÓN AL N+1: Le decimos a Hibernate que, en esta consulta específica,
    // cambie temporalmente de LAZY a EAGER para estos campos, logrando todo en 1 solo LEFT JOIN.
    @EntityGraph(attributePaths = {"user", "table", "items", "items.product"})
    @Query("SELECT o FROM Order o WHERE o.id = :id")
    Optional<Order> findByIdWithDetais(Long id);

    //Optener las ordenes activas de una mesa específica
    List<Order> findByTableIdAndStatusNot(Long tableId, OrderStatus status);
}
