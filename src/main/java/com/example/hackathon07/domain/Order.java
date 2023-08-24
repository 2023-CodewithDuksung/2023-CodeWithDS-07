package com.example.hackathon07.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@ToString
@Entity
@Table(name = "Orders")
public class Order {
    @Id @GeneratedValue
    @Column(name = "Order_ID")
    private Long order_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "User_ID")
    private User user_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "Menu_ID")
    private Menu menu_id;

    @CreatedDate
    @Column(name = "Order_DateTime")
    private LocalDateTime orderDataTime;

    @Column(name = "Order_Quantity")
    private int orderQuantity;

    @Column(name = "Order_Preparation_Status")
    private int orderPreparationStatus;

    @Column(name = "Estimated_Preparation_Time")
    private int orderEstimatedPreparationTime;

    public Order(Long order_id, User user_id, Menu menuId, LocalDateTime orderDataTime, int orderQuantity, int orderPreparationStatus, int orderEstimatedPreparationTime) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.menu_id = menu_id;
        this.orderDataTime = orderDataTime;
        this.orderQuantity = orderQuantity;
        this.orderPreparationStatus = orderPreparationStatus;
        this.orderEstimatedPreparationTime = orderEstimatedPreparationTime;
    }
}
