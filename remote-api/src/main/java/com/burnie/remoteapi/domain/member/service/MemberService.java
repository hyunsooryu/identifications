package com.burnie.remoteapi.domain.member.service;

import com.burnie.remoteapi.domain.member.command.MemberCommand;
import com.burnie.remoteapi.domain.member.dto.MemberDto;
import com.burnie.remoteapi.domain.member.entity.Member;
import com.burnie.remoteapi.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberCommand findMemberByIdCardNo(String idCardNo){
        List<Member> members = memberRepository.findMemberByIdCardNo(idCardNo);
        if(CollectionUtils.isEmpty(members)){
            return null;
        }
        Member member = members.get(0);
        return MemberCommand.of(MemberDto.of(member));
    }
}
