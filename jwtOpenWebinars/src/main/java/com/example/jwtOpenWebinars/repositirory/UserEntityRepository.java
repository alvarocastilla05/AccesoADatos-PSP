package com.example.jwtOpenWebinars.repositirory;

import com.example.jwtOpenWebinars.model.UserEntity;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
