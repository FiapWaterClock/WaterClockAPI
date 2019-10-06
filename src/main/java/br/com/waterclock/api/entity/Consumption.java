package br.com.waterclock.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Calendar;

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

    @Temporal(TemporalType.DATE)
    private Calendar time;

    private double litersPerMinute;

    public Consumption(Clock clock, double litersPerMinute) {
        this.clock = clock;
        this.litersPerMinute = litersPerMinute;
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

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public double getLitersPerMinute() {
        return litersPerMinute;
    }

    public void setLitersPerMinute(double litersPerMinute) {
        this.litersPerMinute = litersPerMinute;
    }

}
