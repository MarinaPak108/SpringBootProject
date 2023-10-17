package com.vandsproject.web;

import com.vandsproject.validation.ValidPassword;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MemberSignUpFormData {
    @NotNull
    @Size(min = 3, max = 255, message = "Login should have between 3 to 255 characters.")
    private String login;

    @NotNull
    @ValidPassword
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
