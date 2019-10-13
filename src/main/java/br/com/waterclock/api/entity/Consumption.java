package br.com.waterclock.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@SequenceGenerator(name = "consumption", sequenceName = "SQ_CONSUMPTION", allocationSize = 1)
public class Consumption {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumption")
    private int id;

    @ManyToOne
    @JoinColumn(name="CD_CLOCK")
    @JsonIgnore
    private Clock clock;

    private LocalDate time;

    private double litersPerMinute;

    public Consumption(Clock clock, double litersPerMinute) {
        this.clock = clock;
        this.litersPerMinute = litersPerMinute;
        this.time = LocalDate.now();
    }

    public Consumption(LocalDate time, double litersPerMinute) {
        this.litersPerMinute = litersPerMinute;
        this.time = time;
    }

    public Consumption(double litersPerMinute) {
        this.litersPerMinute = litersPerMinute;
    }

    public Consumption() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public double getLitersPerMinute() {
        return litersPerMinute;
    }

    public void setLitersPerMinute(double litersPerMinute) {
        this.litersPerMinute = litersPerMinute;
    }

}
