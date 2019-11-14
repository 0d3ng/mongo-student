package apiakademiksample.mongo.controller;

import apiakademiksample.mongo.entitas.Parkir;
import apiakademiksample.mongo.service.ParkirService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/")
public class ParkirController {
    @Autowired
    private ParkirService parkirService;

    @PostMapping("/parkirs")
    @ResponseStatus(HttpStatus.CREATED)
    public Parkir simpan(@RequestBody Parkir parkir) {
        parkir.setId(parkirService.save(parkir));
        return parkir;
    }

    @GetMapping("/parkirs")
    public Page<Parkir> getAll(Pageable pageable) {
        return parkirService.getAll(pageable);
    }

    @GetMapping("/parkirs/{id}")
    public Parkir getById(@PathVariable("id") String id) {
        try {
            Parkir parkir = parkirService.getById(id);
            return parkir;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @DeleteMapping("/parkirs")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("Id") String id) {
        parkirService.delete(id);
    }

    @PatchMapping("/parkirs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Parkir parkir, @PathVariable("id") String id) {
        try {
            Parkir parkir1 = parkirService.getById(id);
            BeanUtils.copyProperties(parkir, parkir1);
            parkir1.setId(id);
            parkirService.save(parkir1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
