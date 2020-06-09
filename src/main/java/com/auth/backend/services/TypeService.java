package com.auth.backend.services;

import com.auth.backend.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TypeService extends JpaRepository<Type, Long> {
}
