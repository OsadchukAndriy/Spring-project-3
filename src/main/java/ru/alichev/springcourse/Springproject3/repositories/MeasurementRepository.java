package ru.alichev.springcourse.Springproject3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alichev.springcourse.Springproject3.models.Measurements;
@Repository
public interface MeasurementRepository extends JpaRepository<Measurements,Integer> {
}
