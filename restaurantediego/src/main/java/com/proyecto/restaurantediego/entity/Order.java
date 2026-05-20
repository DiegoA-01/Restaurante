package com.proyecto.restaurantediego.entity;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.restaurantediego.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//ENTIDAD PADRE
public class Order extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // ¿Quién tomó la orden?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    // ¿En qué mesa?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", nullable =  false)
    private RestaurantTable table;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @Builder.Default
    private OrderStatus status = OrderStatus.PENDING;

    //RELACION PADRE-HIJO
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<OrderItem> items = new ArrayList<>();

    // Método helper (Best Practice)
    public void addItem(OrderItem item){  //la sincronización bidireccional en Java, al agregar un hijo a la lista del padre, el hijo debe apuntar al padre.
        items.add(item);
        item.setOrder(this);
    }
}
