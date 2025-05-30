package knu.motoo.tradingapi.order.dto;

import knu.motoo.commondb.order.OrderSide;
import knu.motoo.commondb.order.OrderType;

import java.math.BigDecimal;

public record OrderCreateRequest(
    Long memberId, //임시
    String symbol,
    OrderType orderType,
    OrderSide orderSide,
    BigDecimal quantity,
    BigDecimal price
) {
}
