package com.manageractivity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manageractivity.model.Users;

public interface UserRepository  extends JpaRepository<Users,Integer>{

}
