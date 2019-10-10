package br.com.waterclock.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@SequenceGenerator(name = "clock", sequenceName = "SQ_CLOCK", allocationSize = 1)
public class Clock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clock")
    private int id;

    @Column
    private Boolean activate;

    private LocalDate installation_date;

    private String serial_number;

    @OneToMany(mappedBy="clock", cascade=CascadeType.ALL,
            fetch=FetchType.LAZY)
    private List<Consumption> consumptions;

    @ManyToOne
    @JoinColumn(name="cd_user")
    @JsonIgnore
    private User user;

    public Clock() {
        this.activate = true;
    }

    public Clock(LocalDate installation_date, String serial_number) {
        this.activate = true;
        this.installation_date = installation_date;
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

    public LocalDate getinstallation_date() {
        return installation_date;
    }

    public void setinstallation_date(LocalDate installation_date) {
        this.installation_date = installation_date;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
