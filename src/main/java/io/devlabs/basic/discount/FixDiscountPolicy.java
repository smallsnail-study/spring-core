package io.devlabs.basic.discount;

import io.devlabs.basic.member.Grade;
import io.devlabs.basic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int dicountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
