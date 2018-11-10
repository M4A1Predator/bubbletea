package com.bubletea.bubletea.repository;

import com.bubletea.bubletea.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findById(int id);
}
