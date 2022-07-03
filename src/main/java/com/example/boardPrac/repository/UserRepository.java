package com.example.boardPrac.repository;

import com.example.boardPrac.entity.Board;
import com.example.boardPrac.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
