package com.example.examprepshoppinglist.repository;

;
import com.example.examprepshoppinglist.model.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);

  // boolean findByUsername(String username);

    boolean existsByUsername(String username);
//
//    @Query("SELECT u FROM User u ORDER BY size(u.orders) DESC ")
//    List<User> findAllByOrdersCountDesc();
}
