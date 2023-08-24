package com.example.hackathon07.dto;

import com.example.hackathon07.domain.Menu;
import com.example.hackathon07.domain.Order;
import com.example.hackathon07.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderDTO {

    private Long order_id;
    private User user_id;
    private Menu menu_id;
    private LocalDateTime orderDataTime;
    private int orderQuantity;
    private int orderPreparationStatus;
    private int orderEstimatedPreparationTime;

    public static OrderDTO toMemberDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrder_id(order.getOrder_id());
        orderDTO.setOrderDataTime(order.getOrderDataTime());
        orderDTO.setOrderQuantity(order.getOrderQuantity());
        return orderDTO;
    }
}
