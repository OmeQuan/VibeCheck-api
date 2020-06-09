package com.auth.backend.repositories;

import java.util.Optional;

import com.auth.backend.models.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DayRepository extends JpaRepository<Day, Long> {
    Optional<Day> findById(Long id);
}
