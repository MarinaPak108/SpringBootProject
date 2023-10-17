package com.vandsproject.controller;

import com.vandsproject.service.MemberService;
import com.vandsproject.web.MemberSignUpFormData;
import com.vandsproject.web.MemberSignUpParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
    private final MemberService service;

    public UserController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/admin")
    public String admin()
    {

        return "This is admin page";
    }

    @GetMapping("/user")
    public String user(){
        return "this is user page";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody MemberSignUpFormData formdata){
        MemberSignUpParam param = formdata.toParameters();
        if(service.checkMember(param.getLogin())){
            return new ResponseEntity<>("Member with login "+ param.getLogin() + " already exists!",
                    HttpStatus.BAD_REQUEST);
        }
        if(service.singup(param)){
            return new ResponseEntity<>("Member is registered successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
    }


}
