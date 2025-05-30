package knu.motoo.commondb.order;

import jakarta.persistence.*;
import knu.motoo.commondb.base.BaseTimeEntity;
import knu.motoo.commondb.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders") // 'order'는 SQL 예약어이므로 'orders'로 변경
public class Order extends BaseTimeEntity {

    @Id @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol; // 종목 코드

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private OrderSide orderSide;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, precision = 18, scale = 8)
    private BigDecimal quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = true)
    private Member member;

    @Builder
    public Order(String symbol, OrderType orderType, OrderStatus orderStatus,
                 OrderSide orderSide, BigDecimal price, BigDecimal quantity, Member member) {
        this.symbol = symbol;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.orderSide = orderSide;
        this.price = price;
        this.quantity = quantity;
        this.member = member;
    }
}
