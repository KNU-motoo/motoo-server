package knu.motoo.tradingapi.order.application;

import knu.motoo.commondb.order.Order;
import knu.motoo.commondb.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OrderWriter {
    private final OrderRepository orderRepository;

    //지정가 주문 생성 메서드
    @Transactional
    public Order createLimitOrder(final Order order) {

        return orderRepository.save(order);
    }
}
