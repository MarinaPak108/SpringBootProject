package com.vandsproject.repo;

import com.vandsproject.entities.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthRepo extends JpaRepository <AuthEntity, Integer> {
    @Override
    List<AuthEntity> findAll();
}
