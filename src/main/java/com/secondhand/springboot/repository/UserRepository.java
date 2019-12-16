package com.secondhand.springboot.repository;

import com.secondhand.springboot.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    public User findAccountByUsername(String username);
    public User findAccountByUsernameAndPassword(String username,String password);
}
