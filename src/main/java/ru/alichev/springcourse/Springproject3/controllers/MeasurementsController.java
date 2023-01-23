package ru.alichev.springcourse.Springproject3.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alichev.springcourse.Springproject3.dto.MeasurementsDTO;
import ru.alichev.springcourse.Springproject3.models.Measurements;
import ru.alichev.springcourse.Springproject3.services.MeasurementService;
import ru.alichev.springcourse.Springproject3.util.MeasurementErrorResponse;
import ru.alichev.springcourse.Springproject3.util.MeasurementException;
import ru.alichev.springcourse.Springproject3.util.MeasurementValidator;

import static ru.alichev.springcourse.Springproject3.util.returnErrors.returnErrorsToClient;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {

    private final MeasurementService measurementService;
    private final ModelMapper modelMapper;
    private final MeasurementValidator measurementValidator;

    @Autowired
    public MeasurementsController(MeasurementService measurementService, ModelMapper modelMapper, MeasurementValidator measurementValidator) {
        this.measurementService = measurementService;
        this.modelMapper = modelMapper;
        this.measurementValidator = measurementValidator;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementsDTO measurementsDTO,
                                          BindingResult bindingResult) {
        Measurements measurements = convertToMeasurements(measurementsDTO);
        if(bindingResult.hasErrors()){
            returnErrorsToClient(bindingResult);
        }
        measurementService.save(measurements);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Measurements convertToMeasurements(MeasurementsDTO measurementsDTO) {
        return modelMapper.map(measurementsDTO, Measurements.class);
    }

    private MeasurementsDTO coverToMeasurementsDTO(Measurements measurements){
        return modelMapper.map(measurements, MeasurementsDTO.class);
    }

    @GetMapping
    public List<MeasurementsDTO> getMeasurements() {
        return measurementService.findAll().stream().map(this::coverToMeasurementsDTO).collect(Collectors.toList());
    }

    @GetMapping("/rainyDaysCount")
    public Long getRainyDaysCount() {
        return measurementService.findAll().stream().filter(Measurements::isRaining).count();
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementException e) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
