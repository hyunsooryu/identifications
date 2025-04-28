package com.burnie.remoteapi.domain.member.dto;

import com.burnie.remoteapi.domain.member.command.MemberCommand;
import com.burnie.remoteapi.domain.member.entity.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Getter
@Setter
public class MemberDto {
    private Long id;
    private String name;
    private String idCardNo;
    private String issueDate;

    public static MemberDto of(Member member){
        MemberDto memberDto = new MemberDto();
        memberDto.setId(member.getId());
        memberDto.setName(member.getName());
        memberDto.setIdCardNo(member.getIdCardNo());
        memberDto.setIssueDate(member.getIssueDate());
        return memberDto;
    }

    public static MemberDto of(MemberCommand memberCommand){
        MemberDto memberDto = new MemberDto();
        if(!Objects.isNull(memberCommand.getId())){
            memberDto.setId(memberDto.getId());
        }
        if(StringUtils.hasText(memberCommand.getName())){
            memberDto.setName(memberCommand.getName());
        }
        if(StringUtils.hasText(memberCommand.getIdCardNo())){
            memberDto.setIdCardNo(memberCommand.getIdCardNo());
        }
        if(StringUtils.hasText(memberCommand.getIssueDate())){
            memberDto.setIssueDate(memberCommand.getIssueDate());
        }
        return memberDto;
    }


}
