package com.vandsproject.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="authorities")
public class AuthEntity {

    @Id
    @Column(name="authid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authid;

    @Basic
    @Column(name = "authority", length = 255)
    private String name;

    @OneToMany
    @JoinColumn(name = "memberrole")
    private List<MemberEntity> members;

    public Integer getAuthid() {
        return authid;
    }

    public void setAuthid(Integer authid) {
        this.authid = authid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberEntity> getMembers() {
        return members;
    }

    public void setMembers(List<MemberEntity> members) {
        this.members = members;
    }
}
