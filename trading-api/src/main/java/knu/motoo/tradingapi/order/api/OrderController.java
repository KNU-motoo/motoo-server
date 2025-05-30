package knu.motoo.tradingapi.order.api;

import knu.motoo.commondb.member.Member;
import knu.motoo.commondb.member.MemberRepository;
import knu.motoo.tradingapi.order.application.OrderService;
import knu.motoo.tradingapi.order.dto.OrderCreateRequest;
import knu.motoo.tradingapi.order.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberRepository memberRepository; // 인증 로직 이전 임시

    @PostMapping
    public ResponseEntity<OrderResponse> createLimitOrder(
            @RequestBody OrderCreateRequest request) {
        //임시 멤버 로직 추후 principal 기반 인증으로 변경 예정
        Member member = memberRepository.findById(request.memberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + request.memberId()));

        OrderResponse response = orderService.createLimitOrder(request, member);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(
            @PathVariable Long orderId) {
        OrderResponse response = orderService.readOrder(orderId);
        return ResponseEntity.ok(response);
    }
}
