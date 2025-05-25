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
public class Order extends BaseTimeEntity {

    @Id @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol; // 종목 코드

    private OrderType orderType;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, precision = 18, scale = 8)
    private BigDecimal quantity;

    @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    public Order(String symbol, OrderType orderType, OrderStatus orderStatus,
                 BigDecimal price, BigDecimal quantity, Member member) {
        this.symbol = symbol;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.price = price;
        this.quantity = quantity;
        this.member = member;
    }
}
