package com.moimah.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moimah.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
