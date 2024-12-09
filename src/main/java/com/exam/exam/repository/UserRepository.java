package com.exam.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.exam.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}