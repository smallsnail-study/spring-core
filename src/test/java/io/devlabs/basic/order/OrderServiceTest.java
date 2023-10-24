package io.devlabs.basic.order;

import io.devlabs.basic.member.Grade;
import io.devlabs.basic.member.Member;
import io.devlabs.basic.member.MemberService;
import io.devlabs.basic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000); // VIP 1000원 할인여부 검증
    }

}
