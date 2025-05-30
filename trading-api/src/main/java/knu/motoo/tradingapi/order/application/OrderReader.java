package knu.motoo.tradingapi.order.application;

import knu.motoo.commoncore.exception.MotooException;
import knu.motoo.commondb.order.Order;
import knu.motoo.commondb.order.OrderRepository;
import knu.motoo.tradingapi.order.exception.OrderErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderReader {
    private final OrderRepository orderRepository;

    public Order readOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new MotooException(OrderErrorCode.ORDER_NOT_FOUND));
    }
}
