package com.proyecto.restaurantediego.entity;

import com.proyecto.restaurantediego.enums.TableStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tables")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantTable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "table_number", nullable = false, unique = true)
    private Integer tableNumber;

    @Min(value = 1, message = "La capacidad debe ser mayor a 0")
    @Column(nullable = false)
    private Integer capacity;

    /**
     *  @Enumerated(EnumType.STRING) esto lo que hace es que se guardan los roles en texto y no en numeros, ya que cuando se agrege otro
     * rol pues no se va a totiar la base de datos 
     * 
     * Builder.Default permite conservar este valor inicial, cuando el objeto se crea usando Lombok Builder.
     * Sin esto, el valor sería null al usar .builder().
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private TableStatus status = TableStatus.AVAILABLE;
}
