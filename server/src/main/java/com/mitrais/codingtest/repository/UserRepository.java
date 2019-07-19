package com.mitrais.codingtest.repository;

import com.mitrais.codingtest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
