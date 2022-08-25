package com.example.gamesonlinedatabase1.repository;

import com.example.gamesonlinedatabase1.Modle.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);


}
