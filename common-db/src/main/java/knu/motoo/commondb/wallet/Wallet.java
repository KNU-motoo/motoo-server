package knu.motoo.commondb.wallet;

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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"symbol", "member_id"}))
public class Wallet extends BaseTimeEntity {

    @Id @Column(name = "wallet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletId;

    @Column(nullable = false)
    private String symbol;

    @Column(precision = 18, scale = 8)
    private BigDecimal quantity;

    @Version
    private Long version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    public Wallet(String symbol, BigDecimal quantity, Member member) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.member = member;
    }
}
