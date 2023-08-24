package com.example.hackathon07.service;

import com.example.hackathon07.domain.Cart;
import com.example.hackathon07.domain.Menu;
import com.example.hackathon07.domain.User;
import com.example.hackathon07.dto.CartDTO;
import com.example.hackathon07.repository.CartRepository;
import com.example.hackathon07.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public CartService(CartRepository cartRepository, MenuRepository menuRepository) {
        this.cartRepository = cartRepository;
        this.menuRepository = menuRepository;
    }

    public CartDTO addMenuToCart(Long userId, Long menuId, BigDecimal cartQuantity) {
        // 사용자 정보 가져오기
        User user = // 사용자 정보를 가져오는 코드 (예: userService.getUserById(userId))
                // 메뉴 정보 가져오기
                Menu menu = menuRepository.findById(menuId).orElse(null);

        // 필요한 정보가 없을 경우 예외 처리
        if (user == null || menu == null) {
            return null;
        }

        // 해당 메뉴가 이미 장바구니에 있는지 확인
        Cart cart = cartRepository.findByUserIdAndMenuId(user, menu);
        if (cart == null) {
            // 새로운 장바구니 아이템 생성
            cart = new Cart();
            cart.setUserId(user);
            cart.setMenuId(menu);
        }

        // 장바구니 아이템의 수량 설정
        cart.setCartQuantity(cartQuantity);

        // 메뉴 가격과 수량을 곱하여 총 가격 계산 및 설정
        BigDecimal menuPrice = menu.getPrice();
        BigDecimal totalPrice = menuPrice.multiply(cartQuantity);
        cart.setCartTotalPrice(totalPrice);

        // 장바구니 아이템 저장
        cartRepository.save(cart);

        // DTO로 변환하여 반환
        return CartDTO.toCartDTO(cart);
    }
}
