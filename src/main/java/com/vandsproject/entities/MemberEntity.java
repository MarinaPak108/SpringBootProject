package com.vandsproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class MemberEntity {

    @Id
    @Column(name = "memberid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberid;

    @Basic
    @Column(name = "memberlogin", length = 255, unique = true)
    private String memberlogin;

    @Basic
    @Column(name = "memberpassword",length = 255)
    private String memberpassword;

    @ManyToOne
    @JoinColumn(name = "memberrole")
    private AuthEntity memberrole;

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getMemberlogin() {
        return memberlogin;
    }

    public void setMemberlogin(String memberlogin) {
        this.memberlogin = memberlogin;
    }

    public String getMemberpassword() {
        return memberpassword;
    }

    public void setMemberpassword(String memberpassword) {
        this.memberpassword = memberpassword;
    }

    public AuthEntity getMemberrole() {
        return memberrole;
    }

    public void setMemberrole(AuthEntity memberrole) {
        this.memberrole = memberrole;
    }

    @Override
    public String toString() {
        return "MemberEntity{" +
                "memberid=" + memberid +
                ", memberlogin='" + memberlogin + '\'' +
                ", memberpassword='" + memberpassword + '\'' +
                ", memberrole=" + memberrole.getName() +
                '}';
    }
}
