package com.burnie.remoteapi.service;

import com.burnie.remoteapi.domain.member.command.MemberCommand;
import com.burnie.remoteapi.domain.member.service.MemberService;
import com.burnie.remoteapi.vo.AuthVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service(value = "idCardAuthService")
@RequiredArgsConstructor
public class IdCardAuthService implements AuthService{

    private final MemberService memberService;

    @Override
    public AuthVo processIdentification(AuthVo authVo) {
        MemberCommand memberCommand = memberService.findMemberByIdCardNo(authVo.getIdCardNo());
        if(Objects.isNull(memberCommand)) return null;

        boolean isMatch = authVo.getName().equals(memberCommand.getName())
                && authVo.getIssueDate().equals(memberCommand.getIssueDate())
                && authVo.getIdCardNo().equals(memberCommand.getIdCardNo());

        authVo.setAuthResult(isMatch ? "Y" : "N");
        return authVo;
    }
}
