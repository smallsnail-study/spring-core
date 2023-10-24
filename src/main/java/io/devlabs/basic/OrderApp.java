package io.devlabs.basic;

import io.devlabs.basic.member.Grade;
import io.devlabs.basic.member.Member;
import io.devlabs.basic.member.MemberService;
import io.devlabs.basic.member.MemberServiceImpl;
import io.devlabs.basic.order.Order;
import io.devlabs.basic.order.OrderService;
import io.devlabs.basic.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        // VIP member를 생성 후 DB에 저장
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order); // Order 에 만들어 둔 toString이 출력된다.
    }
}
