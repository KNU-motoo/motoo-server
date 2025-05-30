package knu.motoo.tradingapi.order.dto;

import knu.motoo.commondb.order.Order;
import knu.motoo.commondb.order.OrderSide;
import knu.motoo.commondb.order.OrderStatus;
import knu.motoo.commondb.order.OrderType;

import java.math.BigDecimal;

public record OrderResponse(
        Long orderId,
        String symbol,
        OrderType orderType,
        OrderSide orderSide,
        OrderStatus orderStatus,
        BigDecimal price,
        BigDecimal quantity
) {
    public static OrderResponse from(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getSymbol(),
                order.getOrderType(),
                order.getOrderSide(),
                order.getOrderStatus(),
                order.getPrice(),
                order.getQuantity()
        );
    }
}
