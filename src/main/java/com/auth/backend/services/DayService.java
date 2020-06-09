package com.auth.backend.services;

import com.auth.backend.models.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DayService
extends JpaRepository<Day, Long> {
 Iterable<Day> findByUserId(Long userId);
}
