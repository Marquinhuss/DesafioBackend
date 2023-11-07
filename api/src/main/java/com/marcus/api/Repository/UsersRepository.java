package com.marcus.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcus.api.Model.Users.Users;
import java.util.Optional;


public interface UsersRepository extends JpaRepository<Users, Long>{

    public Optional<Users> findUserByDocument(String document);

    public Optional<Users> findUserById(Long Id);
}
