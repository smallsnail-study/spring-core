package io.devlabs.basic.order;

import io.devlabs.basic.discount.DiscountPolicy;
import io.devlabs.basic.discount.FixDiscountPolicy;
import io.devlabs.basic.member.Member;
import io.devlabs.basic.member.MemberRepository;
import io.devlabs.basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
