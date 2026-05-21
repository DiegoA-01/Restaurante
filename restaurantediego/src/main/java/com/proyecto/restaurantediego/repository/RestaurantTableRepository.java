package com.proyecto.restaurantediego.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.restaurantediego.entity.RestaurantTable;
import com.proyecto.restaurantediego.enums.TableStatus;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
    
    /**
     * Buscar por número de mesa
     * 
     * @param tableNumber
     * @return
     */
    Optional<RestaurantTable> findByTableNumber(Integer tableNumber);

    /**
     * Verificar si existe el número de mesa
     * 
     * @param tableNumber
     * @return
     */
    boolean existsByTableNumber(Integer tableNumber);

    /**
     * Buscar mesas por estado
     * 
     * @param status
     * @return
     */
    List<RestaurantTable> findByStatus(TableStatus status);

    /**
     * Buscar mesas con capacidad mayor o igual
     * 
     * @param capacity
     * @return
     */
    List<RestaurantTable> findByCapacityGreaterThanEqual(Integer capacity);

    /**
     * Buscar mesas disponibles
     * 
     * @param status
     * @return
     */
    List<RestaurantTable> findByStatusOrderByTableNumberAsc(TableStatus status);
}
