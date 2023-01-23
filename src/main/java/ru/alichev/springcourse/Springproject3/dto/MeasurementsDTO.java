package ru.alichev.springcourse.Springproject3.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MeasurementsDTO {

    @NotNull
    @Min(-100)
    @Max(100)
    private long value;

    @NotNull
    private boolean isRaining;

    @NotNull
    private SensorDTO sensor;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public boolean isRaining() {
        return isRaining;
    }

    public void setRaining(boolean raining) {
        isRaining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
