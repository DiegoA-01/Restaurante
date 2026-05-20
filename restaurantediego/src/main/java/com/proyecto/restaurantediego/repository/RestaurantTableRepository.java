package com.proyecto.restaurantediego.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.restaurantediego.entity.RestaurantTable;
import com.proyecto.restaurantediego.enums.TableStatus;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
    
    // Buscar por número de mesa
    Optional<RestaurantTable> findByTableNumber(Integer tableNumber);

    // Verificar si existe el número de mesa
    boolean existsByTableNumber(Integer tableNumber);

    // Buscar mesas por estado
    List<RestaurantTable> findByStatus(TableStatus status);

    // Buscar mesas con capacidad mayor o igual
    List<RestaurantTable> findByCapacityGreaterThanEqual(Integer capacity);

    // Buscar mesas disponibles
    List<RestaurantTable> findByStatusOrderByTableNumberAsc(TableStatus status);
}
