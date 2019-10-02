package br.com.waterclock.api.resource;

import br.com.waterclock.api.entity.Clock;
import br.com.waterclock.api.repository.ClockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clock")
public class ClockResource {
    @Autowired
    private ClockRepository repository;

    @GetMapping
    public List<Clock> index() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Clock show(@PathVariable int id) {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Clock create(@RequestBody Clock clock) {
        return repository.save(clock);
    }

    @PutMapping("{id}")
    public Clock update(@RequestBody Clock clock, @PathVariable int id) {
        clock.setId(id);
        return repository.save(clock);
    }

    @DeleteMapping("{id")
    public void remove(@PathVariable int id) {
        repository.deleteById(id);
    }
}
