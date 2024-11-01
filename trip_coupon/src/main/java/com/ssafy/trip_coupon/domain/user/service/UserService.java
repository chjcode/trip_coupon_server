package com.ssafy.trip_coupon.domain.user.service;

import com.ssafy.trip_coupon.domain.user.entity.User;
import com.ssafy.trip_coupon.domain.user.entity.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    public void createMemberIfNotExist(User user) {
        user.encodePassword(passwordEncoder);
        userDAO.createUser(user);
    }

    public User login(String email, String password) {
        User loginUser = userDAO.findUserByEmail(email);
        if (loginUser != null && passwordEncoder.matches(password, loginUser.getPassword())) {
            return loginUser;
        } else {
            throw new NoSuchElementException("아이디, 비밀번호를 확인하세요");
        }
    }

//    public void findPassword(String email) {
//        User user = userDAO.findByEmail(email);
//        // TODO: 대충 랜덤으로 비밀번호 생성하고 이메일 보내는 코드
//        String random = "";
//        user.setPassword(passwordEncoder.encode(random));
//    }
//
//
//    public void delete(User user) {
//        userDAO.deleteUser(user);
//    }
//
//    public void update(User user) {
//        userDAO.updateUser(user);
//    }
//
//    public List<User> findAll() {
//        return userDAO.findAll();
//    }

}
