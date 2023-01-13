package com.example.examprepandreys.repository;

import com.example.examprepandreys.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.LongStream;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    boolean findByUsername(String username);
//
//    @Query("SELECT u FROM User u ORDER BY size(u.orders) DESC ")
//    List<User> findAllByOrdersCountDesc();
}
