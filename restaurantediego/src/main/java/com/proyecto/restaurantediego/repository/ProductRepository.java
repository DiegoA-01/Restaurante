package com.proyecto.restaurantediego.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.restaurantediego.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
    //Buscar por el nombre excato
    Optional<Product> findByName(String name);

    //Verificar si existe por nombre
    boolean existsByName(String name);

    //Buscar productos activos
    List<Product> findByIsActiveTrue();

    //Buscar por categoria
    List<Category> findByCategoryId(Long categoryId);

    //Buscar por nombre ignorando mayusculas
    List<Product> findByNameContainingIgnoreCase(String name);


    //Buscar productos con stock bajos 
    List<Product> findByStockLessThan(Integer stock);

    //Buscar por rango de precio
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
}
