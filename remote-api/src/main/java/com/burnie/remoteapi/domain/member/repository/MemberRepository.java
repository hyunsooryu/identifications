package com.burnie.remoteapi.domain.member.repository;

import com.burnie.remoteapi.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findMemberByIdCardNo(String idCardNo);
}
