package com.example.hackathon07.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Cart")

public class Cart {
    @Id @GeneratedValue
    @Column(name = "CART_ID")
    private Long cartId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "USER_ID")
    private User userId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "MENU_ID")
    private Menu menuId;

    @Column(name = "Cart_Quantity")
    private BigDecimal cartQuantity;

    @Column(name = "Cart_Total_Price")
    private BigDecimal cartTotalPrice;

    @Column(name = "Cart_Is_Selected")
    private Boolean cartIsSelected;

    public Cart(Long cartId, User userId, Menu menuId, BigDecimal cartQuantity, BigDecimal cartTotalPrice, boolean cartIsSelected) {
        this.cartId = cartId;
        this.userId = userId;
        this.menuId = menuId;
        this.cartQuantity = cartQuantity;
        this.cartTotalPrice = cartTotalPrice;
        this.cartIsSelected = cartIsSelected;
    }

}
