package com.burnie.remoteapi;

import com.burnie.remoteapi.domain.member.entity.Member;
import com.burnie.remoteapi.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {
    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Member member = new Member();
        member.setName("류현수");
        member.setIdCardNo("9310081216132");
        member.setIssueDate("20250103");
        memberRepository.save(member);
    }
}
