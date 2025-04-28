package com.burnie.remoteapi.domain.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "members", indexes = {
        @Index(name="idx_idcardno", columnList = "meber_id_card_no")
})
@Entity
@SequenceGenerator(name= "memberSeq",
        sequenceName = "member_seq",
        allocationSize = 20, initialValue = 1)
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memberSeq")
    @Column(name = "member_id")
    private Long id;

    @Column(name = "meber_id_card_no")
    private String idCardNo;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_issue_date")
    private String issueDate;

}
