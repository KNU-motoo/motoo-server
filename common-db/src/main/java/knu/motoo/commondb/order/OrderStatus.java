package knu.motoo.commondb.order;

public enum OrderStatus {
    PENDING, // 주문 대기 중
    COMPLETED, // 주문 완료
    CANCELLED, // 주문 취소됨
    FAILED // 주문 실패
}
