 package com.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>
{
	public Users findByEmail(String email);
}
