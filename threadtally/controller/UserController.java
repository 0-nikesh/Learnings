package com.threadtally.threadtally.controller;

import com.threadtally.threadtally.pojo.UserPojo;
import com.threadtally.threadtally.service.UserSevice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
@RequiredArgsConstructor
public class UserController {

        private final UserSevice userSevice;

    @PostMapping("/save")
    public String saveUser( @Valid @RequestBody UserPojo userPojo) {
        System.out.println(userPojo);
        userSevice.saveUser(userPojo);

        return"data created successfully";
    }

}
