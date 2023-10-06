package com.threadtally.threadtally.service.impl;

import com.threadtally.threadtally.entity.User;
import com.threadtally.threadtally.pojo.UserPojo;
import com.threadtally.threadtally.repository.UserRepository;
import com.threadtally.threadtally.service.UserSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserSevice {

    private final UserRepository userRepository;
    @Override
    public void saveUser(UserPojo userPojo) {

        User user= new User();
        System.out.println(userPojo);


        userRepository.save(user);
    }
}
