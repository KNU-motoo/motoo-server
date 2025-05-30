package knu.motoo.tradingapi.order.application;


import knu.motoo.commondb.member.Member;
import knu.motoo.commondb.order.Order;
import knu.motoo.commondb.order.OrderStatus;
import knu.motoo.tradingapi.order.dto.OrderCreateRequest;
import knu.motoo.tradingapi.order.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
    private final OrderReader orderReader;
    private final OrderWriter orderWriter;

    @Transactional
    public OrderResponse createLimitOrder(OrderCreateRequest request, Member member) {

        Order order = Order.builder()
                .member(member)
                .symbol(request.symbol())
                .orderType(request.orderType())
                .orderSide(request.orderSide())
                .orderStatus(OrderStatus.PENDING)
                .quantity(request.quantity())
                .price(request.price())
                .build();

        return OrderResponse.from(orderWriter.createLimitOrder(order));
    }

    public OrderResponse readOrder(Long orderId) {
        return OrderResponse.from(orderReader.readOrder(orderId));
    }
}
