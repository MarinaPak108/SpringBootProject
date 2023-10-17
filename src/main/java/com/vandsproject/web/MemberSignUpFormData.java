package com.vandsproject.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MemberSignUpFormData {
    @NotNull
    @Size(min = 3, max = 255)
    private String login;

    @NotNull
    @Size (min=3, max = 255)
    private String password;

    public MemberSignUpFormData() {
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MemberSignUpParam toParameters() {
        return new MemberSignUpParam(login, password);
    }
}
