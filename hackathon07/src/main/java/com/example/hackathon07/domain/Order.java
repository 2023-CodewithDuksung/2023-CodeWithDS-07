package com.example.hackathon07.domain;

public class Order {
    package com.example.hackathon07.domain;

import jakarta.persistence.*;

    @Entity
    @Table(name = "Orders")
    public class Order {
        @Id @GeneratedValue
        @Column(name = "Order_ID")
        private Long order_id;

        @ManyToOne
        @JoinColumn(referencedColumnName = "User_ID")
        private int userId;

        @ManyToOne
        @JoinColumn(referencedColumnName = "Menu_ID")
        private int menuId;

        @Column(name = "Order_DateTime")
        private orderDataTime;
        Order_Quantity
                Preparation_Status
        Estimated_Preparation_Time
    }
}
