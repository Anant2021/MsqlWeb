package com.example.msqlweb.repository;

import com.example.msqlweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long > {

}
