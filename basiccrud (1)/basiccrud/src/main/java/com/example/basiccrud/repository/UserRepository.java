package com.example.basiccrud.repository;

import com.example.basiccrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // JpaRepo yu extens ettiğimizde bazı hazır methotlar birlikte gelir findById getAll vs.

}
