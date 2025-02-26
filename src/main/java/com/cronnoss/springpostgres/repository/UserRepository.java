package com.cronnoss.springpostgres.repository;

import com.cronnoss.springpostgres.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // createUser
    User save(User user);

    // getUser
    Optional<User> findById(Long id);

    // getAllUsers
    List<User> findAll();

    // deleteUser
    void deleteById(Long id);

}
