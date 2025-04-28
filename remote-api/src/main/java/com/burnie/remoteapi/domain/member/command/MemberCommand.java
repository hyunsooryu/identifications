package com.burnie.remoteapi.domain.member.command;

import com.burnie.remoteapi.domain.member.dto.MemberDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCommand {
    private Long id;
    private String name;
    private String idCardNo;
    private String issueDate;

    public static MemberCommand of(MemberDto memberDto){
        MemberCommand memberCommand = new MemberCommand();
        memberCommand.setId(memberDto.getId());
        memberCommand.setName(memberDto.getName());
        memberCommand.setIdCardNo(memberDto.getIdCardNo());
        memberCommand.setIssueDate(memberDto.getIssueDate());
        return memberCommand;
    }

}
