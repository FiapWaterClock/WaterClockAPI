package br.com.waterclock.api.resource;


import br.com.waterclock.api.entity.Clock;
import br.com.waterclock.api.entity.Consumption;
import br.com.waterclock.api.model.ConsumptionModel;
import br.com.waterclock.api.repository.ClockRepository;
import br.com.waterclock.api.repository.ConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consumption")
public class ConsumptionResource {

    @Autowired
    private ConsumptionRepository repository;

    @Autowired
    private ClockRepository clockRepository;

    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    @GetMapping("{clock_id}")
    public List<Consumption> index(@PathVariable int clock_id) {
        return repository.findByClockId(clock_id);
    }

    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Consumption create(@RequestBody ConsumptionModel consumptionModel) {
        Clock clock = clockRepository.findById(consumptionModel.getClockId());
        Consumption consumption = new Consumption(clock, consumptionModel.getLitersPerMinute());
        return repository.save(consumption);
    }

}
