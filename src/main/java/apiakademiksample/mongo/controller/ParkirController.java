package apiakademiksample.mongo.controller;

import apiakademiksample.mongo.dto.ParkirDto;
import apiakademiksample.mongo.entitas.Parkir;
import apiakademiksample.mongo.service.ParkirService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/")
public class ParkirController {
    @Autowired
    private ParkirService parkirService;
    private ModelMapper modelMapper;

    @Autowired
    public ParkirController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(skipModifiedFieldsMap);
    }

    private PropertyMap<Parkir, ParkirDto> skipModifiedFieldsMap = new PropertyMap<Parkir, ParkirDto>() {
        protected void configure() {
            skip().setTanggalCreated(null);
        }
    };

    @PostMapping("/parkirs")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkirDto simpan(@RequestBody ParkirDto parkir) {
        Parkir parkir1 = modelMapper.map(parkir, Parkir.class);
        parkir1.setTanggalCreated(new Date());
        Parkir save = parkirService.save(parkir1);
        parkir.setId(save.getId());
        parkir.setTanggalCreated(save.getTanggalCreated());
        return parkir;
    }

    @GetMapping("/parkirs")
    public Page<ParkirDto> getAll(Pageable pageable) {
        Page<Parkir> all = parkirService.getAll(pageable);
        List<Parkir> content = all.getContent();
        List<ParkirDto> parkirDtos = new ArrayList<>();
        for (Parkir parkir : content) {
            ParkirDto dto = modelMapper.map(parkir, ParkirDto.class);
            dto.setTanggalCreated(parkir.getTanggalCreated());
            parkirDtos.add(dto);
        }
        return new PageImpl<>(parkirDtos, pageable, all.getTotalElements());
    }

    @GetMapping("/parkirs/{id}")
    public ParkirDto getById(@PathVariable("id") String id) {
        try {
            Parkir parkir = parkirService.getById(id);
            ParkirDto dto = modelMapper.map(parkir,ParkirDto.class);
            dto.setTanggalCreated(parkir.getTanggalCreated());
            return dto;
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
