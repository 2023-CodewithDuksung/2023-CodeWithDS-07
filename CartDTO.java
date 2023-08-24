package com.example.hackathon07.dto;

import com.example.hackathon07.domain.Cart;
import com.example.hackathon07.domain.Menu;
import com.example.hackathon07.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CartDTO {

    private Long cart_id;
    private User userId;
    private Menu menuId;
    private BigDecimal cartQuantity;
    private BigDecimal cartTotalPrice;
    private Boolean cartIsSelected;

    public static CartDTO toCartDTO(Cart cart){
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCart_id(cart.getCart_id());
        cartDTO.setUserId(cart.getUserId());
        cartDTO.setMenuId(cart.getMenuId());
        cartDTO.setCartQuantity(cart.getCartQuantity());
        cartDTO.setCartTotalPrice(cart.getCartTotalPrice());
        cartDTO.setCartIsSelected(cart.getCartIsSelected());
        return cartDTO;
    }
}