package com.example.start.Dao;
import com.example.start.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    List<User> findByName(String name);
    List<User> findByNameAndAge(String name, Integer age);
    List<User> findByNameLike(String name);

    @Query(value = "SELECT u FROM User u WHERE u.name=:name")
    public User findNameHQ(@Param("name") String name);

    @Query(value = "SELECT * FROM t_user WHERE name=?", nativeQuery = true)
    public User findNameSQL(String name);

}