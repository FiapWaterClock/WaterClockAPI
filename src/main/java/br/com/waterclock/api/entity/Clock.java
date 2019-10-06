package br.com.waterclock.api.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@SequenceGenerator(name = "clock", sequenceName = "SQ_CLOCK", allocationSize = 1)
public class Clock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clock")
    private int id;

    private Boolean activate;

    private LocalDate intallation_date;

    private String serial_number;

    @OneToMany(mappedBy="clock", cascade=CascadeType.ALL,
            fetch=FetchType.LAZY)
    private List<Consumption> consumptions;

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

    public List<Consumption> getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(List<Consumption> consumptions) {
        this.consumptions = consumptions;
    }

    public void addConsumption(Consumption newConsumption) {
        newConsumption.setClock(this);
        this.consumptions.add(newConsumption);
    }

}
