package com.proyecto.restaurantediego.repository;

import java.util.Optional;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    /**
     *  Buscar por nombre
     * 
     * @param name
     * @return
     */
    Optional<Category> findByName(String name);

    /**
     * Verificar si existe el nombre
     * 
     * @param name
     * @return
     */
    boolean existsByName(String name);
}
