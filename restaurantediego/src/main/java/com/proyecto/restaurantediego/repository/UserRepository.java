package com.proyecto.restaurantediego.repository;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // "Query Method": Spring Data JPA parsea este nombre y genera el SQL automáticamente:
    // SELECT * FROM users WHERE email = ? AND is_active = true;
    Optional<User> findByEmailAndIsActiveTrue(String email);

    // Verifica si un email ya existe (Útil para el registro)
    boolean existsBYEmail(String email);
}
