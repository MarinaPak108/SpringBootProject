package com.vandsproject.config;

import com.vandsproject.entities.AuthEntity;
import com.vandsproject.entities.MemberEntity;
import com.vandsproject.repo.MemberRepo;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class CustomAuthProvider  implements AuthenticationProvider {

    private final MemberRepo repo;

    public CustomAuthProvider(MemberRepo repo) {
        this.repo = repo;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        MemberEntity member = repo.findMemberEntityByMemberlogin(login);
        // use the credentials
        // and authenticate against the third-party system
        if(password.matches(member.getMemberpassword())){
            return new UsernamePasswordAuthenticationToken(
                    login, password, getAuth(member.getMemberrole()));
        } else {
            throw new BadCredentialsException("Invalid data");
        }
    }



    private Set<SimpleGrantedAuthority> getAuth (AuthEntity auth){
        Set<SimpleGrantedAuthority> listAuth = new HashSet<>();
        String role = auth.getName();
        listAuth.add(new SimpleGrantedAuthority(role));
        return listAuth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
