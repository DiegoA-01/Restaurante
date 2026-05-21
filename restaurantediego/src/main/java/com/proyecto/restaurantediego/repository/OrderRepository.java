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

    /**
     * EntityGraph permite cargar relaciones específicas de forma anticipada (eager loading controlado),
     * evitando consultas adicionales innecesarias.
     * 
     * LazyInitializationException Error que ocurre cuando se intenta acceder a relaciones LAZY fuera del contexto de Hibernate.
     * 
     * Problema N+1 Queries Evita múltiples consultas separadas por cada relación.
     * 
     *  La consulta obtiene una orden completa con todas sus relaciones necesarias en una sola operación.
     * 
     * @param id
     * @return
     */
    @EntityGraph(attributePaths = {"user", "table", "items", "items.product"})
    @Query("SELECT o FROM Order o WHERE o.id = :id")
    Optional<Order> findByIdWithDetais(Long id);

    /**
     * Optener las ordenes activas de una mesa específica
     * 
     * @param tableId
     * @param status
     * @return
     */
    List<Order> findByTableIdAndStatusNot(Long tableId, OrderStatus status);
}
