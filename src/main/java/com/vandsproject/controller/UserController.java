package com.vandsproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {

    @GetMapping("/admin")
    public String admin()
    {

        return "This is admin page";
    }


}
