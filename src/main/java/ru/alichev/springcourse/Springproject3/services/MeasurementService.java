package ru.alichev.springcourse.Springproject3.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alichev.springcourse.Springproject3.models.Measurements;
import ru.alichev.springcourse.Springproject3.repositories.MeasurementRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeasurementService {
   private final MeasurementRepository measurementRepository;
   private final SensorService sensorService;
    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    public List<Measurements> findAll(){
       return measurementRepository.findAll();
    }
    @Transactional
    public void save(Measurements measurements){
        enrichMeasurement(measurements);
        measurementRepository.save(measurements);
    }

    private void enrichMeasurement(Measurements measurements) {
        measurements.setSensor(sensorService.findByName(measurements.getSensor().getName()).get());
        measurements.setMeasurementDateTime(LocalDateTime.now());
    }

}
