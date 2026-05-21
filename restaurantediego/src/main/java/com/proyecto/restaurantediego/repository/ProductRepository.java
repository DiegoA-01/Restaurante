package com.proyecto.restaurantediego.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.restaurantediego.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
    /**
     * Buscar por el nombre excato
     * 
     * @param name
     * @return
     */
    Optional<Product> findByName(String name);

    /**
     * Verificar si existe por nombre
     * 
     * @param name
     * @return
     */
    boolean existsByName(String name);

    /**
     * Buscar productos activos
     * 
     * @return
     */
    List<Product> findByIsActiveTrue();

    /**
     * Buscar por categoria
     * 
     * @param categoryId
     * @return
     */
    List<Category> findByCategoryId(Long categoryId);

    /**
     * Buscar por nombre ignorando mayusculas
     * 
     * @param name
     * @return
     */
    List<Product> findByNameContainingIgnoreCase(String name);


    /**
     * Buscar productos con stock bajos 
     * 
     * @param stock
     * @return
     */
    List<Product> findByStockLessThan(Integer stock);

    /**
     * Buscar por rango de precio
     * 
     * @param min
     * @param max
     * @return
     */
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
}
