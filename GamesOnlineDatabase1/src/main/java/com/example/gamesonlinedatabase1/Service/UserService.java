package com.example.gamesonlinedatabase1.Service;

import com.example.gamesonlinedatabase1.Modle.Games;
import com.example.gamesonlinedatabase1.Modle.User;
import com.example.gamesonlinedatabase1.exception.ApiException;
import com.example.gamesonlinedatabase1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void Register(User user) {
        String hashPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashPassword);
        userRepository.save(user);

    }

    public void UpdateUser(User user, Integer id) {
        User myuser = userRepository.getById(id);
        myuser.setUsername(user.getUsername());
        myuser.setPassword(user.getPassword());
        myuser.setRole(user.getRole());
        userRepository.save(myuser);


    }


    public void DeleteUser(Integer id) {
        User olduser = userRepository.getById(id);
        userRepository.delete(olduser);


    }


}

