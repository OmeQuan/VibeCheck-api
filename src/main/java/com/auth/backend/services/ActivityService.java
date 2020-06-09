package com.auth.backend.services;

import com.auth.backend.models.Activity;
import com.auth.backend.models.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ActivityService extends JpaRepository<Activity, Long> {
    Iterable<Activity> findByDayId(Long dayId);
}
