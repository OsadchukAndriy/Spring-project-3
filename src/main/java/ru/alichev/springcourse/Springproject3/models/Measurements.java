package ru.alichev.springcourse.Springproject3.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Measurements")
public class Measurements {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    private long value;

    @Column(name = "raining")
    private boolean raining;

    @Column(name = "measurement_date_time")
    private Date measurementDateTime;

    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    private Sensor sensor;

    public Measurements() {
    }

    public Measurements(long value, boolean raining, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Date getMeasurementDateTime() {
        return measurementDateTime;
    }

    public void setMeasurementDateTime(Date measurementDateTime) {
        this.measurementDateTime = measurementDateTime;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
