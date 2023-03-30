package com.user.service;

import com.user.VO.ResponseVO;
import com.user.models.User;

public interface UserService {

    public ResponseVO getUser(Long id);

    User saveUser(User user);
}
