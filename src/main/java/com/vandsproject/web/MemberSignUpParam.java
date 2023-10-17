package com.vandsproject.web;

public class MemberSignUpParam {
    private final String login;
    private final String password;

    public MemberSignUpParam(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }

}
