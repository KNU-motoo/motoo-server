package knu.motoo.tradingapi.order.application;

import knu.motoo.commondb.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderReader {
    private final OrderRepository orderRepository;


}
