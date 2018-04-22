package com.sample.db.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.db.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {
	// TODO なぜOptionalなのか・・？jpaの仕様？
	public Optional<User> findById(String id);
}
