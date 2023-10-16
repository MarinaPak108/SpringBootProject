package com.vandsproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class UserController {
    @RestController
    public class controller {

        @GetMapping("/delete")
        public String delete()
        {

            return "This is the delete request";
        }
    }
}
