package com.proyecto.restaurantediego.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Se crea esta entidad abstracta para no tener que colocar en las demas entidades los mismo y replicar codigo 
 * si no que directamentre se extiendan de esta entidad.
 * 
 * MappedSuperClass le dice al a jpa que no es una tabla que son atributos que se que se inyecta en la herencia
 * 
 * EntityListeners Autoriza la fecxha y la hora de los create y los update
 * y en aplication se debe autorizar con el @EnableJpaAuditing
 */
@Setter
@Getter
@MappedSuperclass // indica que esto no es una tabla si no una columna que extiende 
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
