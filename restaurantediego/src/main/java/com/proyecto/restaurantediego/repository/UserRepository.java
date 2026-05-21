package com.proyecto.restaurantediego.repository;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * Busca un usuario activo por su correo electrónico.
     * Spring Data JPA genera automáticamente la consulta:
     * 
     * SELECT * FROM users  WHERE email = ? AND is_active = true
     * 
     * @param email
     * @return
     */
    Optional<User> findByEmailAndIsActiveTrue(String email);

    /**
     * Verifica si un email ya existe (Útil para el registro)
     * 
     * @param email
     * @return
     */
    boolean existsBYEmail(String email);
}
