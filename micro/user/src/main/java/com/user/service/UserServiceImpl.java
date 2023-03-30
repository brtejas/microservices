package com.user.service;

import com.user.VO.ResponseVO;
import com.user.models.Contact;
import com.user.models.User;
import com.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseVO getUser(Long id) {
        ResponseVO responseVO = new ResponseVO();

        User user= userRepo.findById(id).get();

        Contact[] contacts = restTemplate.getForObject("http://localhost:9002/contact/"+id, Contact[].class);

        responseVO.setUser(user);
        responseVO.setContacts(Arrays.asList(contacts));

        return responseVO;
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }
}
