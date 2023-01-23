package ru.alichev.springcourse.Springproject3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alichev.springcourse.Springproject3.models.Sensor;

import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String> {
    public Optional<Sensor> findByName(String name);
}
