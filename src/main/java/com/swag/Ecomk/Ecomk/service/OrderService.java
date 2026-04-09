package com.swag.Ecomk.Ecomk.service;

import com.swag.Ecomk.Ecomk.dto.OrderResponce;
import com.swag.Ecomk.Ecomk.dto.OrdetItemDto;
import com.swag.Ecomk.Ecomk.model.*;
import com.swag.Ecomk.Ecomk.repository.OrderRepository;
import com.swag.Ecomk.Ecomk.repository.UserRepository;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
@Autowired
private CartService cartService;
    @Autowired
private UserRepository userRepository;
    @Autowired
private OrderRepository orderRepository;
    public Optional<OrderResponce> createOrder(String userId) {
//        validate for cart items
     List<CartItem> cartitems=cartService.getCart(userId);
     if(cartitems.isEmpty()){
return Optional.empty();
     }
//        validate for the user
        Optional<User>userOptional=userRepository.findById(Long.valueOf(userId));
     if(userOptional.isEmpty()){
         return Optional.empty();
     }
     User user=userOptional.get();
//        calculate total price
        BigDecimal totalprice=cartitems.stream().map(CartItem::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
//        create order
        Order order=new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.CONFIRMED);
        order.setTotalAmount(totalprice);
        List<OrderItem> orderItems=cartitems.stream().map(item->new OrderItem(
                null,
                item.getProduct(),
                item.getQuantity(),
                item.getPrice(),
                order
        )).toList();
order.setItems(orderItems);
Order saveorder=orderRepository.save(order);
//        create the cart
cartService.clearcart(userId);
return Optional.of(mapToOrderResponce(saveorder));
    }

    private OrderResponce mapToOrderResponce(Order order) {

        List<OrderItem> items = order.getItems() != null ? order.getItems() : new ArrayList<>();

        return new OrderResponce(
                order.getId(),
                items,
                order.getStatus(),
                order.getTotalAmount(),
                items.stream().map(orderItem ->
                        new OrdetItemDto(
                                orderItem.getId(),
                                orderItem.getProduct() != null ? orderItem.getProduct().getId() : null,
                                orderItem.getQuantity(),
                                orderItem.getPrice(),
                                orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity()))
                        )
                ).collect(Collectors.toList()),
                order.getCreatedAt()
        );
    }
}
