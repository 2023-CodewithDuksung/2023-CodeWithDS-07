package com.example.hackathon07.controller;

import com.example.hackathon07.dto.CartDTO;
import com.example.hackathon07.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // 장바구니에 메뉴를 추가하는 엔드포인트
    @PostMapping("/add")
    public ResponseEntity<CartDTO> addMenuToCart(
            @RequestParam Long userId,        // 사용자 ID 파라미터
            @RequestParam Long menuId,        // 메뉴 ID 파라미터
            @RequestParam BigDecimal cartQuantity) {  // 장바구니에 추가할 메뉴 수량 파라미터

        // 장바구니에 메뉴를 추가하고 결과를 받아옴
        CartDTO addedCartItem = cartService.addMenuToCart(userId, menuId, cartQuantity);

        // 추가 성공 시 해당 장바구니 아이템 반환, 실패 시 badRequest 응답 반환
        if (addedCartItem != null) {
            return ResponseEntity.ok(addedCartItem);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // 선택된 상품들을 결제하는 엔드포인트
    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestParam Long userId, @RequestBody List<Long> selectedMenuIds) {
        // 선택된 상품들을 결제 처리하고 결과를 받아옴
        boolean paymentSuccess = cartService.processSelectedItems(userId, selectedMenuIds);

        // 결제 성공 시 성공 메시지 반환, 실패 시 badRequest 응답과 실패 메시지 반환
        if (paymentSuccess) {
            return ResponseEntity.ok("선택한 상품들의 결제가 성공적으로 완료되었습니다.");
        } else {
            return ResponseEntity.badRequest().body("선택한 상품들의 결제 실패");
        }
    }
}
