package io.devlabs.basic;

import io.devlabs.basic.member.Grade;
import io.devlabs.basic.member.Member;
import io.devlabs.basic.member.MemberService;
import io.devlabs.basic.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
