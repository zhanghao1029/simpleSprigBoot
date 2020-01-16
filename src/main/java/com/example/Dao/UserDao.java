package com.example.Dao;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    List<User> findByName(String name);
    List<User> findByNameAndAge(String name, Integer age);
    List<User> findByNameLike(String name);
}