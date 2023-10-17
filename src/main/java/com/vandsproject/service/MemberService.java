package com.vandsproject.service;

import com.vandsproject.entities.AuthEntity;
import com.vandsproject.entities.MemberEntity;
import com.vandsproject.repo.AuthRepo;
import com.vandsproject.repo.MemberRepo;
import com.vandsproject.web.MemberSignUpParam;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepo repo;
    private final AuthRepo aRepo;

    public MemberService(MemberRepo repo, AuthRepo aRepo) {
        this.repo = repo;
        this.aRepo = aRepo;
    }

    public boolean checkMember (String login){
        return repo.existsMemberEntityByMemberlogin(login);
    }

    public Boolean singup (MemberSignUpParam param){
        AuthEntity role = aRepo.getAuthEntityByName("ROLE_USER");
        MemberEntity member = new MemberEntity();
        member.setMemberlogin(param.getLogin());
        member.setMemberpassword(param.getPassword());
        member.setMemberrole(role);
        repo.save(member);
        return true;
    }
}
