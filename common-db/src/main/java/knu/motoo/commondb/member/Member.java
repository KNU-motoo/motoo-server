package knu.motoo.commondb.member;

import jakarta.persistence.*;
import knu.motoo.commondb.account.Account;
import knu.motoo.commondb.base.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Builder
    public Member(String name, MemberType memberType, Account account) {
        this.name = name;
        this.memberType = memberType;
        this.account = account;
    }

}
