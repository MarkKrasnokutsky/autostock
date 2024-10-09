package com.mark.autostock.repository;

import com.mark.autostock.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String login);
    Boolean existsByUsername(String login);
    Boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String email);

    UserEntity getUserById(Long id);

}
