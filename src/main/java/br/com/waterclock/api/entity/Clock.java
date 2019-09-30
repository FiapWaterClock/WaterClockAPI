package br.com.waterclock.api.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "clock", sequenceName = "SQ_CLOCK", allocationSize = 1)
public class Clock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clock")
    private int id;

    private Boolean activate;

    private LocalDate intallation_date;

    private String serial_number;


    public Clock() {
    }

    public Clock(Boolean activate, LocalDate intallation_date, String serial_number) {
        this.activate = activate;
        this.intallation_date = intallation_date;
        this.serial_number = serial_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getActivate() {
        return activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    public LocalDate getIntallation_date() {
        return intallation_date;
    }

    public void setIntallation_date(LocalDate intallation_date) {
        this.intallation_date = intallation_date;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }
}
