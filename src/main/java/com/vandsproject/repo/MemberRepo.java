package com.vandsproject.repo;

import com.vandsproject.entities.AuthEntity;
import com.vandsproject.entities.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository <MemberEntity, Integer> {
    MemberEntity findMemberEntityByMemberlogin(String login);

    Boolean existsMemberEntityByMemberlogin (String login);

}
