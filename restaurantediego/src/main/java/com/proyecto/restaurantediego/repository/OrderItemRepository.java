package com.proyecto.restaurantediego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.restaurantediego.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
    /**
     * Buscar por orden
     * 
     * @param orderId
     * @return
     */
    List<OrderItem> findByOrderId(Long orderId);

    /**
     * Buscar ityems por producto
     * 
     * @param productId
     * @return
     */
    List<OrderItem> findByProductId(Long productId);
}
