package com.example.hackathon07.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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
    private Menu menuId;

    @Column(name = "Order_DateTime")
    private LocalDateTime orderDataTime;

    @Column(name = "Order_Quantity")
    private int orderQuantity;

    @Column(name = "Order_Preparation_Status")
    private int orderPreparationStatus;

    @Column(name = "Estimated_Preparation_Time")
    private LocalDateTime orderEstimatedPreparationTime;

}
